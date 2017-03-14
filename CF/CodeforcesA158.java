package CF;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CodeforcesA158 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(ns.nextToken());
		int k=Integer.parseInt(ns.nextToken());
		int []a=new int [n];
		ns=new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(ns.nextToken());
		
		k--;

		int w=a[k];
			int c=0;
			for(int i=0;i<n;i++)
				if(a[i]>=w&&a[i]!=0)
					c++;
			
			System.out.println(c);
		}
	}


