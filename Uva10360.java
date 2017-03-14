import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Uva10360 {
	static int [][]maze;
	static int []dx={0,-1,0,1,1,-1,-1,1};
	static int []dy={1,0,-1,0,1,-1,1,-1};
	static int [][][]dp;
	static boolean [][][]vis;
	
	public static int killed(int r,int c,int d){
		if(d==0)
			return maze[r][c];
		if(vis[r][c][d])
			return dp[r][c][d];
		
		int sum=0;
		for(int i=0;i<8;i++){
			int r1=r+dx[i];
			int c1=c+dy[i];
			if(valid(r1,c1))
				sum+=killed(r1,c1,d-1);
		}
		vis[r][c][d]=true;
		return dp[r][c][d]=sum;
		
	}
	public static boolean valid(int r,int c){
		return r>=0&&r<1025&&c>=0&&c<1025;
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int T=Integer.parseInt(bf.readLine());
		while(T-->0){
			maze=new int[1025][1025];
			
			int d=Integer.parseInt(bf.readLine());
			int n=Integer.parseInt(bf.readLine());
			StringTokenizer ns = new StringTokenizer(bf.readLine());
			int r1=Integer.parseInt(ns.nextToken());
			int c1=Integer.parseInt(ns.nextToken());
			int p=Integer.parseInt(ns.nextToken());
			maze[r1][c1]=p;
			for(int i=1;i<n;i++){
				ns = new StringTokenizer(bf.readLine());
				r1=Integer.parseInt(ns.nextToken());
				c1=Integer.parseInt(ns.nextToken());
				p=Integer.parseInt(ns.nextToken());
				maze[r1][c1]=p;
				
			}
			dp=new int [1025][1025][52];
			vis=new boolean[1025][1025][52];
			int max=killed(0, 0,d);
			int x=0;
			int y=0;
			for(int i=0;i<1025;i++)
				for(int j=0;j<1025;j++){
					if(i==0&&j==0)
						continue;
					int v=killed(i, j,d);
					if(v>max){
						max=v;
						x=i;
						y=j;
					}else{
					if(v==max){
						if(i<x){
							x=i;
							y=j;
						}
						else
							if(j<y){
								x=i;
								y=j;
							}
					}	
					}
					
					
				}
				out.println(x+" "+y+" "+max);
		}
		
		
		out.close();
	}

}


