/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookdb;

import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Thanh Phuc Huynh
 */
public class connector {
    
    
    Connection conn = null;
    Statement stmt =null;
    ResultSet rs = null;
    CallableStatement cstmt=null;
    public connector(){
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
             conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbbooks?serverTimezone=UTC&user=root");
             System.out.println("thanh cong");
        } catch (Exception ex) {
            System.err.println("loi +"+ex);
        }
               
    }
    public book[] dvsv(){
        book[] books = new book[0];
        
        
        try {
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery("select * from books");
            while(rs.next()){
                books =(book[]) Arrays.copyOf(books, books.length+1);
                books[books.length-1] = new book();
                books[books.length-1].setID(rs.getString("id_book"));
                books[books.length-1].setName(rs.getString("name_book"));
                books[books.length-1].setAuthor(rs.getString("author_book"));
                books[books.length-1].setSL(8);
                books[books.length-1].setCL(2);
                
                String name_book = rs.getString("name_book");
                System.out.println(name_book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    public String checkAdmin(String account, String passwoed){
        String pass = "-1";
        try {
            stmt= conn.createStatement();
            rs =stmt.executeQuery("select getAdmin('"+account+"');");
            while(rs.next()){
            System.err.println("kq"+rs.getString("getAdmin('"+account+"')"));
            pass = rs.getString("getAdmin('"+account+"')");
            }
        } catch (Exception ex) {
            System.out.println("err: "+ ex);
        }
        return pass;
    }
}
