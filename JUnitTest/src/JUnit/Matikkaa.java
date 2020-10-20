package JUnit;

public class Matikkaa {
	
	public static int summa(int eka, int toka) {
		return eka + toka;
	}
	
	public static double potenssi(int eka, int toka) {
		return Math.pow(eka, toka);
	}
	
	public static boolean ekaSuurempiKuin(int eka, int toka) {
		
		if(eka > toka) {
			return true;
		}else {
			return false;
		}
	}

	public static int pintaAla(int pituus, int leveys) {
		
		if(pituus < 0 || leveys < 0) {
			return 0;
		}else {
			return pituus * leveys;
		}
	}

	public static void main(String[] args) {
		System.out.println( Matikkaa.summa(2, 3) ); //summa
		System.out.println( Matikkaa.potenssi(4, 2) ); //potenssi
		System.out.println( Matikkaa.ekaSuurempiKuin(5, 4) ); //ekaSuurempiKuin
		System.out.println( Matikkaa.ekaSuurempiKuin(3, 7) ); //ekaSuurempiKuin
		System.out.println(Matikkaa.pintaAla(3, 3)); //pintaAla
		System.out.println(Matikkaa.pintaAla(-4, 3)); //pintaAla
	}

}
