package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Uva1726_AutomaticCheaterDetection {
	
	public static int binarysearch(ArrayList<Integer> as, int num)
	{
		int res = as.size();
		int low = 0;
		int high = as.size()-1;
		while(low<=high)
		{
			int mid = low + (high - low)/2;
			if(as.get(mid) >= num)
			{
				res = mid;
				high = mid-1;
			}
			else
				low = mid+1;
		}
		
		return res;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int t = in.nextInt();
		while(t-->0)
		{
			int q = in.nextInt();
			ArrayList<Integer> as1 = new ArrayList<>();	//leaked and correct ans 1 1
			ArrayList<Integer> as2 = new ArrayList<>();//notleaked and incorrect ans 0 0
			while(q-->0)
			{
				int diff = in.nextInt();
				int leaked = in.nextInt();
				int corr = (in.next().charAt(0) == 'c')? 1:0; 
				if(leaked == 1 && corr == 1)
					as1.add(diff);
				if(leaked == 0 && corr == 0)
					as2.add(diff);
			}
			Collections.sort(as1);
			Collections.sort(as2);
			long res = 0;
			for(int diff:as1)
			{
				int pos = binarysearch(as2, diff);
				res+=pos;
			}
			sb.append(res).append("\n");	
		}
		System.out.print(sb);
	}
	
	
	
	static class Scanner
	{
		StringTokenizer st;
		BufferedReader bf;
		
		Scanner(InputStream s)
		{
			bf = new BufferedReader(new InputStreamReader(s));
		}
		
		public String next() throws IOException
		{
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(bf.readLine());
			return st.nextToken();
		}
		
		public int nextInt() throws NumberFormatException, IOException
		{
			return Integer.parseInt(next());
		}
		
		public String nextLine() throws IOException
		{
			return bf.readLine();
		}
	}

}
