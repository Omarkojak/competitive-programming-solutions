import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Uva129 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		while(!s.equals("0 0")){
			StringTokenizer ns =new StringTokenizer(bf.readLine());
			int n=Integer.parseInt(ns.nextToken());
			
			
			s=bf.readLine();
		}
		out.close();
	}

}
