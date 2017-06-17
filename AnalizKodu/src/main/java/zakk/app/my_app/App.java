package zakk.app.my_app;
  
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class Reader extends JFrame {

	JFrame Reader = new JFrame("Інформаційна технологія захисту вмісту контенту");

	JButton Vhid = new JButton("Почати роботу");
	JLabel Pusto, l_Text1, l_Text2;

	ImageIcon logo = new ImageIcon("src/res/VNTU_1.png");
	JLabel l_logo = new JLabel(logo);

	eHandler handler = new eHandler();

	public Reader(String s) {
		super(s);

		Pusto = new JLabel("");
		Pusto.setBounds(10, 10, 10, 10);

		Vhid.setBounds(150, 230, 300, 50);
		add(Vhid);

		l_logo.setBounds(5, 5, 155, 155);
		add(l_logo);

		l_Text1 = new JLabel("Iнформаційна технологія захисту");
		l_Text1.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 25));
		l_Text1.setForeground(Color.BLUE);
		l_Text1.setBounds(175, 20, 500, 155);
		add(l_Text1);		

		l_Text2 = new JLabel("вмісту контенту");
		l_Text2.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 25));
		l_Text2.setBounds(250, 50, 500, 155);		
		l_Text2.setForeground(Color.BLUE);
		add(l_Text2);

		add(Pusto);

		Vhid.addActionListener(handler);
	}

	public class eHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == Vhid) {
					new Avtor("");
					setVisible(false);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "System error");

			}
		}
	}

}

public class App {
	public static void main(String[] args) {
		Reader r = new Reader("Інформаційна технологія захисту вмісту контенту");

		r.setVisible(true);
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		r.setSize(600, 400);
		r.setResizable(false);
		r.setLocationRelativeTo(null);
	}
}
