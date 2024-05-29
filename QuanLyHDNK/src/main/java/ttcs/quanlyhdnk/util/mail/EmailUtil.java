/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttcs.quanlyhdnk.util.mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author ADMIN
 */
public class EmailUtil {
    private static final String HOST_NAME       ="smtp.gmail.com";
    private static final String SSL_PORT_NAME   ="465";//587
    private static final String TSL_PORT_NAME   ="587";//TLS/STARTTLS
    private static final String APP_EMAIL       ="vankhanhtest@gmail.com";
    private static final String APP_PASSWORD    ="ryusjjsdzygotjmu";
    //private static final String RECEIVE_EMAIL   ="email_dich@gmail.com";
    
    
    public static void sendEmail( String toEmail, String subject, String body) throws MessagingException{
        
        Properties smtpProps = new Properties();
        smtpProps.put("mail.smtp.auth", "true");
        smtpProps.put("mail.smtp.host", HOST_NAME);
        smtpProps.put("mail.smtp.port", SSL_PORT_NAME);
        smtpProps.put("mail.smtp.socketFactory.port",SSL_PORT_NAME);
        smtpProps.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        smtpProps.put("mail.smtp.starttls.enable", "true"); // for tsl
        
        Session session = Session.getDefaultInstance(smtpProps,new javax.mail.Authenticator(){//lay session
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(APP_EMAIL,APP_PASSWORD);
            }   
        });

        MimeMessage message = new MimeMessage(session);
        message.addHeader("Content-type","text/HTML; charset= UTF-8");
        message.setFrom(new InternetAddress(APP_EMAIL));//ng gui
        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toEmail));// ng nhan
        message.setSubject(subject);// tieu de
        message.setText(body);// noi dung
        
        Transport.send(message);    
    }
}

        //
//                    message.setText(body);
//            Transport.send(message);
//        }catch (MessagingException e){  
//            System.out.println(e.getMessage());
//            if(e.getMessage().equals("Invalid Addresses")){
//                
//            }
//        }