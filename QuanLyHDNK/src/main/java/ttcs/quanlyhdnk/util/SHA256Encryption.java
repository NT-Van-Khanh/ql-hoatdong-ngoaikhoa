/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttcs.quanlyhdnk.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class SHA256Encryption {
    public static String toSHA256(String str){
        String salt="@ptithcm";
        String result=null;
        str= str+salt;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash=md.digest(str.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for(int index = 0; index<hash.length;index++){
                String hex = Integer.toHexString(0xff&hash[index]);
                if(hex.length()==1){
                    hexString.append('0');   
                }
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SHA256Encryption.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    private static  String bytesToHex(byte[] bytes){
        if(bytes==null){
            return null;
        }
        final StringBuilder hex = new StringBuilder(2*bytes.length);
        
        return "";
    }
}
