package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CodeforcesA500 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(ns.nextToken());
		int t=Integer.parseInt(ns.nextToken())-1;
		ns=new StringTokenizer(bf.readLine());
		int []a=new int [n];
		for(int i=0;i<n-1;i++)
			a[i]=Integer.parseInt(ns.nextToken());
		boolean flag=false;
		for(int i=0;i<n;){
			if(i>t)
				break;
			
			if(i==t){
				flag=true;
				break;
			}
			i+=a[i];
		}
		out.println(flag?"YES":"NO");
		out.close();
	}

}
