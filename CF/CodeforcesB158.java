package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesB158 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int []a=new int [5];
		for(int i=0;i<n;i++)
			a[Integer.parseInt(ns.nextToken())]++;
		
		int c1=a[1];
		int c2=a[2];
		int c3=a[3];
		int c4=a[4];
		int sum=0;
		sum+=c4+c2/2+c3;
		int r2=0;
		if(c2%2!=0)
			r2 = 2;
		c1-=c3;
		if(c1<=0)
			c1=0;
		sum +=(c1+r2 + 3)/4;
		
		out.println(sum);
		out.close();
	}

}
