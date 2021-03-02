import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ProcesarTexto {
	
	Map<String,String> imgs= new HashMap<>();
	File f = new File("res/combo.txt");
	Scanner sc;
	
	public ProcesarTexto() {
		imgs.put("LP", "res/LP.png");
		imgs.put("MP", "res/MP.png");
		imgs.put("HP", "res/HP.png");
		imgs.put("LK", "res/LK.png");
		imgs.put("MK", "res/MK.png");
		imgs.put("HK", "res/HK.png");
		imgs.put("JLP", "res/JLP.png");
		imgs.put("JMP", "res/JMP.png");
		imgs.put("JHP", "res/JHP.png");
		imgs.put("JLK", "res/JLK.png");
		imgs.put("JMK", "res/JMK.png");
		imgs.put("JHK", "res/JHK.png");
		imgs.put("CLLP", "res/CLLP.png");
		imgs.put("CLMP", "res/CLMP.png");
		imgs.put("CLHP", "res/CLHP.png");
		imgs.put("CLLK", "res/CLLK.png");
		imgs.put("CLMK", "res/CLMK.png");
		imgs.put("CLHK", "res/CLHK.png");
		imgs.put("CRLP", "res/CRLP.png");
		imgs.put("CRMP", "res/CRMP.png");
		imgs.put("CRHP", "res/CRHP.png");
		imgs.put("CRLK", "res/CRLK.png");
		imgs.put("CRMK", "res/CRMK.png");
		imgs.put("CRHK", "res/CRHK.png");
		imgs.put("HCF", "res/HCF.png");
		imgs.put("HCB", "res/HCB.png");
		imgs.put("QCF", "res/QCF.png");
		imgs.put("QCB", "res/QCB.png");
		imgs.put("A","res/A.png");
		imgs.put("B","res/B.png");
		imgs.put("C","res/C.png");
		imgs.put("D","res/D.png");
		imgs.put("JA","res/JA.png");
		imgs.put("JB","res/JB.png");
		imgs.put("JC","res/JC.png");
		imgs.put("JD","res/JD.png");
		imgs.put("CRA","res/CRA.png");
		imgs.put("CRB","res/CRB.png");
		imgs.put("CRC","res/CRC.png");
		imgs.put("CRD","res/CRD.png");
		imgs.put("CLA","res/CLA.png");
		imgs.put("CLB","res/CLB.png");
		imgs.put("CLC","res/CLC.png");
		imgs.put("CLD","res/CLD.png");
		imgs.put("DP","res/SRK.png");
		imgs.put("DPB","res/SRKB.png");
		imgs.put("FWD","res/FWD.png");
		imgs.put("BCK","res/BCK.png");
		imgs.put("DWN","res/DWN.png");
		imgs.put("DB","res/DB.png");
		imgs.put("DF","res/DF.png");
		imgs.put("UP","res/UP.png");
		imgs.put("XX", "res/XX.png");
		imgs.put(",", "res/Comma.png");
		
	}
	
	////Escanea el archivo de texto y devuelve una lista de rutas en base a las corresponencias establecidas en el HashMap
	public List<List<String>> obtenerRuta() throws FileNotFoundException{
		
		List<List<String>> listaRutas= new ArrayList<List<String>>();
		
		if(!f.exists()) {
			JOptionPane.showMessageDialog(new JFrame(), "File rcrs/combo.txt not found","Error",JOptionPane.ERROR_MESSAGE);
		}else {
			
			sc= new Scanner(f);	
			
		while(sc.hasNextLine()) {
			
			List<String> rutas = new ArrayList<String>();
			String[] codigos=sc.nextLine().split("-");
			
			for(String str:codigos) {

				rutas.add(imgs.get(str.trim().toUpperCase()));
				if (imgs.get(str.trim().toUpperCase())==null){
					JOptionPane.showMessageDialog(new JFrame(),"Move name "+str.trim()+" incorrect", "Error",JOptionPane.ERROR_MESSAGE);
				}
			}

			listaRutas.add(rutas);		
			}
		
			return listaRutas;
		}
		
		return null;
	}
	
}
