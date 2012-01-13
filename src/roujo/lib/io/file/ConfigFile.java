package roujo.lib.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Properties;

/**
 * Basic config file, usable with pretty much any application
 * 
 * @author Roujo
 */
public class ConfigFile {
	private final File file;
	
	public ConfigFile(String path){
		file = new File(path);
	}
	
    public void storeValues(String key, int[] values) {
        Properties prop = new Properties();
        String Key = key.toLowerCase();
        try {
            FileInputStream in = new FileInputStream(file);
            prop.load(in);
            prop.put(Key, Arrays.toString(values));
            prop.store(new FileOutputStream(file), "[Name]= amount");
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
    }
    
    public void storeValue(String key, int value) {
        Properties prop = new Properties();
        String Key = key.toLowerCase();
        try {
            FileInputStream in = new FileInputStream(file);
            prop.load(in);
            prop.put(Key, value);
            prop.store(new FileOutputStream(file), "[Name]= amount");
        } catch (Exception ex) {
        }
    }
}
