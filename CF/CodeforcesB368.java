package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class CodeforcesB368 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(ns.nextToken());
		int m=Integer.parseInt(ns.nextToken());
		int []a=new int [n];
		int []c=new int [n];
		ns=new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(ns.nextToken());
		TreeSet<Integer> ts=new TreeSet<Integer>();
		ts.add(a[n-1]);
		int count=1;
		c[n-1]=1;
		for(int i=n-2;i>=0;i--){
			if(!ts.contains(a[i])){
			ts.add(a[i]);
			count++;
			}
			c[i]=count;
		}
		while(m-->0)
		out.println(c[Integer.parseInt(bf.readLine())-1]);
		//out.println(Arrays.toString(c));
		out.close();
	
	}

}
