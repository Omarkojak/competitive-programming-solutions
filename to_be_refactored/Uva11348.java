package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Uva11348 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t=Integer.parseInt(bf.readLine());int num=1;
		while(t-->0){
			int n=Integer.parseInt(bf.readLine());
			HashMap<Integer, Integer>loc=new HashMap<Integer, Integer>();
			int []a=new int [n];
			ArrayList<Integer>[]input=new ArrayList[n];
			TreeSet<Integer>notunique=new TreeSet<Integer>();
			for(int i=0;i<n;i++){
				input[i]=new ArrayList<Integer>();
				StringTokenizer ns=new StringTokenizer(bf.readLine());
				int k=Integer.parseInt(ns.nextToken());
				while(k-->0){
					int next=Integer.parseInt(ns.nextToken());
					input[i].add(next);
					if(loc.containsKey(next)){
						if(loc.get(next)!=i){
							loc.remove(next);
							notunique.add(next);
						}}else
							if(!notunique.contains(next))
								loc.put(next, i);
						
				}	
			}
			double tokens=loc.size();
			//out.println(tokens);

			out.printf("Case %d:", num++);
			
			for(int i=0;i<n;i++){
				double r=0;
				for(int j=0;j<input[i].size();j++){
					int now=input[i].get(j);
					if(loc.containsKey(now)){
						r++;loc.remove(now);
					}
				}
				//out.println(r+" "+tokens);
				double res=r/tokens;
				out.printf(" %.6f", tokens==0.0? 0:res*100.0);
				out.print("%");
			
			}
			out.println();
		}
		out.close();
	}

}
