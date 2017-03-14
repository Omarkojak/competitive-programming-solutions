package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class CodeforcesA608{

	
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(ns.nextToken());
		int s=Integer.parseInt(ns.nextToken());
		int r=s;
		int taken=0;
		PriorityQueue<Pass> q=new PriorityQueue<Pass>();
		while(n-->0){
			ns=new StringTokenizer(bf.readLine());
			q.add(new Pass(Integer.parseInt(ns.nextToken()), Integer.parseInt(ns.nextToken())));
		}
		while(!q.isEmpty()){
			Pass p=q.poll();
			int f=p.f;
			int se=p.s;
			if(taken+s-f<se){
				int x=se-(taken+(s-f));
				r+=x;
				taken+=x;
			}
			
		}
		out.println(r);
		out.close();
		
}
}

class Pass implements Comparable<Pass>{
	int f;
	int s;
	Pass(int f,int s){
		this.f=f;
		this.s=s;
	}
	public int compareTo(Pass o){
		if(this.f>o.f)
			return -1;
		else
			return 1;
	}
	
	
}