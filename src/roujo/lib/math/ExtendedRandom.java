package roujo.lib.math;

import java.util.Random;
import java.util.Vector;

public class ExtendedRandom extends Random {
	private static final long serialVersionUID = 1L;
	
	public int nextInt(int min, int max) {
		return nextInt(max) + max;
	}
	
	public int nextPositiveInt(int max) {
		return super.nextInt(max) + 1;
	}
	
	public int nextPositiveInt(int min, int max) {
		return nextPositiveInt(max) + min;
	}
	
	public <T> Vector<T> randomizeVector(Vector<T> vector) {
		Vector<T> sourceVector = new Vector<T>(vector);
		Vector<T> randomVector = new Vector<T>();
		while(!sourceVector.isEmpty()) {
			int i = nextInt(sourceVector.size());
			randomVector.add(sourceVector.remove(i));			
		}
		return randomVector;
	}
}
