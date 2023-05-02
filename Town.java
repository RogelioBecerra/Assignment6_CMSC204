import java.util.ArrayList;

/**
 *  The town class (Vertex)
 * @author rogeliobecerra
 *
 */
public class Town implements Comparable<Town>{

	private String name;
	
	ArrayList<Road> roadList = new ArrayList<>();
	
	/**
	 * Constructor 
	 * @param name - name of town
	 */
	public Town(String name) {
		this.name = name;
	}
	
	
	/**
	 * copy Constructor
	 * @param templateTown - copy of town
	 */
	public Town(Town templateTown) {
		this.name = templateTown.getName();
		this.roadList = new ArrayList<>(templateTown.roadList);
	}
	
	/**
	 * adds a Road to the roadList in Town
	 * @param newRoad - road object
	 */
	public void addRoad(Road newRoad) {
		roadList.add(newRoad);
	}
	
	
	/**
	 * return name 
	 * @return name
	 */
	String getName() {
		return name;
	}

	/**
	 * compares town objects 
	 */
	@Override
	public int compareTo(Town o) {
		
		if(this.equals(o)) {
			return 0;
		}
		else
			return -1;
	}
	
	/**
	 * checks if names are the same 
	 * @param obj being compared to 
	 * @return true if names are the same, false if the names are NOT the same
	 */
	public boolean equals(Town obj) {
		
		if(this.name.equals(obj.getName()))
			return true;
		else
			return false;
	}
	
	/**
	 * toString method returns the name 
	 */
	public String toString() {
		return name;
	}
	
	
	/**
	 * the hashcode for the name of the town
	 */
	public int hashCode() {
		
		return name.hashCode();
	}
	
	
	
	
}
