package graphique;


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
public class GestionAction implements ActionListener{
    private int n;
    private Dessin d;
    
    public GestionAction(int n, Dessin d){
        this.n = n;
        this.d = d;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        switch (n){
            case 1: System.exit(0);
                break;
        }
    }
}
