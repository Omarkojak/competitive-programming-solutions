package cp2_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva11402_AhoyPirates {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		//PrintWriter out = new PrintWriter(System.out);
		StringBuilder out = new StringBuilder();
		int t = in.nextInt();	int cse=1;
		while(t-->0)
		{
			int m = in.nextInt();
			ArrayList<String> as =new  ArrayList<>();
			int n =0;
			while(m-->0)
			{
				int k = in.nextInt();
				String s = in.nextLine();
				n+=s.length()*k;
				while(k-->0)
					as.add(s);
			}
			int N = 1;
			while(N < n) N<<=1;
			int [] pirates= new int [N+1];
			int asidx = 0;
			int stringidx = 0;
			String last = as.get(asidx);
			int l = last.length();
			for(int i=1;i<=n;i++,stringidx++){
				if(stringidx == l)
				{
					stringidx =0;
					asidx++;
					last = as.get(asidx);
					l = last.length();
				}
				pirates[i] = last.charAt(stringidx) -'0';
			}

			SegmentTree st = new SegmentTree(pirates);
			int q=in.nextInt();
			out.append("Case "+ cse++ +":\n");
			int k=1;
			while(q-->0)
			{
				char op = in.next().charAt(0);
				int x1 = in.nextInt()+1;
				int x2 = in.nextInt()+1;
				if(op == 'S')
				{
					out.append("Q"+ k++ +": "+st.query(x1, x2)+"\n");
					continue;
				}
				st.update_range(x1, x2, op);
			}
		
		}
		System.out.print(out);
	}
	
	static class SegmentTree{
		int N; 			//the number of elements in the array as a power of 2 (i.e. after padding)
		int[] array;
		int[] sTree;
		char [] lazy; 
		
		SegmentTree(int[] in)		
		{
			array = in; N = in.length - 1;
			sTree = new int[N<<1];		//no. of nodes = 2*N - 1, we add one to cross out index zero
			lazy = new char [N<<1];
			build(1,1,N);
		}
		
		void build(int node, int b, int e)	// O(n)
		{
			if(b == e)	
			{
				sTree[node] = array[b];
			}	
			else						
			{
				int mid = (b+e) >> 1;
				build(node<<1,b,mid);
				build((node<<1) | 1,mid+1,e);
				sTree[node] = sTree[node<<1] + sTree[(node<<1) | 1];
			}
		}
		
		void update_range(int i, int j, char op)		// O(log n) 
		{
			update_range(1,1,N,i,j, op);
		}
		
		void update_range(int node, int b, int e, int i, int j, char op)
		{
			if(i > e || j < b)		
				return;
			if(b >= i && e <= j)		
			{
				update_lazy(node, op);
				update_opr(node, b, e, op);
			}							
			else		
			{
				propagate(node, b, e);
				int mid = (b+e) >> 1;
				update_range(node<<1,b,mid,i,j,op);
				update_range((node<<1) | 1,mid+1,e,i,j,op);
				sTree[node] = sTree[node<<1] + sTree[(node<<1) | 1];		
			}
			
		}
		
		void update_lazy(int node ,char op)
		{
			if(op==' ')
				return;
			if(op=='I')
			{
				switch(lazy[node])
				{
				case 'F':lazy[node] = 'E';break;
				case 'E':lazy[node] = 'F';break;
				case 'I':lazy[node] = ' ';break;
					default:lazy[node] = 'I';
				}
			}
			else
				lazy[node] = op;
		}
		
		void update_opr(int node, int b,int e, char op)
		{
			switch(op)
			{
			case 'F': sTree[node] = (e-b+1); break;
			case 'E': sTree[node] = 0; break;
			case 'I': sTree[node] = (e-b+1) - sTree[node];	break;
			default : return;
			}
		}
		
		void propagate(int node, int b, int e)		
		{
			if(lazy[node] == ' ')
				return;
			
			int mid = (b+e) >> 1;
			update_lazy(node<<1, lazy[node]);
			update_lazy((node<<1)|1, lazy[node]);
			update_opr(node<<1, b, mid, lazy[node]);
			update_opr((node<<1)|1, mid+1, e, lazy[node]);
			lazy[node] = ' ';
		}
		
		int query(int i, int j)
		{
			return query(1,1,N,i,j);
		}
		
		int query(int node, int b, int e, int i, int j)	// O(log n)
		{
			if(i>e || j <b)
				return 0;		
			if(b>= i && e <= j)
				return sTree[node];
			
			propagate(node, b, e);
			int mid = (b+e) >> 1;
			int q1 = query(node<<1,b,mid,i,j);
			int q2 = query((node<<1) | 1,mid+1,e,i,j);
			
			return q1+q2;	
					
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
