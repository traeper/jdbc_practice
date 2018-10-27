package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by jay on 2018. 10. 28.
 * http://hyeonstorage.tistory.com/112 블로그 참고했습니다.
 **/
public class DeleteExample {
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/shopping_mall?useUnicode=true&characterEncoding=UTF-8";
    private static final String user = "root";
    private static final String password = "";

    private static PreparedStatement pstmt;
    private static Connection conn;

    public static void main(String[] args) {
        try {
            // 데이터베이스와 연동하기 위해 DriverManager에 mysql 드라이버를 등록한다.
            Class.forName("com.mysql.jdbc.Driver");

            // DriverManager 객체로부터 Connection 객체를 얻어온다.
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("connection successful");

            // sql 쿼리
            String queryString = "DELETE FROM user WHERE id=?";

            pstmt = conn.prepareStatement(queryString);
            pstmt.setInt(1, 4);

            int resultValue = pstmt.executeUpdate();
            System.out.println("삭제 완료 " + resultValue + "명");
        } catch (Exception e) {
            // 예외가 발생하면 예외 상황을 처리한다.
            e.printStackTrace();
        } finally {
            // 쿼리가 성공 또는 실패에 상관없이 사용한 자원을 해제 한다. (순서중요)
            if (pstmt != null) try {
                // PreparedStatement 객체 해제
                pstmt.close();
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