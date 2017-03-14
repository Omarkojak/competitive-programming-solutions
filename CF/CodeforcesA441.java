package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesA441 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(ns.nextToken());
		int money=Integer.parseInt(ns.nextToken());
		String r="";
		int tokens=0;
		for(int i=1;i<=n;i++){
			ns=new StringTokenizer(bf.readLine());
			int k=Integer.parseInt(ns.nextToken())-1;
			int min=Integer.parseInt(ns.nextToken());
			while(k-->0)
				min=Math.min(min, Integer.parseInt(ns.nextToken()));
			if(min<money){
				tokens++;
				if(tokens==1)
					r+=i;
				else
					r+=" "+i;
			
			}
			
		}
		out.println(tokens);
		if(tokens!=0)
		out.println(r);
		out.close();
	}

}
