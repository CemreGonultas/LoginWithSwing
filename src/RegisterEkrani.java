import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RegisterEkrani extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField kullanici_adi_alani;
	private JPasswordField parola_alani;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterEkrani frame = new RegisterEkrani();
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
	public RegisterEkrani() {
		setTitle("Register Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(Color.GRAY);
		registerPanel.setBounds(10, 10, 502, 322);
		contentPane.add(registerPanel);
		registerPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullanıcı Adı");
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(64, 55, 163, 42);
		registerPanel.add(lblNewLabel);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setForeground(Color.PINK);
		lblParola.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblParola.setBounds(64, 125, 163, 42);
		registerPanel.add(lblParola);
		
		kullanici_adi_alani = new JTextField();
		kullanici_adi_alani.setBounds(209, 66, 147, 27);
		registerPanel.add(kullanici_adi_alani);
		kullanici_adi_alani.setColumns(10);
		
		parola_alani = new JPasswordField();
		parola_alani.setBounds(209, 136, 147, 27);
		registerPanel.add(parola_alani);
		
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerActionPerformed(e);
			}
		});
		register.setFont(new Font("Tahoma", Font.PLAIN, 16));
		register.setBounds(182, 212, 113, 27);
		registerPanel.add(register);
	}
	private void registerActionPerformed(ActionEvent e) {
		String kullanici_adi = kullanici_adi_alani.getText();
		String parola = new String(parola_alani.getPassword());
		
		ArrayList<User> user_list = AnaEkran.getUser_list();
		
		user_list.add(new User(kullanici_adi,parola));
		
		setVisible(false);
	}

}
