package graphique;


import appli.Compte;
import appli.ListeCompte;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yoshi
 */
public class Saisie implements ActionListener {
    TextField reponse;
    ListeCompte L;
    public Saisie(ListeCompte L){
        this.L = L;
        Frame F = new Frame("Saisie de valeur");
        F.setSize(300,50);
        F.setBackground(Color.white);
        F.setLayout(new BorderLayout());
        F.add(new Label("Valeur :"), "West");
        reponse = new TextField(10);
        F.add(reponse, "East");
        reponse.addActionListener(this);
        F.setVisible(true);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        String numero = reponse.getText();
        if (L != null){
            Stat S = new Stat(L, numero);
            Fenetre F = new Fenetre(S);
        }
    }
}
