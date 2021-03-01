import java.awt.Color;
import java.awt.Component;
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
	Dimension tamanoPanel= new Dimension();
	JPanel p = new JPanel();
	
	Imagenes im = new Imagenes();
	
	int resX=Toolkit.getDefaultToolkit().getScreenSize().width;
	int resY=Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public Overlay() throws FileNotFoundException {	
		tamanoPanel.setSize(resX/2.2f, resY/3);	
		setLayout(new GridBagLayout());
		setSize(tamanoPanel);
		setLocation(resX/15, resY/5);
		setAlwaysOnTop(true);
		setUndecorated(true);
		getContentPane().setBackground(Color.black);
		
		
		
		tamanoPanel.setSize(tamanoPanel.getWidth()*0.5, tamanoPanel.getHeight()*0.5);
		
		
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

		List<List<JLabel>> li= im.obtenerImagen(0.12f);
		g.weightx=0;
		g.weighty=0;
		for(Integer n=0;n<li.size();n++) {
		
			for (Integer i=0;i<li.get(n).size();i++) {	
				g.gridx=i;
				g.fill=GridBagConstraints.NONE;				
				p.add(li.get(n).get(i),g);

			}
			g.gridy++;

		}
		JLabel filler= new JLabel();

		g.weightx=1;
		g.weighty=1;
		p.add(filler,g);
	
		
		
		
	}
	
	public void mostrar() {
		
		setVisible(!isVisible());

	}
	
	public void recargar(Float factor) throws FileNotFoundException {
		p.removeAll();
		
		List<List<JLabel>> li= im.obtenerImagen(factor);
		g.weightx=0;
		g.weighty=0;
		for(Integer n=0;n<li.size();n++) {
		
			for (Integer i=0;i<li.get(n).size();i++) {	
				g.gridx=i;
				g.fill=GridBagConstraints.NONE;				
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
