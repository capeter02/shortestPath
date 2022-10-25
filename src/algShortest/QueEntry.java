package algShortest;

public class QueEntry implements Comparable<QueEntry>{
	
	private int key;
	private int value;
	private boolean evaluated;
	public boolean end;
	
	public QueEntry(int key, int value) {
		this.key = key;
		this.value = value;
		
	}
	
	public Integer getKey() {
		return key;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public int compareTo(QueEntry other) {
		return this.getValue().compareTo(other.getValue());
	}
	
	public void evaluate() {
		this.evaluated = true;
	}
	
	public boolean getEvaluated() {
		return evaluated;
	}
	
	public String toString() {
		String string; 
		string = key + " " + value;
		return string;
	}
	
}