package roujo.lib.persistance;

public class ErreurChargement extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ErreurChargement(){
		super("Une erreur s'est produite lors du chargement des objets.");
	}

}
