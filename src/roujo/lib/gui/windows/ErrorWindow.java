package roujo.lib.gui.windows;

public class ErrorWindow extends QueryWindow {
	private static final long serialVersionUID = 1L;
	
	public ErrorWindow(String message){ 
		super("Erreur!", message, new String[]{"Ok"}, new Effet[]{Effet.Quitter});
	}
}