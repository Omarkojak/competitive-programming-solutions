package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Uva725 {
	
	public static boolean checkdupli(int x,int y){
		String s1=x+"";
		String s2=y+"";
		if(s1.length()==4)
			s1="0"+s1;
		if(s2.length()==4)
			s2="0"+s2;
		int []a=new int [10];
		int w;
		for(int i=0;i<5;i++){
			w=Integer.parseInt(s1.charAt(i)+"");
			a[w]++;
			w=Integer.parseInt(s2.charAt(i)+"");
			a[w]++;
		}
		for(int i=0;i<10;i++)
			if(a[i]>1)
				return true;
		
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N =Integer.parseInt(bf.readLine());
		while(N!=0){
			int []a=new int [100005];
			int []b=new int [100005];
			int c=0;
			
			for(int a1=1234;a1<=98765;a1++){
				int b1=a1*N;
				if(b1>100000)
					break;
				
				if(checkdupli(b1,a1))
					continue;
				else{
					a[c]=a1;
					b[c]=b1;
					c++;
				}
					
			}
			
			if(c==0)
				System.out.println("There are no solutions for "+N+".");
			else{
				for(int i=0;i<c;i++){
					String s1=b[i]+"";
					String s2=a[i]+"";
					if(s1.length()==4)
						s1="0"+s1;
					if(s2.length()==4)
						s2="0"+s2;
					System.out.println(s1+" / "+s2+" = "+N);
				}
			}
			N=Integer.parseInt(bf.readLine());
			if(N!=0)
				System.out.println();
		}
		
		
	}

}
