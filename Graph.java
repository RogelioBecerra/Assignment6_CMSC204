import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * The Graph class
 * @author rogeliobecerra
 *
 */
public class Graph implements GraphInterface<Town,Road> {

	ArrayList<LinkedList<Town>> list;
	
	public Graph() {
		list = new ArrayList<>();
	}
	
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) { 
		
		for(LinkedList<Town> l: list) 
		{
			if(l.get(0).equals(sourceVertex)) //linked list source
			{ 
				for(Road r: l.get(0).roadList) 
				{
					if(r.getDestination().equals(destinationVertex)) 
					{
						return r;
					}
				}
			}
			
			if(l.get(0).equals(destinationVertex)) //linked list source
			{ 
				for(Road r: l.get(0).roadList) 
				{
					if(r.getDestination().equals(sourceVertex)) 
					{
						return r;
					}
				}
			}
		}
		
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		
		Road currRoad = new Road(sourceVertex, destinationVertex, weight, description);
		
		//looks for the sourceVertex, if found adds it and returns Road obj
		for(LinkedList<Town> l: list) {
			if(l.get(0).equals(sourceVertex)) {
				l.add(destinationVertex);
				l.get(0).addRoad(currRoad);//adds road to roadlist of the town
				
				return currRoad;
			}
		}
		
		throw new IllegalArgumentException();
	}

	@Override
	public boolean addVertex(Town v) {
		
		LinkedList<Town> currList = new LinkedList<>();
		currList.add(v);
		
		// adds to graph
		if(list.size() == 0) { 
			list.add(currList);
			return true;
		}
		else{
			//checks if Town already exist
			for(LinkedList<Town> l: list) {
				if(l.get(0).equals(v))
					return false;
			}
			// if not found, add
			list.add(currList);
			return true;
		}

	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		
		for(LinkedList<Town> l: list) 
		{
			if(l.get(0).equals(sourceVertex)) 
			{ 
				for(Road r: l.get(0).roadList) 
				{
					if(r.getDestination().equals(destinationVertex)) 
					{
						return true;
					}
				}
			}
			
			if(l.get(0).equals(destinationVertex)) 
			{ 
				for(Road r: l.get(0).roadList) 
				{
					if(r.getDestination().equals(sourceVertex)) 
					{
						return true;
					}
				}
			}
		}
		
		return false;
		
	}
	

	@Override
	public boolean containsVertex(Town v) {
		
		for(LinkedList<Town> l: list) {
			if(l.getFirst().equals(v))
			{
				return true;
			}
		}
		return false;
	}

	
	@Override
	public Set<Road> edgeSet() {
		
		Set<Road> set = new HashSet<>();
		
		for(LinkedList<Town> l: list) {
			
			for(Road r: l.getFirst().roadList) {
				set.add(r);
			}
			
		}
		
		return set;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
	Set<Road> set = new HashSet<>();
			
			for(LinkedList<Town> l: list) {
				
				for(Road r: l.getFirst().roadList) {
					if(r.getDestination().equals(vertex) || r.getSource().equals(vertex))
						set.add(r);
				}
				
			}
			
			return set;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		
		Road tempRoad;
		
		for(LinkedList<Town> l: list) 
		{
			if(l.get(0).equals(sourceVertex)) 
			{ 
				for(int i = 0; i < l.get(0).roadList.size();i++) 
				{
					if(l.getFirst().roadList.get(i).getDestination().equals(destinationVertex)) 
					{
						ArrayList<Road> tempList = l.getFirst().roadList;
						tempRoad = new Road(tempList.get(i));
						tempList.remove(i);
						return tempRoad;
					}
				}
			}
			
			if(l.get(0).equals(destinationVertex)) 
			{ 
				for(int j = 0; j < l.get(0).roadList.size();j++) 
				{
					if(l.getFirst().roadList.get(j).getDestination().equals(sourceVertex)) 
					{
						ArrayList<Road> tempList = l.getFirst().roadList;
						tempRoad = new Road(tempList.get(j));
						tempList.remove(j);
						return tempRoad;
					}
				}
			}
		}
		
		return null;
	}

	@Override
	public boolean removeVertex(Town v) {
		
		for(int i =0; i < list.size();i++)
		{
			if(list.get(i).get(0).equals(v)) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public Set<Town> vertexSet() {
		
		Set<Town> s = new HashSet<>();
		
		for(LinkedList<Town> l: list)
		{
			s.add(l.get(0));
		}
		return s;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		// TODO Auto-generated method stub
		
	}
	
	

}
