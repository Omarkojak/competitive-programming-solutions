package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Uva11057 {
	static int []a;
	public static void shuffle(int []a){
		int n=a.length;
		for(int i=0;i<n;i++){
			int r=i+(int)(Math.random()*(n-i));
			int temp=a[i];
			a[i]=a[r];
			a[r]=temp;
		}
	}

	public static int binarysearch(int k){
		int lw=0;int hi=a.length-1;int ans=-1;
		while(lw<=hi){
			int mid=(lw+hi)/2;
			if(a[mid]==k){
				ans=mid;
				hi=mid-1;
			}
				if(a[mid]>k)
					hi=mid-1;
				else
					lw=mid+1;
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		while(true){
			String s=bf.readLine();
			if(s.isEmpty())
				s=bf.readLine();
			if(s==null)
				break;
			int n=Integer.parseInt(s);
			a=new int [n];
			StringTokenizer ns =new StringTokenizer(bf.readLine());
			int max=0;
			for(int i=0;i<n;i++){
				a[i]=Integer.parseInt(ns.nextToken());
			max=Math.max(max, a[i]);
			}
			int []c=new int [max+1];
			for(int i=0;i<n;i++)
				c[a[i]]++;
			shuffle(a);
			Arrays.sort(a);
			int diff=10000000;int a1=0;int a2=0;
			int M=Integer.parseInt(bf.readLine());
			for(int i=1;i<=M;i++){
				int rem=M-i;
				int ans=binarysearch(rem);
				int ans2=binarysearch(i);
				if(i==rem&&c[i]<2)
					continue;
				if(ans!=-1&&ans2!=-1){
					int k=Math.abs(rem-i);
					//out.println(rem+" "+i+" "+k+" "+diff);
					if(k<diff){
						a1=rem;
						a2=i;
						diff=k;
					}
				}
			}
			out.printf("Peter should buy books whose prices are %d and %d.\n\n", Math.min(a1, a2),Math.max(a1, a2));
			//out.println(binarysearch(4));
			//s=bf.readLine();
		}
		//out.println();
		out.close();
	}

}
