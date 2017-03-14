package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.TreeMap;


public class CodeforcesB1 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
		boolean flag = true;
        String s = bf.readLine();
        if(s.charAt(0)=='R'&&s.charAt(1)>=48&&s.charAt(1)<=57)
        {
            for(int j = 2; j < s.length();j++)
            if(s.charAt(j)=='C'){
            	flag = false;
            	break;
            	}
        }
        if (flag){
            int i;
            for( i = 0; i < s.length(); i++ )
                if( s.charAt(i) >= 48&&s.charAt(i) <= 57 ) break;
            int r = Integer.parseInt(s.substring(i, s.length())), c = 0;
            int p = i - 1;
            for(int j = 0; j < i; j++)
            {
                c+=(s.charAt(j)-64)*Math.pow(26, p);
                p--;
            }
            out.println("R"+r+"C"+c);   
        }
        else
        {
            int i;
            for( i = s.length() - 1; i >= 0 ; i-- )
                if( s.charAt(i)=='C' ) break;
            int c = Integer.parseInt(s.substring(i+1));
            String w = "";
            while ( c != 0)
            {
                int a = c%26;
                if( a == 0)
                {
                    a = 26;
                    c = c / 26 + -1;
                }
                else
                    c/=26;
                w = (char) (a + 64) + w;
            }
            int r = Integer.parseInt(s.substring(1, i));
            out.println(w+r);
        }
    }
		out.close();
	}
	

}
