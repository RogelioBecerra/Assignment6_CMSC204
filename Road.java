/**
 *  the road class(Edge)
 * @author rogeliobecerra
 *
 */
public class Road implements Comparable<Road>{

	private Town pointA;
	private Town pointB;
	private int distance;
	private String roadName;
	
	/**
	 * Constructor
	 * @param source - start town
	 * @param destination - other town
	 * @param dis - distance
	 * @param name - name of road
	 */
	public Road(Town source, Town destination, int dis, String name) {
		this.pointA = source;
		this.pointB = destination;
		this.distance = dis;
		this.roadName = name;
	}
	
	/**
	 * Constructor with weight set to 1
	 * @param source- start town
	 * @param destination - other town
	 * @param name - name of road
	 */
	public Road(Town source, Town destination, String name) {
		this.pointA = source;
		this.pointB = destination;
		this.distance = 1;
		this.roadName = name;
	}
	
	
	/**
	 * Copy Constructor
	 * @param r - the Road obj to be copy
	 */
	public Road(Road r) {
		this.pointA = r.pointA;
		this.pointB = r.pointB;
		this.distance = r.distance;
		this.roadName = r.roadName;
	}
	
	/**
	 * 
	 * @return Returns true if each of the ends of the road r is the same as the ends of this road.
	 *  @param o road object
	 */
	public boolean equals(Road o) {
		String sName1 = pointA.getName();
		String dName1 = pointB.getName();
		
		String sName2 = o.pointA.getName();
		String dName2 = o.pointB.getName();
		
		if(sName1.equals(sName2) && dName1.equals(dName2) || sName1.equals(dName2) && dName1.equals(sName2) )
			return true;
		else 
			return false;
		
	}
	
	@Override
	public int compareTo(Road o) {
		if(this.equals(o))
			return 0;
		else 
			return -1;
		
	}
	
	/**
	 * Looks if a town exist connected to this town 
	 * @param town - town to check for 
	 * @return - Returns true only if the edge contains the given town
	 */
	public boolean contains(Town town) {
			
		if(pointA.equals(town) || pointB.equals(town))
			return true;
		else 
			return false;
	}
	
	/**
	 * other town
	 * @return Returns the second town on the road
	 */
	public Town getDestination() {
		return pointB;
	}
	
	/**
	 * name of road
	 * @return Returns the road name
	 */
	public String getName() {
		return roadName;
	}
	
	/**
	 * first town
	 * @return Returns the first town on the road
	 */
	public Town getSource() {
		return pointA;
	}
	
	/**
	 * Weight
	 * @return Returns the distance of the road
	 */
	public int getWeight() {
		return distance;
	}
	
	/**
	 * To string method.
	 */
	public String toString() {      
		return getName();
		
	}
	
	
}
