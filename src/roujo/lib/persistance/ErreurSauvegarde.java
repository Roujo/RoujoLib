package roujo.lib.persistance;

public class ErreurSauvegarde extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ErreurSauvegarde(){
		super("Une erreur s'est produite lors de la sauvegarde des objets.");
	}
}
