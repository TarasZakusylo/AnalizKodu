package zakk.app.my_app;
  
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

 
public class VubirPoslug  extends JFrame {
	
	JFrame vubirPoslug = new JFrame("Diploma0.2");

	 JLabel  Pusto ;
	
 	JButton b_analiz = new JButton ("Аналіз");
 	JButton b_redactor = new JButton ("Редактор");
 	JButton b_nazad = new JButton ("Назад");
 	
	JLabel l_vbirPoslug = new JLabel("Вибір послуги");
 	
    ImageIcon logo = new ImageIcon("src/res/VNTU_1.png");
  	 JLabel l_logo = new JLabel(logo);
 
		 	 eHandler handler = new eHandler();
		 	 
	public VubirPoslug(String s) {
        super(s);
    
        vubirPoslug.setVisible(true);
        vubirPoslug.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vubirPoslug.setSize(600,400);
        vubirPoslug.setResizable(false);
        vubirPoslug.setLocationRelativeTo(null);
        
      	Pusto = new JLabel("");
    	Pusto.setBounds(10,10,10,10);
    	
        l_logo.setBounds(5, 5, 155, 155);
    	
        vubirPoslug.add(l_logo);
        
        l_vbirPoslug.setBounds(250,25,250,60);
        l_vbirPoslug.setFont(new Font("Serif",Font.ITALIC|Font.BOLD,30));
    	vubirPoslug.add(l_vbirPoslug);
    	
        b_analiz.setBounds(150, 230, 150, 50) ;
        vubirPoslug.add(b_analiz);
        b_redactor.setBounds(300, 230, 150, 50) ;
        vubirPoslug.add(b_redactor);
     	b_nazad.setBounds(500,5,100,20) ;
     	vubirPoslug.add(b_nazad);
    	
    	vubirPoslug.add(Pusto);
        
    	b_analiz.addActionListener(handler);
    	b_redactor.addActionListener(handler);	
    	b_nazad.addActionListener(handler);
	}
	
	public class eHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == b_analiz) {
				     new Analiz_Opl ("");
				     vubirPoslug.setVisible(false);
				}
				if (e.getSource() == b_redactor) {
				     new Redactor("");
				     vubirPoslug.setVisible(false);
				}
				if (e.getSource() == b_nazad) {

				     new Avtor("");
				     vubirPoslug.setVisible(false);
				}
			} catch (Exception ex) {
			//	JOptionPane.showMessageDialog(null, "System error");

			}
		}
	}
}
	
 
