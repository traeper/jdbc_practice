package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by jay on 2018. 10. 28.
 * http://hyeonstorage.tistory.com/112 블로그 참고했습니다.
 **/
public class InsertExample {
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/shopping_mall?useUnicode=true&characterEncoding=UTF-8";
    private static final String user = "root";
    private static final String password = "1234";

    private static PreparedStatement pstmt;
    private static Connection conn;

    public static void main(String[] args) {
        try {
            // 데이터베이스와 연동하기 위해 DriverManager에 mysql 드라이버를 등록한다.
            Class.forName("com.mysql.jdbc.Driver");

            // DriverManager 객체로부터 Connection 객체를 얻어온다.
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("connection successful");

            // TODO 다이얼로그 띄우기.

            // TODO Import 할 엑셀 파일 선택

            // TODO 엑셀 파일에서 데이터 불러오기(N건)

            // TODO N건의 데이터에 대해 반복문으로 INSERT 쿼리 실행하기

            // TODO exam_date가 null인 경우
//            if(patient.getExamDate() == null) {
//
//            }

            // sql 쿼리
            String sql = "insert into user (name) values(?)";

            // prepareStatement에서 해당 sql을 미리 컴파일한다.
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "손나은");
//            pstmt.setInt(2, 20181029);

            // 쿼리를 실행한다.
            pstmt.executeUpdate();

            // 성공시 메시지 출력
            System.out.println("user 테이블에 새로운 레코드를 추가했습니다.");
        } catch (SQLException e) {
            // 예외가 발생하면 예외 상황을 처리한다.
            e.printStackTrace();

            System.out.println("user 테이블에 새로운 레코드 추가에 실패했습니다.");
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