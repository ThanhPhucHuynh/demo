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
public class readers {
    private String ID;
    private String Name;
    private String address;
    private String phone;
    
    public readers(){
        this.ID = null;
        this.Name =null;
        this.address=null;
        this.phone=null;
    }
    public void setID(String id){
        this.ID=id;
    }
    public void setName(String name){
        this.Name=name;
    } 
    public void setAddress(String address){
        this.address=address;
    } 
    public void setphone(String phone){
        this.phone=phone;
    }  
    
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.Name;
    }
    public String getAddress(){
        return this.address;
    }
    public String getPhone(){
        return this.phone;
    }
    
}
