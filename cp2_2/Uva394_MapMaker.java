package cp2_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Uva394_MapMaker {

	public static void main(String[] args) throws IOException {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in))) {
			String input;
			StringTokenizer data;
			Map<String, int[]> constantsMap = new HashMap<>();

			while ((input = reader.readLine()) != null && input.length() > 0) {
				data = new StringTokenizer(input);
				int arraysNumber = Integer.parseInt(data.nextToken());
				int refsNumber = Integer.parseInt(data.nextToken());

				for (int i = 0; i < arraysNumber; i++) {
					data = new StringTokenizer(reader.readLine());
					String arrayName = data.nextToken();
					int b = Integer.parseInt(data.nextToken());
					int cD = Integer.parseInt(data.nextToken());
					int d = Integer.parseInt(data.nextToken());
					int[] l = new int[d];
					int[] u = new int[d];

					for (int j = 0; j < d; j++) {
						l[j] = Integer.parseInt(data.nextToken());
						u[j] = Integer.parseInt(data.nextToken());
					}
					Struct struct = new Struct(b, d, l, u, cD);
					constantsMap.put(arrayName, struct.getConstants());
				}

				for (int i = 0; i < refsNumber; i++) {
					data = new StringTokenizer(reader.readLine());
					String arrayName = data.nextToken();
					StringBuilder builder = new StringBuilder(arrayName)
							.append("[");
					String separator = "";
					int[] constants = constantsMap.get(arrayName);
					int[] refs = new int[constants.length];
					refs[0] = 1;

					for (int j = 1; j < refs.length; j++) {
						refs[j] = Integer.parseInt(data.nextToken());
						builder.append(separator).append(refs[j]);
						separator = ", ";
					}
					builder.append("] = ");
					int result = 0;

					for (int j = 0; j < constants.length; j++) {
						result += constants[j] * refs[j];
					}
					builder.append(result);
					System.out.println(builder.toString());
				}
			}
		}
	}

	private static class Struct {
		private int b; // base address of the array
		private int d; // number of dimensions in the array
		private int[] l; // lower bound of dimension d
		private int[] u; // upper bound of dimension d
		private int cD; // array element size in bytes
		private int[] c; // result constants

		public Struct(int baseAddress, int dimensionsNumber,
				int[] lowerDimensionBound, int[] upperDimensionBound,
				int arrayElementSize) {
			this.b = baseAddress;
			this.d = dimensionsNumber;
			this.l = lowerDimensionBound;
			this.u = upperDimensionBound;
			this.cD = arrayElementSize;
		}

		public int[] getConstants() {
			c = new int[d + 1];
			c[d] = cD;

			for (int i = d - 1; i > 0; i--) {
				c[i] = c[i + 1] * (u[i] - l[i] + 1);
			}

			c[0] = b;

			for (int i = 1; i <= d; i++) {
				c[0] -= c[i] * l[i - 1];
			}
			return c;
		}
	}
}