
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


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
        ligne = new ArrayList<>(10);
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
    
    public void affichePourcentage(){
        ArrayList<String> theme;
        theme = (ArrayList<String>) this.getListeTheme();
        
        HashMap<String, Double> L = calculPourcentage();
        for (String S : theme){
            System.out.println(S+" :");
            System.out.println(L.get(S));
        }
    }
    
    public HashMap<String, Double> calculPourcentage(){
        ArrayList<String> theme = this.getListeTheme();
        HashMap<String, Double> listePourcentage;
        double sommePourcentage;
        double sommeTotale = 0;
        double pourcentage ;
        int i = 0;
        
        listePourcentage = new HashMap<>();
        while (i < theme.size()){
            sommePourcentage = 0;
            for (LigneComptable L : ligne){
                if (L.getSensOperation().equalsIgnoreCase("Débit")
                        && L.getTheme().equalsIgnoreCase(theme.get(i))){
                    sommePourcentage += L.getValeur();
                }else if (L.getSensOperation().equalsIgnoreCase("Débit")){
                    sommeTotale += L.getValeur();
                }
            }
            pourcentage = (sommePourcentage * 100) / sommeTotale;
          
            listePourcentage.put(theme.get(i), pourcentage);
              i++;
        }
        return listePourcentage;
    }
    
    public ArrayList<String> getListeTheme(){
        ArrayList<String> theme ;
        theme = new ArrayList<>(10);
        int j = 0;
        String tmpTheme;
        
        for (LigneComptable L : ligne){
            tmpTheme = L.getTheme();
            if (theme.isEmpty()){
                theme.add(tmpTheme);
            }else{
                while (j < theme.size()){
                    if (!tmpTheme.equals(theme.get(j))){
                        theme.add(tmpTheme);
                    }
                    j++;
                }
            }
        }
        return theme;
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
            }else {
                System.out.println("Pas d'enregistrement !!!");
            }
            i++;
        }
    }
    
    
    @Override
    public String toString(){
        return "\nNuméro de compte : "+numeroCompte+"\nType de compte : "+type+"\nSolde : "+solde;
    }
    
}