/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.choxmi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class ServletClass extends HttpServlet {

     private String message;

  public void init() throws ServletException
  {
      // Do required initialization
      message = "Hello World";
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println("First Name : "+request.getParameter("first_name"));
      out.println("Last Name : "+request.getParameter("last_name"));
      out.println("<h1>" + message + "</h1>");
      DBClass dbclass = new DBClass();
      ArrayList<String> datalist = dbclass.getData(Integer.parseInt(request.getParameter("book_id")));
      for(int i=0;i<datalist.size();i++){
      out.println("<p>"+datalist.get(i)+"</p>");
      }
  }
}
