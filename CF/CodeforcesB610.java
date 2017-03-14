package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CodeforcesB610 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		int []a=new int [n];
		int b[]=new int[n];
		long max=0;
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		long min =0;
		for(int i=0;i<n;i++){
			a[i]=Integer.parseInt(ns.nextToken());
			if(i==0) {min=a[i]; max=a[i];}
			min=Math.min(min, a[i]);
			max=Math.max(a[i], max);
		}
		int c=0;
		long r=0;
		int k=0;
		for(int i=0;i<n;i++)
			if(a[i]>min)
				k++;
			else
				break;
		for(int i=0;i<n;i++){
			if(a[i]>min)
				c++;
			else
				c=0;
		if(i==n-1)
			c+=k;
		r=Math.max(r, c);
		}
		long result=n*min+r;
		out.println(result);
		
		
		out.close();
		
		
		
		
	}

}
