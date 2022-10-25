package shortestPathTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import AlgShortest.QueEntry;
import AlgShortest.ShortestPath;
import dataStructure.DirectedEdge;
import dataStructure.GraphData;

public class ShortestPathTests{
	
	@Test
	public void testDirectedEdge() {
		ArrayList<DirectedEdge> uut = new ArrayList<DirectedEdge>(4);
		uut.add(new DirectedEdge(1, 2, 15));
		uut.add(new DirectedEdge(1, 3, 10));
		uut.add(new DirectedEdge(2, 4, 7));
		uut.add(new DirectedEdge(2, 7, 20));
		
		int[] expectedSrcEdge = new int[] { 1, 1, 2, 2};
		for(int x = 0; x < expectedSrcEdge.length; x++) {
			assertEquals(expectedSrcEdge[x], uut.get(x).getSourceEdge());
		}
		
		int[] expectedTargetEdge = new int[] { 2, 3, 4, 7};
		for(int x = 0; x < expectedTargetEdge.length; x++) {
			assertEquals(expectedTargetEdge[x], uut.get(x).getTargetEdge());
		}
		
		int[] expectedWeight = new int[] { 15, 10, 7, 20};
		for(int x = 0; x < expectedWeight.length; x++) {
			assertEquals(expectedWeight[x], uut.get(x).getWeight());
		}
	}
	
	@Test
	public void testGraphData() {
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
	    
	    assertEquals(6, uut.getNumberOfVerticies());
	    assertEquals(8, uut.getNumberOfEdges());
	    
	    ArrayList<DirectedEdge> collectEdgesExpect = new ArrayList<DirectedEdge>();
	    collectEdgesExpect.add(new DirectedEdge(0, 1, 1));
	    collectEdgesExpect.add(new DirectedEdge(1, 0, 1));
	    collectEdgesExpect.add(new DirectedEdge(1, 3, 2));
	    collectEdgesExpect.add(new DirectedEdge(2, 3, 3));
	    collectEdgesExpect.add(new DirectedEdge(2, 5, 5));
	    collectEdgesExpect.add(new DirectedEdge(3, 1, 2));
	    collectEdgesExpect.add(new DirectedEdge(3, 2, 3));
	    collectEdgesExpect.add(new DirectedEdge(5, 2, 5));
	    assertEquals(collectEdgesExpect, uut.edges());
	}
	@Test
	public void testShortestPath() {
		GraphData Graph = new GraphData(5);
		DirectedEdge thing = new DirectedEdge(0, 1, 1);
	    Graph.addEdge(thing);
	    DirectedEdge thing1 = new DirectedEdge(0, 2, 2);
	    Graph.addEdge(thing1);
	    DirectedEdge thing2 = new DirectedEdge(2, 3, 2);
	    Graph.addEdge(thing2);
	    DirectedEdge thing3 = new DirectedEdge(1, 3, 2);
	    Graph.addEdge(thing3);
	    DirectedEdge thing4 = new DirectedEdge(3, 4, 1);
	    Graph.addEdge(thing4);
	    DirectedEdge thing5 = new DirectedEdge(2, 4, 4);
		
		ShortestPath uut = new ShortestPath(Graph, 0, 4);
		
		String pathToExpected = new String("New York-->Los Angeles\n" + "Los Angeles-->Houston\n" + "Houston-->Phoenix\n" + "4");
		
		assertEquals(uut.pathTo(), pathToExpected);
		
		assertEquals(uut.distTo(1), 1);
		assertEquals(uut.distTo(2), 2);
		assertEquals(uut.distTo(3), 3);
		assertEquals(uut.distTo(4), 4);
	}
	
	@Test
	public void testQueEntry() {
		QueEntry tester1 = new QueEntry(10, 5);
		QueEntry tester2 = new QueEntry(6, 2);
		QueEntry tester3 = new QueEntry(3, 7);
		QueEntry tester4 = new QueEntry(12, 4);
		QueEntry tester5 = new QueEntry(45, 24);
		
		ArrayList<QueEntry> testerArray= new ArrayList<QueEntry>();
		
		testerArray.add(tester1);
		testerArray.add(tester2);
		testerArray.add(tester3);
		testerArray.add(tester4);
		testerArray.add(tester5);
		
		Integer[] keyArray = new Integer[]{10, 6, 3, 12, 45};
		
		Integer[] valueArray = new Integer[] {5, 2, 7, 4, 24};
		
		for (int i = 0; i < 5; i++) {
			assertEquals(testerArray.get(i).getKey(), keyArray[i]);
			assertEquals(testerArray.get(i).getValue(), valueArray[i]);
		}
		
	}
	
	
	
}