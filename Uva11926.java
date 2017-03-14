import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Uva11926 {
	public static boolean check(ArrayList<time>a){
		for(int i=0;i<a.size()-1;i++){
			time t1=a.get(i);time t2=a.get(i+1);
			if(t1.st==t2.st)
				return false;
			if(t2.st>t1.st&&t2.st<t1.e)
				return false;
			if(t1.st>t2.st&&t1.st<t2.e)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		while(!s.equals("0 0")){
			ArrayList<time>as=new ArrayList<time>();
			StringTokenizer ns =new StringTokenizer(s);
			int n=Integer.parseInt(ns.nextToken());
			int m=Integer.parseInt(ns.nextToken());
			while(n-->0){
				ns=new StringTokenizer(bf.readLine());
				as.add(new time(Integer.parseInt(ns.nextToken()),Integer.parseInt(ns.nextToken())));
			}
			while(m-->0){
				ns=new StringTokenizer(bf.readLine());
				int st=Integer.parseInt(ns.nextToken());
				int e=Integer.parseInt(ns.nextToken());
				int inter=Integer.parseInt(ns.nextToken());
				while(e<1000000){
					as.add(new time(st,e));
					st+=inter;e+=inter;
				}
				as.add(new time(st,e));
			}
			Collections.sort(as);
			boolean flag=check(as);
			out.println(flag? "NO CONFLICT":"CONFLICT");
			s=bf.readLine();
		}
		out.close();
	}

}
class time implements Comparable<time>{
	int st;
	int e;
	time(int t,int e1){
		st=t;
		e=e1;
	}
	public int compareTo(time o){
		return Integer.compare(this.st, o.st);
	}
}
