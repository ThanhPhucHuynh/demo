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
   
    PreparedStatement ps =null;
  //  PreparedStatement 
    public connector(){
             
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
             conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/book_db?serverTimezone=UTC&user=root");
             System.out.println("thanh cong");
        } catch (Exception ex) {
            System.err.println("loi +"+ex);
        }
               
    }
    public book[] dvsv(){
        book[] books = new book[0];          
        try {
          //  stmt = conn.createStatement();
          PreparedStatement   ps = conn.prepareStatement("select b.id_book,b.name_book,b.author_book,b.id_category,b.numbers_book,b.price_book from books b");
           ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                books =(book[]) Arrays.copyOf(books, books.length+1);
                books[books.length-1] = new book();
                books[books.length-1].setID(rs.getString("id_book"));
                books[books.length-1].setName(rs.getString("name_book"));
                books[books.length-1].setAuthor(rs.getString("author_book"));
                books[books.length-1].setCategory(getTL(rs.getString("id_category")));
             // books[books.length-1].setCategory("ass");
                books[books.length-1].setSL(rs.getInt("numbers_book"));
                books[books.length-1].setPrice(rs.getInt("price_book"));
                String name_book = rs.getString("name_book");
                System.out.println(name_book);
               
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    public String getTL(String id_category){
        String name="xxx";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select getTL('"+id_category+"')");
            while(rs.next()){
                name= rs.getString("getTL('"+id_category+"')");
            } 
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(connector.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return name;
    }
    
    public category[] getCategory(){
        category[] tl =new category[0];
        try {
            PreparedStatement   ps = conn.prepareStatement("select * from category");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                tl = (category[]) Arrays.copyOf(tl, tl.length+1);
                tl[tl.length-1]=new category();      
                tl[tl.length-1].setID(rs.getString("id_category"));
                tl[tl.length-1].setName(rs.getString("name_category"));
                
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return tl;
    }
    
    public boolean addBook(String ID,String Name,String author,String id_category, int sl,int pice){
        boolean flag = false;
        CallableStatement cstmt=null;
        //ResultSet rs = null;
        System.err.println("oke la");
        int check = checkIDexist(ID);
        if(check==-1){
        
        
        try {
            cstmt=conn.prepareCall("{call sp_addbook(?,?,?,?,?,?)}");
            cstmt.setString(1,ID);
            cstmt.setString(2, Name);
            cstmt.setString(3, author);
            cstmt.setString(4,id_category);
            cstmt.setInt(5, sl);
            cstmt.setInt(6, pice);
            cstmt.executeQuery();
            flag=true;
            cstmt.close();
                    
          } catch (SQLException ex) {
            Logger.getLogger(connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }else{
            try {
                cstmt=conn.prepareCall("{call sp_updatebook(?,?)}");
                cstmt.setString(1, ID);
                cstmt.setInt(2, check+sl);
                cstmt.executeQuery();
                 flag=true;
                 cstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(connector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          
        return flag;
    }
    
    public void delBook(String id){
        CallableStatement cstmt=null;
        int check = checkIDexist(id);
        if(check==1){
         
          try {
            cstmt=conn.prepareCall("{call sp_delbook(?)}");
            cstmt.setString(1,id);
            cstmt.executeQuery();          
            cstmt.close();          
          } catch (SQLException ex) {
            Logger.getLogger(connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
             try {
                cstmt=conn.prepareCall("{call sp_updatebook(?,?)}");
                cstmt.setString(1, id);
                cstmt.setInt(2, check-1);
                cstmt.executeQuery();
                 //flag=true;
                 cstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(connector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public int checkIDexist(String id){
        int flag = -1;
         try {
            stmt= conn.createStatement();
            rs =stmt.executeQuery("select getSL('"+id+"')");
            while(rs.next()){
           // System.err.println("kq"+rs.getString("getAdmin('"+account+"')"));
            flag = rs.getInt("getSL('"+id+"')");
            }
        } catch (Exception ex) {
            System.out.println("err: "+ ex);
        }
        return flag;
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
