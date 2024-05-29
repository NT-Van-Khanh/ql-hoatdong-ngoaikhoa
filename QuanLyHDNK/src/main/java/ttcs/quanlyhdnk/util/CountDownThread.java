/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttcs.quanlyhdnk.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class CountDownThread extends Thread {
    @Override
    public void run(){
            int count =60*2;
            int index=count;
            for(;index>0;--index){
                System.out.println(index);
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CountDownThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            if(index==0){
                System.out.print("Het gio");
            }
    }
}
