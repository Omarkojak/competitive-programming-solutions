package CF;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

public class CodeforcesA554 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		TreeSet<String> ts=new TreeSet<String>();
		String s=bf.readLine();
		for(int i='a';i<='z';i++){
			ts.add(s+(char)i);
			ts.add((char)(i)+s);
		}
		for(int i=1;i<s.length();i++){
			String p1=s.substring(0, i);
			String p2=s.substring(i, s.length());
			for(int j='a';j<='z';j++)
				ts.add(p1+(char)j+p2);	
		}
		out.println(ts.size());
		out.flush();
		out.close();
	}

}
