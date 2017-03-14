package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesB611 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		long a=Long.parseLong(ns.nextToken());
		long b=Long.parseLong(ns.nextToken());
		int r=0;
		int prev=0;
		for(long i=a;i<=b;){
			long cnt=0;
			long copy=i;
			long times=0;
			while(copy>0){
				times++;
				 if(0 == (copy&1))
					cnt++;
				 copy >>= 1;
			}
			if(cnt==1){
				i++;
				r++;
			}else
				if(cnt>2)
					i+=cnt;
				else
					if(cnt==0)
						i+=times+1;
					else
						i++;
			
			
		}
		out.println(r);
		out.close();
	}

}
