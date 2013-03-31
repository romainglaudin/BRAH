import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Image  {
	 
	public Image(){}
	
    public Image (String nomimage) {
    	try{
      BufferedImage tmp = ImageIO.read(new File(nomimage));
    	} catch (IOException e) {
            System.err.println("Could not read image " + nomimage);
        }

    }
   

}