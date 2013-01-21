
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yoshi
 */
public class Stat {
    private ListeCompte listeCompte;
    private FichierCompte F;
    
    private ArrayList<String> theme;
    private HashMap<String, Double> pourcentage;
    
    
    public void statParMotif(String numcompte){
        F = new FichierCompte();
        F.ouvrir(numcompte);
        listeCompte = F.lire();
        F.fermer();
        pourcentage = listeCompte.getPourcentageDebit(numcompte);
        theme = listeCompte.getThemeDebit(numcompte);
    }
    
    public void dessine(Graphics g){
        Color CreditColor = Color.blue;
        Rectangle R = new Rectangle(50, 100, g, CreditColor);
    }
}
