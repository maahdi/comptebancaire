
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yoshi
 */
public class GestionFenetre extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
    
}
