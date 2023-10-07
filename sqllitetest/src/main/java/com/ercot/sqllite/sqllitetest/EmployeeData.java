package com.ercot.sqllite.sqllitetest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EmployeeData
{
	
	public EmployeeData()
	{
		
	}

	public void insertData(Employee employee)
	{
		try {
			Connection con = getConnection();
			String query = "insert into Employee values(?,?,?,?,?) ";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1, employee.getId());
			psmt.setString(2, employee.getFirstName());
			psmt.setString(3, employee.getLastName());
			psmt.setString(4, employee.getEmailAddress());
			psmt.setString(5, employee.getPhoneNumner());
			int count = psmt.executeUpdate();
			con.commit();
			System.out.println("Number of records inserted in the database :"+count);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readData(int id)
	{
		try {
			
			Connection con = getConnection();
			String query = "Select ID, first_name, last_name, email, phone from Employee where ID=?";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				int idVal=rs.getInt("ID");
				String firstName=rs.getString("first_name");
				String lastName=rs.getString("last_name");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				
				System.out.println("Id : "+idVal+"  First name : "+firstName+"  last  name :"+lastName+"  email "+email+"  phone :"+phone);			
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private Connection getConnection()
	{
		Connection con = null;
		try {
			
			Class.forName("org.sqlite.JDBC");
	        con = DriverManager.getConnection("jdbc:sqlite:C:\\Software\\Sqllite\\test.db");
	        con.setAutoCommit(false);
	        System.out.println("Opened database successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main( String[] args )
    {
		Scanner scanner = null;
		System.out.println("Choose your option \n"
				+ " 1:  Insert new Employee \n"
				+ " 2:  Get Empployee details by Id");
		
		scanner = new Scanner(System.in);
		String choice=scanner.nextLine();
		EmployeeData employeeData = null;
		if("1".equals(choice))
		{
			//
			Employee employee = new Employee();
	        System.out.println("Enter Employee Id: ");
			int id=Integer.parseInt(scanner.nextLine());
			employee.setId(id);
			
			System.out.println("Enter Employee first name: ");
			String firstName=scanner.nextLine();
			employee.setFirstName(firstName);

			
			System.out.println("Enter Employee last name: ");
			String lastName=scanner.nextLine();
			employee.setLastName(lastName);
			
			System.out.println("Enter Employee email: ");
			String email=scanner.nextLine();
			employee.setEmailAddress(email);

			
			System.out.println("Enter Employee phone: ");
			String phone=scanner.nextLine();
			employee.setPhoneNumner(phone);

			
			employeeData = new EmployeeData();
			employeeData.insertData(employee);
		}else {
			System.out.println("Enter Employee Id: ");
			String idStr = scanner.nextLine();
			employeeData = new EmployeeData();
			employeeData.readData(Integer.parseInt(idStr));
		}
		scanner.close();
		
    }
}
