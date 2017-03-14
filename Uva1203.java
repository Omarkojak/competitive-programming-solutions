import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Uva1203 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();PriorityQueue<Q1> pq=new PriorityQueue<Q1>();
		while(!s.equals("#")){
			StringTokenizer ns =new StringTokenizer(s);
			ns.nextToken();
			int num=Integer.parseInt(ns.nextToken());int p=Integer.parseInt(ns.nextToken());
			pq.add(new Q1(num,p,p));
			s=bf.readLine();
		}
		int k=Integer.parseInt(bf.readLine());
		while(k-->0){
			Q1 qout=pq.poll();
			out.println(qout.num);
			pq.add(new Q1(qout.num, qout.time+qout.p, qout.p));
		}
		out.close();
	}

}
class Q1 implements Comparable<Q1>{
	int num;int time;int p;
	Q1(int n,int t,int p){
		num=n;time=t;this.p=p;
	}
	public int compareTo(Q1 o){
		if(Integer.compare(this.time, o.time)!=0)
		return Integer.compare(this.time, o.time);
			return Integer.compare(this.num, o.num);
	}
}
