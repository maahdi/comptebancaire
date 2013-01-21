package compteBancaire;
import java.util.Scanner;


public class CptEpargne extends Compte{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double taux;


	public CptEpargne(String numcompte, String typ, double sold){

		super(numcompte, typ, sold);
		taux = controleTaux();
	}
	
	private double controleTaux() {
		double tmp;
       Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Taux de placement :     ");
			tmp = sc.nextDouble();
		} while (tmp < 0);
		return tmp;
	}
	
	public String toString(){
		return super.toString()+"\nTaux d'épargne : "+taux;
	}
	
	public double tauxControle (){
		 double d = 0;
		return  d;
	}
	public String getType(){
		return super.type;
	}

	public double getTaux() {
		return taux;
	}
//	public void creerLigneComptable(){
//		
//		super.creerLigneComptable();
//	}
}
