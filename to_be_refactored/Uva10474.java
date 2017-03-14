package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Uva10474 {
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

	public static int binarysearch(int x){
		int low=0;int high=a.length-1;
		int ans=-1;
		while(low<=high){
			int mid=(high+low)/2;
			if(a[mid]==x){
				ans=mid;
				high=mid-1;
			}
			if(a[mid]>x)
				high=mid-1;
			if(a[mid]<x)
				low=mid+1;
		}
		
		return ans;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		int k=1;
		while(!s.equals("0 0")){
			StringTokenizer ns =new StringTokenizer(s);
			int n=Integer.parseInt(ns.nextToken());
			int q=Integer.parseInt(ns.nextToken());
			a=new int [n];
			for(int i=0;i<n;i++)
				a[i]=Integer.parseInt(bf.readLine());
			shuffle(a);
			Arrays.sort(a);
			out.printf("CASE# %d:\n", k++);
			while(q-->0){
				int x=Integer.parseInt(bf.readLine());
				int i=binarysearch(x);
				if(i==-1)
					out.printf("%d not found\n",x);
				else
					out.printf("%d found at %d\n",x,i+1);
			}
			
			s=bf.readLine();
		}
		out.close();
	}
	

}
