package dataStructure;

import java.util.ArrayList;
import java.util.Collection;

public class GraphData {
	
	private int numberOfEdges;
	private Collection<DirectedEdge>[] paths;
	private final int numberOfVertices;
	
	@SuppressWarnings("unchecked")
	public GraphData(int verticies) {
		this.paths = (Collection<DirectedEdge>[]) new ArrayList[verticies];
		this.numberOfVertices = verticies;
		for (int x = 0; x < verticies; x++) {
			paths[x] = new ArrayList<DirectedEdge>();
		}
	}
	
	public boolean addEdge(DirectedEdge roadTo) {
		for(DirectedEdge edge : paths[roadTo.getSourceEdge()]) {
            if(edge.getTargetEdge() == roadTo.getTargetEdge()) {
                return false;
            }
        }
        if(roadTo.getSourceEdge() == roadTo.getTargetEdge()) {
            return false;
        } 
        DirectedEdge roadBack = new DirectedEdge(roadTo.getTargetEdge(), roadTo.getSourceEdge(), roadTo.getWeight());

        //adds both the road to and the road back to the paths of the graph
        paths[roadTo.getSourceEdge()].add(roadTo);
        paths[roadTo.getTargetEdge()].add(roadBack);
        numberOfEdges+=2;
        return true;
	}
	
	public Collection<DirectedEdge> getAdjacent(Integer to) {
		return paths[to];
	}
	
	public int getNumberOfVerticies() {
		return numberOfVertices;
	}

	public int getNumberOfEdges() {
		return numberOfEdges;
	}
	
	public Iterable<DirectedEdge> edges() {
		ArrayList<DirectedEdge> collectEdges = new ArrayList<DirectedEdge>();
		for(int verticies = 0; verticies < this.numberOfVertices; verticies++) {
			for(DirectedEdge edge : paths[verticies]) {
				collectEdges.add(edge);
			}
		}
		System.out.print(collectEdges);
		return collectEdges;
	}
	
	public boolean addUndirectEdge(DirectedEdge roadTo) {

        //creates a directed edge going the opposite direction as the input
        DirectedEdge roadBack = new DirectedEdge(roadTo.getTargetEdge(), roadTo.getSourceEdge(), roadTo.getWeight());

        //adds both the road to and the road back to the paths of the graph
        paths[roadTo.getSourceEdge()].add(roadTo);
        paths[roadTo.getTargetEdge()].add(roadBack);

        return true;
    }
	
	public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.getNumberOfVerticies() + " " + this.getNumberOfEdges() + "\n");
        for (int v = 0; v < this.getNumberOfVerticies(); v++) {
            s.append(v + ": ");
            for (DirectedEdge e : paths[v]) {
                s.append(e + "  ");
            }
            s.append("\n");
        }
        return s.toString();
    }
	
	public static void main(String[] args) {
		GraphData uut = new GraphData(6);
		DirectedEdge thing = new DirectedEdge(0, 1, 1);
	    uut.addEdge(thing);
	    DirectedEdge thing1 = new DirectedEdge(1, 3, 2);
	    uut.addEdge(thing1);
	    DirectedEdge thing2 = new DirectedEdge(3, 2, 3);
	    uut.addEdge(thing2);
	    DirectedEdge thing3 = new DirectedEdge(3, 1, 4);
	    uut.addEdge(thing3);
	    DirectedEdge thing4 = new DirectedEdge(5, 2, 5);
	    uut.addEdge(thing4);
        uut.edges();
        System.out.println(uut);
    }
}