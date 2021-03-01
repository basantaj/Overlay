

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


public class Listener implements NativeKeyListener{
	boolean ctrl=false;
	boolean shift=false;
	Float factor=0.12f;
	Overlay o;
	public Listener() throws FileNotFoundException {
		LogManager.getLogManager().reset();
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		o= new Overlay();
	}
	
	public void agregarHook() throws FileNotFoundException {
		try {

			
			GlobalScreen.registerNativeHook();
						
		}catch (NativeHookException e) {
			System.out.println("Error registrando hook");
		}
		GlobalScreen.addNativeKeyListener(this);

	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		//System.out.println(e.getKeyCode());
		
		switch (e.getKeyCode()) {
		
		case NativeKeyEvent.VC_CONTROL:
			ctrl=true;
			break;
			
		case NativeKeyEvent.VC_SHIFT:
			shift=true;
			break;
			
		case NativeKeyEvent.VC_O:
			if (ctrl) {
				o.mostrar();
			}
			break;
			
		case 3658: //Keycode para la tecla - del numpad
			if(ctrl && shift) {
				factor-=0.02f;
				try {
					o.recargar(factor);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(o);
			}else if (ctrl) {
				o.setOpacity((o.getOpacity()*0.8f));
			}
			break;
			
		case 3662: //Keycode para la tecla + del numpad
			if(ctrl && shift) {
				factor+=0.02f;
				try {
					o.recargar(factor);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else if (ctrl) {
				o.setOpacity(clamp(o.getOpacity()*1.2f));
				
			}
			break;
		case NativeKeyEvent.VC_R:
			if(ctrl) {
				factor=0.12f;
				try {
					o.recargar(factor);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			}
		case NativeKeyEvent.VC_Q:
			if(ctrl && shift) {
			System.exit(0);
			}
			break;
		default:
			break;
		}
	
		
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		if (e.getKeyCode()==NativeKeyEvent.VC_CONTROL) {
			ctrl=false;
		}
		if(e.getKeyCode()==NativeKeyEvent.VC_SHIFT) {
			shift=false;
		}
		
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		/*no se implementa*/
	}
	
	
	private float clamp(float f) {
		if (f<0.2f) {
			return 0.2f;
		}else if (f>1) {
			return 1;
		} else return f;
	}
	

}
