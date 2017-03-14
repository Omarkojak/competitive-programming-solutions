package cp4_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Uva10356_RoughRoads {
	
	static final int INF = (int)1e9;	//don't increase, avoid overflow
	static ArrayList<Edge>[] adjList;
	static int V;
	static int dijkstra(){
		int[][] dist = new int[V][2];
		for(int i=0;i<V;i++)
			for(int j=0;j<2;j++)
				dist[i][j]=INF;
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		dist[0][0] = 0;
		pq.add(new Edge(0, 0,true));
		while(!pq.isEmpty())
		{
			Edge cur = pq.remove();int r=1;
			if(cur.wa)
				r=0;
			if(cur.cost > dist[cur.node][r])
				continue;
			for(Edge nxt: adjList[cur.node])
				if(cur.cost + nxt.cost < dist[nxt.node][(r+1)%2])
				{
					dist[nxt.node][(r+1)%2] = cur.cost + nxt.cost;
					pq.add(new Edge(nxt.node, dist[nxt.node][(r+1)%2],!cur.wa));
				}
				
		}
		return dist[V-1][0];
	}
	
	static class Edge implements Comparable<Edge>
	{
		int node, cost;
		boolean wa;
		Edge(int a, int b,boolean walk)
		{
			node = a;
			cost = b;
			wa=walk;
		}
		
		public int compareTo(Edge e)
		{
			if(cost != e.cost)
				return cost - e.cost;
			return node - e.node;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		String s=bf.readLine();int k=1;
		while(s!=null&&s.length()!=0){
			StringTokenizer ns=new StringTokenizer(s);
			int n=Integer.parseInt(ns.nextToken());
			int m=Integer.parseInt(ns.nextToken());
			adjList=new ArrayList[n];
			for(int i=0;i<n;i++)
				adjList[i]=new ArrayList<Edge>();V=n;
			for(int i=0;i<m;i++){
				ns=new StringTokenizer(bf.readLine());
				int from=Integer.parseInt(ns.nextToken());
				int to=Integer.parseInt(ns.nextToken());
				int cost=Integer.parseInt(ns.nextToken());
				adjList[from].add(new Edge(to,cost,false));
				adjList[to].add(new Edge(from,cost,false));
			}
			System.out.printf("Set #%d\n",k++);
			int res=dijkstra();
			System.out.println(res==INF? "?":res);
			s=bf.readLine();
		}
	}
		
}
