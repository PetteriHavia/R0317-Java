import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Lämpötilamuunnin {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Chat Frame");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,100);
		frame.setLayout(new GridLayout(2,2));
		
		JButton convertBtn =new JButton("Convert");
		JLabel celLabel = new JLabel("Celsius");
		
		JTextField celField= new JTextField("");
		celField.setHorizontalAlignment(JTextField.CENTER);
		
		JLabel fahLabel = new JLabel("");
		fahLabel.setHorizontalAlignment(JLabel.CENTER);
		
		frame.add(celLabel);
		frame.add(celField);
		frame.add(convertBtn);
		frame.add(fahLabel);
		
		
		convertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int fahrenheit = (int)((Double.parseDouble(celField.getText())) * 1.8 + 32);
					fahLabel.setText(fahrenheit + " Fahrenheit");
					
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null, "Wrong input format, requires number");
				}
			}
		});
		
		frame.setVisible(true);
	}
}
