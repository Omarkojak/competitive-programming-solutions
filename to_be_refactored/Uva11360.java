package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Uva11360 {
	static int [][]matrix;
	
	public static void row(int a,int b){ 
		for(int i=0;i<matrix[a].length;i++){
			int temp=matrix[a][i];
			matrix[a][i]=matrix[b][i];
			matrix[b][i]=temp;
		}	
	}
	
	public static void col(int a,int b){ 
		for(int i=0;i<matrix.length;i++){
			int temp=matrix[i][a];
			matrix[i][a]=matrix[i][b];
			matrix[i][b]=temp;
		}	
	}
	
	public static void t(){
		for(int i=0;i<matrix.length;i++)
			for(int j=i+1;j<matrix[i].length;j++){
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
	
	}
	public static void inc(){
		for(int i=0;i<matrix.length;i++)
			for(int j=0;j<matrix[i].length;j++){
				int v=(matrix[i][j]+1)%10;
				matrix[i][j]=v;
			}
	}
	
	public static void dec(){
		for(int i=0;i<matrix.length;i++)
			for(int j=0;j<matrix[i].length;j++){
				int v=(matrix[i][j]-1);
				matrix[i][j]=(v==-1)? 9:v;
			}
		
	}
	
	public static  void disp(){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++)
				System.out.print(matrix[i][j]);
		System.out.println();
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out =new PrintWriter(System.out);
		int t=Integer.parseInt(bf.readLine());int num=1;
		while(t-->0){
			int n=Integer.parseInt(bf.readLine());
			matrix=new int [n][n];
			for(int i=0;i<n;i++){
			String s=bf.readLine();
				for(int j=0;j<n;j++){
					matrix[i][j]=Integer.parseInt(s.charAt(j)+"");
				}
			}
			out.printf("Case #%d\n", num++);
			//out.println(1);
			int m=Integer.parseInt(bf.readLine());
			while(m-->0){
				StringTokenizer ns =new StringTokenizer(bf.readLine());String s=ns.nextToken();
				if(s.equals("transpose")) t();
				if(s.equals("row")) row(Integer.parseInt(ns.nextToken())-1,Integer.parseInt(ns.nextToken())-1);
				if(s.equals("col")) col(Integer.parseInt(ns.nextToken())-1,Integer.parseInt(ns.nextToken())-1);
				if(s.equals("inc")) inc();
				if(s.equals("dec")) dec();
			}
			
			//out.println(Arrays.deepToString(matrix));
			for(int i=0;i<matrix.length;i++){
				for(int j=0;j<matrix[i].length;j++)
					out.print(matrix[i][j]);
			out.println();
			}
			
			out.println();
		}
		out.flush();
		out.close();
	}

}
