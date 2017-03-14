package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesA581 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		int red=Integer.parseInt(ns.nextToken());
		int blue=Integer.parseInt(ns.nextToken());
		int r=Math.min(blue, red);
		out.print(r+" ");
		blue-=r;
		red-=r;
		if(blue==0)
			out.print(red/2);
		else
			if(red==0)
				out.print(blue/2);
		out.close();
	}

}
