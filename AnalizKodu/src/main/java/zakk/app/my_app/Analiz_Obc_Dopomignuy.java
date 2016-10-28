package zakk.app.my_app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
 
public class Analiz_Obc_Dopomignuy extends Analiz_Obcuslenna{
	
	JFrame Analiz_Obc_Dopomignuy = new JFrame("Diploma0.2");
	
	JButton  Yes , No ;
	
	JTextField t_hlah = new JTextField(20);
	
	JLabel Pusto ,Comentar = new JLabel ("Вкажіть шлях до файлу,"
 			+ " його ім’я та формат.");
	JLabel Comentar1 = new JLabel ("Наприклад:\"C:tempdir\\tmp.txt\"");
	
	 int type2 = JOptionPane.WARNING_MESSAGE;
	
	  eHandler handler = new eHandler();
	
 	Analiz_Obc_Dopomignuy(String s) throws IOException{
		super(s);
		

		
		Analiz_Obc_Dopomignuy.setVisible(true);
		Analiz_Obc_Dopomignuy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	Analiz_Obc_Dopomignuy.setSize(400, 200);
      	Analiz_Obc_Dopomignuy.setResizable(false);
      	Analiz_Obc_Dopomignuy.setLocationRelativeTo(null);
		
		Yes = new JButton("Так");
        No = new JButton("Ні");
		
        Analiz_Obc_Dopomignuy.add(Yes);
        Analiz_Obc_Dopomignuy.add(No);
        
        Yes.setBounds(80,120,100,40);
        No.setBounds(220,120,100,40);   
        
        Pusto = new JLabel("");
		Pusto.setBounds(10, 10, 10, 10);
        
        t_hlah.setBounds(20,70,350,20);
        Analiz_Obc_Dopomignuy.add(t_hlah);
        
        Comentar1.setBounds(70,35,280,20);
        Analiz_Obc_Dopomignuy.add(Comentar1);
        Comentar.setBounds(25,10,330,20);
        Analiz_Obc_Dopomignuy.add(Comentar);
  
        Analiz_Obc_Dopomignuy.add(Pusto);
        
 
		      Yes.addActionListener(handler);
	          No.addActionListener(handler);
	}
 	 
 	 public class eHandler  implements ActionListener{
			public void actionPerformed(ActionEvent e) {
	            try { 
	            	  if (e.getSource() == Yes) {
	  			    	String hlah =  t_hlah.getText(); 	    	
				    	
				    	try {
							sc_k = new Scanner(new File(hlah));
						} catch (Exception ez) {
							JOptionPane.showMessageDialog(null, "Невірно введено(не введено)"
									+ " або такого файлу не існує.");
						}
				
						// /////// зчитування файлу через ArrayList
				
						BufferedReader reader = new BufferedReader(new FileReader(hlah));
				
						String line;
						List<String> lines = new ArrayList<String>();
				
						while ((line = reader.readLine()) != null) {
							lines.add(line);
						}
						String[] linesAsArray = lines.toArray(new String[lines
								.size()]);
				
						for (int i = 0; i < linesAsArray.length; i++) {
							// System.out.println(linesAsArray[i]);
							st = st + linesAsArray[i] + "\n";
						}
				
						textArea.setText(st);
						Analiz_Obc_Dopomignuy.setVisible(false);
				    	
	            	  }
		            	
	            	  if (e.getSource() == No) {
	            		  Analiz_Obc_Dopomignuy.setVisible(false);
	            		
	                  }  
	            	  

	            	} catch (Exception ex) {
	            }
	            //    JOptionPane.showMessageDialog(null, "ВВедіть  дані");
	            }
	        }
}
