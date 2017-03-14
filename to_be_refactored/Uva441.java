package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva441 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s=bf.readLine();
		while(!s.equals("0")){
			StringTokenizer ns = new StringTokenizer(s);
			int n=Integer.parseInt(ns.nextToken());
			int []a= new int [n];
			for(int i=0;i<n;i++)
				a[i]=Integer.parseInt(ns.nextToken());
			
			for(int i=0;i<=n-6;i++)
				for(int j=i+1;j<=n-5;j++)
					for(int k=j+1;k<=n-4;k++)
						for(int w=k+1;w<=n-3;w++)
							for(int o=w+1;o<=n-2;o++)
								for(int f=o+1;f<=n-1;f++)
									System.out.println(a[i]+" "+a[j]+" "+a[k]+" "+a[w]+" "+a[o]+" "+a[f]);


			
			
			s=bf.readLine();
			if(!s.equals("0"))
				System.out.println();
		}
		
		
		
	}

}
