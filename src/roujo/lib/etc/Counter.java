package roujo.lib.etc;

import java.util.HashMap;

public class Counter<T> extends HashMap<T, Integer> {
	private static final long serialVersionUID = 1L;
	
	private int total;

	public Counter() {
	}

	public void addElement(T element) {
		this.addElement(element, 0);
	}
	
	public void addElement(T element, Integer amount) {
		this.put(element, amount);
	}

	public void removeElement(T element) {
		this.remove(element);
	}

	public void increment(T element) {
		Integer count = this.get(element);
		this.put(element, count + 1);
	}
	
	public void increment(T element, Integer amount) {
		if(this.containsKey(element)) {
			Integer count = this.get(element);
			this.put(element, count + amount);
		} else {
			this.put(element, amount);
		}
	}

	public void decrement(T element) {
		this.decrement(element, 1);
	}
	
	public void decrement(T element, Integer amount) {
		if(this.containsKey(element)) {
			Integer count = this.get(element);
			this.put(element, count - amount);
		} else {
			this.put(element, -amount);
		}
	}
	
	public int getAmount(T element) {
		if(this.containsKey(element)) {
			return this.get(element);
		} else {
			return 0;
		}
	}

	public int getTotal() {
		return this.total;
	}
}
