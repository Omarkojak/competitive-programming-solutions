package cp2_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10158_War {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		UnionFind uf = new UnionFind(n);
		while(true)
		{
			int type = in.nextInt();
			int f1 = uf.findSet(in.nextInt());
			int f2 = uf.findSet(in.nextInt());
			if(type == 0)
				break;
			
			if(type == 1)
			{
				if(uf.enemy[f1] == f2 || uf.enemy[f2] == f1)
				{
					sb.append(-1).append("\n");
					continue;
				}
				uf.unionSet(f1, f2);
				if(uf.enemy[f1] != -1 && uf.enemy[f2] != -1)
				{
					uf.unionSet(uf.enemy[f1], uf.enemy[f2]);
					uf.enemy[uf.findSet(uf.enemy[f1])] = uf.findSet(f1);
					continue;
				}
				
				if(uf.enemy[f1] != -1)
				{
					uf.enemy[f1] = uf.enemy[f2] = uf.findSet(uf.enemy[f1]);
					uf.enemy[uf.enemy[f1]] = uf.findSet(f1);
					continue;
				}
				if(uf.enemy[f2] != -1)
				{
					uf.enemy[f1] = uf.enemy[f2] = uf.findSet(uf.enemy[f2]);
					uf.enemy[uf.enemy[f1]] = uf.findSet(f1);
				}
					continue;
			}
			
			if(type == 2)
			{
				if(uf.isSameSet(f1, f2))
				{
					sb.append(-1).append("\n");
					continue;
				}
				if(uf.enemy[f1] != -1)
					uf.unionSet(uf.enemy[f1], f2);
				if(uf.enemy[f2] != -1)
					uf.unionSet(uf.enemy[f2], f1);
				f1 = uf.findSet(f1);
				f2 = uf.findSet(f2);
				uf.enemy[f1] = f2;
				uf.enemy[f2] = f1;
				continue;
			}
			
			if(type == 3)
			{
				if(f1 == f2)
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				continue;
			}
			if(uf.enemy[f1] == f2)
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
		}
		System.out.print(sb);
	}
	
	static class UnionFind {                                              
		int[] p, rank, setSize;
		int [] enemy;
		
		
		public UnionFind(int N) 
		{
			 p = new int[N];
			 rank = new int[N];
			 setSize = new int[N];
			 for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1; }
			 enemy = new int [N];
			 Arrays.fill(enemy, -1);
		}
		
		public int findSet(int i) 
		{ 
			if (p[i] == i) return i;
			else return p[i] = findSet(p[i]);
		 }
		
		public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }
		
		public void unionSet(int i, int j) 
		{ 
			 if (isSameSet(i, j)) 
				 return;
			 int x = findSet(i), y = findSet(j);

			 if (rank[x] > rank[y]) { 
				 p[y] = x; setSize[x] += setSize[y]; 
				 }
			 else
			 {	
				 p[x] = y; setSize[y] += setSize[x];
			 	 if(rank[x] == rank[y]) rank[y]++; 
			 } 
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
