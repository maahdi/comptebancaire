package graphique;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yoshi
 */
public class Dessin extends Canvas{
    private Stat S;
    private Color couleur = Color.green;
    public final static Color couleurFond = Color.white;
    
    public Dessin(Stat S){
        this.S = S;
        setBackground(couleurFond);
        setForeground(couleur);
        setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        
    }
    
    @Override
    public void paint(Graphics g){
        S.dessine(g);
    }
    
}
