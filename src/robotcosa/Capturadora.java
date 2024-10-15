/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotcosa;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author EAG
 */
public class Capturadora{
    
    Robot r;
    int veces;
    ArrayList<BufferedImage> lista = new ArrayList<>();
    
    public Capturadora(int num) throws AWTException, IOException, InterruptedException{
        
        veces = num;
        
        r = new Robot();
        
        for (int i = 0; i < num; i++) {
            
            lista.add(hacerCaptura());
            Thread.sleep(1000);
        }
    }
    
    public BufferedImage hacerCaptura(){
        BufferedImage screenshot = r.createScreenCapture(new Rectangle(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height));        
        return screenshot;
    }
    
    public void guardar(){
        
        for (int i = 0; i < veces; i++) {
            
            File f = new File("C:\\Users\\EAG\\Desktop\\guardar\\ " + i + " .jpg");

            try {
                
                f.createNewFile();
                ImageIO.write(lista.get(i), "jpg", f);
                
            } catch (IOException ex) {
                Logger.getLogger(Capturadora.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public static void main(String[] args) throws AWTException, IOException, InterruptedException {
        Capturadora robotCosa = new Capturadora(5);
                
        robotCosa.hacerCaptura();
        robotCosa.guardar();
    }
    
}
