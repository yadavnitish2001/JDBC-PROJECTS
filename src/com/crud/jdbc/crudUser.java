package com.crud.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class crudUser {
    public static void Create(Connection con) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the table Name");
            String TableName = sc.next();
            String query = "CREATE TABLE " + TableName + " (Id INT, Name VARCHAR(20))";

            Statement stmt = con.createStatement();
            stmt.execute(query);
            System.out.println("Table is Created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showTable(Connection con) {
        try {
            String query = "SHOW TABLES";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void read(Connection con) {
        Scanner sc = new Scanner(System.in);
        showTable(con);
        try {
            System.out.println("Enter the table name to be displayed");
            String TableName = sc.next();
            String query = "SELECT * FROM " + TableName;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Insert(Connection con) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the table name");
            String TableName = sc.next();
            System.out.println("Enter Id");
            int Id = sc.nextInt();
            System.out.println("Enter Name");
            String Name = sc.next();
            String query = "INSERT INTO " + TableName + " VALUES (" + Id + ", '" + Name + "')";
            Statement stmt = con.createStatement();
            stmt.execute(query);
            System.out.println("Data Inserted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Update(Connection con) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the table Name");
            String TableName = sc.next();
            System.out.println("Enter ID of the row to update:");
            int id = sc.nextInt();
            System.out.println("Enter new Name:");
            String name = sc.next();
            String query = "UPDATE " + TableName + " SET Name='" + name + "' WHERE Id=" + id;
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Data updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Delete(Connection con) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the table Name");
            String TableName = sc.next();
            System.out.println("Enter ID of the row to delete:");
            int id = sc.nextInt();
            String query = "DELETE FROM " + TableName + " WHERE Id=" + id;
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Data deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String url = "jdbc:mysql://localhost:3306/jdbc_database";
            String username = "root";
            String password = "Yadavnitish@@7000";
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Enter the Number to perform operation");
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    Create(con);
                    break;
                case 2:
                    Insert(con);
                    break;
                case 3:
                    read(con);
                    break;
                case 4:
                    Update(con);
                    break;
                case 5:
                    Delete(con);
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
            
            // Close connection when done
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
