
public class Olio {

	private String teoksenNimi;
	private String tekijanNimi;
	private String julkaisuvuosi;
	
	
	//Konstruktori
	public Olio() {
		teoksenNimi = "Tyhjä";
		tekijanNimi = "Tyhjä";
		julkaisuvuosi = "Tyhjä";
	}
	
	public Olio(String teoksenNimi, String tekijanNimi, String julkaisuvuosi) {
		this();
		this.teoksenNimi = teoksenNimi;
		this.tekijanNimi = tekijanNimi;
		this.julkaisuvuosi = julkaisuvuosi;
	}
	
	//Setterit ja Getterit
	
	public String getTeoksenNimi() {
		return teoksenNimi;
	}
	
	public void setTeoksenNimi(String teoksenNimi) {
		this.teoksenNimi= teoksenNimi;
	}
	
	public String getTekijanNimi() {
		return tekijanNimi;
	}
	
	public void setTekijanNimi(String tekijanNimi) {
		this.tekijanNimi = tekijanNimi;
	}
	
	public String getJulkaisuvuosi() {
		return julkaisuvuosi;
	}
	
	public void setJulkaisuvuosi(String julkaisuvuosi) {
		this.julkaisuvuosi= julkaisuvuosi;
	}
	

	public String toString() {
		return "Olio [teoksenNimi= " + teoksenNimi + " , tekijanNimi= " + tekijanNimi + ", julkaisuvuosi= " + julkaisuvuosi + "]";
	}
	
}
