import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Uva539 {
	static ArrayList<Integer>[]g;
	static boolean vis[][];
	public static int dfs(int node){
		int max=0;
		for(int i=0;i<g[node].size();i++){
			int u=g[node].get(i);
			if(!vis[node][u]){
				vis[node][u]=vis[u][node]=true;
				max=Math.max(max, 1+dfs(u));
				vis[node][u]=vis[u][node]=false;
			}
		}
		return max;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		while(!s.equals("0 0")){
			StringTokenizer ns =new StringTokenizer(s);
			int n=Integer.parseInt(ns.nextToken());
			int m=Integer.parseInt(ns.nextToken());
			g=new ArrayList[n];
			for(int i=0;i<n;i++)
				g[i]=new ArrayList<Integer>();
			for(int i=0;i<m;i++){
				ns=new StringTokenizer(bf.readLine());
				int v1=Integer.parseInt(ns.nextToken());int v2=Integer.parseInt(ns.nextToken());
				g[v1].add(v2);g[v2].add(v1);
			}
				int max=0;
				for(int i=0;i<n;i++){
					vis=new boolean[30][30];
					max=Math.max(max,dfs(i));
				}
			out.println(max);
			s=bf.readLine();
		}
		out.close();
	}

}
