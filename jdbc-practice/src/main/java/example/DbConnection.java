package example;

import java.sql.*;

/**
 * Created by jay on 2018. 10. 28.
 **/
public class DbConnection {
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final  String url = "jdbc:mysql://localhost:3306/shopping_mall?useUnicode=true&characterEncoding=UTF-8";
    private static final  String user = "root";
    private static final  String password = "1234";


    public static void main(String[] args) {
        try {
            // 데이터베이스와 연동하기 위해 DriverManager에 mysql 드라이버를 등록한다.
            Class.forName("com.mysql.jdbc.Driver");

            // DriverManager 객체로부터 Connection 객체를 얻어온다.
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("connection successful");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
