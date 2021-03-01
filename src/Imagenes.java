import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Imagenes {
	ProcesarTexto p= new ProcesarTexto();
	
	public List<List<JLabel>> obtenerImagen(float factor) throws FileNotFoundException {
		
		List<List<String>> rutas=p.obtenerRuta();
		List<List<JLabel>> labels=new ArrayList<List<JLabel>>();		
		BufferedImage img;
		
		 for(Integer n=0;n<rutas.size();n++) {	
			 List<JLabel> imgList= new ArrayList<JLabel>();
			 for (Integer i=0;i<rutas.get(n).size();i++) {	
				 try {
					 if(rutas.get(n).get(i) != null) {
						 img = ImageIO.read(new File(rutas.get(n).get(i)));
						 JLabel label = new JLabel();
						 label.setIcon(new ImageIcon(img.getScaledInstance(Math.round(img.getWidth()*factor),Math.round(img.getHeight()*factor),Image.SCALE_SMOOTH)));
						 imgList.add(label);
					 }
				 } catch (IOException e) {
					 e.printStackTrace();
					 return null;
				 }
			 }
			 labels.add(imgList);
		
		 }

		
		return labels; 
	}
	
	
	
}
