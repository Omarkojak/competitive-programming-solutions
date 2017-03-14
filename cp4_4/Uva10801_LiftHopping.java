package cp4_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Uva10801_LiftHopping {
	static ArrayList<Edge> adjList[];
	static final int inf=(int) 1e9;
	
	static int dijkstra(int t){
		PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
		pq.add(new Edge(520,0));
		int []dist=new int [600];
		Arrays.fill(dist, inf);
		while(!pq.isEmpty()){
			Edge curr=pq.poll();
			
			//if(curr.c>=dist[curr.u])
				//continue;
			
			for(Edge e:adjList[curr.u]){
				if(curr.c+e.c<dist[e.u]){
					dist[e.u]=curr.c+e.c;
					pq.add(new Edge(e.u,dist[e.u]));
				}
			}
		}
		int min=inf;
		while(t<600){
			min=Math.min(min, dist[t]);
			t+=100;
		}
		//System.out.println(Arrays.toString(dist));
		return min;
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s=bf.readLine();
		while(s!=null&&s.length()!=0){
			StringTokenizer ns=new StringTokenizer(s);
			int n=Integer.parseInt(ns.nextToken());
			int t=Integer.parseInt(ns.nextToken());
			int []cost=new int [n];
			ns=new StringTokenizer(bf.readLine());	
			for(int i=0;i<n;i++)
				cost[i]=Integer.parseInt(ns.nextToken());
			
			adjList=new ArrayList[600];
			for(int i=0;i<600;i++)
				adjList[i]=new ArrayList<Edge>();
			boolean []input=new boolean [600];
			Queue<Integer> check=new LinkedList<Integer>();
			int start=0;
			for(int i=0;i<n;i++){
				ns=new StringTokenizer(bf.readLine());
				int []a=new int [ns.countTokens()];
				int j=0;
				while(ns.hasMoreTokens())
					a[j++]=Integer.parseInt(ns.nextToken());
				
				
				Arrays.sort(a);
				if(a[0]!=0){
				check.add(a[0]+start);
				}
				input[a[0]+start]=true;
				for(j=1;j<a.length;j++){
					int prev=a[j-1]+start;int now=a[j]+start;
					int c=Math.abs(now-prev)*cost[i];
					adjList[prev].add(new Edge(now,c));
					adjList[now].add(new Edge(prev,c));
					input[now]=true;
					check.add(now);
				}
				start+=100;
			}
			while(!check.isEmpty()){
				int origin=check.poll();
				int st=origin+100;
				while(st<500){
					if(input[st]){
						int c=60;
						if(origin%100==0)
							c=0;
						adjList[origin].add(new Edge(st,c));
						adjList[st].add(new Edge(origin,c));
					}
					st+=100;
				}
			}
			adjList[520].add(new Edge(0,0));adjList[520].add(new Edge(100,0));adjList[520].add(new Edge(200,0));adjList[520].add(new Edge(300,0));adjList[520].add(new Edge(400,0));
			int query=dijkstra(t);
			System.out.println(query==inf? "IMPOSSIBLE":query);
			//System.out.println(adjList[0].toString());
			s=bf.readLine();
		}
	}

	static class Edge implements Comparable<Edge>{
		int u,c;
		Edge(int a,int b){
			u=a;c=b;
		}
		@Override
		public int compareTo(Edge o) {
			if(c!=o.c)
				return c-o.c;
			return u-o.u;
		}
	}

}
