package code;
/**
 * @author Aykut Acarer
 * 
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class Searching extends JFrame {

	private JPanel contentPane;
	private JTextField txt_field;
	static String str;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Searching frame = new Searching();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Searching() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txt_field = new JTextField();
		txt_field.setBounds(33, 100, 324, 29);
		contentPane.add(txt_field);
		txt_field.setColumns(10);

		JButton btn_Go = new JButton("Go");
		btn_Go.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btn_Go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				str = txt_field.getText();
				try {
					
						Pattern patt = Pattern.compile(str);
						FileReader fr = new FileReader("C:\\Users\\CC-Student\\Desktop\\Beispiel_Datei\\metin.txt");
						BufferedReader br = new BufferedReader(fr);
						String zeile = "";
						String ergebnis = "";
						String ergebnis2 = "";
						int count = 0;
						int count2=0;
						while ((zeile = br.readLine()) != null) {
							
							Matcher matcher = patt.matcher(zeile);
							boolean found = false;
							count++;
							while (matcher.find()) {
								
								ergebnis = "I found the text  "+"'"+ matcher.group() +"'"+ " " + count + ". Zeile"
										+ "  starting at index  " + matcher.start() + "  and ending at index  " + matcher.end();
								System.out.println(ergebnis);
								count2++;
								found = true;
							}
							if (!found) {
								ergebnis2 = "No extra match found";

							}
							
						}
						System.out.println("Total matches "+count2);
						System.out.println(ergebnis2);
						br.close();
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btn_Go.setBounds(367, 99, 57, 30);
		contentPane.add(btn_Go);

		JLabel lblNewLabel = new JLabel("Search Engine");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel.setBounds(157, 65, 115, 29);
		contentPane.add(lblNewLabel);
	}
}
