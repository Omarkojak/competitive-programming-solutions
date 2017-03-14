package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesA588 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		int []a=new int [n];
		int []p=new int [n];
		for(int i=0;i<n;i++){
			StringTokenizer ns =new StringTokenizer(bf.readLine());
			a[i]=Integer.parseInt(ns.nextToken());
			p[i]=Integer.parseInt(ns.nextToken());
		}
		int r=0;
		int min=p[0];
		for(int i=0;i<n;i++){
			min=Math.min(p[i], min);
			r+=min*a[i];
		}
		out.println(r);
		out.close();
	}

}
