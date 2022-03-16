package text_Account_Book;
import java.util.Scanner;


public class Account_Book {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		final int SIZE = 1;  // 배열의 크기를 임시로 정하기 위한 상수
		
		/*가계부의 정보들을 저장할 배열들*/
		String[] date = new String[SIZE];
		String[] type = new String[SIZE];
		String[] memo = new String[SIZE];
		int[] money = new int[SIZE];
		
		int income = 0;  // 총 수입
		int expense = 0;  // 총 지출
		int total = 0;  // 총 보유 금액
		
		int flag = 0;
		int page = 1;
		
		while(true) {
			System.out.println("====================================");
			System.out.println("1.내용 추가 | 2.수입 | 3.지출 | 5.종료");
			System.out.println("====================================");
			
			System.out.printf("날짜\t\t금액\t\t수입/지출\n");
			
			
			break;
		}
		

	}

}
