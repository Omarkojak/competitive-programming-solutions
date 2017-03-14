package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;


public class Uva514 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		while(n!=0){
			String s=bf.readLine();
			while(!s.equals("0")){
				StringTokenizer ns =new StringTokenizer(s);
				int []a=new int [n];Stack<Integer> st=new Stack<Integer>();
				for(int i=0;i<n;i++)
					a[i]=Integer.parseInt(ns.nextToken());
				int c=1;
				while(c<a[0]){
					st.add(c++);
				}
				if(c==n){
					int i=1;boolean flag=true;
					while(!st.isEmpty()&&flag){
						if(st.pop()!=a[i])
							flag=false;
						i++;
					}
					out.println(flag? "Yes":"No");
				}else{
					c++;
					int i=1;boolean flag=true;
					while(i<n&&flag){
						while(c<a[i]){
							st.add(c++);
						}
						if(a[i]!=c&&a[i]!=st.peek())
							flag=false;
						if(a[i]==c){i++;c++;}
						
						else if(a[i]==st.peek()){st.pop();i++;}
					}
					
						out.println(flag? "Yes":"No");
				}
				
				s=bf.readLine();
			}
			n=Integer.parseInt(bf.readLine());
				out.println();
		}
		out.close();
	}

}
