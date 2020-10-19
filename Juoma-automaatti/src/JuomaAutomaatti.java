import java.awt.Color;
import java.beans.XMLDecoder;
import java.io.FileNotFoundException;
import java.text.NumberFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JuomaAutomaatti {
	
	private int kahvi;
	private int tee;
	private int  kaakao;
	
	
	//Konstruktori
	public JuomaAutomaatti() {
		this.kahvi = 50;
		this.tee = 50;
		this.kaakao = 50;
	}
	
	public JuomaAutomaatti(int uusiTee, int uusiKaakao, int uusiKahvi) {
		this.tee = uusiTee;
		this.kaakao = uusiKaakao;
		this.kahvi = uusiKahvi;
	}

	//Getterit ja Setterit
	public int getKahvi() {
		return kahvi;
	}
	
	public void setKahvi(int kahvi) {
		this.kahvi = kahvi;
	}
	
	public int getTee() {
		return tee;
	}
	
	public void setTee(int tee) {
		this.tee = tee;
	}
	
	
	public int getKaakao() {
		return kaakao;
	}
	
	public void setKaakao(int kaakao) {
		this.kaakao = kaakao;
	}
	
	
	
	void valmistaKahvi() {
		System.out.println("Odota hetki, kahvisi valmistuu.");
		JuomaAutomaattiGUI.textAreaKonsoli.append("Odota hetki, kahvisi valmistuu." + "\n");
		if (this.kahvi - 10 < 0 ) {
			this.kahvi = 0;
			System.out.println("Kahvia ei ole en‰‰n j‰ljell‰! T‰yt‰ s‰iliˆ.");
			JuomaAutomaattiGUI.textAreaKonsoli.append("Kahvia ei ole en‰‰n j‰ljell‰! T‰yt‰ s‰iliˆ." + "\n");
		} 
		else if (this.kahvi <= 20){
			this.kahvi -= 10;
			JuomaAutomaattiGUI.lblKahvinM‰‰r‰.setForeground(Color.RED);
			JuomaAutomaattiGUI.lblKahvinM‰‰r‰.setText("" + getKahvi());
		}
		else {
			this.kahvi -= 10;
			JuomaAutomaattiGUI.lblKahvinM‰‰r‰.setText("" + getKahvi());
		}
	}
	
	void valmistaTee() {
		System.out.println("Odota hetki, teesi valmistuu.");
		JuomaAutomaattiGUI.textAreaKonsoli.append("Odota hetki, teesi valmistuu." + "\n");
		if (this.tee - 10 < 0 ) {
			this.tee = 0;
			System.out.println("Teet‰ ei ole en‰‰n j‰ljell‰! T‰yt‰ s‰iliˆ.");
			JuomaAutomaattiGUI.textAreaKonsoli.append("Teet‰ ei ole en‰‰n j‰ljell‰! T‰yt‰ s‰iliˆ." + "\n");
		} 
		else if (this.tee <= 20 ){
			this.tee -= 10;
			JuomaAutomaattiGUI.lblTeenM‰‰r‰.setForeground(Color.RED);
			JuomaAutomaattiGUI.lblTeenM‰‰r‰.setText("" + getTee());
		}
		else {
			this.tee -= 10;
			JuomaAutomaattiGUI.lblTeenM‰‰r‰.setText("" + getTee());
		}
	}
	
	void valmistaKaakao() {
		System.out.println("Odota hetki, kaakaosi valmistuu.");
		JuomaAutomaattiGUI.textAreaKonsoli.append("Odota hetki, kaakaosi valmistuu." + "\n");
		if (this.kaakao - 10 < 0) {
			this.kaakao = 0;
			System.out.println("Kaakaota ei ole en‰‰n j‰ljell‰! T‰yt‰ s‰iliˆ.");
			JuomaAutomaattiGUI.textAreaKonsoli.append("Kaakaota ei ole en‰‰n j‰ljell‰! T‰yt‰ s‰iliˆ." + "\n");
		} 
		else if (this.kaakao <= 20){
			this.kaakao -= 10;
			JuomaAutomaattiGUI.lblKaakaonM‰‰r‰.setForeground(Color.RED);
			JuomaAutomaattiGUI.lblKaakaonM‰‰r‰.setText("" + getKaakao());
		}
		else {
			this.kaakao -= 10;
			JuomaAutomaattiGUI.lblKaakaonM‰‰r‰.setText("" + getKaakao());
		}
	}
	
	
	void asetaM‰‰r‰(String valinta) {
		int m‰‰r‰ = 0;
		// Verrataan ehdon t‰yttymist‰
		boolean ehto = true;
		
		String syˆte = JOptionPane.showInputDialog(null, "Aseta arvo");
		
		//Tarkista syˆte
		if(syˆte != null) {
			try {
				m‰‰r‰ = Integer.parseInt(syˆte);
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Virhe syˆtteess‰, anna numero");
				ehto = !ehto;
			}
			//T‰yttˆm‰‰r‰n tarkistus
			if(m‰‰r‰ > 150) {
				m‰‰r‰ = 150;
			}else if (m‰‰r‰ < 0) {
				m‰‰r‰ = 0;
			}
			}else {
				ehto =! ehto;
	}
		
		//T‰ytet‰‰n
		if(ehto) {
			
			switch(valinta) {
			
			case "Kahvi":
				setKahvi(m‰‰r‰);
				JuomaAutomaattiGUI.lblKahvinM‰‰r‰.setText("" + getKahvi());
				if(getKahvi() > 10) {
					JuomaAutomaattiGUI.lblKahvinM‰‰r‰.setForeground(Color.BLACK);
				}else {
					JuomaAutomaattiGUI.lblKahvinM‰‰r‰.setForeground(Color.RED);
				}
				break;
				
			case "Tee":
				setTee(m‰‰r‰);
				JuomaAutomaattiGUI.lblTeenM‰‰r‰.setText("" + getTee());
				if(getTee() > 10) {
					JuomaAutomaattiGUI.lblTeenM‰‰r‰.setForeground(Color.BLACK);
				}else {
					JuomaAutomaattiGUI.lblTeenM‰‰r‰.setForeground(Color.RED);
				}
				break;
				
			case "Kaakao":
				setKaakao(m‰‰r‰);
				JuomaAutomaattiGUI.lblKaakaonM‰‰r‰.setText("" + getKaakao());
				if(getKaakao() > 10) {
					JuomaAutomaattiGUI.lblKaakaonM‰‰r‰.setForeground(Color.BLACK);
				}else {
					JuomaAutomaattiGUI.lblKaakaonM‰‰r‰.setForeground(Color.RED);
				}
				break;
			}
		}
	}
	
	void lataaTiedot() {
		try {
			JuomaAutomaatti uusi = Sarjallistaminen.lueTiedostosta();
			
			setKahvi(uusi.getKahvi());
			setTee(uusi.getTee());
			setKaakao(uusi.getKaakao());
			
			JuomaAutomaattiGUI.lblKahvinM‰‰r‰.setText("" + getKahvi());
			if (getKahvi() > 10) {
				JuomaAutomaattiGUI.lblKahvinM‰‰r‰.setForeground(Color.BLACK);
			}else {
				JuomaAutomaattiGUI.lblKahvinM‰‰r‰.setForeground(Color.RED);
			}
			JuomaAutomaattiGUI.lblTeenM‰‰r‰.setText("" + getTee());
			if (getTee() > 10) {
				JuomaAutomaattiGUI.lblTeenM‰‰r‰.setForeground(Color.BLACK);
			}else {
				JuomaAutomaattiGUI.lblTeenM‰‰r‰.setForeground(Color.RED);
			}
			JuomaAutomaattiGUI.lblKaakaonM‰‰r‰.setText("" + getKaakao());
			if (getKaakao() > 10) {
				JuomaAutomaattiGUI.lblKaakaonM‰‰r‰.setForeground(Color.BLACK);
			}else {
				JuomaAutomaattiGUI.lblKaakaonM‰‰r‰.setForeground(Color.RED);
			}
			
			
		}catch(FileNotFoundException el) {
			
		}
		
	}
	
	public String toString() {
		return "JuomaAutomaatti [tee-" + tee + ", kahvi-" + kahvi + ", kaakao-" + kaakao + "]";
	}
	

}
