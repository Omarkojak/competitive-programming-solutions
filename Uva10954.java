import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Uva10954 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int x=Integer.parseInt(bf.readLine());
		while(x!=0){
			//int n=Integer.parseInt(bf.readLine());
			PriorityQueue<Integer>pq=new PriorityQueue<Integer>();
			StringTokenizer ns =new StringTokenizer(bf.readLine());
			while(x-->0)
				pq.add(Integer.parseInt(ns.nextToken()));
			int cost=0;
			while(pq.size()>1){
				int x1=pq.poll();
				int x2=pq.poll();
				cost+=x1+x2;
				pq.add(x1+x2);
			}
			out.println(cost);
			x=Integer.parseInt(bf.readLine());
		}
		out.close();
	}

}
