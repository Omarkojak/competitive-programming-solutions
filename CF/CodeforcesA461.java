package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CodeforcesA461 {
	
	
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
		int []a=new int [n];
		long sum=0;
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++){
			a[i]=Integer.parseInt(ns.nextToken());
			sum+=a[i];
		}
		long r=sum;
		shuffle(a);
		Arrays.sort(a);
		for(int i=0;i<n-1;i++){
			
			sum-=a[i];
			r+=a[i]+sum;
		}
		out.println(r);	
		out.close();
		
	}

}
