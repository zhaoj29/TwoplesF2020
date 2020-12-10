import java.util.*;

public class Graph{
	
	private boolean[] visited; //boolean of visited nodes 
	private HashMap<Integer, ArrayList<Integer>> vertices; //linkedlist of ints(?) -- the vertices 
	private ArrayList<Integer> adjVerts; //adjacent verticies
	
	private final int STARTING_CAP=5; //starting capacity for each arraylist (not sure if i need this)
	
	//need constructor to create a graph w/ number of vertices
	public Graph(int numVerts){
		visited=new boolean[numVerts];
		vertices=new HashMap<Integer, ArrayList<Integer>>();
		
	}
	
	//add edges to graph
	public void addEdge(int from, ArrayList<Integer> to){
		//adjVerts=new ArrayList<Integer>(STARTING_CAP);
		//adjVerts.add(to); //adjacent verticies
		vertices.put(from,to);
		//System.out.println(vertices);
	}
	
	//the actual algo 
	public void DFS(int startVert){
		Stack<Integer> next=new Stack<Integer>();
		
		adjVerts=vertices.get(startVert); //get the adjacent verts for starting vertex
		
		//start at some vertex
		next.push(startVert);
		while(next.size()!=0){ 
			//then put all adjacent vertices to starting vert into a list 
			int nextVert=next.pop();
			System.out.println("Next vertex: "+nextVert);
			visited[nextVert]=true;
			adjVerts=vertices.get(nextVert);
			if(adjVerts!=null){
				for(int i=0; i<adjVerts.size();i++){
					int v=adjVerts.get(i);
					if(!visited[v]){
						next.push(v); //@index nextVert
					}
					
				}
			}
		}
	//pick "top"/start of the stack as next node
		//then put all those adjacent vertices into stack 
		//go to one unvisited
		
	}
	
	public static void main(String[] args){
		Graph g=new Graph(4);
		ArrayList<Integer> set1=new ArrayList<Integer>();
		set1.add(1);
		set1.add(3);
		g.addEdge(0,set1);
		
		ArrayList<Integer> set2=new ArrayList<Integer>();
		set2.add(2);
		
		g.addEdge(1,set2);
		
		//g.DFS(0);
		
		ArrayList<Integer> set3=new ArrayList<Integer>();
		set3.add(0);
		g.addEdge(2,set3);
		g.DFS(0);
		
	}
	
	 
	
	
}