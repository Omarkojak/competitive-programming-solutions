import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva12482 {
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
		while(s!=null){
			StringTokenizer ns =new StringTokenizer(s);
			int n=Integer.parseInt(ns.nextToken());
			int l=Integer.parseInt(ns.nextToken());
			int c=Integer.parseInt(ns.nextToken());
			ns=new StringTokenizer(bf.readLine());
			int []a=new int [n];
			for(int i=0;i<n;i++)
				a[i]=ns.nextToken().length();
			
			int i=0;
			int r=0;
			while(i<n){
				int k=0;
				int j=i;
				while(j<n&&k+a[j]<=c)
					k+=a[j++]+1;
				i=j;
				r++;
			}
			//out.println(r);
			int res=r/l;
			if(r%l!=0)
				res++;
			out.println(res);
			s=bf.readLine();
		}
		out.close();
	}

}
