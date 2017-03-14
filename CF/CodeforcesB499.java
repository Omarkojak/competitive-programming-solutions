package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CodeforcesB499 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(ns.nextToken());
		int m=Integer.parseInt(ns.nextToken());
		TreeMap<String, String> tm=new TreeMap<String, String>();
		while(m-->0){
			ns=new StringTokenizer(bf.readLine());
			tm.put(ns.nextToken(), ns.nextToken());
		}
		ns=new StringTokenizer(bf.readLine());
		while(n-->0){
			String s1=ns.nextToken();
			String s2=tm.get(s1);
			if(s2.length()<s1.length())
				out.print(s2);
			else
				out.print(s1);
			if(n!=0)
				out.print(" ");
		}
		out.close();
	}

}
