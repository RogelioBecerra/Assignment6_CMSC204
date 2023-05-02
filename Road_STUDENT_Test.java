import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Road_STUDENT_Test {

	Graph g;
	
	Road r1;
	Road r2;
	
	
	Town t1;
	Town t2;
	Town t3;
	Town t4;
	
	@BeforeEach
	void setUp() throws Exception {
		g = new Graph();
		
		t1 = new Town("Sky");
		t2 = new Town("Hill");
		t3 = new Town("Water");
		t4 = new Town("Fire");
		
		g.addVertex(t1);
		g.addVertex(t2);
		g.addVertex(t3);
		g.addVertex(t4);
		
		 r1 = new Road(t1, t2, 2, "Road1");
		 r2 = new Road(t3, t4, 2, "Road2");
	}

	@AfterEach
	void tearDown() throws Exception {
		r1 = r2 = null;
		t1 = t2= t3= t4= null;
		g = null;
	}

	
	@Test
	void testCompareTo() {
		assertEquals(0, r1.compareTo(new Road(t1, t2, 2, "Road1")));
		assertEquals(-1, r1.compareTo(new Road(t1, t3, 2, "Road1")));
	}
	
	@Test
	void testContains() {
		assertEquals(true,r1.contains(t2));
		assertEquals(false,r1.contains(t4));
	}
	
	@Test
	void testGetDestination() {
		assertEquals(t4, r2.getDestination());
	}
	
	@Test
	void testGetSource() {
		assertEquals(t3, r2.getSource());
	}
	
	@Test
	void testGetName() {
		assertEquals("Road1", r1.getName());
		assertEquals("Road2", r2.getName());
	}
	
	@Test
	void testGetWeight() {
		assertEquals(2, r2.getWeight());
	}
	
	

}
