package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CodeforcesA288 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		TreeSet <Integer>s=new TreeSet<Integer>();
		s.add(Integer.parseInt(ns.nextToken()));
		s.add(Integer.parseInt(ns.nextToken()));
		s.add(Integer.parseInt(ns.nextToken()));
		s.add(Integer.parseInt(ns.nextToken()));
		out.println(4-s.size());
		out.close();
	}

}
