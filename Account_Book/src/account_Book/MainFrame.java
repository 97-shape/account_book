package account_Book;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MainFrame {

	private JFrame frame;
	private JTextField searchField;
	private JTextField inputDate;
	private JTextField inputMoney;
	/**
	 * @wbp.nonvisual location=91,689
	 */
	private final JTextField textID = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}
	
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		textID.setColumns(10);
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(211, 211, 211));
		frame.setSize(new Dimension(1068, 655));
		
		frame.setLocationRelativeTo(null); // ó�� ���� ��ġ = ȭ�� ���
		
		// frame.setJMenuBar(menuBar());
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String[][] data = DB.getData("ASC");
		String[] header = {"��¥", "����/����", "�ݾ�", "�޸�", "id"};
		DefaultTableModel model = new DefaultTableModel(data, header);
		JTable table = new JTable(model);
		
		table.setRowHeight(30);
		table.setSize(800,400);
		
		table.getColumn("id").setWidth(0);
		table.getColumn("id").setMinWidth(0);
		table.getColumn("id").setMaxWidth(0);
		
		/* ���̺� ��� ����*/
		JTableHeader head = table.getTableHeader();
		head.setBackground(new Color(92,179, 255));
		head.setForeground(new Color(255,255,255));
		
		
		JComboBox<String> orderBox = new JComboBox<String>();
		orderBox.addItem("ASC");
		orderBox.addItem("DESC");
		orderBox.setSelectedIndex(0);
		orderBox.setBounds(205, 282, 58, 20);
		frame.getContentPane().add(orderBox);
		
		JScrollPane jscp1 = new JScrollPane(table);
		// jscp1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		jscp1.setLocation(12,280);
        jscp1.setSize(1028,322);
        frame.getContentPane().add(jscp1);
		
		table.setPreferredScrollableViewportSize(new Dimension(800, 400));
		
		/* �˻�â */
		
		JComboBox<String> searchType = new JComboBox<String>();
		searchType.addItem("��¥");
		searchType.addItem("����/����");
		searchType.addItem("�ݾ�");
		searchType.addItem("sql��");
		searchType.setSelectedIndex(0); // �⺻�� ����
		searchType.setBounds(12, 247, 90, 23);
		frame.getContentPane().add(searchType);
				
		searchField = new JTextField();
		searchField.setBounds(114, 248, 317, 22);
		frame.getContentPane().add(searchField);
		searchField.setColumns(10);
		
		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(443, 247, 97, 23);
		frame.getContentPane().add(btnSearch);
		
				
		/* �Է� / ���� */
		
		JLabel lblDate = new JLabel("\uB0A0\uC9DC");
		lblDate.setBounds(22, 127, 57, 15);
		lblDate.setHorizontalAlignment(JLabel.CENTER);  // ��� ����
		frame.getContentPane().add(lblDate);
		
		inputDate = new JTextField();
		inputDate.setBounds(91, 118, 168, 34);
		frame.getContentPane().add(inputDate);
		inputDate.setColumns(10);
		
		JLabel lblMoney = new JLabel("\uAE08\uC561");
		lblMoney.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoney.setBounds(22, 179, 57, 15);
		frame.getContentPane().add(lblMoney);
		
		inputMoney = new JTextField();
		inputMoney.setColumns(10);
		inputMoney.setBounds(91, 170, 407, 34);
		frame.getContentPane().add(inputMoney);
		
		JRadioButton rdbtnIncome = new JRadioButton("\uC218\uC785");
		rdbtnIncome.setBackground(new Color(211, 211, 211));
		rdbtnIncome.setBounds(327, 123, 72, 23);
		frame.getContentPane().add(rdbtnIncome);
		
		JRadioButton rdbtnOutcome = new JRadioButton("\uC9C0\uCD9C");
		rdbtnOutcome.setBackground(new Color(211, 211, 211));
		rdbtnOutcome.setBounds(415, 123, 72, 23);
		frame.getContentPane().add(rdbtnOutcome);
		
		ButtonGroup typeRadio = new ButtonGroup();
		typeRadio.add(rdbtnIncome);
		typeRadio.add(rdbtnOutcome);
		
		rdbtnIncome.setActionCommand("����");
		rdbtnOutcome.setActionCommand("����");
		
		JLabel lblMemo = new JLabel("\uBA54\uBAA8");
		lblMemo.setBounds(587, 114, 57, 15);
		frame.getContentPane().add(lblMemo);
		
		JTextPane inputMemo = new JTextPane();
		inputMemo.setBounds(587, 139, 407, 65);
		frame.getContentPane().add(inputMemo);
		
		/* ��ư */
		
		JButton btnInsert = new JButton("\uC0BD\uC785");
		btnInsert.setBounds(616, 247, 97, 23);
		frame.getContentPane().add(btnInsert);
		
		JButton btnUpdate = new JButton("\uC218\uC815");
		btnUpdate.setBounds(725, 247, 97, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDel = new JButton("\uC0AD\uC81C");
		btnDel.setBounds(834, 247, 97, 23);
		frame.getContentPane().add(btnDel);
		
		JComboBox<String> showType = new JComboBox<String>();
		showType.setBounds(943, 247, 97, 23);
		showType.addItem("��ü");
		showType.addItem("����");
		showType.addItem("����");
		frame.getContentPane().add(showType);
		
		/* �̺�Ʈ */
		
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String date = inputDate.getText();
					String type = typeRadio.getSelection().getActionCommand();
					String money = inputMoney.getText();
					String memo = inputMemo.getText();
					
					DB.insertData(date, type, money, memo);
					model.addRow(new Object[] {date, type, money, memo});  // Jtable�� �� �߰�
				}catch (Exception e1){
					new JOptionPane();
					JOptionPane.showMessageDialog(null, "�Է� ���� ������ �ֽ��ϴ�.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String date = inputDate.getText();
					String type = typeRadio.getSelection().getActionCommand();
					String money = inputMoney.getText();
					String memo = inputMemo.getText();
					String id = textID.getText();
					
					DB.updateData(date, type, money, memo, id);
					model.setNumRows(0);
					String[][] newData = DB.getData((String) orderBox.getSelectedItem());
					for (int i=0; i<newData.length; i++) {
						model.addRow(newData[i]);					
					}
				}catch (Exception e1){
					new JOptionPane();
					JOptionPane.showMessageDialog(null, "�Է� ���� ������ �ֽ��ϴ�.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String id = textID.getText();
					DB.deleteData(id);
					model.setNumRows(0);
					String[][] newData = DB.getData((String) orderBox.getSelectedItem());
					for (int i=0; i<newData.length; i++) {
						model.addRow(newData[i]);					
					}
				}catch (Exception e1){
					new JOptionPane();
					JOptionPane.showMessageDialog(null, "�Է� ���� ������ �ֽ��ϴ�.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		showType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String type = (String) showType.getSelectedItem();
				if (type == "��ü"){
					for (int i=0; i<data.length; i++) {
						model.addRow(data[i]);					
					}
				}else {
					model.setNumRows(0);
					String[][] newData = DB.getDataFilter(type, (String) orderBox.getSelectedItem());
					for (int i=0; i<newData.length; i++) {
						model.addRow(newData[i]);					
					}
				}
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String type = (String) searchType.getSelectedItem();
				String search = (String) searchField.getText(); 
				System.out.println(type + " " + search);
				if (type == "sql��") {
					
				}else {
					switch (type) {
						case "��¥":
							type = "a_date";
							break;
						case "����/����":
							type = "a_type";
							break;
						case "�ݾ�":
							type = "money";
							break;
					}
					search = String.format("where %s='%s'", type, search);
					System.out.println(type + " " + search);
				}
				String[][] searchData = DB.getSearchData(search, (String) orderBox.getSelectedItem());
				model.setNumRows(0);
				for (int i=0; i<searchData.length; i++) {
					model.addRow(searchData[i]);					
				}
			}
		});
		
		orderBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String order = (String) orderBox.getSelectedItem();
				String[][] orderData = DB.getData(order);
				model.setNumRows(0);
				for (int i=0; i<orderData.length; i++) {
					model.addRow(orderData[i]);					
				}
			}
		});
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table.rowAtPoint(evt.getPoint());
		        inputDate.setText((String) table.getValueAt(row, 0));
		        if (table.getValueAt(row, 1).equals("����")) {
		        	rdbtnIncome.setSelected(true);
		        }else {
		        	rdbtnOutcome.setSelected(true);
		        }
		        inputMoney.setText((String) table.getValueAt(row, 2));
		        inputMemo.setText((String) table.getValueAt(row, 3));
		        textID.setText((String) table.getValueAt(row, 4));
			}
		});
	}
}
