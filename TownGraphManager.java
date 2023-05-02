import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * The TownGraphManager class
 * @author rogeliobecerra
 *
 */
public class TownGraphManager implements TownGraphManagerInterface{

	Graph g = new Graph();
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		
		Town t1 = null ;
		boolean flag1 = false;
		Town t2 = null ;
		boolean flag2 = false;
		
		for(LinkedList<Town> l: g.list) {
			if(l.getFirst().getName().equals(town1)) {
				t1 = l.getFirst();
				flag1 = true;
			}
			
			if(l.getFirst().getName().equals(town2)) {
				t2 = l.getFirst();
				flag2 = true;
			}
		}
		
		if(flag1 && flag2)
		{
			g.addEdge(t1, t2, weight, roadName);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String getRoad(String town1, String town2) {
		
		String rd = null;
		
		for(LinkedList<Town> l: g.list) {
			if(l.getFirst().getName().equals(town1)) // find town1
			{
				for(Road rds: l.getFirst().roadList) // goes through roadlist
				{
					if(rds.getDestination().getName().equals(town2)) {
						rd = rds.getName();
					}	
				}
				
			}
			
			if(l.getFirst().getName().equals(town2)) { //finds town2
				for(Road rds: l.getFirst().roadList) // goes through roadlist
				{
					if(rds.getDestination().getName().equals(town1)) {
						rd = rds.getName();
					}	
				}
			}
		}
		
		return rd;
	}

	@Override
	public boolean addTown(String v) {
		
		return g.addVertex(new Town(v));
	}

	@Override
	public Town getTown(String name) {
		for(LinkedList<Town> l: g.list) {
			if(l.getFirst().getName().equals(name))
			{
				return l.getFirst();
			}
		}
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		for(LinkedList<Town> l : g.list) {
			if(l.getFirst().getName().equals(v))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		
		for(LinkedList<Town> l: g.list) {
			if(l.getFirst().getName().equals(town1))
			{
				for(Road rd: l.getFirst().roadList) {
					if(rd.getName().equals(town2)) {
						return true;
					}
				}
			}
			
			if(l.getFirst().getName().equals(town2))
			{
				for(Road rd: l.getFirst().roadList) {
					if(rd.getName().equals(town1)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	@Override
	public ArrayList<String> allRoads() {
		
		ArrayList<String> temp = new ArrayList<>();
		
		for(LinkedList<Town> l: g.list)
		{
			for(Road rd:l.getFirst().roadList)
			{
				temp.add(rd.getName());
			}
		}
		
		Collections.sort(temp);
		
		return temp;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		
		Town t1 = null;
		Town t2 = null;
		
		boolean flag = true;
		
		for(LinkedList<Town> l: g.list)
		{
			if(l.getFirst().getName().equals(town1))
			{
				t1 = l.getFirst();
			}
			
			if(l.getFirst().getName().equals(town2))
			{
				t2 = l.getFirst();
			}
		}
	
		Road r = g.removeEdge(t1, t2, 0, road);
		
		if(r == null)
			flag = false;
		return flag;
		
	}

	@Override
	public boolean deleteTown(String v) {
		
		for(LinkedList<Town> l: g.list)
		{
			if(l.getFirst().getName().equals(v))
			{
				return g.removeVertex(l.getFirst());
			}
		}
		return false;
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> temp = new ArrayList<>();
		
		for(LinkedList<Town> l: g.list)
		{
			temp.add(l.getFirst().getName());
			
		}
		
		Collections.sort(temp);
		
		return temp;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		return null;
	}


	

	
}
