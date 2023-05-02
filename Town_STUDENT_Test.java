import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Town_STUDENT_Test {

	Town t1;
	Town t2;
	Town t3;
	
	@BeforeEach
	void setUp() throws Exception {
		t1 = new Town("Hill");
		t2 = new Town("Cloud");
		t3 = new Town("Stone");
	}

	@AfterEach
	void tearDown() throws Exception {
		t1 = t2 = t3 =null;
	}


	@Test
	void testGetName() {
		assertEquals("Hill", t1.getName());
		assertEquals("Stone", t3.getName());
	}
	
	@Test
	void testCompareTo() {
		assertEquals(0, t2.compareTo(new Town("Cloud")));
		assertEquals(-1, t2.compareTo(t1));
		
	}
	
	@Test
	void testEquals() {
		assertEquals(true, t2.equals(new Town("Cloud")));
		assertEquals(false, t2.equals(t1));
	}
	
}
