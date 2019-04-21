package jkt.hms.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Shailesh
 * 
 */
public class SqlQueryConverter {
	public static void main(String[] args) throws IOException {

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));

			String input = "";

			while (true) {

				String inc = "";

				input = in.readLine();

				StringTokenizer st = new StringTokenizer(input, "$");
				if (st.hasMoreTokens() && st.countTokens() > 1) {

					while (st.hasMoreTokens()) {
						String parseLine = st.nextToken();
						String extendedLine = "";
						String textToChanged = "";
						String textNotToChanged = "";
						if (parseLine.contains("}")) {
							int fIndex = parseLine.indexOf("}");
							textNotToChanged = parseLine.substring(0, fIndex);
							textNotToChanged = textNotToChanged + "} ";
							if (parseLine.length() > fIndex + 1) {

								textToChanged = parseLine.substring(fIndex + 1)
										.toLowerCase();
							}
							inc = inc + "$" + textNotToChanged + textToChanged;

						} else {

							inc = inc + parseLine.toLowerCase();
						}
					}

					if ("".equals(inc)) {

						break;

					}
				} else {

					inc = input.toLowerCase();

				}

			

			}
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
