package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Uva10576 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		while(s!=null&&s.length()!=0){
			StringTokenizer ns =new StringTokenizer(s);
			int su=Integer.parseInt(ns.nextToken());
			int d=Integer.parseInt(ns.nextToken());
			int bitch=-1;
			for (int mask = 0; mask < (1 << 12); mask++) {
                int totals = 0;
                boolean flag = true;
                for (int i = 0; i < 12; ++i) {
                    if ((mask & (1 << i)) != 0)
                        totals += su;
                    else
                        totals -= d;
                    if (i + 5 <= 12) {
                        int eachGroup = 0;
                        for (int j = i; j < i + 5; ++j) {
                            if ((mask & (1 << j)) != 0)
                                eachGroup += su;
                            else
                                eachGroup -= d;
                        }
                        if (eachGroup >= 0)
                            flag = false;
                    }
                }
                if (flag)
                    bitch = Math.max(bitch, totals);
            }
			out.println(bitch==-1? "Deficit":bitch);
			s=bf.readLine();
		}
		out.close();
	}

}
