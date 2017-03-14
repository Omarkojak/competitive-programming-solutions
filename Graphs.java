import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Graphs{
	
public static void main(String [] args){
		
		
		
	}
	
	
}

class Graph {
	ArrayList<Integer> []g;
	boolean []visited;
	int []dist;
	ArrayList<Pair> []gw;
	
	Graph(int n){
		 g=new ArrayList[n];
		 gw=new ArrayList[n];
		 
		 for(int i=0;i<n;i++){
			g[i] =new ArrayList<Integer>();
			gw[i]=new ArrayList<Pair>();
		 }
		 
		 visited= new boolean[n];
		 dist=new int[n];
	}
	
	void dfs(int v) {
        visited[v] = true;

        for (int i = 0; i < g[v].size(); i++) {
            int r = g[v].get(i);
            if (!visited[r])
              dfs(r);
        }
    }
	
	void bfs(int v){
		Queue <Integer>q=new LinkedList<Integer>();
		q.add(v);
		visited[v]=true;
		while(!q.isEmpty()){
			int u=q.poll();
			for(int i=0;i<g[u].size();i++){
				int w=g[u].get(i);
				if(!visited[w])
					q.add(w);
			}
	}
}
	
	void dijkstra(int v){
		PriorityQueue <Pair> q=new PriorityQueue<Pair>(); 	
		dist[v]=0;
		q.add(new Pair(v,0));
		while(!q.isEmpty()){
			int u=q.peek().v;
			int w=q.peek().w;
			for(int i=0;i<gw[u].size();i++){
				int u1=gw[u].get(i).v;
				int w1=gw[u].get(i).w;
				if(w+w1<dist[u1]){
				dist[u1]=w+w1;
				q.add(new Pair(u1,dist[u1]));
				}
					
			}
			
		}
	
	}

	
	
}
	
class Pair implements Comparable<Pair>{
	int v;
	int w;
	Pair(int v,int w){
		this.v=v;
		this.w=w;
	}
	
	@Override
	public int compareTo(Pair o) {
		return w < o.w ? -1 : w > o.w ? 1 : 0;
	}
	
}

	
	
	
	
	

