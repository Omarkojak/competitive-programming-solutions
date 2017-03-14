package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Uva10071 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		while(s!=null){
			StringTokenizer ns=new StringTokenizer(s);
			out.println(Integer.parseInt(ns.nextToken())*Integer.parseInt(ns.nextToken())*2);
			s=bf.readLine();
			
		}
		out.close();
	}

}
