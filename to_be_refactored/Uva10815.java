package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Uva10815 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		TreeSet<String>ts=new TreeSet<String>();
		String s=bf.readLine();
		while(s!=null){
			int last=0;
			if(s.length()!=0){
				String k="";
				s=s.toLowerCase();
			for(int i=0;i<s.length();i++){
				char c=s.charAt(i);
				if(c>=97&&c<=122)
					k+=c;
				else{
					if(k.length()!=0)
						ts.add(k);
				k="";
				}			
				}
			if(k.length()!=0)
				ts.add(k);
			}
			
			s=bf.readLine();
		}
		int size=ts.size();
		//out.println(ts.toString());
		for(int i=0;i<size;i++)
			out.println(ts.pollFirst());
		out.close();
	}
	

}
