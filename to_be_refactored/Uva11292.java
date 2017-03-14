package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva11292 {

	public static void shuffle(int []a){
		int n=a.length;
		for(int i=0;i<n;i++){
			int r=i+(int)(Math.random()*(n-i));
			int temp=a[i];
			a[i]=a[r];
			a[r]=temp;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		while(!s.equals("0 0")){
			StringTokenizer ns =new StringTokenizer(s);
			int n=Integer.parseInt(ns.nextToken());
			int m=Integer.parseInt(ns.nextToken());
			int []drags=new int [n];
			int []knights=new int [m];
			for(int i=0;i<n;i++)
				drags[i]=Integer.parseInt(bf.readLine());
			for(int i=0;i<m;i++)
				knights[i]=Integer.parseInt(bf.readLine());
			shuffle(drags);
			shuffle(knights);
			Arrays.sort(drags);
			Arrays.sort(knights);
			long r=0;
			int d=0;int k=0;
			while(k<m&&d<n){
				while(k<m&&drags[d]>knights[k])
					k++;
				if(k==m)
					break;
				r+=knights[k];
				k++;d++;
				
			}
			if(d==n)
				out.println(r);
			else
				out.println("Loowater is doomed!");
			s=bf.readLine();
		}
		out.close();
	}

}
