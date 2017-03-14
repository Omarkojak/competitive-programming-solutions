package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CodeforcesB474 {
	
	public static void shuffle(int []a){
		int n=a.length;
		for(int i=0;i<n;i++){
			int r=i+(int)(Math.random()*(n-i));
			int temp=a[i];
			a[i]=a[r];
			a[r]=temp;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		int []a=new int [2000005];
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		int k=1;
		for(int i=0;i<n;i++){
			int times=Integer.parseInt(ns.nextToken());
			while(times-->0)
				a[k++]=i+1;
		}
		int q=Integer.parseInt(bf.readLine());
		ns=new StringTokenizer(bf.readLine());
		while(q-->0){
			out.println(a[Integer.parseInt(ns.nextToken())]);
		}
		out.close();
	}

}
