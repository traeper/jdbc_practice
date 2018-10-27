package example;

import java.sql.*;

/**
 * Created by jay on 2018. 10. 28.
 * http://hyeonstorage.tistory.com/112 블로그 참고했습니다.
 **/
public class SelectExample {
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/shopping_mall?useUnicode=true&characterEncoding=UTF-8";
    private static final String user = "root";
    private static final String password = "";

    private static Statement stmt;
    private static Connection conn;
    private static ResultSet resultSet;

    public static void main(String[] args) {
        try {
            // 데이터베이스와 연동하기 위해 DriverManager에 mysql 드라이버를 등록한다.
            Class.forName("com.mysql.jdbc.Driver");

            // DriverManager 객체로부터 Connection 객체를 얻어온다.
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("connection successful");

            String queryString = "SELECT * FROM user";

            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(queryString);

            // 컬럼 정보 가져오기
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            // 컬럼 출력
            System.out.println(resultSetMetaData.getColumnName(1) + "\t" + resultSetMetaData.getColumnName(2));

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "\t" + resultSet.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 쿼리가 성공 또는 실패에 상관없이 사용한 자원을 해제 한다. (순서중요)
            if (stmt != null) try {
                // PreparedStatement 객체 해제
                stmt.close();
            } catch (SQLException sqle) {
            }

            if (conn != null) try {
                // Connection 해제
                conn.close();
            } catch (SQLException sqle) {
            }

        }
    }


}