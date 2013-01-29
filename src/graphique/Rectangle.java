package graphique;


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
    private int px = (400 / 2) -50;
    private int py = (400 / 2) - 100;
    private int width = 50;
    private int nbPoints = 4;
    private final int MAXSIZE= 100;
    private int lastY = py;
    private int lastX = px;
    
    public Rectangle(Graphics g, Color c){
        g.setColor(c);
        g.fillRect(px, py, 50, 100);
        lastX = lastX - 50;
    }
    
    public Rectangle(int height, Graphics g, Color c, int lastX, int lastY){
      g.setColor(c);
      g.fillRect(lastX, lastY, 52, height);
      g.drawString(""+lastX,300,100);
      lastY = py + height;
    }
    
    public int getlastX(){
        return lastX;
    }
    
    public int getLastY(){
        return lastY;
    }
    
  
    
}
