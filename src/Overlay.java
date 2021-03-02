import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class Overlay extends JFrame   {

	GridBagConstraints g = new GridBagConstraints();
	Dimension resolucion=Toolkit.getDefaultToolkit().getScreenSize();
	Dimension tamanoPanel= new Dimension();
	JPanel p = new JPanel();	
	Imagenes im = new Imagenes();
	
	int resX=resolucion.width;
	int resY=resolucion.height;	
	
	////Configuración inicial del panel
		public Overlay() throws FileNotFoundException {	
		tamanoPanel.setSize(resX/2.2f, resY/3);	
		setLayout(new GridBagLayout());
		setSize(tamanoPanel);
		setLocation(resX/15, resY/5);
		setAlwaysOnTop(true);
		setUndecorated(true);
		getContentPane().setBackground(Color.black);			
		
		p.setLayout(new GridBagLayout());
		p.setSize(tamanoPanel);
		p.setBackground(Color.black);
		g.anchor=GridBagConstraints.NORTHWEST;
		g.weightx=1;
		g.weighty=1;
		g.gridx=0;
		g.gridy=0;
		g.fill=GridBagConstraints.BOTH;
		add(p,g);
		
		recargar(0.12f);
		
	}
	
	public void mostrar() {	
		
		setVisible(!isVisible());
	}
	
	////Recarga el panel(Refleja cambios en el archivo). Redimensiona íconos usando parámetro factor.
	public void recargar(Float factor) throws FileNotFoundException {
		List<List<JLabel>> li= im.obtenerImagen(factor);
		p.removeAll();		
		
		g.weightx=0;
		g.weighty=0;
		g.fill=GridBagConstraints.NONE;
		
		for(Integer n=0;n<li.size();n++) {		
			for (Integer i=0;i<li.get(n).size();i++) {	
				g.gridx=i;				
				p.add(li.get(n).get(i),g);
			}
			g.gridy++;
		}
		
		JLabel filler= new JLabel();
		g.weightx=1;
		g.weighty=1;
		p.add(filler,g);
		
		SwingUtilities.updateComponentTreeUI(this);
	}
}
