package roujo.lib.gui.windows;

import roujo.lib.gui.util.QuitButtonListener;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class QueryWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public enum Effet {Quitter, Recommencer};
	
	// Paneau de la fenêtre
	private JPanel panel = new JPanel();

	// Layout en grille
	private GridLayout grille = new GridLayout(2,1);
	
	// Message de la fenêtre
	private JLabel message;
	
	public QueryWindow(String title, String message, String[] boutons, Effet[] effets) {
		setTitle(title);
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		
		this.panel.setLayout(grille);
		
		this.message = new JLabel(message);
		this.message.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel.add(this.message);
		for (int i = 0; i < boutons.length; ++i){
			JButton button = new JButton(boutons[i]);
			switch(effets[i]){
				case Quitter:
					button.addActionListener(new QuitButtonListener());
					break;
				default:
					break;
			}
			panel.add(button);
		}
		
		setContentPane(panel);
		setVisible(true);
	}

}
