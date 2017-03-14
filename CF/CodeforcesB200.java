package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesB200 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		double n=Double.parseDouble(bf.readLine());
		double sum=0;
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++)
			sum+=(Double.parseDouble(ns.nextToken())/100.0);
		double r=sum/n;
		r*=100;
		out.println(r);
		out.close();
	}

}
