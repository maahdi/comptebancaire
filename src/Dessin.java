
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
    public Dessin(){
        S = new Stat();
        setBackground(Color.white);
        setForeground(Color.red);
        setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        
    }
    public void paint(Graphics g){
        S.dessine(g);
    }
    
}
