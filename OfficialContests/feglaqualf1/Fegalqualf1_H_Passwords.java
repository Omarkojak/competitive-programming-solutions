package OfficialContests.feglaqualf1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Fegalqualf1_H_Passwords {

	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		int t=in.nextInt();
		StringBuilder sb=new StringBuilder();
		while(t-->0){
			TreeMap<Character, Integer> mp=new TreeMap<Character, Integer>();
			Queue<Character> q=new LinkedList<Character>();
			String s=in.nextLine();
			for(int i=0;i<s.length();i++){
				char curr=s.charAt(i);
				if(mp.containsKey(curr)){
					int v=mp.get(curr);
					mp.put(curr, v+1);
				}else{
					mp.put(curr, 1);
					q.add(curr);
				}
			}
			ArrayList<ch> as=new ArrayList<ch>();
			while(!q.isEmpty()){
				char curr=q.poll();
				as.add(new ch(curr,mp.get(curr)));
			}
			Collections.sort(as);
			String k="";
			if(as.size()%2==0){
				int idx1=as.size()/2;
				k=as.get(idx1-1).c+""+as.get(idx1).c;
			}else{
				int idx=as.size()/2;
				k=as.get(idx).c+"";
			}
			sb.append(k+"\n");
			
		}
		System.out.print(sb);
		
		
	}
	
	static class ch implements Comparable<ch>{
		char c;int occ;
		ch(char a,int b){
			c=a;occ=b;
		}
		public int compareTo(ch o) {
			if(occ!=o.occ)
				return occ-o.occ;
			
			return (int)(c-o.c);
			
		}
		
		
		
		
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
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public boolean ready() throws IOException {return br.ready();}

	}
}
