package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesB339 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(ns.nextToken());
		int m=Integer.parseInt(ns.nextToken());
		ns=new StringTokenizer(bf.readLine());
		long r=0;
		int i=1;
		while(m-->0){
			int d=Integer.parseInt(ns.nextToken());
			if(d>=i)
				r+=d-i;
			else
				r+=(n+-i)+d;
			i=d;
		}
		out.println(r);
		out.close();
	}

}	
