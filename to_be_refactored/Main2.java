package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main2 {

	public static void shuffle(int []a){
		int n=a.length;
		for(int i=0;i<n;i++){
			int r=i+(int)(Math.random()*(n-i));
			int temp=a[i];
			a[i]=a[r];
			a[r]=temp;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int []a=new int [n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		int m=in.nextInt();
		int b[]=new int [m];
		for(int j=0;j<m;j++)
			b[j]=in.nextInt();
			
		shuffle(a);shuffle(b);
		Arrays.sort(a);Arrays.sort(b);
		if(a[n-1]<=b[0]){
			if(n<m){
			System.out.printf("%d:%d\n",n*2,m*2);
			}else{
				System.out.printf("%d:%d\n",n*3,m*3);
			}
			return ;
		}
		int d=a[0]-1;
		int ans1=n*3;
		int ans2=0;
		for(int i=0;i<m;i++)
			if(b[i]<=d)
				ans2+=2;
			else
				ans2+=3;
		
		System.out.printf("%d:%d\n",ans1,ans2);
		
		int d2=a[0];
		//int ans1=n*3;
		int ans11=(n-1)*3+2;
		int ans22=0;
		for(int i=0;i<m;i++)
			if(b[i]<=d2)
				ans22+=2;
			else
				ans22+=3;
		if(ans11-ans22>ans1-ans2){
			System.out.printf("%d:%d\n",ans11,ans22);
			return;

		}

		if(ans11-ans22<ans1-ans2){
			System.out.printf("%d:%d\n",ans1,ans2);
			return;

		}
			if(ans11>ans1)
			System.out.printf("%d:%d\n",ans11,ans22);
			else
				System.out.printf("%d:%d\n",ans1,ans2);

		
	}
	
	static class Fruit implements Comparable<Fruit>{
		int a;int b;
		Fruit(int x,int y){
			a=x;
			y=b;
		}
		@Override
		public int compareTo(Fruit o) {
			// TODO Auto-generated method stub
			if(a!=o.a)
				return a-o.a;
			
			return o.b-b;
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
