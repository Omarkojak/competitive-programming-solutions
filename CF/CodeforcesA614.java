package CF;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class CodeforcesA614 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		long l=Long.parseLong(ns.nextToken());
		long r=Long.parseLong(ns.nextToken());
		long pow=Long.parseLong(ns.nextToken());
		StringBuilder sb=new StringBuilder();
		ArrayList<BigInteger> as=new ArrayList<BigInteger>();
		if(1>=l&&1<=r)
			as.add(new BigInteger("1"));
		BigInteger now=new BigInteger(pow+"");
		BigInteger beg=new BigInteger(l+"");
		BigInteger end=new BigInteger(r+"");
		BigInteger po=new BigInteger(pow+"");
		while(now.compareTo(end)<=0){
		if(now.compareTo(beg)>=0)
			as.add(now);
		now=now.multiply(po);
		}
		if(as.size()==0)
			out.println(-1);
		else{
			for(int i=0;i<as.size()-1;i++)
				out.print(as.get(i)+" ");
				
			out.print(as.get(as.size()-1)+"\n");
		}		
		out.flush();
		out.close();
	}
}
