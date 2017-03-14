package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesA476 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(ns.nextToken());
		int m=Integer.parseInt(ns.nextToken());
		int i=n/2+ ((n%2!=0)? 1:0);
		for(;i<=n;i++){
			if(i%m==0)
				break;
		}
		out.println((i%m==0&&i<=n)? i:"-1");
		out.close();
	}

}
