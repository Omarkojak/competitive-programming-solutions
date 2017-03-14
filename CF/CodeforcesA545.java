package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesA545 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		int[]c=new int [n+1];
		int [][]maze=new int [n][n];
		for(int i=0;i<n;i++){
			StringTokenizer ns =new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++)
				maze[i][j]=Integer.parseInt(ns.nextToken());
		}
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++){
				if(maze[i][j]==-1||maze[i][j]==0)
					continue;
				int x=maze[i][j];
				if(x==3){
					c[i+1]=-1;
					c[j+1]=-1;
				}else
					if(x==2)
						c[j+1]=-1;
					else
						c[i+1]=-1;
			}
		
		int cnt=0;
		String s="";
		int i=1;
		for(;i<n+1;i++)
			if(c[i]!=-1){
				cnt++;
				s+=i;
				break;
			}
		for(++i;i<n+1;i++)	
			if(c[i]!=-1){
				cnt++;
				s+=" "+i;
			}
		out.println(cnt);
		if(cnt!=0)
		out.println(s);
		out.close();
		
	}

}
