package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CodeforcesA151 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns =new StringTokenizer(bf.readLine());int n=Integer.parseInt(ns.nextToken());int k=Integer.parseInt(ns.nextToken());int l=Integer.parseInt(ns.nextToken());int c=Integer.parseInt(ns.nextToken());int d=Integer.parseInt(ns.nextToken());int p=Integer.parseInt(ns.nextToken());int nl=Integer.parseInt(ns.nextToken());int np=Integer.parseInt(ns.nextToken());int litr=k*l/nl;int lems=c*d;int sug=p/np;
		out.println(Math.min(Math.min(litr, lems), sug)/n);
		out.close();
	}

}
