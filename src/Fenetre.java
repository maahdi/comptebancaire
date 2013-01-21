
import java.awt.Color;
import java.awt.Frame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yoshi
 */
public class Fenetre {
    public final static int height = 400;
    public final static int width = 400;
    
    public static void main(String [] args){
        Frame F = new Frame();
        F.setTitle("Histogramme");
        F.setBackground(Color.gray);
        F.setSize(height, width);
        Dessin page = new Dessin();
        F.add(page, "Center");
        F.add(new DesBoutons(page), "South");
        F.addWindowListener(new GestionFenetre());
        F.setVisible(true);
    }
}
