package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class A765 {

	public static void main(String[] args)throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String home = in.nextLine();
		TreeMap<String, Integer> mp = new TreeMap<>();
		while(n-->0){
			String ss = in.nextLine();
			String a1 = ss.charAt(0) +""+ ss.charAt(1)+"" + ss.charAt(2);
			String a2 = ss.charAt(5) +""+ ss.charAt(6)+"" + ss.charAt(7);
			if(a1.equals(home)){
				int c = 0;
				if(mp.containsKey(a2))
					c = mp.get(a2);
				mp.put(a2, c - 1);
				
			}else{
				int c = 0;
				if(mp.containsKey(a1))
					c = mp.get(a1);
				mp.put(a1, c + 1);
			}
		}
		boolean f = true;
		for(Entry<String, Integer> e:mp.entrySet())
			if(e.getValue() != 0)
				f = false;
		
		System.out.println(f? "home":"contest");
		
		
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
	}

}
