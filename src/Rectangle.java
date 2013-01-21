
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yoshi
 */
public class Rectangle{
    private int px = 400 / 2 -50;
    private int py = 400 / 2 - 100;
  
    private int nbPoints = 4;
    
    public Rectangle(int width, int height, Graphics g, Color c){
        g.setColor(c);
        g.fillRect(px, py, width, height);
        
    }
    
}
