package zakk.app.my_app;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Meny  extends JFrame {

	 static Scanner scn ;
 
	 String Reading1  = "";
	 String Reading2 ;
	
	 static Scanner sc_k ;
	 
	public Meny() {
		super("Тестовое окно");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		panel.add(Box.createVerticalGlue());

		final JLabel label = new JLabel("Выбранный файл");
		label.setAlignmentX(CENTER_ALIGNMENT);
		panel.add(label);

		panel.add(Box.createRigidArea(new Dimension(10, 10)));
 
		
		JButton button = new JButton("Показать JFileChooser");
		button.setAlignmentX(CENTER_ALIGNMENT);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileopen = new JFileChooser();
				
			    
		        FileFilter ft = new FileNameExtensionFilter("Text Files", "txt");
		        fileopen.addChoosableFileFilter( ft );
		        FileFilter ft1 = new FileNameExtensionFilter("Java Files", "java");
		        fileopen.addChoosableFileFilter( ft1 );
		        FileFilter ft2 = new FileNameExtensionFilter("Folder","null");
		        fileopen.addChoosableFileFilter( ft2 );
		        
		        
				int ret = fileopen.showDialog(null, "Открыть файл");
				if (ret == JFileChooser.APPROVE_OPTION) {
					File file = fileopen.getSelectedFile();
					 label.setText(file.getName());
					
		 
					String st = "";		 
				
	 
				 String name = file.getAbsolutePath();  // шлях до файла
					int kk= 0;int kk1= 0;
					String ch = "";
				 char[] chars = name.toCharArray();
				 
						for (int i = 0; i < chars.length ; i++) {
							try {
								if (chars[i] == '\'' || chars[i] == '/') {									
									kk++;
								}
							} catch (Exception ex) {
							}
						}
							
						
						for (int i = 0; i < chars.length ; i++) {
							try {
								if (chars[i] == '\'' || chars[i] == '/') {	
									kk1++;	
									ch = ch + chars[i];
									if(kk == kk1){
										break;
									}
								}
							} catch (Exception ex) {
							}
						}
						System.out.print(ch);
					}

				}
			
		});

		panel.add(button);
		panel.add(Box.createVerticalGlue());
		getContentPane().add(panel);

		setPreferredSize(new Dimension(260, 220));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
