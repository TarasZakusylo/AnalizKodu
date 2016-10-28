package zakk.app.my_app;
  
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

  

class Reestr extends JFrame {
	
	JFrame reestr = new JFrame("Diploma0.2");

	int n1 = (int)(100*Math.random());
	int n2 = (int)(100*Math.random());
 	
	
 	JButton b_reestr = new JButton ("Зареєструвати");
  	JButton b_nazad = new JButton ("Назад");
 	
    JLabel  Pusto ;    
    JLabel l_regiscracia = new JLabel ("Реєстрація");
    JLabel l_name = new JLabel ("Ім’я");      
    JLabel l_password = new JLabel ("Пароль");
    JLabel l_mail = new JLabel ("e-mail");
    JLabel l_capcha1 = new JLabel ("Виконайте наступну арифметичні");
    JLabel l_capcha2 = new JLabel ("операції: "+ n1 + " + "+ n2 +" =" );
    
    JTextField t_name = new JTextField();
    JTextField t_password = new JTextField();
    JTextField t_mail = new JTextField();
    JTextField t_capcha = new JTextField();
    
    ImageIcon logo = new ImageIcon("src/res/VNTU_1.png");
  	 JLabel l_logo = new JLabel(logo);
  	
  	 String s_capcha ,s_name ,s_password ,s_mail , s_infa ;	
  	 
 	    eHandler handler = new eHandler();
 	    
	
	 public Reestr(String s) {
         super(s);
         
         reestr.setVisible(true);
         reestr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         reestr.setSize(600,400);
         reestr.setResizable(false);
         reestr.setLocationRelativeTo(null);
         
         l_regiscracia.setFont(new Font("Serif",Font.ITALIC|Font.BOLD,30));
         
         	Pusto = new JLabel("");
    	Pusto.setBounds(10,10,10,10);
    	 
    	
     	
     	l_regiscracia.setBounds(250,25,250,60) ;
     	reestr.add(l_regiscracia);
     	l_name.setBounds(285,100,200,20) ;
     	reestr.add(l_name);
    	t_name.setBounds(370,100,150,20) ;
     	reestr.add(t_name);
     	l_password.setBounds(285,130,150,20) ;
     	reestr.add(l_password);
     	t_password.setBounds(370,130,150,20) ;
     	reestr.add(t_password);
     	l_mail.setBounds(285, 160, 150, 20) ;
     	reestr.add(l_mail);
     	t_mail.setBounds(370,160,150,20) ;
     	reestr.add(t_mail);
     	l_capcha1.setBounds(285, 190, 320, 20) ;
     	reestr.add(l_capcha1);
     	l_capcha2.setBounds(285, 210, 320, 20) ;
     	reestr.add(l_capcha2);
     	t_capcha.setBounds(420,210,100,20) ;
     	reestr.add(t_capcha);
//     	b_capcha.setBounds(340,250,130,20) ;
//     	reestr.add(b_capcha);
     	b_nazad.setBounds(500,5,100,20) ;
     	reestr.add(b_nazad);
     	b_reestr.setBounds(150, 300, 300, 50) ;
     	reestr.add(b_reestr);
 
         l_logo.setBounds(5, 5, 155, 155);
         reestr.add(l_logo);
      	
//         l_Text = new JLabel("Текст текст текст");
//         l_Text.setFont(new Font("Serif",Font.ITALIC|Font.BOLD,30));
//         l_Text.setBounds( 200, 20 , 400, 155);
//         reestr.add(l_Text);
      	
         reestr.add(Pusto);
		
         b_reestr.addActionListener(handler); 
         b_nazad.addActionListener(handler);
	}

	public class eHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == b_reestr) {
							int k = 0;			
										 						
					 s_name = t_name.getText();						 						
					 s_password = t_password.getText();								 						
					 s_mail = t_mail.getText();						
 
	 
					 
							switch (s_name) {
							case "Name":
								JOptionPane.showMessageDialog(null, "Змініть ім’я");
								break;
							case "":
								JOptionPane.showMessageDialog(null, "Введіть ім’я");
								break;
							case " ":
								JOptionPane.showMessageDialog(null, "Змініть ім’я");
								break;
							case "  ":
								JOptionPane.showMessageDialog(null, "Змініть ім’я");
								break;
							default:
								 k++;
								break;
							}	
							
							switch (s_password) {
							case "Password":
								JOptionPane.showMessageDialog(null, "Змініть пароль");
								break;
							case "":
								JOptionPane.showMessageDialog(null, "Введіть пароль");
								break;
							case " ":
								JOptionPane.showMessageDialog(null, "Змініть пароль");
								break;
							case "  ":
								JOptionPane.showMessageDialog(null, "Змініть пароль");
								break;
							default:
								 k++;
								break;
							}	
					    
							switch (s_mail) {
							case "Mail":
								JOptionPane.showMessageDialog(null, "Змініть mail");
								break;
							case "":
								JOptionPane.showMessageDialog(null, "Введіть mail");
								break;
							case " ":
								JOptionPane.showMessageDialog(null, "Змініть mail");
								break;
							case "  ":
								JOptionPane.showMessageDialog(null, "Змініть mail");
								break;
							default:
								 k++;
								break;
							}	

				
						 s_capcha = t_capcha.getText();	
						int n = n1 + n2;
						int a1 = Integer.parseInt(s_capcha);
						
						if (a1 == n) {
							 k++;							
						} 
						
						if (k > 3) {
							 k++;
							JOptionPane
									.showMessageDialog(null, "Заявку подано. Чекайте повідомлення на пошту.");
						} 
					
				}

				if (e.getSource() == b_nazad) {

				     new Avtor("");
		             reestr.setVisible(false);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Невірна перевірка");

			}
		}
	}

}