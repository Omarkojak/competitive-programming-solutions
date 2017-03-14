package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CodeforcesA119 {
	
	public static int GCD(int a, int b) {
		   if (b==0) return a;
		   return GCD(b,a%b);
		}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int a=Integer.parseInt(ns.nextToken());
		int b=Integer.parseInt(ns.nextToken());
		int n=Integer.parseInt(ns.nextToken());
		int ans=1;
		int gcd=GCD(a,n);
		while(n> 0&&n>=gcd){
			n-=gcd;
			ans=1-ans;
			gcd=GCD(ans==1?a:b,n);
		}
		out.println(ans);
		out.close();
	}

}
