package cms;

public class StudentOrientationGraph {

	private int vertices;
	private int [][]adjacencyMatrix;
	private String buildings[];
	
	public StudentOrientationGraph(String[] buildings) {
		this.vertices = buildings.length;
		this.buildings = buildings;
		adjacencyMatrix = new int[vertices][vertices];
	}
	
	//O(1)
	public void addEdge(int src, int dest, int weight) {
		
		if(src < 0 || dest < 0 || src >= vertices || dest >= vertices) {
			System.out.println("Error, Try Again!!");
			return;
		}
		
		adjacencyMatrix[src][dest] = weight;
		adjacencyMatrix[dest][src] = weight;
	} 
	
	//O(n^3)
	public void bellManFord(int src) {
		
		if(src < 0 ||  src >= vertices) {
			System.out.println("Error, Try Again!!");
			return;
		}
		
		int dist[] = new int[vertices];
		
		for(int i = 0; i < vertices; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0; 
		
		//relax edges v - 1  times
		
		for(int k = 0; k < vertices - 1; k++) {
			for(int u = 0; u < vertices; u++) {
				for(int v = 0; v < vertices; v++) {
					if(adjacencyMatrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE
							&& dist[u] + adjacencyMatrix[u][v] < dist[v]) {
						dist[v] = dist[u] + adjacencyMatrix[u][v];
					}
				}
			}
		}
		
		
	    System.out.println("Building Distance from Source (" + buildings[src] + "):");
	    for(int i = 0; i < vertices; i++) {
	        System.out.println(buildings[i] + "\t" + dist[i] + " meters.");
	    }

	}
}
