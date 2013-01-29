package graphique;


import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yoshi
 */
public class DesBoutons extends Panel{
    public DesBoutons(Dessin d){
        setBackground(Color.lightGray);
        Button bExit = new Button("Quitter");
        bExit.addActionListener(new GestionAction(1,d));
        this.add(bExit);
        
    }
    
    
}
