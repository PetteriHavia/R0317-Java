import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Sarjallistaminen {
	
	static String tie = "Tallenne.xml";
	
	public static void kirjoitaTiedostoon(JuomaAutomaatti AutomaattiOlio ) throws IOException {
	
		//Tiedosto johon tallennetaan
		FileOutputStream tiedosto = new FileOutputStream("Tallenne.xml");
		//XML tiedostoa varten
		XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(tiedosto));
		
		//Olio XMl muotoon
		enc.writeObject(AutomaattiOlio);
		
		enc.close();
		JOptionPane.showMessageDialog(null, "Tiedot tallennettu tiedostoon Tallenne.xml." + "\n");
		System.out.println("Tiedot tallennettu tiedostoon Tallenne.xml.");
		JuomaAutomaattiGUI.textAreaKonsoli.append("Tiedot tallennettu tiedostoon Tallenne.xml" + "\n");
	}
	
	
	public static JuomaAutomaatti lueTiedostosta() throws FileNotFoundException {
		
		XMLDecoder decoder = null;
		FileInputStream tiedosto = new FileInputStream(tie);
		decoder = new XMLDecoder(new BufferedInputStream(tiedosto));
		decoder.close();
		JuomaAutomaattiGUI.textAreaKonsoli.append("Tiedosto ladattu juoma-automaattiin" + "\n");
		JuomaAutomaatti info = (JuomaAutomaatti) decoder.readObject();
		return info;
	}
}

