package dataStructure;

public class DirectedEdge {
	private final int srcEdge;
	private final int targetEdge;
	private final int weight;
	
	public DirectedEdge(int srcEdge, int targetEdge, int weight) {
		this.srcEdge = srcEdge;
		this.targetEdge = targetEdge;
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getSourceEdge() {
		return srcEdge;
	}
	
	public int getTargetEdge() {
		return targetEdge;
	}
	
	public String toString() { 
		return String.format("%d->%d %d", this.srcEdge, this.targetEdge, weight); 
	} 
	
	public static void main(String[] args) {
        DirectedEdge e = new DirectedEdge(12, 34, 5);
        System.out.print(e);
    }
}