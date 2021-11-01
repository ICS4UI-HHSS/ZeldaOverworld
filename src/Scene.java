
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lamonta
 */
public class Scene {
    private BufferedImage img;
    private String description;
    
    public Scene(String filename, String description){
        this.description = description;
        
        // load in the image
        this.img = null;
        try{
           this.img = ImageIO.read(new File("images//" + filename));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public BufferedImage getImage(){
        return this.img;
    }
    
}
