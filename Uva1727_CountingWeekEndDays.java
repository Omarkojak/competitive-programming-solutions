import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Uva1727_CountingWeekEndDays {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		TreeMap<String, Integer> months =new TreeMap<>();
		months.put("JAN", 31);months.put("FEB", 28);months.put("MAR", 31);months.put("APR", 30);months.put("MAY", 31);months.put("JUN", 30);months.put("JUL", 31);
		months.put("AUG", 31);months.put("SEP", 30);months.put("OCT", 31);months.put("NOV", 30);months.put("DEC", 31);
		
		TreeMap<String, Integer> days =new TreeMap<>();
		days.put("SUN", 1);days.put("MON", 2);days.put("TUE", 3);days.put("WED", 4);days.put("THU", 5);
		days.put("FRI", 6);days.put("SAT", 7);

		while(t-->0)
		{
			StringTokenizer ns = new StringTokenizer(bf.readLine());
			int daysofmonth = months.get(ns.nextToken());
			int currday = days.get(ns.nextToken());
			int ans = 0;
			while(daysofmonth-->0)
			{
				//System.out.println(currday);
				if(currday == 6 || currday == 7)
					ans++;
				
				currday++;
				if(currday == 8)
					currday = 1;
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}

}
