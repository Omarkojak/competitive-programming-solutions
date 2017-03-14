import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Uva11742 {
	
	public static boolean nextPermutation(int []a){
		int n=a.length;
		int i=n-1;
		while(i>0&&a[i-1]>=a[i])
			i--;
		if(i<=0)
			return false;
		
		int j=n-1;
		while(a[j]<=a[i-1])
			j--;
		
		int temp=a[j];
		a[j]=a[i-1];
		a[i-1]=temp;
		j=n-1;
		while(i<j){
			temp=a[i];
			a[i]=a[j];
			a[j]=temp;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		while(!s.equals("0 0")){
			StringTokenizer ns = new StringTokenizer(s);
			int n=Integer.parseInt(ns.nextToken());
			int m=Integer.parseInt(ns.nextToken());
			int []array=new int [n];
			for(int i=0;i<n;i++)
				array[i]=i;
			int []a=new int [m];
			int []b=new int [m];
			int []c=new int [m];
			for(int i=0;i<m;i++){
				ns = new StringTokenizer(bf.readLine());
				a[i]=Integer.parseInt(ns.nextToken());
				b[i]=Integer.parseInt(ns.nextToken());
				c[i]=Integer.parseInt(ns.nextToken());
			}
			int times=0;
			do{
				TreeMap<Integer, Integer> mp=new TreeMap<Integer, Integer>();
				for(int i=0;i<n;i++)
					mp.put(array[i],i);
				boolean flag=true;
				for(int i=0;i<m&&flag;i++){
					int p1=mp.get(a[i]);
					int p2=mp.get(b[i]);
					int dist=Math.abs(p1-p2);
					if(c[i]>0){
						if(dist>c[i])
							flag=false;
					}else
						if(dist<-c[i])
							flag=false;
					
				}
				if(flag)
					times++;
			}while(nextPermutation(array));
			out.println(times);
			s=bf.readLine();
		}
		out.close();
		
	}

}
