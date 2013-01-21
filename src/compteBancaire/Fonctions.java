package compteBancaire;
import java.util.Scanner;


public class Fonctions {
	public static void attente(){
		Scanner sc = new Scanner(System.in);
		System.out.println("=========Appuyer sur entrée pour continuer=========");
		String d = sc.nextLine();
		d.toLowerCase();
	}
        
        public static boolean testNumCpt(String numcompte){
            if (numcompte.matches("[0-1]{3}-222-[0-9]{3}")){
                return true;
            }else{
                return false;
            }
        }
        
        public static boolean controleSoldeInitial(Double solde){
            if (solde < 0){
                return false;             
            }else{
                return true;
            }
        } 
        
        public static String controleDebitOuCredit(String type){
            char c = type.toUpperCase().charAt(0);
            String retour;
            switch (c){
                case 'D' :
                    retour = "Débit";
                    break;
                case 'C':
                    retour = "Crédit";
                    break;
                default :
                    retour = null;
            }
            return retour;
        }
        
        public static String controleTypeCompte(String type){
            char c = type.toUpperCase().charAt(0);
            String retour;
            switch (c){
                case 'E' :
                    retour = "Epargne";
                    break;
                case 'C':
                    retour = "Courant";
                    break;
                case 'J':
                    retour = "Joint";
                default :
                    retour = null;
            }
            return retour;
        }
        
        public static boolean controleMoyenPaiement(String S){
            if (S.length() > 1){
                String rslt = S.substring(0,2);
                if (!("CB".equals(rslt) || "CO".equals(rslt) || "CH".equals(rslt))){
                    return false;
                }else{
                    return true;
                }
            }else{
                return false;
            }
        }
       
}
