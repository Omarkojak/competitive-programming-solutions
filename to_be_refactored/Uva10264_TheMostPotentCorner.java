package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uva10264_TheMostPotentCorner {

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String s=bf.readLine();
		int []pow=new int [16];
		pow[1]=2;
		for(int i=2;i<16;i++)
			pow[i]=2*pow[i-1];
		//System.out.println(Arrays.toString(pow));
		while(s!=null&&s.length()!=0){
			int n=Integer.parseInt(s);
			int l=pow[n];
			int []a=new int [l];			
			for(int i=0;i<l;i++)
				a[i]=Integer.parseInt(bf.readLine());
			int []sum=new int [l];
			for(int i=0;i<l;i++)
				for(int k=0;k<n;k++){
					int index=(1<<k)^i;
					//System.out.println(index);
					sum[i]+=a[index];
				}
			int max=0;	
			for(int i=0;i<l;i++)
				for(int k=0;k<n;k++){
					int index=(1<<k)^i;
					//System.out.println(index);
					max=Math.max(max,sum[i]+sum[index]);
				}
			sb.append(max+"\n");
			s=bf.readLine();
		}
		System.out.print(sb);
	}

}
