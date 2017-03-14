package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesB463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		int []a=new int [n];
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		int max=0;
		for(int i=0;i<n;i++)
			max=Math.max(max,Integer.parseInt(ns.nextToken()));
		
		out.println(max);
		out.close();
	}

}
