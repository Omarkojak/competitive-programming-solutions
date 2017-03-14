package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Uva11961 {
	static int length,k,tokens;
	static String s;
	static ArrayList<String> beg;
	
	static void ev(int index,int curr,String r){
		if(curr>k)return;
		if(index==length){
			beg.add(r);
			tokens++;
			return ;
		}
		ev(index+1,(s.charAt(index)=='A')? curr:curr+1,r+"A");
		ev(index+1,(s.charAt(index)=='C')? curr:curr+1,r+"C");
		ev(index+1,(s.charAt(index)=='G')? curr:curr+1,r+"G");
		ev(index+1,(s.charAt(index)=='T')? curr:curr+1,r+"T");

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			StringTokenizer ns =new StringTokenizer(bf.readLine());
			length=Integer.parseInt(ns.nextToken());
			k=Integer.parseInt(ns.nextToken());
			beg=new ArrayList<String>();
			tokens=0;
			s=bf.readLine();
			ev(0,0,"");
			out.println(tokens);
			for(int i=0;i<beg.size();i++)
				out.println(beg.get(i));
		}
		out.close();
	}

}
