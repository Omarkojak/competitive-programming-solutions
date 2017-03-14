package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Uva11988 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		while(s!=null&&s.length()!=0){
			LinkedList<String> words = new LinkedList<String>();
			int i = 0, j = 0;char last = ']';
			while(j < s.length()){
				if(s.charAt(j)=='['){
					String word = s.substring(i,j);
					if(last==']')
						words.addLast(word);
					else
						words.addFirst(word);
					last = '[';
					i = j + 1;
				}
				else
					if(s.charAt(j)==']'){
						String word = s.substring(i,j);
						if(last==']')
							words.addLast(word);
						else
							words.addFirst(word);
						last = ']';
						i = j + 1;
					}
				j++;
			}
			String word = s.substring(i,j);
			if(last==']')
				words.addLast(word);
			else
				words.addFirst(word);
			StringBuilder sb = new StringBuilder();
			while(!words.isEmpty())
				sb.append(words.remove());
			out.println(sb);
			s=bf.readLine();
		}
		out.close();
		}
	}


