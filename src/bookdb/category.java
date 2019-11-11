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
public class category {
    private String id;
    private String name;
    
    public category(){
        this.id=null;
        this.name=null;
    }
    
    public String getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public void setID(String id){
        this.id = id;
    }
    public void setName(String Name){
        this.name = Name;
    }
    
    
}
