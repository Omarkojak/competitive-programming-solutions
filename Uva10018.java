import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Uva10018 {
	
	public static boolean check(String s){
		int l=s.length()/2;
		for(int i=0;i<l;i++)
			if(s.charAt(i)!=s.charAt(s.length()-i-1))
				return false;
		return true;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		while(n-->0){
			String s=bf.readLine();
			boolean flag=true;
			int times=0;
			while(flag){
			StringBuilder sb=new StringBuilder(s);
			
			if(check(sb.toString()))
				flag=false;
			else{
				times++;
				long x=Long.parseLong(sb.toString());
				long x1=Long.parseLong(sb.reverse().toString());
				s=x+x1+"";
			}
			}
			out.println(times+" "+s);
		}
		out.close();
	}

}
