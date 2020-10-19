
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class JuomaAutomaattiGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JMenuItem menuKaakao;
	private static JMenuItem menuTee;
	private static JMenuItem menuKahvi;
	static JLabel lblKahvinM‰‰r‰;
	static JLabel lblTeenM‰‰r‰;
	static JLabel lblKaakaonM‰‰r‰;
	static JTextArea textAreaKonsoli;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Luodaan olio johon voidaan viitata
					JuomaAutomaatti AutomaattiOlio = new JuomaAutomaatti();
					JuomaAutomaattiGUI frame = new JuomaAutomaattiGUI(AutomaattiOlio);
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
	public JuomaAutomaattiGUI(JuomaAutomaatti AutomaattiOlio) {
		
		setTitle("JuomaAutomaatti GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 500);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		
		
		//KAHVI NAPPI
		JButton kahviBtn = new JButton();
		kahviBtn.setBounds(23, 50, 100, 100);
		contentPane.add(kahviBtn);
		Image coffee = new ImageIcon(this.getClass().getResource("/coffee.png")).getImage();
		kahviBtn.setIcon(new ImageIcon(coffee));
		
		kahviBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AutomaattiOlio.valmistaKahvi();
			}
		});
		
		
		//TEE NAPPI
		JButton teeBtn = new JButton();
		teeBtn.setBounds(23, 153, 100, 100);
		contentPane.add(teeBtn);
		Image tea = new ImageIcon(this.getClass().getResource("/tea.png")).getImage();
		teeBtn.setIcon(new ImageIcon(tea));
		
		teeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AutomaattiOlio.valmistaTee();
			}
		});
		
		
		//KAAKAO NAPPI
		JButton kaakaoBtn = new JButton();
		kaakaoBtn.setBounds(23, 256, 100, 100);
		contentPane.add(kaakaoBtn);
		Image cocoa = new ImageIcon(this.getClass().getResource("/cocoa.png")).getImage();
		kaakaoBtn.setIcon(new ImageIcon(cocoa));
		
		kaakaoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AutomaattiOlio.valmistaKaakao();
			}
		});
		
		
		//MENU
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 334, 22);
		contentPane.add(menuBar);
		JMenu mnNewMenu = new JMenu("Yll\u00E4pito");
		
		//ASETA KAHVIN MƒƒRƒ
		menuKahvi = new JMenuItem("Aseta Kahvin m‰‰r‰");
		menuKahvi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AutomaattiOlio.asetaM‰‰r‰("Kahvi");
			}
		});
		
		//ASETA KAHVIN MƒƒRƒ
		menuTee = new JMenuItem("Aseta teen m‰‰r‰");
		menuTee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AutomaattiOlio.asetaM‰‰r‰("Tee");
			}
		});
		
		
		//ASETA KAHVIN MƒƒRƒ
		menuKaakao = new JMenuItem("Aseta kaakaon m‰‰r‰");
		menuKaakao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AutomaattiOlio.asetaM‰‰r‰("Kaakao");
			}
		});
		
		
		//TALLENNA TIEDOT
		JMenuItem menuTallenna = new JMenuItem("Tallenna automaatin tila");
		menuTallenna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Sarjallistaminen.kirjoitaTiedostoon(AutomaattiOlio);
				}catch (Exception t) {
				}
			}
		});
		
		
		//LATAA TIEDOT
		JMenuItem menuLataa = new JMenuItem("Lataa automaatti");
		menuLataa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AutomaattiOlio.lataaTiedot();
			}
		});
		
		
		//SULJE OHJELMA
		JMenuItem menuLopeta = new JMenuItem("Lopeta");
		menuLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem menuVersioTiedot = new JMenuItem("Versiotiedot");
		menuVersioTiedot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Versiotiedot ikkuna = new Versiotiedot();
				ikkuna.setVisible(true);

			}
		});
		
		JMenuItem menuOhje = new JMenuItem("Ohje");
		mnNewMenu.add(menuKahvi);
		mnNewMenu.add(menuTee);
		mnNewMenu.add(menuKaakao);
		mnNewMenu.add(menuTallenna);
		mnNewMenu.add(menuLataa);
		mnNewMenu.add(menuLopeta);
		menuBar.add(mnNewMenu);
		JMenu mnNewMenu2 = new JMenu("Tietoja Ohjelmasta");
		mnNewMenu2.add(menuVersioTiedot);
		mnNewMenu2.add(menuOhje);
		menuBar.add(mnNewMenu2);
		
		
		//LABEL TEKSTIT
		JLabel lblKahvi = new JLabel("Kahvi:");
		lblKahvi.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblKahvi.setBounds(160, 82, 56, 14);
		contentPane.add(lblKahvi);
		
		JLabel lblTee = new JLabel("Tee:");
		lblTee.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblTee.setBounds(160, 185, 56, 14);
		contentPane.add(lblTee);
		
		JLabel lblKaakao = new JLabel("Kaakao:");
		lblKaakao.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblKaakao.setBounds(160, 290, 73, 14);
		contentPane.add(lblKaakao);
		
		
		//LABEL TEKSTI MƒƒRƒT
		lblKahvinM‰‰r‰ = new JLabel("" + AutomaattiOlio.getKahvi());
		lblKahvinM‰‰r‰.setBounds(243, 82, 61, 14);
		contentPane.add(lblKahvinM‰‰r‰);
		
		lblTeenM‰‰r‰ = new JLabel("" + AutomaattiOlio.getTee());
		lblTeenM‰‰r‰.setBounds(243, 185, 61, 14);
		contentPane.add(lblTeenM‰‰r‰);
		
		lblKaakaonM‰‰r‰ = new JLabel("" + AutomaattiOlio.getKaakao());
		lblKaakaonM‰‰r‰.setBounds(243, 290, 61, 14);
		contentPane.add(lblKaakaonM‰‰r‰);
		
		
		//KONSOLI
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 384, 268, 66);
		contentPane.add(scrollPane);
		
		textAreaKonsoli = new JTextArea();
		textAreaKonsoli.setEditable(false);
		Font f = textAreaKonsoli.getFont();
		Font f2 = new Font(f.getFontName(), f.getStyle(), f.getSize()-1);
		textAreaKonsoli.setFont(f2);
		scrollPane.setViewportView(textAreaKonsoli);
		
		JLabel lblKonsoli = new JLabel("Konsoli:");
		lblKonsoli.setBounds(23, 367, 46, 14);
		contentPane.add(lblKonsoli);
		
	


		
		
		
	}
}
