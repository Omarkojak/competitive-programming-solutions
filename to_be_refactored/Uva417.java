package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Uva417 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		TreeMap<String, Integer> mp = new TreeMap<String, Integer>();
		int k = 1;
		Queue<String> q = new LinkedList<String>();
		for(char c = 'a'; c <= 'z'; c++) 
			q.add(""+c);
		while(!q.isEmpty()){
			String cur = q.remove();
			mp.put(cur, k++);
			
			if(cur.length() < 5)
				for(char c = (char)(cur.charAt(cur.length() - 1) + 1); c <= 'z' ; c++) 
					q.add(cur+c);
		}
		String s=bf.readLine();
		while(s!=null&&s.length()!=0){
			if(mp.containsKey(s))
				out.println(mp.get(s));
			else
				out.println(0);
			s=bf.readLine();
		}
		out.close();
	}

}
