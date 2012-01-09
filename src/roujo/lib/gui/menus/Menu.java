package roujo.lib.gui.menus;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import roujo.lib.gui.util.QuitButtonListener;
import roujo.lib.gui.windows.ErrorWindow;
import roujo.lib.gui.windows.QueryWindow;
import roujo.lib.gui.windows.QueryWindow.Effet;

//import util.persistance.GestionInformations;

public class Menu extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static Menu INSTANCE;
	
	// Panneau principal
	private JPanel panel = new JPanel();
	// Paneau pour options
	private JPanel panelP = new JPanel();
	
	// Layout principal
	private BorderLayout layout = new BorderLayout();
	// Layout pour options
	private GridLayout grille = new GridLayout(2,3);
	
	// Titre
	private JLabel titre = new JLabel("Menu Principal");
	
	// Boutons de choix
	private JButton bouton1 = new JButton("Créer une partie");
	private JButton bouton3 = new JButton("Joindre une partie");
	private JButton bouton2 = new JButton("Options");
	private JButton bouton4 = new JButton("Infos");
	
	private JButton boutonQuit = new JButton("Quitter");
	
	
	public Menu(){
		INSTANCE = this;
		
		setTitle("Project Alpha - Menu Principal");
		setSize(500, 150);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		
		this.panelP.setLayout(layout);
		this.titre.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelP.add(titre, BorderLayout.NORTH);
		this.panelP.add(panel, BorderLayout.CENTER);
		this.boutonQuit.addActionListener(new BoutonQuitListener());
		this.panelP.add(boutonQuit, BorderLayout.SOUTH);
		
		
		this.panel.setLayout(grille);
		
		this.bouton1.addActionListener(new Bouton1Listener());
		this.panel.add(bouton1);
		this.bouton3.addActionListener(new Bouton3Listener());
		this.panel.add(bouton3);
		this.bouton2.addActionListener(new Bouton2Listener());
		this.panel.add(bouton2);
		this.bouton4.addActionListener(new Bouton4Listener());
		this.panel.add(bouton4);
		
		setContentPane(panelP);
		setVisible(true);
	}
	
	class Bouton1Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

		}
	}
	
	class Bouton2Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			new ErrorWindow("Option non disponible!");
		}
	}
	
	class Bouton3Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			new ErrorWindow("Option non disponible!");
		}
	}
	
	class Bouton4Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String titre = "Crédits";
			String message = "Jeu fait par Jonathan Rouillard. Version 0.3.0";
			String[] boutons = new String[]{"Quitter"};
			Effet[] effets = new Effet[]{Effet.Quitter};
			new QueryWindow(titre, message, boutons, effets);
		}
	}
	
	class BoutonQuitListener extends QuitButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			/*try {
				GestionInformations.sauvegarde();
			} catch (ErreurSauvegarde ex) {
				new ErrorWindow(ex.getMessage());
			}*/
			super.actionPerformed(e);
			System.exit(0);
		}
	}
	
	public static void setVisibility(boolean visibility){
		INSTANCE.setVisible(visibility);
	}
}
