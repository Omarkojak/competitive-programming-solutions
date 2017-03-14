package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class CodeforcesA462 {
	static int []dx={1,-1,0,0};
	static int []dy={0,0,1,-1};
	static int n;
	
	public static boolean valid(int r,int c){
		return r>=0&&r<n&&c>=0&&c<n;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		n=Integer.parseInt(bf.readLine());
		char[][]m=new char[n][n];
		for(int i=0;i<n;i++){
			String s=bf.readLine();
			for(int j=0;j<n;j++)
				m[i][j]=s.charAt(j);
			}
		boolean flag=true;
		for(int i=0;i<n&&flag;i++)
			for(int j=0;j<n&&flag;j++){
				int v=0;
				for(int k=0;k<4;k++){
					int rn=i+dx[k];
					int cn=j+dy[k];
					if(valid(rn,cn))
						if(m[rn][cn]=='o')
							v++;
				}
				if(v%2!=0)
					flag=false;
			}
			out.println(flag?"YES":"NO");
			out.close();
	}

}
