import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Uva939 {
	
	public static boolean isagene(String s){
		return s.equals("dominant")||s.equals("recessive")||s.equals("non-existent");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		TreeMap<String, String>genes=new TreeMap<String, String>();
		TreeSet<String> names=new TreeSet<String>();
		TreeMap<String, String> parents=new TreeMap<String, String>();
		Queue<Parents> q=new LinkedList<Parents>();
		int t=Integer.parseInt(bf.readLine());
		
		while(t-->0){
			StringTokenizer ns =new StringTokenizer(bf.readLine());
			String s1=ns.nextToken();
			String s2=ns.nextToken();
			if(isagene(s2)){
			genes.put(s1, s2);
			names.add(s1);
			}else{
				names.add(s2);
				if(parents.containsKey(s2)){
					q.add(new Parents(s2, s1, parents.get(s2)));
					//out.println(s1+"   "+parents.get(s2));
				}
				else
					parents.put(s2, s1);
				
		}
		}	
		
		while(!q.isEmpty()){
			Parents p=q.poll();
			String child=p.c;
			String gene="";
			if(genes.containsKey(p.p1)&&genes.containsKey(p.p2)){
			String g1=genes.get(p.p1);
			String g2=genes.get(p.p2);
			if((g1.equals("non-existent")&&g2.equals("non-existent"))||(g1.equals("recessive")&&g2.equals("non-existent"))||(g1.equals("non-existent")&&g2.equals("recessive")))
				gene="non-existent";
			else
				if((g1.equals("dominant")&&g2.equals("dominant"))||(g1.equals("recessive")&&g2.equals("dominant"))||(g1.equals("dominant")&&g2.equals("recessive")))
					gene="dominant";
				else
					gene="recessive";
			genes.put(child, gene);
			}else
				q.add(p);
		}

		int size=names.size();
		while(size-->0){
			String k=names.pollFirst();
			String g=genes.get(k);
			out.println(k+" "+g);
		}
		out.flush();
		out.close();
	}

}
class Parents{
	String c;String p1;String p2;
	Parents(String cc,String pp1,String pp2){
		c=cc;p1=pp1;p2=pp2;
	}
}
