package roujo.lib.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * Basic config file, usable with pretty much any application
 * 
 * @author Roujo
 */
public class DataFile {
	private final File file;
	private final Properties prop;
	private final String description;
	
	public DataFile(String path) throws IOException{
		file = new File(path);
		prop = new Properties();
		FileInputStream in = new FileInputStream(file);
		prop.load(in);
		description = "";
	}
	
	public DataFile(String path, String description) throws IOException{
		file = new File(path);
		prop = new Properties();
		FileInputStream in = new FileInputStream(file);
		prop.load(in);
		this.description = description;
	}
	
	public boolean reloadData(){
		try {
			FileInputStream in = new FileInputStream(file);
			prop.load(in);
			return true;
		} catch (IOException e){
			return false;
		}
	}
	
	public void saveInfo(String key, int[] values){
		prop.put(key, Arrays.toString(values));
	}
	
    public boolean saveData() {
        try {
            prop.store(new FileOutputStream(file), description);
            return true;
        } catch (Exception ex) {
        	return false;
        }
    }
}
