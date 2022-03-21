package text_Account_Book;
import java.util.ArrayList;
import java.util.Scanner;


public class Account_Book {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		final int SIZE = 11;  // �迭�� ũ�⸦ �ӽ÷� ���ϱ� ���� ���
		
		/*������� �������� ������ �迭�� (�����迭)*/
		ArrayList<String> date = new ArrayList<String>(SIZE);
		ArrayList<String> type = new ArrayList<String>(SIZE);
		ArrayList<String> memo = new ArrayList<String>(SIZE);
		ArrayList<Integer> money = new ArrayList<Integer>(SIZE);
		
		/*������� �������� ������ �迭��
		String[] date = new String[SIZE];
		String[] type = new String[SIZE];
		String[] memo = new String[SIZE];
		int[] money = new int[SIZE];
		*/
		
		int len = SIZE;  // �迭�� ����
		
		int income = 0;  // �� ����
		int expense = 0;  // �� ����
		int total = 0;  // �� ���� �ݾ�
		
		int flag = 0;  // ���
		int page = 0;
		int display = 5;  // �� �������� ��� ������ �������� ��
		final int Display_Level = 5;  // �� �������� �ִ� 5�� ��� ���
		
		int show = 0;  // ��µ� �������� �ε���
		while(true) {
			System.out.println("==============================================================");
			System.out.println("1.���� �߰� | 2.���� | 3.���� | 5.����");
			System.out.println("==============================================================");
			
			System.out.printf("��¥\t\t����/����\t\t�ݾ�\t\t��\n");
			
			len = date.size();
			
			/* �迭�� ���̺��� �ִ� ����� �� ū��?*/
			if (len - (page * Display_Level) < Display_Level)
				display = len;
			else
				display = 5 * (page+1);
			
			for (show = page * 5; show < display; show++) {
				System.out.printf("%s\t%s\t\t%d\t\t%s \n", date.get(show), type.get(show), money.get(show), memo.get(show));
			}
			
			System.out.println("==============================================================");
			System.out.printf("6.����\t\t\tpage %d\t\t\t7.����\n", page+1);
			System.out.print("����� �Է����ּ���: ");
			flag = sc.nextInt();
			
			switch (flag) {
			case(1):
				System.out.print("��¥: ");
				date.add(sc.next());
				System.out.print("�ݾ�: ");
				money.add(sc.nextInt());
				System.out.print("����/����: ");
				type.add(sc.next());
				System.out.print("��: ");
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
