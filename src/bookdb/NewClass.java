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
public class NewClass {
    public static void main(String agp[]){
        connector cn =new  connector();
        System.out.println(cn.getnameReadersexist("B16"));
        cn.addReaders("B16", "Thanh Thao", "Dong Thap", "09278137");
    }
}
