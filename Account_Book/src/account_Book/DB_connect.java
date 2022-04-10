package account_Book;

import java.sql.*;

public class DB_connect {
    private Connection conn; //DB 커넥션 연결 객체
    private static final String USERNAME = "root";//DBMS접속 시 아이디
    private static final String PASSWORD = "violet@@1123";//DBMS접속 시 비밀번호
    private static final String URL = "jdbc:mysql://localhost:3306/account_book";//DBMS접속할 db명
    
    public DB_connect() {
        try {
        	Statement state = null; 
        	// DB 접속
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            state = conn.createStatement();
            
            String sql; //SQL문을 저장할 String
            sql = "SELECT * FROM account_book";
            ResultSet rs = state.executeQuery(sql); //SQL문을 전달하여 실행
            			
            while(rs.next()){
        		String no = rs.getString("account_no");
        		String date = rs.getString("account_date");
        		String type = rs.getString("account_type");
        		String money = rs.getString("account_money");
        		String memo = rs.getString("account_memo");
        		System.out.print(no + " " + date + " " +  type+" "+money+" ");
        		if (memo == null)
        			System.out.println("");
        		else
        			System.out.println(memo);
        	}
        	
        	rs.close();
        	state.close();
        	conn.close();
        } catch (Exception e) {
            System.out.println("드라이버 로딩 실패 ");
            try {
                conn.close();
            } catch (SQLException e1) {    }
        }
    }
}