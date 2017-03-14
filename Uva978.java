import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Uva978 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			PriorityQueue<Integer> qg=new PriorityQueue<Integer>();
			PriorityQueue<Integer> qb=new PriorityQueue<Integer>();
			StringTokenizer ns =new StringTokenizer(bf.readLine());
			int battles=Integer.parseInt(ns.nextToken());
			int g=Integer.parseInt(ns.nextToken());
			int b=Integer.parseInt(ns.nextToken());
			for(int i=0;i<g;i++)
				qg.add(Integer.parseInt(bf.readLine())*-1);
			for(int i=0;i<b;i++)
				qb.add(Integer.parseInt(bf.readLine())*-1);
			
				while(qb.size()!=0&&qg.size()!=0){
					Queue<Integer>tempb=new LinkedList<Integer>();
					Queue<Integer>tempg=new LinkedList<Integer>();
					int mnsze=Math.min(qb.size(), Math.min(battles,qg.size()));
					while(mnsze-->0){
						int b1=qb.poll()*-1;int g1=qg.poll()*-1;
						if(g1>b1)
							tempg.add(g1-b1);
						else
							if(b1>g1)
								tempb.add(b1-g1);
					}
					while(!tempb.isEmpty()) qb.add(tempb.poll()*-1);
					while(!tempg.isEmpty()) qg.add(tempg.poll()*-1);
				}
				if(qb.size()==0&&qg.size()==0)
					out.println("green and blue died");
				else
					if(qb.size()==0){
						out.println("green wins");
						while(!qg.isEmpty()) out.println(qg.poll()*-1);
					}else{
						out.println("blue wins");
						while(!qb.isEmpty()) out.println(qb.poll()*-1);
					}
				if(t!=0)
					out.println();
		}
		out.flush();
		out.close();
	}

}
