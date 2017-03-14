package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Uva11085 {
	static int []q;
	static int []p;
	public static boolean possible(int r,int c){
		for(int i=0;i<r;i++){
		
			if(p[i]==c)
				return false;
			if(Math.abs(p[i]-c)==Math.abs(r-i))
				return false;
			}	
		return true;
	}
	public static int solve(int i){
		if(i==8)
			return 0;
		int tot=100000;
		for(int j=0;j<8;j++)
			if(possible(i, j)){
				p[i]=j;
				tot=Math.min(tot, j==q[i]?solve(i+1):1+solve(i+1));
			}
		
		return tot;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine(); int r=1;
		while(s!=null&&s.length()!=0){
			StringTokenizer ns =new StringTokenizer(s);
			q=new int [8];
			p=new int [8];
			for(int i=0;i<8;i++){
				q[i]=Integer.parseInt(ns.nextToken())-1;
				p[i]=q[i];
			}
			out.printf("Case %d: %d\n",r++,solve(0));
			s=bf.readLine();
		}
		out.close();
	}

}
