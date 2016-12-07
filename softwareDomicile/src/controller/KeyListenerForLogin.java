package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.DialogLogIn;

public class KeyListenerForLogin implements KeyListener {

	private Controller controller;
	private DialogLogIn dialogLogIn;

	public KeyListenerForLogin(Controller controller) {
		this.controller = controller;
		dialogLogIn = new DialogLogIn(controller, this);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		loginWithEnter(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		loginWithEnter(e);
	}

	public void loginWithEnter(KeyEvent e){
		if (KeyEvent.VK_ENTER==e.getKeyCode())
		{
			e.consume();	
			if (dialogLogIn.getStatus() != null) {
				controller.login();
			}
		}
		if (KeyEvent.VK_TAB==e.getKeyCode())
		{
			e.consume();
		}
	}
}
