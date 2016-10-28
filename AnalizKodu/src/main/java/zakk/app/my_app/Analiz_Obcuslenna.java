package zakk.app.my_app;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

class Analiz_Obcuslenna extends JFrame {

	JFrame analiz_Obcuslenna = new JFrame("Diploma0.2");

	JButton Analiz = new JButton("Аналіз коду");
	JButton Zavantajutu = new JButton("Завантажити");
	JButton b_nazad = new JButton("Назад");
	JButton b_ocustutu = new JButton("Очистити");
	JButton b_zberegtu = new JButton("Зберегти");

	JLabel Pusto, l_Text, l_Instrukcia;

	JTextArea textArea = new JTextArea();
	String TEXT;
	JPanel panel = new JPanel();
	JPanel mainPanel = new JPanel();
	JTextArea area = new JTextArea();

	Scanner sc_k;
	String s, st = "";

	String hlah;
	
	static Scanner scn ;
	 String Reading1  = "";
	 String Reading2 ;

	public Formatter x;

	eHandler handler = new eHandler();

	public Analiz_Obcuslenna(String s) {
		super(s);

		analiz_Obcuslenna.setVisible(true);
		analiz_Obcuslenna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		analiz_Obcuslenna.setSize(600, 400);
		analiz_Obcuslenna.setResizable(false);
		analiz_Obcuslenna.setLocationRelativeTo(null);

		Pusto = new JLabel("");
		Pusto.setBounds(10, 10, 10, 10);

		Analiz.setBounds(30, 322, 140, 30);
		analiz_Obcuslenna.add(Analiz);
		Zavantajutu.setBounds(300, 322, 140, 30);
		analiz_Obcuslenna.add(Zavantajutu);
		b_nazad.setBounds(500, 5, 100, 20);
		analiz_Obcuslenna.add(b_nazad);
		b_ocustutu.setBounds(170, 322, 140, 30);
		analiz_Obcuslenna.add(b_ocustutu);
		b_zberegtu.setBounds(440, 322, 140, 30);
		analiz_Obcuslenna.add(b_zberegtu);

		// //////// поле

		mainPanel.setLayout(new BorderLayout());

		textArea.setText(TEXT);
		// textArea.setCaretPosition(0);
		JScrollPane scrollPane = new JScrollPane(textArea);
		mainPanel.add(scrollPane, BorderLayout.CENTER);

		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		// area.setLayout(new FlowLayout());
		mainPanel.add(area, BorderLayout.SOUTH);
		mainPanel.setBounds(30, 80, 550, 260);

		analiz_Obcuslenna.getContentPane().add(mainPanel);
		// //////////

		l_Text = new JLabel("Аналіз коду");
		l_Text.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 30));
		l_Text.setBounds(190, 10, 400, 35);
		analiz_Obcuslenna.add(l_Text);

		l_Text = new JLabel(
				"Впишіть код для аназізу в поле або завантажте його.");
		l_Text.setBounds(100, 40, 400, 20);
		analiz_Obcuslenna.add(l_Text);

		analiz_Obcuslenna.add(Pusto);

		Analiz.addActionListener(handler);
		Zavantajutu.addActionListener(handler);
		b_nazad.addActionListener(handler);
		b_ocustutu.addActionListener(handler);
		b_zberegtu.addActionListener(handler);
	}


	void zakrutu(int t) {
		
		if (t == 1) {
			analiz_Obcuslenna.setVisible(false);
		}
	}
	public class eHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == Analiz) {

					String s = textArea.getText();
			//		JOptionPane.showMessageDialog(null, s);

		/////////////////// PohukSliv
					
					String searchWord = "var";  
					String searchWord1 = "flash.display.Sprite"; 
					String searchWord2 = "flash.text.TextField"; 
					String searchWord3 = "trace"; 
			 		String searchWord4 = "function";
					
			 		int  k = 0;
			 		int kk = 0;
			 		int kk1 = 0;
			 		
			 		
					String[] lines = new String(s).split("\n"); // кодировку  указать  нужную
					int i = 1;
					for (String line : lines) {
						String[] words = line.split(" ");
						int j = 1;
						for (String word : words) {
							if (word.equalsIgnoreCase(searchWord) ||
									word.equalsIgnoreCase(searchWord1) ||
									word.equalsIgnoreCase(searchWord2) ||
									word.equalsIgnoreCase(searchWord3) ||
									word.equalsIgnoreCase(searchWord4)) {
//								System.out.println("Найдено в " + i + "-й строке, " + j
//										+ "-е слово");
								k++;
							}
							j++;
						}
						i++;
 
						 ////////////////////// дужки	( )
						
						char[] chars = line.toCharArray();

						for (int q = 0; q < chars.length; q++) {

							try {
								if (chars[q] == '(') {
									// System.out.println("Урa");
									kk++;

								}
							} catch (Exception ex) {
							}
						}
						for (int q1 = 0; q1 < chars.length; q1++) {
							try {
								if (chars[q1] == ')') {
									// System.out.println("Урa");
									kk--;
								}
							} catch (Exception ex) {
							}
						}
 ////////////////////// дужки	{ }
						
						char[] chars1 = line.toCharArray();

						for (int q = 0; q < chars.length; q++) {

							try {
								if (chars1[q] == '{') {
									// System.out.println("Урa");
									kk1++;

								}
							} catch (Exception ex) {
							}
						}
						for (int q1 = 0; q1 < chars.length; q1++) {
							try {
								if (chars1[q1] == '}') {
									// System.out.println("Урa");
									kk1--;
								}
							} catch (Exception ex) {
							}
						}
						
						
					}
					if (kk != 0){ 
						JOptionPane.showMessageDialog(null, " Невідповідність дужок типу ( ) ");
					}
					if (kk1 != 0){ 
						JOptionPane.showMessageDialog(null, " Невідповідність дужок типу { } ");
					}
					
					if (k >= 1) {
						JOptionPane.showMessageDialog(null,
								"Знайдено шкідливе ПЗ! Адміністратор повідомлений.");
						new Avtor("");
						analiz_Obcuslenna.setVisible(false);
									
					}
					else {
						JOptionPane.showMessageDialog(null,	"Безпечно");
					}
					
	 
					


				}
				if (e.getSource() == b_nazad) {

					new Analiz_Opl("");
					analiz_Obcuslenna.setVisible(false);
				}
				if (e.getSource() == Zavantajutu) {
//					new Analiz_Obc_Dopomignuy("");
//					analiz_Obcuslenna.setVisible(false);
					
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
						
						String st = "";		 
					
		 
					 String name = file.getAbsolutePath();
					      
						
					try{	
						 
						try {
							scn = new Scanner(new File(name));
						} catch (Exception ez) {
							JOptionPane.showMessageDialog(null, "Невірно введено(не введено)"
									+ " або такого файлу не існує.");
						}
						
						BufferedReader reader = new BufferedReader(new FileReader(name));
						
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
					
					} catch (Exception ez) {}

					textArea.setText(st);
						
						}

					
				}
				if (e.getSource() == b_ocustutu) {
					textArea.setText(null);
				}
				if (e.getSource() == b_zberegtu) {
					String dofaylu = JOptionPane
							.showInputDialog("Вкажіть шлях до файла.");

					if (dofaylu != null) {
						String dofaylu1 = JOptionPane
								.showInputDialog("Вкажіть ім’я файла.");

						if (dofaylu != null) {
							String s = textArea.getText();

							dofaylu = dofaylu + "/" + dofaylu1 + ".java";
//							System.out.println(dofaylu);

							x = new Formatter(dofaylu);
							x.format(s);
							x.close();

							JOptionPane.showMessageDialog(null, "Збережено");
						}
					}
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Некоректне введення");

			}
		}
	}

}
 