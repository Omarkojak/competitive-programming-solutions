package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeforcesC609 {
	
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
		int []b=new int [n];
		StringTokenizer ns=new StringTokenizer(bf.readLine());
		int sum=0;
		for(int i=0;i<n;i++){
			int x=Integer.parseInt(ns.nextToken());
			a[i]=x;
			sum+=x;
		}
		int target=sum/n;
		int k=sum%n;
		int j;
		for(j=0;j<n-k;j++)
			b[j]=target;
		for(;j<n;j++)
			b[j]=target+1;
		
		shuffle(a);
		Arrays.sort(a);
		int r=0;
		for(int i=0;i<n;i++)
			if(b[i]>a[i])
				r+=b[i]-a[i];
		
		out.println(r);
		out.close();
		
	}

}
