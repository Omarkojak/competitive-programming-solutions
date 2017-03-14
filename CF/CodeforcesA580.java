package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesA580 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		int []a=new int [n];
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(ns.nextToken());
		int j;
		int r=1;
		for(int i=0;i<n;i++){
			int rn=1;
			int lst=i+1;	
			
			for(j=i;j<n-1;j++)
				if(a[j]<=a[j+1])
					rn++;
				else
					break;
			lst=j;
			r=Math.max(rn, r);
			i=lst;
		}
		out.println(r);	
		out.close();
			
	}

}
