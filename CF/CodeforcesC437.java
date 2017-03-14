package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesC437 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(ns.nextToken());
		int m=Integer.parseInt(ns.nextToken());
		int []a=new int [n];
		ns=new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(ns.nextToken());
		
		long sum=0;
		for(int i=0;i<m;i++){
			ns=new StringTokenizer(bf.readLine());
			int n1=Integer.parseInt(ns.nextToken())-1;
			int n2=Integer.parseInt(ns.nextToken())-1;
			sum+=Math.min(a[n1], a[n2]);
			
		}
		out.println(sum);
		out.close();
		
		
	}

}
