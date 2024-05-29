/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttcs.quanlyhdnk.util;

import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class RandomCode {
    private static String numberString="0123456789"; 
    
    public static String randomCode(){
        Random rd = new Random();
        String output="";
        int index;
        for(int i=0;i<4;++i){
             index = rd.nextInt(0,numberString.length());
             output=output + numberString.charAt(index);
            
        }
        return output;
    }
}
