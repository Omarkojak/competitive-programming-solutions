package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Uva10469 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		while(s!=null&&s.length()!=0){
			StringTokenizer ns =new StringTokenizer(s);
			long x1=Long.parseLong(ns.nextToken());
			long x2=Long.parseLong(ns.nextToken());
			out.println(x1^x2);
			s=bf.readLine();
		}
		out.close();
	}

}
