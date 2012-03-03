package roujo.lib.io.file;

public class DataSavingException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DataSavingException(){
		super("An error has occured while saving data.");
	}
}
