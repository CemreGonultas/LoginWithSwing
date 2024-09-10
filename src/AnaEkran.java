import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

class User{
	private String kullanici_adi;
	private String parola;
	public User(String kullanici_adi, String parola) {
		
		this.kullanici_adi = kullanici_adi;
		this.parola = parola;
	}
	public String getKullanici_adi() {
		return kullanici_adi;
	}
	public void setKullanici_adi(String kullanici_adi) {
		this.kullanici_adi = kullanici_adi;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	
	
}

public class AnaEkran extends JFrame {
	private static ArrayList<User> user_list = new ArrayList<User>();

	public static ArrayList<User> getUser_list() {
		return user_list;
	}

	public static void setUser_list(ArrayList<User> user_list) {
		AnaEkran.user_list = user_list;
	}
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField kullaniciAdiAlani;
	private JPasswordField parolaAlani;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaEkran frame = new AnaEkran();
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
	public AnaEkran() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel registerLoginPanel = new JPanel();
		registerLoginPanel.setBackground(Color.ORANGE);
		registerLoginPanel.setBounds(10, 298, 763, 101);
		contentPane.add(registerLoginPanel);
		registerLoginPanel.setLayout(null);
		
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerActionPerformed(e);
			}
		});
		register.setFont(new Font("Tahoma", Font.PLAIN, 16));
		register.setBounds(104, 26, 126, 40);
		registerLoginPanel.add(register);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		login.setFont(new Font("Tahoma", Font.PLAIN, 16));
		login.setBounds(405, 26, 126, 40);
		registerLoginPanel.add(login);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(Color.PINK);
		loginPanel.setForeground(Color.RED);
		loginPanel.setBounds(10, 10, 763, 281);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullanıcı Adı: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(114, 83, 105, 13);
		loginPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Parola:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(114, 107, 105, 13);
		loginPanel.add(lblNewLabel_1);
		
		kullaniciAdiAlani = new JTextField();
		kullaniciAdiAlani.setBounds(250, 82, 96, 19);
		loginPanel.add(kullaniciAdiAlani);
		kullaniciAdiAlani.setColumns(10);
		
		parolaAlani = new JPasswordField();
		parolaAlani.setBounds(250, 106, 96, 19);
		loginPanel.add(parolaAlani);
	}
	private void registerActionPerformed(ActionEvent e) {
		RegisterEkrani registerekrani = new RegisterEkrani();
		
		registerekrani.setVisible(true);
	}
	private void loginActionPerformed(ActionEvent e) {
		String kullanici_adi = kullaniciAdiAlani.getText();
		String parola = new String(parolaAlani.getPassword());
		
		if(user_list.size() == 0) {
			JOptionPane.showMessageDialog(this, "Hiçbir kullanıcı bulunmmaktadır...");
		}
		else {
			for(User user: user_list) {
				if(user.getKullanici_adi().equals(kullanici_adi) && user.getParola().equals(parola)) {
					JOptionPane.showMessageDialog(this, "Hoşgeldiniz " + kullanici_adi);
					return;
				}
				
			}
			JOptionPane.showMessageDialog(this, "Böyle bir kullanıcı bulunmamaktadır.Lütfen register ol.");

		}
	}
}
