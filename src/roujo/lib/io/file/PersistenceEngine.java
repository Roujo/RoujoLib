package roujo.lib.io.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersistenceEngine {
	private static final PersistenceEngine instance = new PersistenceEngine();

	public static PersistenceEngine getInstance() {
		return instance;
	}

	private PersistenceEngine() {
	}

	public void save(Object object, String filename) throws IOException {
		ObjectOutputStream out;
		out = new ObjectOutputStream(new FileOutputStream(filename));
		out.writeObject(object);
		out.close();
	}

	public Object load(String filename) throws IOException,
			ClassNotFoundException {
		ObjectInputStream in;
		Object object;
		in = new ObjectInputStream(new FileInputStream(filename));
		object = in.readObject();
		in.close();
		return object;
	}
}
