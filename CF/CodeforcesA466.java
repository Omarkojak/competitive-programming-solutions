package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesA466 {
	static int n,m,a,b;
	static int []dp;
	
	public static int count(int rides){
		if(rides<=0)
			return 0;
		
		if(dp[rides]!=0)
			return dp[rides];
		
		int a1=a+count(rides-1);
		int a2=b+count(rides-m);
		return dp[rides]=Math.min(a1, a2);
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		n=Integer.parseInt(ns.nextToken());
		m=Integer.parseInt(ns.nextToken());
		a=Integer.parseInt(ns.nextToken());
		b=Integer.parseInt(ns.nextToken());
		dp=new int [n+1];
		int p=count(n);
		out.print(p);
		out.close();
	}

}
