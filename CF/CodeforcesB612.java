package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesB612 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		int []c=new int [n+1];
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		for(int i=1;i<=n;i++)
			c[Integer.parseInt(ns.nextToken())]=i;
		long r=0;
		for(int i=1;i<n;i++)
			r+=Math.abs(c[i+1]-c[i]);
		//out.println(Arrays.to);
		out.println(r);
		out.close();
	}

}