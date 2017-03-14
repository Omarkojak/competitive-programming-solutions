import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Uva540 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n=Integer.parseInt(bf.readLine());int c=1;
		while(n!=0){
			out.printf("Scenario #%d\n", c++);
			TreeMap<Integer, Integer> whatteam=new TreeMap<Integer, Integer>();
			Queue<Integer>process=new LinkedList<Integer>();
			TreeMap<Integer, Queue<Integer>> container=new TreeMap<Integer, Queue<Integer>>();
			for(int i=1;i<=n;i++){
				StringTokenizer ns =new StringTokenizer(bf.readLine());
				int num=Integer.parseInt(ns.nextToken());
				for(int j=0;j<num;j++)
					whatteam.put(Integer.parseInt(ns.nextToken()), i);
			}
			String s=bf.readLine();
			while(!s.equals("STOP")){
				StringTokenizer ns =new StringTokenizer(s);
				String todo=ns.nextToken();
				if(todo.equals("ENQUEUE")){
					int elem=Integer.parseInt(ns.nextToken());
					int whichteam=whatteam.get(elem);
					if(container.containsKey(whichteam))
						container.get(whichteam).add(elem);
					else{
						Queue<Integer>q=new LinkedList<Integer>();
						q.add(elem);process.add(whichteam);
						container.put(whichteam,q);
					}}else{
						int beg=process.peek();
						int elem=container.get(beg).poll();
						out.println(elem);
						if(container.get(beg).isEmpty()){
							process.poll();container.remove(beg);
						}
					
				}
				s=bf.readLine();
			}
			n=Integer.parseInt(bf.readLine());
			out.println();
		}
		//out.println();
		out.close();
	}

}
