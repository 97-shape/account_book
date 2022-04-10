package account_Book;

import java.sql.*;

public class DB_connect {
    private Connection conn; //DB Ŀ�ؼ� ���� ��ü
    private static final String USERNAME = "root";//DBMS���� �� ���̵�
    private static final String PASSWORD = "violet@@1123";//DBMS���� �� ��й�ȣ
    private static final String URL = "jdbc:mysql://localhost:3306/account_book";//DBMS������ db��
    
    public DB_connect() {
        try {
        	Statement state = null; 
        	// DB ����
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            state = conn.createStatement();
            
            String sql; //SQL���� ������ String
            sql = "SELECT * FROM account_book";
            ResultSet rs = state.executeQuery(sql); //SQL���� �����Ͽ� ����
            			
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
            System.out.println("����̹� �ε� ���� ");
            try {
                conn.close();
            } catch (SQLException e1) {    }
        }
    }
}