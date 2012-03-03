package roujo.lib.io.file;

import java.io.IOException;

public class DataSavingException extends IOException {
	private static final long serialVersionUID = 1L;
	
	public DataSavingException(){
		super("An error has occured while saving data.");
	}
}
