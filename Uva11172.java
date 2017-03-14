import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Uva11172 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			StringTokenizer ns =new StringTokenizer(bf.readLine());
			long x1=Long.parseLong(ns.nextToken());
			long x2=Long.parseLong(ns.nextToken());
			if(x1<x2)
				out.println("<");
			else
				if(x1>x2)
					out.println(">");
				else
					out.println("=");
		}
		out.close();
	}

}
