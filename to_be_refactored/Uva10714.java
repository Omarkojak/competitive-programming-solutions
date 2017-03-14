package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Uva10714 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		//int t=Integer.parseInt(bf.readLine());
		int t=sc.nextInt();
		while(t-->0){
			int lw=0;int hi=0;int l=sc.nextInt();int n=sc.nextInt();
			//StringTokenizer ns =new StringTokenizer(bf.readLine());
			//int l=Integer.parseInt(ns.nextToken());
			//int n=Integer.parseInt(ns.nextToken());
			int []a=new int [n];
			//ns=new StringTokenizer(bf.readLine());
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			Arrays.sort(a);
			for(int i=0;i<n;i++){
				int  x=Math.min(a[i], l-a[i]);
				lw=Math.max(x, lw);
			}
			hi=Math.max(l-a[0],a[n-1]);
			
			out.printf("%d %d\n", lw,hi);
		}
		out.close();
	}

}
