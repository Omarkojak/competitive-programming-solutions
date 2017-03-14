package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Uva10113_ExchangeRates {
	static Pair[][]adjMatrix;
	static boolean []vis;
	static int N;
	
	public static Pair dfs(int s,int t){
		vis[s]=true;
		for(int i=0;i<N;i++){
			if(adjMatrix[s][i]!=null&&!vis[i]){
				if(i==t)
					return adjMatrix[s][i];
				Pair traverse=dfs(i,t);
				if(traverse==null)
					continue;
				Pair curr=adjMatrix[s][i];
				int middle=LCM(curr.c2,traverse.c1);
				int first=curr.c1*(middle/curr.c2);
				int second=traverse.c2*(middle/traverse.c1);
				int gcd=GCD(first,second);
				return new Pair(first/gcd,second/gcd);
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s=bf.readLine();
		TreeMap<String ,Integer> mp=new TreeMap<String, Integer>();
		N=0;
		adjMatrix=new Pair [70][70];
		while(!s.equals(".")){
			StringTokenizer ns=new StringTokenizer(s);
			String q=ns.nextToken();
			if(q.equals("!")){
				int c1=Integer.parseInt(ns.nextToken());
				String k1=ns.nextToken();
				ns.nextToken();
				int c2=Integer.parseInt(ns.nextToken());
				String k2=ns.nextToken();
				if(!mp.containsKey(k1))
					mp.put(k1, N++);
				if(!mp.containsKey(k2))
					mp.put(k2, N++);
				int u=mp.get(k1);
				int v=mp.get(k2);
				int div=GCD(c1,c2);
				adjMatrix[u][v]=new Pair(c1/div,c2/div);
				adjMatrix[v][u]=new Pair(c2/div,c1/div);
			}else{
				vis=new boolean [N];
				String k1=ns.nextToken();
				ns.nextToken();
				String k2=ns.nextToken();
				if(!mp.containsKey(k1)||!mp.containsKey(k2))
					System.out.printf("? %s = ? %s\n",k1,k2);
				else{
					Pair res=dfs(mp.get(k1),mp.get(k2));
					if(res==null)
						System.out.printf("? %s = ? %s\n",k1,k2);
					else
					System.out.printf("%d %s = %d %s\n",res.c1,k1,res.c2,k2);
				}
				
			}
			s=bf.readLine();
		}
	}
	static class Pair{
		int c1;int c2;
		Pair(int a,int b){
			c1=a;c2=b;
		}
	}
	public static int GCD(int a, int b) {
		   if (b==0) return a;
		   return GCD(b,a%b);
		}
	
	public static int LCM(int a, int b) {
		return a*(b/GCD(a,b));
	}
}
