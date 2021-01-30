package com.example.oauth1;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

//@SpringBootTest
public class Oauth1ApplicationTests {

    public static void main(String[] args) {
        loadMySQLExtDict();
    }

    private static Properties prop = new Properties();
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("error:" + e);
        }
    }
    private static void loadMySQLExtDict() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://39.107.138.238:3306/ik_test?characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
                    "root", "yzh817621!!");

            System.out.println("conn:"+conn.toString());

            stmt = conn.createStatement();


            rs = stmt.executeQuery(prop.getProperty("select word from hot_words"));
            while(rs.next()) {
                String theWord = rs.getString("word");
                System.out.println(theWord);            }
        } catch (Exception e) {
            System.out.println("xxx"+e);
        } finally {

        }
    }

}
