package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesA439 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(ns.nextToken());
		int d=Integer.parseInt(ns.nextToken());
		ns=new StringTokenizer(bf.readLine());
		int sum=0;
		for(int i=0;i<n;i++)
			sum+=Integer.parseInt(ns.nextToken());
		
		if(sum+((n-1)*10)>d)
			out.println(-1);
		else{
			int r=(n-1)*2;
			int rem=d-(sum+((n-1)*10));
			r+=rem/5;
			out.println(r);
		}
		out.close();
		
	}

}
