package com.crud.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class crud {
	public static void main(String[] args) {
		try {
			String url="jdbc:mysql://localhost:3306/JDBC_Database";
			String username="root";
			String password="Yadavnitish@@7000";
			
			String query="Create Table Student(Roll int,Name varchar(10))";
			String query1 = "insert INTO student VALUES (1, 'Rahul'), (2, 'Rohit')";
			String query2="update Student set Name='Nitish' where Name='Rohit'"; 
			String query3="Delete from student";
			String query4="Select*from student";
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded");
			
			//Establsihed the connection
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("Connection is Established");
			
			//create a statement
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query4);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
			//stmt.execute(query4);
			System.out.println("Query is executed");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
