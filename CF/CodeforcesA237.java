package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesA237 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		int [] h=new int [n];
		int []m=new int [n];
		for(int i=0;i<n;i++){
			StringTokenizer ns =new StringTokenizer(bf.readLine());
			h[i]=Integer.parseInt(ns.nextToken());
			m[i]=Integer.parseInt(ns.nextToken());
		}
		int r=1;
		for(int i=1;i<n;i++){
			int cash=1;
			while(i<n&&h[i]==h[i-1]&&m[i]==m[i-1]){
				i++;
				cash++;
			}
			
			if(cash>r)
				r=cash;
		
		}
			
		out.println(r);
		out.close();
	}

}
