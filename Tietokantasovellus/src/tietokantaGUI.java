import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class tietokantaGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTable table;
	static DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Metodit tietokantaOlio = new Metodit();
					tietokantaGUI frame = new tietokantaGUI(tietokantaOlio);
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
	public tietokantaGUI(Metodit tietokantaOlio) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Metodit.naytaTiedot();
			}
		});
		setTitle("Kirjatietokanta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		this.setResizable(false);
		
		
		//MENU
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Tiedosto");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Tietoja Ohjelmasta");
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//LISÄÄ NAPPI
		JButton btnLisaa = new JButton("Lisää rivi");
		btnLisaa.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnLisaa.setBounds(89, 283, 131, 45);
		contentPane.add(btnLisaa);
		btnLisaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lisaaKirjaGUI ikkuna = new lisaaKirjaGUI();
				ikkuna.setVisible(true);
			}
		});
		
		//POISTA NAPPI
		JButton btnPoista = new JButton("Poista valittu rivi");
		btnPoista.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPoista.setBounds(250, 283, 131, 45);
		contentPane.add(btnPoista);
		btnPoista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int row = table.getSelectedRow();
					String kirja = (table.getModel().getValueAt(row, 0).toString());
					Metodit.poistaKirja(kirja);
					
				}catch(ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null, "Valitse rivi, joka poistetaan");
					System.out.println(e1);
				}
			}
		});
		
		//PÄIVITÄ NAPPI
		JButton btnPaivita = new JButton("Päivitä taulukko");
		btnPaivita.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPaivita.setBounds(411, 283, 122, 45);
		contentPane.add(btnPaivita);
		btnPaivita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodit.naytaTiedot();
			}
		});
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 27, 565, 224);
		contentPane.add(scrollPane);
		
		//TABLE
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
	}
}
