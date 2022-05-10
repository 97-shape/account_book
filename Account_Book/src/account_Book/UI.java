package account_Book;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UI {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setVisible(true);
		/*  Dimension Ŭ������ Ư�� ������ �簢���� ���� ������ ���� ������ �� �ֵ��� �����ִ� Ŭ����
		 * setPreferredSize �� setSize ���̴�? 
		 */
		frame.setPreferredSize(new Dimension(940, 840/12*9));
		frame.setSize(840, 840/12*9);
		frame.setResizable(false); // â ũ�� ���� ����

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // GUI�� �ݰ��� �� �� �ൿ
		
		frame.setLocationRelativeTo(null);  // â�� ���� ��ġ
		
		panel.add(new JLabel("Welcome"));
		
		frame.add(panel);
		
	}

}
