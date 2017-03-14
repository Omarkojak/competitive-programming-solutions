package CF;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class CF_B520_TwoButtons {
	static int n,m;
	static final int INF = (int)1e9;	//don't increase, avoid overflow
	static ArrayList<Edge>[] adjList;
	
	static int dijkstra(){
		int[] dist = new int[m*2];
		Arrays.fill(dist, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		dist[n] = 0;
		pq.add(new Edge(n, 0));
		while(!pq.isEmpty())
		{
			Edge cur = pq.remove();
			if(cur.node == m)		//remove if all nodes are sinks
				return dist[m];
			if(cur.cost > dist[cur.node])
				continue;
			for(Edge nxt: adjList[cur.node]){
				if(nxt.node>=m*2)
					continue;
				if(cur.cost + nxt.cost < dist[nxt.node])
				{
					dist[nxt.node] = cur.cost + nxt.cost;
					pq.add(new Edge(nxt.node, dist[nxt.node]));
				}
			}
				
		}
		return -1;
	}
	
	static class Edge implements Comparable<Edge>
	{
		int node, cost;
		
		Edge(int a, int b)
		{
			node = a;
			cost = b;
		}
		
		public int compareTo(Edge e)
		{
			if(cost != e.cost)
				return cost - e.cost;
			return node - e.node;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		adjList=new ArrayList[m*2];boolean flag=true;
		for(int i=0;i<m*2;i++)
			adjList[i]=new ArrayList<Edge>();
		for(int i=1;i<m*2;i++){
			if(i!=1)
			adjList[i].add(new Edge(i-1,1));
			adjList[i].add(new Edge(i*2,1));
			}
		if(n>=m)
			System.out.println(n-m);	
		else
		System.out.println(dijkstra());
		
		}
	}


