import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Uva10382 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		while(s!=null&&s.length()!=0){
			StringTokenizer ns =new StringTokenizer(s);
			int n=Integer.parseInt(ns.nextToken());
			int l=Integer.parseInt(ns.nextToken());
			double w=Double.parseDouble(ns.nextToken());
			Grass []array=new Grass [n];
			for(int i=0;i<n;i++){
				ns=new StringTokenizer(bf.readLine());
				int p=Integer.parseInt(ns.nextToken());
				double x=Double.parseDouble(ns.nextToken());
				double r=Math.sqrt(x*x-(w*w)/4.0);
				array[i]=new Grass(p-r, p+r);
			}
			Arrays.sort(array);
			int i = 0;
            double end = 0;
            int count = 0;
            boolean check = true;
            while (end < l && check) {
                double max = end;
                int j;
                check = false;
                for (j = i; j < n && array[j].left <= end; j++) {
                    check = true;
                    max = Math.max(max, array[j].right);
                }
                if (end != max)
                    count++;
                end = max;
                i = j;
            }
            if (!check)
                out.println(-1);
            else
                out.println(count);
		
			s=bf.readLine();
		}
		out.close();
	}

}

class Grass implements Comparable<Grass>{
	double left;
	double right;
	Grass(double l,double r){
		this.left=l;
		this.right=r;
	}
	public int compareTo(Grass o){
		if(Double.compare(this.left, o.left)!=0)
			return Double.compare(this.left, o.left);
		return Double.compare(this.right, o.right);
	}
}
