package zakk.app.my_app;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Redactor extends JFrame {

	JFrame Redactor = new JFrame("Diploma0.2");

	JButton b_perevirutu = new JButton("Почати роботу");
	JButton b_nazad = new JButton("Назад");
	JButton b_analiz = new JButton("Перейти до аналізу");

	JLabel Pusto;

	// JTextField t_rekvizutu = new JTextField(20);

	JLabel l_redactor = new JLabel("Редактор");
	JLabel l_hlah = new JLabel("Для початку роботи оберіть файл в папці");
	JLabel l_hlah1 = new JLabel(" із якою хочете працювати");

	ImageIcon logo = new ImageIcon("src/res/VNTU_1.png");
	JLabel l_logo = new JLabel(logo);

	static Scanner scn;

	String Reading1 = "";
	String Reading2;

	static Scanner sc_k;

	eHandler handler = new eHandler();

	public Redactor(String s) {
		super(s);

		Redactor.setVisible(true);
		Redactor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Redactor.setSize(600, 400);
		Redactor.setResizable(false);
		Redactor.setLocationRelativeTo(null);

		b_nazad.setBounds(500, 5, 100, 20);
		Redactor.add(b_nazad);
		b_perevirutu.setBounds(150, 260, 300, 50);
		Redactor.add(b_perevirutu);
		b_analiz.setBounds(0, 0, 0, 0);
		Redactor.add(b_analiz);

		String komentar = "Для вказання папки, каталогу натисніть на будь-який файлв ньому.";
		b_perevirutu.setToolTipText(komentar);

		l_hlah.setBounds(150, 170, 450, 20);
		Redactor.add(l_hlah);
		l_hlah1.setBounds(200, 190, 450, 20);
		Redactor.add(l_hlah1);
		l_logo.setBounds(5, 5, 155, 155);
		Redactor.add(l_logo);

		// t_rekvizutu.setBounds(250, 200, 200, 20);
		// Redactor.add(t_rekvizutu);
		l_redactor.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 30));
		l_redactor.setBounds(250, 25, 250, 60);
		Redactor.add(l_redactor);

		Pusto = new JLabel("");
		Pusto.setBounds(10, 10, 10, 10);
		Redactor.add(Pusto);

		b_perevirutu.addActionListener(handler);
		b_nazad.addActionListener(handler);
		b_analiz.addActionListener(handler);
	}

	public class eHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == b_perevirutu) {

					String ch = "";
					JFileChooser fileopen = new JFileChooser();

					FileFilter ft = new FileNameExtensionFilter("Text Files", "txt");
					fileopen.addChoosableFileFilter(ft);
					FileFilter ft1 = new FileNameExtensionFilter("Java Files", "java");
					fileopen.addChoosableFileFilter(ft1);
					FileFilter ft2 = new FileNameExtensionFilter("Folder", "null");
					fileopen.addChoosableFileFilter(ft2);

					int ret = fileopen.showDialog(null, "Открыть");

					if (ret == JFileChooser.APPROVE_OPTION) {
						File file = fileopen.getSelectedFile();

						String name = file.getAbsolutePath(); // шлях до файла
						int kk = 0;
						int kk1 = 0;

						char[] chars = name.toCharArray();

						for (int i = 0; i < chars.length; i++) {
							try {
								if (chars[i] == '\'' || chars[i] == '/') {
									kk++;
								}
							} catch (Exception ex) {
							}
						}

						for (int i = 0; i < chars.length; i++) {
							try {
								if (chars[i] == '\'' || chars[i] == '/') {
									kk1++;
									if (kk == kk1) {
										break;
									}
								}

								ch = ch + chars[i];
							} catch (Exception ex) {
							}
						}
 
						String nebezpeka = "";
						String nebezpeka1 = "";
						String nebezpeka2 = "";
						File[] filesList = null;

						final File file1 = new File(ch);
						// System.out.println("Полный путь к файлу: " +
						// file1.getAbsolutePath());
						if (file1.exists()) {
							final File parentFolder = new File(file1.getAbsolutePath().substring(0,
									file1.getAbsolutePath().lastIndexOf(File.separator)));
							// System.out.println("Полный путь к родительскому
							// каталогу: "
							// + parentFolder.getAbsolutePath());

							// создаем объект на папку с файлами
							File filesPath = new java.io.File(parentFolder.getAbsolutePath());

							// записываем файлы из папки в массив объектов типа
							// File
							filesList = filesPath.listFiles();

						} else {
							// System.out.println("Файл не существует.");
						}

						int k = 0, k1 = 0, k2 = 0, k21 = 0;
						int mitka = 0, mitka1 = 0, mitka2 = 0;


						for (int i = 0; i < filesList.length; i++) {
							// читаем текущее имя файла 

							String buf = filesList[i].getName();
 
							if (buf.endsWith(".flv") || buf.endsWith(".swf") || buf.endsWith(".flash")
									|| buf.endsWith(".applet")) {
								mitka = 1;
								if (k == 0) {
									nebezpeka = nebezpeka + buf;
								} else {
									nebezpeka = nebezpeka + " , " + buf;
								}
								k++;

								b_analiz.setBounds(150, 315, 300, 30);
							}

							if (buf.endsWith(".java") || buf.endsWith(".txt") || buf.endsWith(".xml")
									|| buf.endsWith(".html") || buf.endsWith(".php") || buf.endsWith(".js")
									|| buf.endsWith(".cpp") || buf.endsWith(".cs")) {

								int len = buf.length();

								if (len > 1000) {
									mitka1 = 1;
									if (k1 == 0) {
										nebezpeka1 = nebezpeka1 + buf;
									} else {
										nebezpeka1 = nebezpeka1 + " , " + buf;
									}
									k1++;

									b_analiz.setBounds(150, 315, 300, 30);
								}

							}


							char[] chars1 = buf.toCharArray();

							for (int j = 0; j < chars1.length; j++) {
								k21++;
							}

							if (k21 >= 15) {

								mitka2 = 1;
								if (k2 == 0) {
									nebezpeka2 = nebezpeka2 + buf;
								} else {
									nebezpeka2 = nebezpeka2 + " , " + buf;
								}
								k2++;

								b_analiz.setBounds(150, 315, 300, 30);

							}
							k21 = 0;
						}


						if (mitka == 1)
							JOptionPane.showMessageDialog(null,
									" \"" + nebezpeka + "\" є підозрілим, рекомендовано проаналізувати.");
						if (mitka1 == 1)
							JOptionPane.showMessageDialog(null,
									" \"" + nebezpeka1 + "\" є підозрілим, рекомендовано проаналізувати.");
						if (mitka2 == 1)
							JOptionPane.showMessageDialog(null,
									" \"" + nebezpeka2 + "\" є підозрілим, рекомендовано проаналізувати.");

						if (mitka == 0 && mitka1 == 0 && mitka2 == 0)
							JOptionPane.showMessageDialog(null, "Безпечно");

					}

				}
				if (e.getSource() == b_nazad) {

					new VubirPoslug("");
					Redactor.setVisible(false);
				}
				if (e.getSource() == b_analiz) {

					new Analiz_Obcuslenna("");
					Redactor.setVisible(false);

				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "System error");

			}
		}

	}

}