import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Uva11995 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		while(s!=null&&s.length()!=0){
			Stack<Integer> st=new Stack<Integer>();boolean fs=true;
			PriorityQueue<Integer> pq=new PriorityQueue<Integer>();boolean fpq=true;
			Queue<Integer> q =new LinkedList<Integer>();boolean fq=true;
			int n=Integer.parseInt(s);
			while(n-->0){
				StringTokenizer ns =new StringTokenizer(bf.readLine());
				int typ=Integer.parseInt(ns.nextToken());
				int x=Integer.parseInt(ns.nextToken());
				if(typ==1){ st.push(x);pq.add(-x);q.add(x);}
				else{
					if(fs){
						if(st.isEmpty()) fs=false;
						else{
							int k=st.pop();
							if(k!=x)
								fs=false;
						}	
					}
					if(fpq){
						if(pq.isEmpty()) fpq=false;
						else{
							int k=pq.poll()*-1;
							if(k!=x)
								fpq=false;
						}
					}
					if(fq){
						if(q.isEmpty()) fq=false;
						else{
							int k=q.poll();
							if(k!=x)
								fq=false;
						}
					}
				}	
			}String res="";
			if(fpq==false&&fq==false&&fs==false)
				res="impossible";
			else
				if((fpq&&fq)||(fpq&&fs)|(fs&&fq))
					res="not sure";
				else
					res=fq? "queue":fs?"stack":"priority queue";
			out.println(res);
			s=bf.readLine();
		}
		out.close();
	}

}
