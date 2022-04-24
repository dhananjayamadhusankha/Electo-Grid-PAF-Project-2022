package com.xadmin.electrogrid.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.electrogrid.model.Employee;

public class EmployeeDao {
	  private String jdbcURL = "jdbc:mysql://localhost:3306/employeedb?useSSL=false";
	  private String jdbcEmployeename = "root";
	  private String jdbcPassword = "root" ;
	  private String jdbcDriver = "com.mysql.jdbc.Driver" ;
	  
	  private static final String INSERT_EMPLOYEES_SQL= "INSERT INTO employees" + "  (name, phonno, email) VALUES "
	     + " (?, ?, ?);";
	  
	   private static final String INSERT_EMPLOYEE_BY_ID ="select id, name, phoneno, email from employees where id =?"; 
	   private static final String SELECT_ALL_EMPLOYEES = "seleft from employees";
       private static final String DELETE_EMPLOYEES_SQL ="delete from employees where id = ?:";
       private static final String UPDATE_EMPLOYEES_SQL= "update employees set name= ?, phoneno= ?, email= ? where id= ?;";
       
	public EmployeeDao() {
		
	}
       
    protected Connection getConneection()
    {
    	Connection connection = null;
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcURL, jdbcEmployeename, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
    }
        
    // insert employee
    public void insertEmployee(Employee employee) throws SQLException {
		System.out.println(INSERT_EMPLOYEES_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConneection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEES_SQL)) {
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getPhoneno());
			preparedStatement.setString(3, employee.getEmail());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}


    
    // select employee by id
    public Employee selectEmployee(int id) {
		Employee employee = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConneection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String phoneno = rs.getString("phoneno");
				String email = rs.getString("email");
				employee = new Employee(name, phoneno, email);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return employee;
	}
    
    // select all employees

	public List<Employee> selectAllEmployees() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Employee> employees = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConneection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String phoneno = rs.getString("phoneno");
				String email = rs.getString("email");
				employees.add(new Employee(name, phoneno , email));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return employees;
	}
    

	
	// delete employee
	public boolean deleteEmployee(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConneection();
				PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEES_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
    // update employee
	
	public boolean updateEmployee(Employee employee) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConneection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEES_SQL);) {
			System.out.println("updated Employee:"+statement);
			statement.setString(1, employee.getName());
			statement.setString(2, employee.getPhoneno());
			statement.setString(3, employee.getEmail());
			statement.setInt(4, employee.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
		
	


