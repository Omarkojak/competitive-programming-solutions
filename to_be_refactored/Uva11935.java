package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Uva11935 {
public static void main(String[] args)throws Exception {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	String s=bf.readLine();
	while(!s.equals("0 Fuel consumption 0")){
		StringTokenizer ns =new StringTokenizer(s);
		double sum=0.0;
		double fc=0.0;
		double leak=0.0;double prev=0.0;double max=0.0;
		double now=Double.parseDouble(ns.nextToken());
		String k=ns.nextToken();
		while(!(k.equals("Goal"))){
			if(k.equals("Fuel")){
				ns.nextToken();
				sum+=(now-prev)*fc+leak*(now-prev);
				fc=Double.parseDouble(ns.nextToken())/100.0;
				prev=now;
			}
			else if(k.equals("Leak")){
				
				sum+=(now-prev)*fc+leak*(now-prev);
				leak++;
				prev=now;
			}
			else if(k.equals("Gas")){
				//out.println(now);
				sum+=(now-prev)*fc+leak*(now-prev);
				max=Math.max(sum,max);
				sum=0;
				prev=now;
			}
			else if(k.equals("Mechanic")){
				
				sum+=(now-prev)*fc+leak*(now-prev);
				leak=0;
				prev=now;
			}
			ns=new StringTokenizer(bf.readLine());
			now=Integer.parseInt(ns.nextToken());
			k=ns.nextToken();
		}
		double r=Math.max(max,((sum+(now-prev)*fc+leak*(now-prev))));
		s=bf.readLine();
		out.printf("%.3f\n",r);
		
	}
	out.close();
}

}