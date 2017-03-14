package cp4_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Uva11367_FullTank {
	static ArrayList<Edge>[]adjList;
	static int[][]cost;
	static int []fuel;
	static int n;
	static final int inf=(int)1e9;
	
	//triple node fuel cost
	public static int dijkstra(int u,int v,int fu){
		cost=new int [n][fu+5];
		for(int i=0;i<n;i++)
			Arrays.fill(cost[i], inf);
		cost[u][0]=0;
		PriorityQueue<Triple>pq=new PriorityQueue<Triple>();
		pq.add(new Triple(u,0,0));
		while(!pq.isEmpty()){
			Triple curr=pq.poll();
			if(curr.c>cost[curr.u][curr.f])
				continue;
				
			for(Edge nxt:adjList[curr.u]) 
				if(nxt.cost<=curr.f&&curr.c<cost[nxt.u][curr.f-nxt.cost]){
					cost[nxt.u][curr.f-nxt.cost]=curr.c;
					pq.add(new Triple(nxt.u,curr.f-nxt.cost,cost[nxt.u][curr.f-nxt.cost]));
				}
			
				if(curr.f < fu && curr.c + fuel[curr.u] < cost[curr.u][curr.f + 1]){
					cost[curr.u][curr.f + 1] = curr.c + fuel[curr.u];
					pq.add(new Triple(curr.u, curr.f + 1, curr.c + fuel[curr.u])); 
				}
			
			}
		
		return cost[v][0];
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String s=bf.readLine();
		StringTokenizer ns=new StringTokenizer(s);
		n=Integer.parseInt(ns.nextToken());
		int m=Integer.parseInt(ns.nextToken());
		fuel=new int[n];
		ns=new  StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++)
			fuel[i]=Integer.parseInt(ns.nextToken());
		
		adjList=new ArrayList[n];
		for(int i=0;i<n;i++)
			adjList[i]=new ArrayList<Edge>();
		while(m-->0){
			ns=new StringTokenizer(bf.readLine());
			int u1=Integer.parseInt(ns.nextToken());
			int u2=Integer.parseInt(ns.nextToken());
			int cost=Integer.parseInt(ns.nextToken());
			adjList[u1].add(new Edge(u2,cost));
			adjList[u2].add(new Edge(u1,cost));
		}
		int q=Integer.parseInt(bf.readLine());
		while(q-->0){
			ns=new StringTokenizer(bf.readLine());
			int fu=Integer.parseInt(ns.nextToken());
			int u1=Integer.parseInt(ns.nextToken());
			int u2=Integer.parseInt(ns.nextToken());
			int res=dijkstra(u1,u2,fu);
			sb.append((res==inf)?"impossible\n":res+"\n");
		}
	
	System.out.print(sb);
		
		
	}
	
	static class Triple implements Comparable<Triple>{
		int u, f ,c;

		Triple(int x, int y, int z) { u = x; f = y; c = z; }
		
		public int compareTo(Triple o) { return c - o.c; }
		
	}
	
	static class Edge
	{
		int u, cost;
		
		Edge(int x, int y){ u = x; cost  = y; }
	}

}
