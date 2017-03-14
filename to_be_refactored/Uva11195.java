package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva11195 {
	static int [][]dp;
	static char[][]m;
	
	public static int eval(int r,int c){
		if (c==8)
			return 0;
		
		if(dp[r][c]!=-1)
			return dp[r][c];
		
		
		return 0;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		int c=1;
		while(n!=0){
			dp=new int[n][n];
			m=new char[n][n];
			
			for(int i=0;i<n;i++){
				StringTokenizer ns = new StringTokenizer(bf.readLine());
				for(int j=0;j<n;j++){
					m[i][j]=ns.nextToken().charAt(0);
					dp[i][j]=-1;
				}
			}
			int sum=0;
			for(int i=0;i<n;i++)
				sum+=eval(i,0);
			
			System.out.println("Case "+c+": "+sum);
			c++;
			n=Integer.parseInt(bf.readLine());
		}
		
		
		
	}

}
