package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CF_B631 {

	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int n=in.nextInt();
		int m=in.nextInt();
		int q=in.nextInt();
		TreeMap<Integer,pair>row=new TreeMap<Integer,pair>();
		TreeMap<Integer,pair>column=new TreeMap<Integer,pair>();
		
		for(int i=0;i<q;i++){
			int check=in.nextInt();
			int idx=in.nextInt();
			int color=in.nextInt();
			if(check==1){
				row.put(idx-1, new pair(color,i));
			}else{
				column.put(idx-1, new pair(color,i));
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				int orr=0;int orc=0;
				if(!row.containsKey(i))
					orr=-1;
				else
					orr=row.get(i).order;
				
				if(!column.containsKey(j))
					orc=-1;
				else
					orc=column.get(j).order;
				
				if(orr==-1&&orc==-1)
					sb.append("0");
					else
						if(orc==-1)
							sb.append(row.get(i).color+"");
						else
							if(orr==-1)
								sb.append(column.get(j).color+"");
							else{
								if(orr<orc)
									sb.append(column.get(j).color+"");
								else
									sb.append(row.get(i).color+"");
								
							}
				
				if(j+1<m)
					sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
		
	
		
	}
	
	static class pair{
		int color;int order;
		pair(int a,int b){
			color=a;order=b;
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
	

	