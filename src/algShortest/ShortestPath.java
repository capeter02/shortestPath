package algShortest;

import java.util.PriorityQueue;
import java.util.Stack;
import dataStructure.DirectedEdge;
import dataStructure.GraphData;

public class ShortestPath {
	
	private static DirectedEdge[] viaVert;
	private PriorityQueue<QueEntry> minPriorityQue;
	private static Integer[] distTo;
	private int end;
	private String[] cityNames;
	
	public ShortestPath(GraphData paths, int start, int end) {
		cityNames = new String[]{"New York","Los Angeles","Chicago","Houston","Phoenix","Philadelphia","San Antonio","San Diego","Dallas","San Jose", "Fresno", "Austin", "Jacksonville", "Charleston", "Nashville", "New Orleans","Denver"};	
		this.end = end;
		minPriorityQue = new PriorityQueue<QueEntry>(paths.getNumberOfVerticies());
		distTo = new Integer[paths.getNumberOfVerticies()];
		viaVert = new DirectedEdge[paths.getNumberOfVerticies()];
		for (int x = 0; x < paths.getNumberOfVerticies(); x++) {
			QueEntry addEntry = new QueEntry(x, 1000);
			if (addEntry.getKey() == end) {
				addEntry.end = true;
			}
			minPriorityQue.add(addEntry);
			distTo[x] = 1000;
		}
		distTo[start] = 0;	
		QueEntry startEntry = new QueEntry(start, 0);	
		minPriorityQue.add(startEntry);
		while(!minPriorityQue.isEmpty()) {
			QueEntry removeEntry = minPriorityQue.remove();
			relax(paths, removeEntry);
			if (removeEntry.end == true) {
				break;
			}
		}	
	}
	
	public void relax(GraphData paths, QueEntry vertex) {
		for (DirectedEdge adjEdge: paths.getAdjacent(vertex.getKey())) {
			int adjacent = adjEdge.getTargetEdge();
			if (distTo[adjacent] > (distTo[vertex.getKey()] + adjEdge.getWeight())) {
				distTo[adjacent] = distTo[vertex.getKey()] + adjEdge.getWeight();
				viaVert[adjacent] = adjEdge;
				minPriorityQue.add(new QueEntry(adjacent, distTo[adjacent]));
			}			
		}
	}
	
	public int distTo(int vertex) {
		return distTo[vertex];
	}
	
	public String pathTo() {
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		StringBuilder pathStringBuilder = new StringBuilder();
		for (DirectedEdge e = viaVert[end]; e  != null; e = viaVert[e.getSourceEdge()]) {
			path.push(e);
			pathStringBuilder.insert(0, cityNames[e.getSourceEdge()] +"-->"+ cityNames[e.getTargetEdge()] + "\n");
		}
		
		pathStringBuilder.append(distTo[end]);
		
		return pathStringBuilder.toString();
	}
	
	//public String toString() {
	//	StringBuilder s = new StringBuilder();
		//Stack<DirectedEdge> path = pathTo();
	//	s.append("The shortest path from " + this.start + " to " + this.end + " is: ");
	//	s.append(path.pop().getSourceEdge());
	//	while(!path.empty()) {
	//		s.append(" -> " + path.pop().getSourceEdge());
	//	}
	//	s.append(" -> " + this.end + " with a total cost of " + distTo[this.end] + ".");
	//	return s.toString();
    //}
	
	public static void main(String[] args) {
        GraphData G = new GraphData(17);
        DirectedEdge thing = new DirectedEdge(2, 5, 11);
        G.addEdge(thing);
        DirectedEdge thing1 = new DirectedEdge(2, 14, 7);
        G.addEdge(thing1);
        DirectedEdge thing2 = new DirectedEdge(2, 16, 15);
        G.addEdge(thing2);
        DirectedEdge thing3 = new DirectedEdge(5, 0, 1);
        G.addEdge(thing3);
        DirectedEdge thing4 = new DirectedEdge(5, 13, 10);
        G.addEdge(thing4);
        DirectedEdge thing5 = new DirectedEdge(5, 14, 12);
        G.addEdge(thing5);
        DirectedEdge thing6 = new DirectedEdge(13, 12, 3);
        G.addEdge(thing6);
        DirectedEdge thing7 = new DirectedEdge(12, 14, 8);
        G.addEdge(thing7);
        DirectedEdge thing8 = new DirectedEdge(12, 15, 7);
        G.addEdge(thing8);
        DirectedEdge thing9 = new DirectedEdge(15, 8, 6);
        G.addEdge(thing9);
        DirectedEdge thing10 = new DirectedEdge(15, 3, 7);
        G.addEdge(thing10);
        DirectedEdge thing11 = new DirectedEdge(8, 6, 2);
        G.addEdge(thing11);
        DirectedEdge thing12 = new DirectedEdge(8, 3, 3);
        G.addEdge(thing12);
        DirectedEdge thing13 = new DirectedEdge(3, 6, 4);
        G.addEdge(thing13);
        DirectedEdge thing14 = new DirectedEdge(3, 11, 6);
        G.addEdge(thing14);
        DirectedEdge thing15 = new DirectedEdge(9, 1, 9);
        G.addEdge(thing15);
        DirectedEdge thing16 = new DirectedEdge(11, 9, 7);
        G.addEdge(thing16);
        DirectedEdge thing17 = new DirectedEdge(9, 16, 10);
        G.addEdge(thing17);
        DirectedEdge thing18 = new DirectedEdge(16, 4, 7);
        G.addEdge(thing18);
        DirectedEdge thing19 = new DirectedEdge(4, 1, 4);
        G.addEdge(thing19);
        DirectedEdge thing20 = new DirectedEdge(1, 7, 3);
        G.addEdge(thing20);
        DirectedEdge thing21 = new DirectedEdge(4, 7, 8);
        G.addEdge(thing21);
        DirectedEdge thing22 = new DirectedEdge(7, 10, 10);
        G.addEdge(thing22);
        DirectedEdge thing23 = new DirectedEdge(4, 10, 14);
        G.addEdge(thing23);
        DirectedEdge thing24 = new DirectedEdge(10, 16, 8);
        G.addEdge(thing24);
        DirectedEdge thing25 = new DirectedEdge(10, 2, 16);
        G.addEdge(thing25);
        DirectedEdge thing26 = new DirectedEdge(14, 15, 12);
        G.addEdge(thing26);
        
        System.out.print(G);
        
        
        
        new GraphicInterface(G);
        
    }
}