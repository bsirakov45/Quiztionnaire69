package main;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import View.Login;
import controller.Controller;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    
		}
		Controller controller = new Controller();
		Login login = new Login(controller);
	}
}