package roujo.lib.gui.util;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class QuitButtonListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Window win = SwingUtilities.getWindowAncestor((Component) e.getSource());
        win.dispose();
	}

}
