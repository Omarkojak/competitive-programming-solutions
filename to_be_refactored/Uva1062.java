package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

public class Uva1062 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s=bf.readLine();int num=1;
		while(!s.equals("end")){
			ArrayList<Stack<Character>>as=new ArrayList<Stack<Character>>();
			int prev=0;
			for(int i=0;i<s.length();i++){
				int k=0;char c=s.charAt(i);
				while(k<prev&&c>as.get(k).peek())
					k++;
				if(k==prev){
					Stack<Character>st=new Stack<Character>();st.add(c);
					as.add(st);
					prev++;
				}else
					as.get(k).add(c);
				
			}
			out.printf("Case %d: %d\n",num++ ,as.size());
			s=bf.readLine();
		}
		out.flush();
		out.close();
	}

}
