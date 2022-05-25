package account_Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DB {
	private Connection conn; //DB Ŀ�ؼ� ���� ��ü
    private static final String USERNAME = "root";//DBMS���� �� ���̵�
    private static final String PASSWORD = "root";//DBMS���� �� ��й�ȣ
    private static final String URL = "jdbc:mysql://localhost:3306/account_book";//DBMS������ DB��
    
    public DB() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");  // forName ���� : https://limdevbasic.tistory.com/26
            System.out.println("����̹� �ε� ����");
        } catch (Exception e) {  // Exception ��ü e ����
        	e.printStackTrace();  // ���� ���� ���
        }
    }
    
    public static boolean logIn(String id, String password) {
    	if (USERNAME.equals(id) && PASSWORD.equals(password)) {
    		getConn();
    		return true;
    	}
    	else {
    		// System.out.println("ID Ȥ�� Password�� Ʋ�Ƚ��ϴ�.");
    		return false;
    	}
    }
    
    public static Connection getConn() {
    	
    	Connection conn = null;
    	
    	try {
    		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    		// System.out.println("�α��� ����");
    	} catch (SQLException e) {
    		System.out.println("�α��� ����(�߸��� �Է� ����)");
    	}
    	return conn;
    }
    /* ������ ���� */
    public static void insertData(String date, String type, String money, String memo){
		try{
			Connection con = getConn();
			
			/* ��ɾ� ���� */
			String sql = "INSERT INTO account_book (a_date, a_type, money, memo) "
					+ "VALUES ( ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, date);  // PreparedStatement ��ü��.setString(? ����, �Է� ������)
				pstmt.setString(2, type);
				pstmt.setString(3, money);
				pstmt.setString(4, memo);
				pstmt.executeUpdate();
				// System.out.println("The data has been saved!");
		}catch(Exception e){
			// System.out.println(e.getMessage());
		}
	}
    
    /* ������ ���� */
    public static void updateData(String date, String type, String money, String memo, String id){
		try{
			Connection con = getConn();
			
			/* ��ɾ� ���� */
			String sql = "UPDATE account_book SET a_date=?, a_type=?, money=?, memo=? WHERE id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, date);  // PreparedStatement ��ü��.setString(? ����, �Է� ������)
				pstmt.setString(2, type);
				pstmt.setString(3, money);
				pstmt.setString(4, memo);
				pstmt.setString(5, id);
				pstmt.executeUpdate();
				// System.out.println("The data has been saved!");
		}catch(Exception e){
			// System.out.println(e.getMessage());
		}
	}
    
    /* ������ ���� */
    public static void deleteData(String id){
		try{
			Connection con = getConn();
			
			/* ��ɾ� ���� */
			String sql = "DELETE FROM account_book WHERE id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
				// System.out.println("The data has been saved!");
		}catch(Exception e){
			// System.out.println(e.getMessage());
		}
	}
    
    // ������ �ҷ�����
    public static String[][] getData(String order){
		try{
			Connection con = getConn();
			PreparedStatement statement = con.prepareStatement("Select a_date, a_type, money, memo, id FROM account_book ORDER BY a_date " + order);
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()){
				list.add(new String[]{
							results.getString("a_date"),
							results.getString("a_type"),
							results.getString("money"),
							results.getString("memo"),
							results.getString("id"),
						});
			}
			// System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
			
		}catch(Exception e){
			// System.out.println(e.getMessage());
			return null;
		}
	}
    
    // ������ �ҷ�����(����)
    
    public static String[][] getDataFilter(String type, String order){
    	try{
			Connection con = getConn();
			PreparedStatement statement = con.prepareStatement("Select a_date, a_type, money, memo FROM account_book where a_type= '" + type + "' ORDER BY a_date " + order);
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()){
				list.add(new String[]{
							results.getString("a_date"),
							results.getString("a_type"),
							results.getString("money"),
							results.getString("memo"),
							results.getString("id"),
						});
			}
			// System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
			
		}catch(Exception e){
			// System.out.println(e.getMessage());
			return null;
		}
	}
    
    public static String[][] getSearchData(String type, String order){
    	try{
			Connection con = getConn();
			PreparedStatement statement = con.prepareStatement("Select a_date, a_type, money, memo FROM account_book " + type + " ORDER BY a_date " + order);
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()){
				list.add(new String[]{
							results.getString("a_date"),
							results.getString("a_type"),
							results.getString("money"),
							results.getString("memo"),
							results.getString("id"),
						});
			}
			// System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
			
		}catch(Exception e){
			// System.out.println(e.getMessage());
			return null;
		}
	}
}