/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphique;
import appli.FichierCompte;
import appli.ListeCompte;
/**
 *
 * @author yoshi
 */
public class AppliStart {
    public static void main(String [] args){
        ListeCompte liste = new ListeCompte();
        FichierCompte F = new FichierCompte();
        if (F.ouvrir("L")) {
            liste = F.lire();
            F.fermer();
        }
        Saisie S;
        if (liste != null) {
            S = new Saisie(liste);
        }
    }
}
