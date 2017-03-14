import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;


public class Uva10935 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int x=Integer.parseInt(bf.readLine());
		while(x!=0){
			Queue<Integer> q=new LinkedList<Integer>();
			for(int i=1;i<=x;i++)
				q.add(i);
			out.print("Discarded cards:");
			while(q.size()>1){
				out.print(" "+q.poll());
				if(q.size()!=1)
					out.print(",");
				q.add(q.poll());
			}
			out.println();
			out.println("Remaining card: "+q.poll());
			x=Integer.parseInt(bf.readLine());
		}
		out.close();
	}

}
