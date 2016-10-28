package zakk.app.my_app;
 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Avtor extends JFrame{
 
 	 JLabel  Pusto ;

	
 	int type1 = JOptionPane.ERROR_MESSAGE;  //  ЕМБЛЕМА ВІКНА
    int type2 = JOptionPane.WARNING_MESSAGE;
 	 
	JFrame avtor = new JFrame("Diploma0.2");

	JLabel l_avtoruzacia = new JLabel("Авторизація");
	JLabel l_login = new JLabel ("Логін");
	JLabel l_password = new JLabel("Пароль");
	JLabel l_reestracia = new JLabel("Якщо Ви не зареєстровані, то натисніть сюди ");
	
	JTextField t_login = new JTextField(20);
	JPasswordField t_password = new JPasswordField(20);
	
	JButton b_vhid = new JButton("Вхід");
	JButton b_reestracia = new JButton("Реєстрація");
	
	 ImageIcon logo = new ImageIcon("src/res/VNTU_1.png");
  	 JLabel l_logo = new JLabel(logo);
	
 	  eHandler handler = new eHandler();
	  
	  public Avtor(String s) {
          super(s);
          
          avtor.setVisible(true);
          avtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          avtor.setSize(600, 400);
          avtor.setResizable(false);
          avtor.setLocationRelativeTo(null);
	
      	Pusto = new JLabel("");
    	Pusto.setBounds(10,10,10,10);
    	
    	l_avtoruzacia.setBounds(250,25,250,60);
    	l_login.setBounds(285,100,200,20);
    	t_login.setBounds(275,130,200,20);
    	l_password.setBounds(285,160,200,20);
    	t_password.setBounds(275,190,200,20);
    	b_vhid.setBounds(275,220,200,20);
    	l_reestracia.setBounds(120,300,500,20);
    	b_reestracia.setBounds(50,330,500,20);
    
    	l_avtoruzacia.setFont(new Font("Serif",Font.ITALIC|Font.BOLD,30));
    	
        l_logo.setBounds(5, 5, 155, 155);
    	
    	avtor.add(l_logo);
    	
    	avtor.add(l_avtoruzacia);
    	avtor.add(l_login);
    	avtor.add(l_password);
    	avtor.add(l_reestracia);
    	avtor.add(t_login);
    	avtor.add(t_password);
    	avtor.add(b_vhid);
    	avtor.add(b_reestracia);
 
    	
    	avtor.add(Pusto);
    	
    	b_vhid.addActionListener(handler);
    	b_reestracia.addActionListener(handler);
       
	  }
	  
	public class eHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == b_vhid) {

				 	 String a,b;
					
					a = t_login.getText();
					b = t_password.getText();

					int z1=0,z2=0;
					
					switch (a) { // порівняння стрінгови змінних
					case "1":
						z1 = 1;
					}
					switch (b) {
					case "1":
						z2 = 1;
					}

					if (z1 == 1 && z2 == 1) {

						JOptionPane.showMessageDialog(null, "Доступ отримано",null, type2);
						 new VubirPoslug("");
						avtor.setVisible(false);

					} else {
						JOptionPane.showMessageDialog(null,
								"Дані не введено, або введено помилково", null,	type1);
					}

					z1 = 0;
					z2 = 0;

				}
				if (e.getSource() == b_reestracia) {
					JOptionPane.showMessageDialog(null, "Вітаємо на реєстрації",null, type2);
					 new Reestr(""); 
					avtor.setVisible(false);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "ВВедіть  дані");
			}

		}
	}

}