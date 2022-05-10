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
		/*  Dimension 클래스는 특정 영역의 사각형과 폭과 높이의 값을 관리할 수 있도록 도와주는 클래스
		 * setPreferredSize 와 setSize 차이는? 
		 */
		frame.setPreferredSize(new Dimension(940, 840/12*9));
		frame.setSize(840, 840/12*9);
		frame.setResizable(false); // 창 크기 변경 설정

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // GUI가 닫겼을 때 할 행동
		
		frame.setLocationRelativeTo(null);  // 창의 실행 위치
		
		panel.add(new JLabel("Welcome"));
		
		frame.add(panel);
		
	}

}
