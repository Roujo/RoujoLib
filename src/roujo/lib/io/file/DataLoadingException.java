package roujo.lib.io.file;

import java.io.IOException;

public class DataLoadingException extends IOException {
	private static final long serialVersionUID = 1L;
	
	public DataLoadingException(){
		super("An error has occured while loading data.");
	}

}
