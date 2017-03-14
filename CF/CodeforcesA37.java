package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesA37 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		int []l=new int [1005];
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++)
			l[Integer.parseInt(ns.nextToken())]++;
		int towers=0;
		int h=0;
		for(int i=0;i<1005;i++)
			if(l[i]!=0){
				towers++;
				h=Math.max(l[i], h);
			}
		out.println(h+" "+towers);
		out.close();
	}

}
