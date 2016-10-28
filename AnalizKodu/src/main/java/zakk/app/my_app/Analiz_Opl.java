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

public class Analiz_Opl extends JFrame{

	JFrame analiz = new JFrame("Diploma0.2");

	JButton b_oplata= new JButton ("Оплата");
	JButton b_nazad = new JButton ("Назад");
	
    JLabel  Pusto;
    JLabel  l_analiz = new JLabel ("Аналіз коду");
    JLabel  l_cina = new JLabel ("Ціна послуги - 000 грн.");
    JLabel  l_rekvizutu = new JLabel ("Вкажіть номере картки для оплати послуги");
    
     JTextField t_rekvizutu = new JTextField(20); 
  
    ImageIcon logo = new ImageIcon("src/res/VNTU_1.png");
  	 JLabel l_logo = new JLabel(logo);
  	
 	    eHandler handler = new eHandler();
 	    
	
	 public Analiz_Opl(String s) {
         super(s);
         
         analiz.setVisible(true);
         analiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         analiz.setSize(600,400);
         analiz.setResizable(false);
         analiz.setLocationRelativeTo(null); 

		Pusto = new JLabel("");
		Pusto.setBounds(10, 10, 10, 10);

		b_oplata.setBounds(150, 260, 300, 50);
		analiz.add(b_oplata);
     	b_nazad.setBounds(500,5,100,20) ;
     	analiz.add(b_nazad);

		l_logo.setBounds(5, 5, 155, 155);
		analiz.add(l_logo);
		l_cina.setBounds(200, 140, 300, 20);
		analiz.add(l_cina);
		l_rekvizutu.setBounds(200, 170, 350, 20);
		analiz.add(l_rekvizutu);

		t_rekvizutu.setBounds(250, 200, 200, 20);
		analiz.add(t_rekvizutu);
		
		l_analiz.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 30));
		l_analiz.setBounds(250,25,250,60);
		analiz.add(l_analiz);

		analiz.add(Pusto);

		b_oplata.addActionListener(handler);
		b_nazad.addActionListener(handler);
	}

	public class eHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == b_oplata) {
					String n = JOptionPane
							.showInputDialog(null,
									"Введіть код доступу, що надісланий вам на електронну пошту" );
				
					  
				    if (n != null){  // налагоджуємо Cancel
						switch (n) {
						case "":
							JOptionPane.showMessageDialog(null, "Невірний код");
							break;
						case " ":
							JOptionPane.showMessageDialog(null, "Невірний код");
							break;
						case "  ":
							JOptionPane.showMessageDialog(null, "Невірний код");
							break;
						case "   ":
							JOptionPane.showMessageDialog(null, "Невірний код");
							break;
						case "    ":
							JOptionPane.showMessageDialog(null, "Невірний код");
							break;
						default:
							new Analiz_Obcuslenna("");
							analiz.setVisible(false);
							break;
						}				        
				    }
				 
				
				}
				if (e.getSource() == b_nazad) {

					new VubirPoslug("");
					analiz.setVisible(false);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "System error");

			}
		}
		}

	}
 
