import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva12455 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			int l=Integer.parseInt(bf.readLine());
			int n=Integer.parseInt(bf.readLine());
			StringTokenizer ns =new StringTokenizer(bf.readLine());
			int []a=new int [n];
			for(int i=0;i<n;i++)
				a[i]=Integer.parseInt(ns.nextToken());
			boolean flag=false;
			
			for(int i=0;i<(1<<n);i++){
				int sum=0;
				for(int j=0;j<n;j++)
					if((i &(1 << j))>0)
						sum+=a[j];
					
				if(sum==l)
					flag=true;
						
			}
			System.out.println(flag? "YES":"NO");
			
		}
		
		
	}

}
