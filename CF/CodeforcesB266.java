package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesB266 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(ns.nextToken());
		int t=Integer.parseInt(ns.nextToken());
		StringBuilder s=new StringBuilder(bf.readLine());
		for(int i=0;i<t;i++)
			for(int j=0;j<s.length()-1;j++){
				if(s.charAt(j)=='B'&&s.charAt(j+1)=='G'){
					s.replace(j, j+2, "GB");
					j++;
				}
					
			}
		out.println(s);
		out.close();
	
	}

}
