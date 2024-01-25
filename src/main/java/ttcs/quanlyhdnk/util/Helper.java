/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttcs.quanlyhdnk.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ADMIN
 */
public class Helper {
    public static Connection openConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=QuanLyHDNK;encrypt=true;trustServerCertificate=true;";
        String user ="sa";
        String password="123456";
        Connection con = DriverManager.getConnection(connectionURL,user,password);
        return con;
    }
}
