package graphique;


import appli.Compte;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import appli.ListeCompte;
import appli.FichierCompte;
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
    private String numcompte;
    private ArrayList<String> theme;
    private HashMap<String, Double> pourcentage;
    
    public Stat(ListeCompte L, String numero){
        listeCompte = L;
        numcompte = numero;
    }
    
    public void statParMotif(){
        pourcentage = listeCompte.getPourcentageDebit(numcompte);
        theme = listeCompte.getThemeDebit(numcompte);
    }
    
    public void dessine(Graphics g){
                statParMotif();
		g.setColor(Color.darkGray);
		g.drawString("Compte n° : " + numcompte, 100, 50);
		g.drawString("Crédit", 105, 220);
		g.drawString("Débit", 160, 220);
		g.drawString(" "+pourcentage.size(), 200, 100);
                
                Color CreditColor = Color.red;
                Rectangle R = new Rectangle(g, Color.blue);
                int lastX =  R.getlastX();
                int lastY = R.getLastY();
//                System.out.print(pourcentage.size());
        int taille;
        Collection<Double> C = pourcentage.values();
        for (Double D : C){
            taille = D.intValue();
            Rectangle T = new Rectangle( taille, g, CreditColor,lastX, lastY);
        }
        
    }
}
