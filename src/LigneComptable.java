
import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LigneComptable implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private double valeur;
    private String dateLC;
    private String theme;
    private String moyenPaiement;
    private String sensOperation;
    private double soldeTmp = 0;
    
    
    public LigneComptable(double solde){
        saisieLigne(solde);
        switch (sensOperation) {
            case "Débit":
                soldeTmp = solde - valeur;
                break;
            case "Crédit":
                soldeTmp = solde + valeur;
                break;
        }
    }
    
    public String getTheme(){
        return theme;
    }
    public double getValeur(){
        return valeur;
    }
    public String getSensOperation(){
        return sensOperation;
    }
    public double getNewSolde(){
        return soldeTmp;
    }
    private void saisieLigne(double solde){
        Scanner sc = new Scanner(System.in);
        Pattern patternDateLC = Pattern.compile("[0-3][0-9]/[0-1][0-9]/[0-9]{4}");
        
        System.out.print("Débit ou Crédit ? :");
        String s = sc.nextLine();
        char c = s.toUpperCase().charAt(0);
        switch (c){
            case 'D' :
                sensOperation = "Débit";
                break;
            case 'C':
                sensOperation = "Crédit";
                break;
        }
        
        System.out.println("Montant de l'opération : ");
        valeur = sc.nextDouble();
        System.out.println("Date (jj/mm/aaaa): ");
        //		dateLC = sc.nextLine();
        //Tant que le pattern est différent de celui compiler
        boolean sortie = false;
        while (!(sortie)){
            if (!(sc.hasNext(patternDateLC))){
                System.out.println("Mauvais format de date !!! ");
                System.out.println("Entrez une nouvelle date (jj/mm/aaaa): ");
                dateLC = sc.next();
            }else {
                dateLC = sc.next();
                sortie = true;
            }
        }
        System.out.println(dateLC);
        Scanner p = new Scanner(System.in);
        System.out.println("Moyen de paiement (CB, Chèque, Comptant : ");
        String d = p.nextLine();
        String chaine =d.toUpperCase();
        moyenPaiement = chaine.substring(0,2);
        System.out.println("Désignation opération : ");
        theme = p.nextLine();
    }
    
    @Override
    public String toString(){
        return sensOperation+" : "+valeur+"\n"+
                "Le : "+dateLC +
                "\nMode : "+moyenPaiement+
                "\nThème : "+theme;
    }
    
    //	public double majSolde(double s){
    //		double rslt = 0;
    //		if (sensOperation == "Débit"){
    //			rslt = s - valeur;
    //		}else if (sensOperation == "Crédit"){
    //			rslt = s + valeur;
    //		}
    //		return rslt;
    //	}

}

