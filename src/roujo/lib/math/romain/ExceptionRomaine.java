package roujo.lib.math.romain;

public abstract class ExceptionRomaine extends Exception {
	private static final long serialVersionUID = 1L;

	public ExceptionRomaine(){
		super("Exception: Problème de chiffre romain!");
	}
	
	public ExceptionRomaine(String string) {
		super(string);
	}

}
