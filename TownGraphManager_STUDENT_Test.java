import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TownGraphManager_STUDENT_Test {

	TownGraphManager g;
	
	@BeforeEach
	void setUp() throws Exception {
		g = new TownGraphManager();
		
		g.addTown("Sky");
		g.addTown("Hill");
		
		g.addTown("Water");
		g.addTown("Fire");
		
		g.addRoad("Sky", "Hill", 2,"Road1");
		g.addRoad("Water", "Fire", 2 ,"Road2");
		 
		//Extra
		g.addTown("Lemon");
		g.addTown("Apple");
		 
	}

	@AfterEach
	void tearDown() throws Exception {
		g = null;
	}

	
	@Test
	public void testAllRoads() {
		ArrayList<String> roads = g.allRoads();
		
		assertEquals("Road1", roads.get(0));
		assertEquals("Road2", roads.get(1));
		
	}
	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = g.allTowns();
		assertEquals("Apple", roads.get(0));
		assertEquals("Fire", roads.get(1));
		
	}
	
	@Test
	public void testAddRoad() {
		ArrayList<String> roads = g.allRoads();
		assertEquals("Road1", roads.get(0));
		
		g.addRoad("Lemon", "Apple", 1,"Fruit rd");
		roads = g.allRoads();
		
		assertEquals("Fruit rd", roads.get(0));
		assertEquals("Road1", roads.get(1));
		assertEquals("Road2", roads.get(2));
	}
	
	@Test
	public void testAddTown() {
		assertEquals(false, g.containsTown("Town_12"));
		g.addTown("Town_12");
		assertEquals(true, g.containsTown("Town_12"));
	}
	
	@Test
	public void testContainsTown() {
		assertEquals(false, g.containsTown("Town 1000"));
		assertEquals(true, g.containsTown("Hill"));
	}
	
	@Test
	public void testGetRoad() {
		assertEquals("Road1", g.getRoad("Sky", "Hill"));
		
	}
	
	@Test
	public void testDeleteTown() {
		assertEquals(true, g.containsTown("Apple"));
		g.deleteTown("Apple");
		assertEquals(false, g.containsTown("Apple"));
	}

}
