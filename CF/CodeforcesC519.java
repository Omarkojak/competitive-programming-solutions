package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesC519 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(ns.nextToken());
		int m=Integer.parseInt(ns.nextToken());
		int r=0;
		while(n+m>=3){
			if(n==0||m==0)
				break;
			r++;
			if(n<m){
				n-=1;
				m-=2;
			}else{
				n-=2;
				m-=1;
		}
		}
		out.println(r);
		out.close();
	}

}
