package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class CodeforcesD611 {
	static String s;
	
	public static int count(int n,int i){
		int copy=n;
		n-=i;
		int r=0;
		if(n%2!=0)
			r+=n/2;
		else{
			int x=n/2;
			int h1=Integer.parseInt(s.substring(i, i+x));
			int h2=Integer.parseInt(s.substring(i+x, copy));
			if(h1>=h2)
				x--;
			r+=x;
		}
		return r;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		s=bf.readLine();
		int cnt=1;
		int f=Integer.parseInt(s.charAt(0)+"");
		for(int i=1;i<n;i++){
			int now=Integer.parseInt(s.charAt(i)+"");
			if(now>f){
				f=now;
				cnt++;
			}else
				break;
		}
		//out.println(cnt);
		int r=1;
			
			for(int i=0;i<cnt;i++){
				if(i+1<n&&s.charAt(i+1)=='0')
					i++;
				int x=count(n,i);
				//out.println(i+" "+x);
				r+=x;
			}
		if(cnt==n&&n!=1)
			r--;
		out.println(r);
		out.close();
	}

}
