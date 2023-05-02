import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Graph_STUDENT_Test {
	Graph g;
	
	Road r1;
	Road r2;
	
	Town t1;
	Town t2;
	Town t3;
	Town t4;
	Town t5;
	Town t6;
	
	@BeforeEach
	void setUp() throws Exception {
		g = new Graph();
		
		t1 = new Town("Sky");
		t2 = new Town("Hill");
		t3 = new Town("Water");
		t4 = new Town("Fire");
		t5 = new Town("Lemon");
		t6 = new Town("Apple");
		
		g.addVertex(t1);
		g.addVertex(t2);
		g.addVertex(t3);
		g.addVertex(t4);
		g.addVertex(t5);
		g.addVertex(t6);
		
		 r1 = new Road(t1, t2, 2, "Road1");
		 r2 = new Road(t3, t4, 2, "Road2");
		 
		 g.addEdge(t1, t2, 2, "Road1");
		 g.addEdge(t3, t4, 2, "Road2");
	}

	@AfterEach
	void tearDown() throws Exception {
		r1 = r2 = null;
		t1 = t2= t3= t4= t5= t6 =null;
		g = null;
	}


	@Test
	public void testAddEdge() {
		g.addEdge(t5, t6, 5, "Dark");
		assertEquals(true, g.containsEdge(t6, t5));
	}

	@Test
	public void testAddVertex() {
		Town newTown = new Town("mac");
		assertEquals(false, g.containsVertex(newTown));
		g.addVertex(newTown);
		assertEquals(true, g.containsVertex(newTown));
	}

	@Test
	public void testContainsEdge() {
		g.addEdge(t5, t6, 5, "Dark");
		assertEquals(true, g.containsEdge(t6, t5));
	}

	@Test
	public void testContainsVertex() {
		assertEquals(true, g.containsVertex(new Town("Sky")));
		assertEquals(true, g.containsVertex(new Town("Hill")));
	}

	@Test
	public void testEdgeSet() {
		Set<Road> roads = g.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		
		assertEquals("Road1", roadArrayList.get(0));
		
		
	}

	@Test
	public void testEdgesOf() {
		Set<Road> roads = g.edgesOf(t1);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		
		assertEquals("Road1", roadArrayList.get(0));
		
	}
	
	@Test
	public void testRemoveEdge() {
		assertEquals(true, g.containsEdge(t2, t1));
		g.removeEdge(t1, t2, 6, "Road_12");
		assertEquals(false, g.containsEdge(t1, t2));
	}
	
	@Test
	public void testRemoveVertex() {
		assertEquals(true, g.containsVertex(t1));
		g.removeVertex(t1);
		assertEquals(false, g.containsVertex(t1));
	}

	@Test
	public void testVertexSet() {
		Set<Town> roads = g.vertexSet();
		assertEquals(true,roads.contains(t2));
		
	}

}
