/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.choxmi.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DBClass {
    String url = "jdbc:mysql://localhost:3306/javabase";
    String username = "java";
    String password = "password";
    Connection conn;
    
    public DBClass(){
        try{
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        conn = DriverManager.getConnection
           ("jdbc:derby://localhost:1527/book_details");
        }catch(Exception e){
            
        }
    }
    
    public ArrayList<String> getData(int id){
        ArrayList<String> dataSet = new ArrayList<>();
        String check = "";
        try{
            check = conn.toString();
        Statement stmt = conn.createStatement();
        check = "Stmt";
        ResultSet rs = stmt.executeQuery("SELECT * FROM APP.DETAILS where id = "+id);
        check = "Result set";
        while(rs.next()){
//            Data data = new Data();
//            data.setId(rs.getInt("id"));
//            data.setName(rs.getString("name"));
            dataSet.add(rs.getString("name"));
        }
        
        stmt.close();
        conn.close();
        }catch(Exception e){
           check = "Error is "+e.toString();
        }
        return dataSet;
    }
}
