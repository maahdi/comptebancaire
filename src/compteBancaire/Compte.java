package compteBancaire;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


public class Compte implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		protected String numeroCompte;
		protected String type;
		protected double solde;
		protected ArrayList<LigneComptable> ligne;
		
		public Compte(String numcompte, String typ, double sold){
			ligne = new ArrayList<LigneComptable>(10);
			type = typ;
			numeroCompte = numcompte;
			solde = sold;
		}
		
		public String getNumeroCompte(){
			return numeroCompte;
		}
		
		public String getType(){
			return type;
		}
		
		public void creerLigneComptable(){
			ligne.add(new LigneComptable(solde));
			int i = ligne.size() - 1;
			System.out.println(i);
			LigneComptable L = ligne.get(i);
			solde = L.getNewSolde();
//			if (ligne.get(ligne.lastIndexOf(ligne)) != null ){
//				return true;
//			}else {
//				return false;
//			}
		}
		
		public void afficherLignes(){
				int taille = ligne.size() - 1;
				int i = taille - 10;
				if (taille < 0){
					taille = ligne.size();
					i = ligne.size() + 1;
				}else if (taille < 10){
					i = 0;
				}
				
				while (i <= taille){
					if (ligne.get(i) != null){
						LigneComptable L = ligne.get(i);
						System.out.println(L.toString());
						System.out.println();
					}else System.out.println("Pas d'enregistrement !!!");
					i++;
				}
			}
			
		
		public String toString(){
			return "\nNuméro de compte : "+numeroCompte+"\nType de compte : "+type+"\nSolde : "+solde;
		}
	
	}
