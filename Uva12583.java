import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Uva12583 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int t=Integer.parseInt(bf.readLine());
		int res=1;
		while(t-->0){
			StringTokenizer ns =new StringTokenizer(bf.readLine());
			int n=Integer.parseInt(ns.nextToken());
			int k=Integer.parseInt(ns.nextToken());
			String s=ns.nextToken();
			int count=0;
			for(int i=n-1;i>0;i--){
				char c=s.charAt(i);
				int r=k;
				int j=i-1;
				while(r-->0&&j>=0){
					char w=s.charAt(j--);
					if(w==c){
						count++;
						break;
					}
				}
			}
			
			out.printf("Case %d: %d\n", res++,count);
			
		}
		out.close();
	}

}
