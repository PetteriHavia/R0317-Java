import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class lisaaKirjaGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField fieldKirja;
	static JTextField fieldTekija;
	static JTextField fieldVuosi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lisaaKirjaGUI frame = new lisaaKirjaGUI();
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
	public lisaaKirjaGUI() {
		setTitle("Kirjatietokanta");
		//Sulkee vain tämän ikkunan
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Kirjan hallinta");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(30, 11, 113, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblKirja = new JLabel("Kirjan nimi:");
		lblKirja.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKirja.setBounds(30, 66, 83, 14);
		contentPane.add(lblKirja);
		
		JLabel lblTekija = new JLabel("Tekij\u00E4:");
		lblTekija.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTekija.setBounds(30, 108, 83, 14);
		contentPane.add(lblTekija);
		
		JLabel lblVuosi = new JLabel("Julkaisuvuosi:");
		lblVuosi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVuosi.setBounds(30, 149, 83, 14);
		contentPane.add(lblVuosi);
		
		fieldKirja = new JTextField();
		fieldKirja.setBounds(123, 64, 139, 20);
		contentPane.add(fieldKirja);
		fieldKirja.setColumns(10);
		
		fieldTekija = new JTextField();
		fieldTekija.setColumns(10);
		fieldTekija.setBounds(123, 106, 139, 20);
		contentPane.add(fieldTekija);
		
		fieldVuosi = new JTextField();
		fieldVuosi.setColumns(10);
		fieldVuosi.setBounds(123, 147, 139, 20);
		contentPane.add(fieldVuosi);
		
		//LISÄÄ KIRJA NAPPI
		JButton btnLisaaKirja = new JButton("Lis\u00E4\u00E4 kirja");
		btnLisaaKirja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Kenttien tarkistus
				if(fieldKirja.getText().equals("") || fieldTekija.getText().equals("") || fieldVuosi.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Täytä jokainen kohta!");
				}else if (fieldVuosi.getText().length() > 4) {
					JOptionPane.showMessageDialog(contentPane, "Korkeintaan neljä numeroa");
				
					
				}else {
				//Jatka
					try {
						
						Metodit.lisaaKirja(fieldKirja.getText(), fieldTekija.getText(), fieldVuosi.getText());
						
						fieldKirja.setText("");
						fieldTekija.setText("");
						fieldVuosi.setText("");
						
					}catch (Exception e2) {
						System.out.print("Tapahtui virhe");
						e2.printStackTrace();
					}
				}
			}
		});
		btnLisaaKirja.setBounds(30, 214, 97, 34);
		contentPane.add(btnLisaaKirja);
		
		//TYHJENNÄ NAPPI
		JButton btnTyhjenna = new JButton("Tyhjenn\u00E4");
		btnTyhjenna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fieldKirja.setText("");
				fieldTekija.setText("");
				fieldVuosi.setText("");
			}
		});
		btnTyhjenna.setBounds(165, 214, 97, 34);
		contentPane.add(btnTyhjenna);
	}
}
