package CF;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesA496 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int n=Integer.parseInt(bf.readLine());int min=10000;int ind=-1;
		int []a=new int [n];
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(ns.nextToken());
		for(int i=1;i<n-1;i++){
			int diff=Math.abs(a[i-1]-a[i+1]);
			if(diff<min){
				min=diff;
				ind=i;
			}
		}int max=0;
		for(int i=0;i<n-1;){
			if(i==ind-1){
				if(i+2<n)
					max=Math.max(max, Math.abs(a[i]-a[i+2]));
				i+=2;
				continue;
			}
			max=Math.max(max,Math.abs(a[i]-a[i+1]));
			i++;
		}
		out.println(max);
		out.close();
	}

}
