package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesA507 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(ns.nextToken());
		int k=Integer.parseInt(ns.nextToken());
		int []a=new int [n];
		ns=new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(ns.nextToken());
		
		String r="";
		int taken=0;
		int tokens=0;
		for(int i=0;i<n;i++){
			int min=a[0];
			int minind=0;
			for(int j=1;j<n;j++){
				if(a[j]<min){
					min=a[j];
					minind=j;
				}
			}
			
			if(k>=min){
			k-=min;
			r+=(minind+1)+" ";
			a[minind]=200;
			tokens++;
			}else
				break;
		}
		out.println(tokens);
		if(tokens>0){
			out.println(r.substring(0, r.length()-1));
		}
		out.close();
	}

}
