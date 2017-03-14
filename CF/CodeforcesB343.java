package CF;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;


public class CodeforcesB343 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out =new PrintWriter(System.out);
		String s=bf.readLine();
		Stack<Character> st=new Stack<Character>();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(!st.isEmpty()&&st.peek()==c)
				st.pop();
			else
				st.push(c);
		}
		out.println(st.isEmpty()?"Yes":"No");
		out.flush();
		out.close();
	}

}
