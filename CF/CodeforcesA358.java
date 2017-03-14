package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesA358 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		int []a=new int [n];
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(ns.nextToken());
		boolean flag=false;
		for(int i=2;i<n-1&&!flag;i++)
			for(int j=0;j<i&&!flag;j++){
				int min=Math.min(a[i],a[i+1]);
				int max=Math.max(a[i+1], a[i]);
				int minbeg=Math.min(a[j],a[j+1]);
				int maxbeg=Math.max(a[j],a[j+1]);
				if(min>minbeg&&min<maxbeg)
					if(max>maxbeg)
						flag=true;
				
				if(minbeg>min&&minbeg<max)
					if(maxbeg>max)
						flag=true;
			
			}
		out.println(flag? "yes":"no");
		out.close();
	}

}
