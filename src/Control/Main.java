package Control;

import java.awt.EventQueue;

import Vista.VistaInicioSesion;

public class Main {
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ControlVistas cv= new ControlVistas();
					cv.getVis().setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
