import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Uva11679 {

	public static boolean btngan(int[] reserves) {
	    for (int i = 0; i < reserves.length; i++) {
	      if (reserves[i] < 0)
	        return false;
	    }
	    return true;
	  }
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		while(!s.equals("0 0")){
			StringTokenizer ns =new StringTokenizer(s);
			int b=Integer.parseInt(ns.nextToken());
			int q=Integer.parseInt(ns.nextToken());
			int []a=new int[b+1];
			ns=new StringTokenizer(bf.readLine());
			for(int i=1;i<=b;i++)
				a[i]=Integer.parseInt(ns.nextToken());
			
			while(q-->0){
			ns=new StringTokenizer(bf.readLine());
			int b1=Integer.parseInt(ns.nextToken());
			int b2=Integer.parseInt(ns.nextToken());
			int cost=Integer.parseInt(ns.nextToken());
			
			a[b1]-=cost;
			a[b2]+=cost;
			}
			out.println(btngan(a)? "S":"N");
			s=bf.readLine();
		}
		out.close();
	}

}
