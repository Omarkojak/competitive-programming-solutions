package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class CodeforcesA330 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		int r=Integer.parseInt(ns.nextToken());
		int c=Integer.parseInt(ns.nextToken());
		TreeSet<Integer> sr=new TreeSet<Integer>();
		TreeSet<Integer> sc=new TreeSet<Integer>();
		for(int i=0;i<r;i++)
			sr.add(i);
		for(int i=0;i<c;i++)
			sc.add(i);
		for(int i=0;i<r;i++){
			String s=bf.readLine();
			for(int j=0;j<c;j++)
				if(s.charAt(j)=='S'){
					//out.println(i+" "+j);
					sr.remove(i);
					sc.remove(j);
				}
		}
		//out.println(sr.size());
		//out.println(sc.size());

		int res=0;
		res+=sr.size()*c;
		res+=sc.size()*r-sc.size()*sr.size();
		out.println(res);
		out.close();
	}

}
