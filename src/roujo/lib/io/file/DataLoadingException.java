package roujo.lib.io.file;

public class DataLoadingException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DataLoadingException(){
		super("An error has occured while loading data.");
	}

}
