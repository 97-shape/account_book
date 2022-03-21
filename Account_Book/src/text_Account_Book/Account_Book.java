package text_Account_Book;
import java.util.ArrayList;
import java.util.Scanner;


public class Account_Book {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		final int SIZE = 11;  // 배열의 크기를 임시로 정하기 위한 상수
		
		/*가계부의 정보들을 저장할 배열들 (동적배열)*/
		ArrayList<String> date = new ArrayList<String>(SIZE);
		ArrayList<String> type = new ArrayList<String>(SIZE);
		ArrayList<String> memo = new ArrayList<String>(SIZE);
		ArrayList<Integer> money = new ArrayList<Integer>(SIZE);
		
		/*가계부의 정보들을 저장할 배열들
		String[] date = new String[SIZE];
		String[] type = new String[SIZE];
		String[] memo = new String[SIZE];
		int[] money = new int[SIZE];
		*/
		
		int len = SIZE;  // 배열의 길이
		
		int income = 0;  // 총 수입
		int expense = 0;  // 총 지출
		int total = 0;  // 총 보유 금액
		
		int flag = 0;  // 명령
		int page = 0;
		int display = 5;  // 한 페이지에 출력 가능한 데이터의 수
		final int Display_Level = 5;  // 한 페이지에 최대 5개 목록 출력
		
		int show = 0;  // 출력될 데이터의 인덱스
		while(true) {
			System.out.println("==============================================================");
			System.out.println("1.내용 추가 | 2.수입 | 3.지출 | 5.종료");
			System.out.println("==============================================================");
			
			System.out.printf("날짜\t\t수입/지출\t\t금액\t\t상세\n");
			
			len = date.size();
			
			/* 배열의 길이보다 최대 목록이 더 큰가?*/
			if (len - (page * Display_Level) < Display_Level)
				display = len;
			else
				display = 5 * (page+1);
			
			for (show = page * 5; show < display; show++) {
				System.out.printf("%s\t%s\t\t%d\t\t%s \n", date.get(show), type.get(show), money.get(show), memo.get(show));
			}
			
			System.out.println("==============================================================");
			System.out.printf("6.이전\t\t\tpage %d\t\t\t7.다음\n", page+1);
			System.out.print("명령을 입력해주세요: ");
			flag = sc.nextInt();
			
			switch (flag) {
			case(1):
				System.out.print("날짜: ");
				date.add(sc.next());
				System.out.print("금액: ");
				money.add(sc.nextInt());
				System.out.print("수입/지출: ");
				type.add(sc.next());
				System.out.print("상세: ");
				memo.add(sc.next());
				break;
			case(5):
				System.exit(0);
			case(6):
				if (page != 0)
					page--;
				break;
			case(7):
				if (display%5 == 0)
					page++;
				break;
					
			}
			
			/*
			for (; page < date.length; page++) {
				if (date[page] == null)
					System.out.println("");
				else
					System.out.printf("%s %s %d %s \n", date[page], type[page], money[page], memo[page]);
			}
			*/
		}
		

	}

}
