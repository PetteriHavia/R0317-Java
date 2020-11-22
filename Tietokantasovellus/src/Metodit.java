
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



class Metodit {
	public static void main(String args[]) {
	
		//Tulosta konsoliin
		try {
			//Yhteysosoite
			String URL = "jdbc:mysql://localhost:3306/java";
			String USERID = "root";
			String PASSWORD = "";
			
			//Yhteyden luonti
			Connection con = DriverManager.getConnection(URL, USERID, PASSWORD);
			//Kysely
			Statement stmt = con.createStatement();
			
			System.out.println("Yhteys muodostettu tietokantaan.");
			
			//Tulokset talteen
			ResultSet rs = stmt.executeQuery("SELECT * FROM KIRJAT");
			
			 while (rs.next()) {
					String kirja = rs.getString(2);
					String tekija = rs.getString(3);
					int vuosiluku = rs.getInt(4);
								
					System.out.println("Kirjan nimi: " + kirja);
					System.out.println("Tekijän nimi: " + tekija);
					System.out.println("Vuosiluku: " + vuosiluku);
					System.out.println();
			}
			// Suljetaan yhteys
			con.close();

		} catch (Exception e) {
			System.out.println("Virhe tietokannan käytössä!");
			System.out.println(e);
		} // catch
	} // main
	
	
	public static void naytaTiedot() {
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Kirjan nimi");
		model.addColumn("Tekijä");
		model.addColumn("Julkaisuvuosi");
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM KIRJAT");
			
			while(rs.next()) {
				System.out.println(rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
				model.addRow(new Object[] { rs.getString(2), rs.getString(3), rs.getString(4) });
			}
			
			con.close();
			
			tietokantaGUI.table.setModel(model);
			
			tietokantaGUI.table.getColumnModel().getColumn(1).setPreferredWidth(45);
			tietokantaGUI.table.getColumnModel().getColumn(2).setPreferredWidth(30);
			tietokantaGUI.table.getColumnModel().getColumn(3).setPreferredWidth(30);
			
		}catch (Exception e) {
			System.out.print(e);
		}
	}
	
	

	
	public static void tallennaKirja(Olio uusiTallenne) {
		
		try {
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
			
			String sql = "INSERT INTO kirjat (TeoksenNimi, TekijanNimi, Julkaisuvuosi) values (?,?,?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			
			preparedStmt.setString(1, uusiTallenne.getTeoksenNimi());
			preparedStmt.setString(2, uusiTallenne.getTekijanNimi());
			preparedStmt.setString(3, uusiTallenne.getJulkaisuvuosi());
			
			preparedStmt.execute();
			
			con.close();
			
		}catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	
	public static void lisaaKirja(String uusiKirja, String uusiTekija, String uusiVuosi) {
		
		//Luo uusi objekti parametrina välitetyillä arvoilla
		Olio uusi = new Olio(uusiKirja, uusiTekija, uusiVuosi);
		
		System.out.println(uusi);
		
		//Siiretään olio tallennaKirja metodin avulla tietokantaan
		tallennaKirja(uusi);
		
		//Varmennus viesti
		JOptionPane.showMessageDialog(null, "Tiedot lisätty tietokantaan");
		
		naytaTiedot();
	}
	
	
	public static void poistaKirja(String kirja) {
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
			Statement stmt = con.createStatement();
		
			String sql = "DELETE FROM Kirjat WHERE TeoksenNimi = + '"  + kirja  + "'";
			stmt.executeUpdate(sql);
			
			naytaTiedot();
			
			con.close();
			
		}catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}			
}