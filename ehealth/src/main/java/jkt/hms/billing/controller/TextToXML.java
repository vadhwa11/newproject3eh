package jkt.hms.billing.controller;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TextToXML {
	public static void main(String arg[]) {
		try {
			String text[] = new String[10];
			try {
				FileOutputStream fout = new FileOutputStream(
						"C:/Documents and Settings/ritu/Desktop/TextToXML.xml");
				OutputStreamWriter out = new OutputStreamWriter(fout);
				InputStreamReader in = new InputStreamReader(System.in);
				BufferedReader bin = new BufferedReader(in);
				for (int i = 0; i < 10; i++) {
					text[i] = bin.readLine();
				}
				out.write("<?xml version=\"1.0\"?>\r\n");
				out.write("<Root>\r\n");
				for (int i = 0; i < 10; i++) {
					out.write("  <child" + i + ">" + i + ":" + text[i]
							+ "</child" + i + ">");
				}
				out.write("</Root>");
				out.close();
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
