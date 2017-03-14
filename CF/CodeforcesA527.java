package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesA527 {
	
	static long ev(long a,long b){
		if(a==b)
			return 1;
		long v=a/b;
		if(a%b==0)
			v--;
		a-=v*b;
		return v+ev(Math.max(a, b),Math.min(a, b));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		long a=Long.parseLong(ns.nextToken());
		long b =Long.parseLong(ns.nextToken());
		out.println(ev(a,b));
		out.close();
	}

}
