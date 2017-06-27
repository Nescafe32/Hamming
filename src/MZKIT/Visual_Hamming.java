package MZKIT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Visual_Hamming {
	private static JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6, textField_7;
	private static JComboBox [] comboBox;
	private static JComboBox iskBlockNumber, iskSymNumber;
	static Integer [][] arrCod, arrDecod;
	static Integer [] rez, kolvoOd, k, r;
	static ArrayList <Integer[]> codirovanie, decodirovanie;
	static int codeRast, kolvoNadl, limit, lenght;
	static String name;
	
	static Character s1, s2, s3, s4; 					// �������
	static String c1 = "", c2 = "", c3 = "", c4 = ""; 	// �� ����
	
	public static void podschet (int limit, Integer [] arr) { 			// ������� ���������� ������ ��� ���������� ri ��� ci
		int dop = 0, i;
		for (i = 0; i < arr.length && i < limit; i += 2)
			dop += arr[i];
		kolvoOd[0] = dop;
		
		dop = 0;
		for (i = 1; i < limit; i += 4)
			for (int j = i; j < arr.length && j <  i + 2; j++)
			dop += arr[j];
		kolvoOd[1] = dop;
		
		dop = 0;
		for (i = 3; i < limit; i += 8)
			for (int j = i; j < arr.length && j < i + 4; j++)
			dop += arr[j];
		kolvoOd[2] = dop;
		
		dop = 0;
		for (i = 7; i < limit; i += 16)
			for (int j = i; j < arr.length && j < i + 8; j++)
			dop += arr[j];
		kolvoOd[3] = dop;
	}
	
	public static String code (Map <Character, String> es, Set <Character> set, Character s) { // ������� � ����� ��� �������
		for (Character key : set) {	
			if (s.equals(key)) { 
				return es.get(key);
			}
		}
		return null;
	}
	
	private static void cod () { // �������� ��� ����� � ������� ���������� � �����
		arrCod = codirovanie.toArray(new Integer [codirovanie.size()][]);
		StringBuilder [] sbCod = new StringBuilder [codirovanie.size()];
		
		for (int i = 0; i < codirovanie.size(); i++) {
			sbCod[i] = new StringBuilder ();
			for (int j = 0; j < arrCod[i].length; j++)
				sbCod[i].append(arrCod[i][j]);
				
		}
		
		textField.setText(sbCod[0].toString());
		textField_2.setText(sbCod[1].toString());
		textField_4.setText(sbCod[2].toString()); 
		
		if (codeRast == 4) { 
			textField_6.setText(sbCod[3].toString()); 
		}
	}
	
	private static void decod () { // ���������� ��� �����
		arrDecod = decodirovanie.toArray(new Integer [decodirovanie.size()][]);
		StringBuilder [] sbDecod = new StringBuilder [codirovanie.size()];

		for (int i = 0; i < codirovanie.size(); i++) {
			sbDecod[i] = new StringBuilder ();
			for (int j = 0; j < arrDecod[i].length; j++)
				sbDecod[i].append(arrDecod[i][j]);					
		}
		
		textField_1.setText(sbDecod[0].toString());
		textField_3.setText(sbDecod[1].toString());
		textField_5.setText(sbDecod[2].toString());
		if (codeRast == 4) { 
			textField_7.setText(sbDecod[3].toString()); 
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame ("smth");
		frame.setBounds (100, 100, 503, 322);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
    	frame.setResizable(false);
    	frame.setTitle("��� ��������");
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("���������");
		btnNewButton.setBounds(151, 69, 156, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("�������� ������");
		btnNewButton_1.setBounds(151, 103, 156, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("��������� �����������");
		lblNewLabel.setBounds(64, 137, 143, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("��������� �������������");
		lblNewLabel_1.setBounds(248, 138, 156, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("1 ����");
		lblNewLabel_2.setBounds(8, 165, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("2 ����");
		lblNewLabel_3.setBounds(8, 190, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("3 ����");
		lblNewLabel_4.setBounds(8, 219, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("4 ����");
		lblNewLabel_5.setBounds(8, 244, 46, 14);
		lblNewLabel_5.setVisible(false);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(64, 163, 143, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(248, 162, 156, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(64, 187, 143, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(248, 187, 156, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(64, 216, 143, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(248, 216, 156, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(64, 241, 143, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setVisible(false);
		
		textField_7 = new JTextField();
		textField_7.setBounds(248, 241, 156, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setVisible(false);
		
		textField.setEditable(false); textField_1.setEditable(false); textField_2.setEditable(false);
		textField_3.setEditable(false); textField_4.setEditable(false); textField_5.setEditable(false);
		textField_6.setEditable(false); textField_7.setEditable(false);
		
		frame.setVisible(true);
		
		Map <Character, String> es = new HashMap <> (32); // ����� ������-���
		es.put('�', "000001");
		es.put('�', "000010");
		es.put('�', "000011");
		es.put('�', "000100");
		es.put('�', "000101");
		es.put('�', "000110");
		es.put('�', "000111");
		es.put('�', "001000");
		es.put('�', "001001");
		es.put('�', "001010");
		es.put('�', "001011");
		es.put('�', "001100");
		es.put('�', "001101");
		es.put('�', "001110");
		es.put('�', "001111");
		es.put('�', "010000");
		es.put('�', "010001");
		es.put('�', "010010");
		es.put('�', "010011");
		es.put('�', "010100");
		es.put('�', "010101");
		es.put('�', "010110");
		es.put('�', "010111");
		es.put('�', "011000");
		es.put('�', "011001");
		es.put('�', "011010");
		es.put('�', "011011");
		es.put('�', "011100");
		es.put('�', "011101");
		es.put('�', "011110");
		es.put('�', "011111");
		es.put('�', "100000");
		
		String [] alfavit = {"�", "�", "�", "�", "�", "�", "�", "�", "�", "�",
				"�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", 
				"�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�"}; 
		String [] codeDist = {"3", "4"};
		frame.getContentPane().setVisible(false);
		comboBox = new JComboBox[5];
		int i, j;
		for (i = 0; i < 4; i++) { // ������� ������� � ���������� � ���������
			comboBox[i] = new JComboBox (alfavit);
			comboBox[i].setBounds((i + 2) * 50, 25, 40, 20);
			frame.getContentPane().add(comboBox[i]);
		}
		comboBox[4] = new JComboBox (codeDist); // � ������� ����������
		comboBox[4].setBounds((i + 2) * 50, 25, 40, 20);
		frame.getContentPane().add(comboBox[4]);
		
		frame.getContentPane().setVisible(true);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Set <Character> set = new TreeSet <> ();	
				set = (Set<Character>)es.keySet(); // �������� ����� ������ � ������� ���������� ��� ���
				s1 = (Character)((String)comboBox[0].getSelectedItem()).charAt(0); c1 = code (es, set, s1);
				s2 = (Character)((String)comboBox[1].getSelectedItem()).charAt(0); c2 = code (es, set, s2);
				s3 = (Character)((String)comboBox[2].getSelectedItem()).charAt(0); c3 = code (es, set, s3);
				s4 = (Character)((String)comboBox[3].getSelectedItem()).charAt(0); c4 = code (es, set, s4);
				
				// � ������ ��������� d � 4 �� 3 - ��� �����������
				lblNewLabel_5.setVisible(false); textField_6.setVisible(false); textField_7.setVisible(false); 
				name = c1 + c2 + c3 + c4; 	// ������� �����
				lenght = name.length();		// � ��� �����
				int i, z, p;
				
				codeRast = Integer.parseInt((String) comboBox[4].getSelectedItem());
				if (codeRast == 4) {
					lblNewLabel_5.setVisible(true);
					textField_6.setVisible(true);
					textField_7.setVisible(true);
				}
				
				codirovanie = new ArrayList<>();
				decodirovanie = new ArrayList<>();
				
				for (int q = 0; q < lenght; q += lenght / codeRast) { // �������� �������� � ����������
					k = new Integer [lenght / codeRast];				
					z = 0;
					 
					for (i = q; i < q + lenght / codeRast; i++) {
						k[z++] = name.charAt(i) - '0';
					}
					
					kolvoNadl = 4;
					limit = kolvoNadl + lenght / codeRast; // ��������� ����� �����
					
					r = new Integer [kolvoNadl];
					p = 0;
					rez = new Integer [limit]; // ������ � ����������� �����
					
					for (i = 0; i < rez.length; i++) { // ������� �� ��������������� ������� �������������� ������� k
						if (i == 0 || i == 1 || i == 3 || i == 7) rez[i] = 0;
						else rez[i] = k[p++]; 
					}
								
					kolvoOd = new Integer [kolvoNadl];
			
					podschet (limit, rez); // ������� �������� r
					rez[0] = kolvoOd[0] % 2;
					rez[1] = kolvoOd[1] % 2;
					rez[3] = kolvoOd[2] % 2;
					rez[7] = kolvoOd[3] % 2;
					
					// ������� �������������� � ��������������� ����
					codirovanie.add(rez); 
					decodirovanie.add(k);								
				}
					
				cod (); decod (); 				 // �������� � ���������� ��� �����
				btnNewButton_1.setVisible(true); // ������ ����� �������� ������				
			}
		});	
		
		btnNewButton_1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame jfrm = new JFrame ("���������");
				frame.setVisible (false);
				jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				jfrm.setBounds(100, 100, 250, 250);
				jfrm.setLayout(null);
				jfrm.setVisible(true);

				JButton exit = new JButton ("���������");
				jfrm.setVisible(false);
				JLabel label1, label2;
				
				String [] ibn = new String [codeRast]; 						// ��� ����� ������ ������
				String [] isn = new String [lenght / codeRast + kolvoNadl]; // ��� ����� ���������� �������� � �����
				
				int i;
				
				// ��������� ���� ��������� ������� ����������
				for (i = 0; i < ibn.length; i++) {
					ibn[i] = new String();
					ibn[i] = "" + (i + 1);
					
				}
				
				for (i = 0; i < isn.length; i++) {
					isn[i] = new String();
					isn[i] = "" + (i + 1);
					
				}
				
				label1 = new JLabel ("����� �����"); label1.setBounds(5, 70, 170, 20); jfrm.add(label1);
				label2 = new JLabel ("����� �������"); label2.setBounds(5, 100, 170, 20); jfrm.add(label2);
				
				iskBlockNumber = new JComboBox (ibn);
				iskBlockNumber.setBounds(190, 70, 40, 20); jfrm.add(iskBlockNumber);
				
				iskSymNumber = new JComboBox (isn);
				iskSymNumber.setBounds(190, 100, 40, 20); jfrm.add(iskSymNumber);
			
				jfrm.setVisible(true);
				exit.setBounds(60, 175, 120, 20);
				jfrm.add(exit);
				
				exit.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						int i, blockNumb, sym1, smth;
						blockNumb = Integer.parseInt((String)iskBlockNumber.getSelectedItem()); // ����� �����, ��� ��������� ���������
						
						Integer[] errorComb = new Integer [limit];
						errorComb = codirovanie.get(blockNumb - 1); // �������� ����������� ����
						
						sym1 = Integer.parseInt((String)iskSymNumber.getSelectedItem()); // ���������� ������
						if (errorComb[sym1 - 1] == 1) errorComb[sym1 - 1] = 0; 	// ���� ������ ��� ������� - �������� �� ����
						else errorComb[sym1 - 1] = 1;					   		// � ��������
						
						smth = name.length() / codeRast;
				
						podschet (limit, errorComb); 	// ������������ ����
					
						int [] c = new int [kolvoNadl];
						for (i = 0; i < c.length; i++) 	// ������� �������� ��������
							c[i] = (kolvoOd[i]) % 2;
					
						String C = c[3] + "" + c[2] + "" + c[1] + "" + c[0]; // ������� �������
						int error = new Integer (C); 	// ��������� ��� � �����
						
						System.out.println ();
						if (error == 0) ; // ���� ������ ��� - �������������� �������� ������������������ �������������� �������� �����
						else {
							int errIndex = 0; 
							for (i = c.length - 1; i >= 0 ; i--)
								errIndex += c[i] * Math.pow(2, i);
							
							// ������� ������ ���� ������� �� ��������� ����� ���� ��������� �� ���������� ������
							if (errIndex > errorComb.length || errIndex == 1 || errIndex == 2 || errIndex == 4 || errIndex == 8) { 
								JOptionPane.showMessageDialog(new JFrame(),  "������� ������", "���������� ������", JOptionPane.INFORMATION_MESSAGE);
								
								codirovanie.set(blockNumb - 1, errorComb);

								StringBuilder sb = new StringBuilder ();
								
								for (int p = 0; p < errorComb.length; p++) // ������� � ������ ������� �����
									sb.append(errorComb[p]);
								
								switch (blockNumb) {
								case 1: textField.setText(sb.toString()); textField_1.setText(textField.getText()); break;
								case 2: textField_2.setText(sb.toString()); textField_3.setText(textField_2.getText()); break;
								case 3: textField_4.setText(sb.toString()); textField_5.setText(textField_4.getText()); break;
								case 4: textField_6.setText(sb.toString()); textField_7.setText(textField_6.getText()); break;				
								}

							}
							else { 				// ���� ��������� ������
								int kIndex; 	// ������� ���������� ������ ��������������� �������
								if (errIndex > 2 && errIndex < 4) kIndex = 1;
								else if (errIndex > 4 && errIndex < 8) kIndex = errIndex - 3; 
								else kIndex = errIndex - 4;
	
								// ������� ��������� � ����������� � ����������� ������
								JOptionPane.showMessageDialog(new JFrame(),  "�� ������� " + errIndex + " ���������� ������\n" + 
										"������ k" + kIndex + " = " + errorComb[errIndex - 1] + " ������ �� ��������",
										"���������� ������", JOptionPane.INFORMATION_MESSAGE);
								if (errorComb[errIndex - 1] == 0) {  errorComb[errIndex - 1] = 1; }
								else { errorComb[errIndex - 1] = 0; }
								decodirovanie.set(blockNumb - 1, k);
							}
						}				
					
						jfrm.setVisible (false);	
						frame.setVisible (true);
					}
				});	
			}
		});
	}
}