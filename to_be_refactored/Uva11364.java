package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Uva11364 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			int n=Integer.parseInt(bf.readLine())-1;
			StringTokenizer ns=new StringTokenizer(bf.readLine());
			int x=Integer.parseInt(ns.nextToken());
			int min=x;
			int max=x;
			while(n-->0){
				x=Integer.parseInt(ns.nextToken());
				min=Math.min(x, min);
				max=Math.max(max, x);
			}
			out.println((max-min)*2);
		}
		out.close();
	}

}
