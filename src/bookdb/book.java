/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookdb;

/**
 *
 * @author Thanh Phuc Huynh
 */
public class book {
    private String ID;
    private String Name;
    private String Author;
    private int  Sl;
    private int CL;
    
    
    public book(){
        this.ID = null;
        this.Name = null;
        this.Author = null;
        this.Sl = -1;
        this.CL = -1;
    }
    
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.Name;
    }
    public String getAuthor(){
        return this.Author;
    }
    public int getSL(){
        return this.Sl;
    }
    public int getCL(){
        return this.CL;
    }
    
    public void setID(String ID){
        this.ID = ID;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public void setAuthor(String Author){
        this.Author = Author;
    }
    public void setSL(int sl){
        this.Sl =sl;
    }
    public void setCL(int cl){
        this.CL =cl;
    }
    
}
