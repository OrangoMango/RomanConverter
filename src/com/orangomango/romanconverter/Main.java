package com.orangomango.romanconverter;

import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{
		System.out.print("Select mode:\n[1] Roman Number -> Decimal Number\n[2] Decimal Number -> Roman Number\n------------------\n: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		if (input.equals("1")){
			System.out.print("Input: ");
			String r = reader.readLine();
			System.out.format("---------\nConverted %s in %s\n", r, RomanNumber.toNumber(r));
		} else if (input.equals("2")){
			System.out.print("Input: ");
			int i = Integer.parseInt(reader.readLine());
			System.out.format("---------\nConverted %s in %s\n", i, RomanNumber.toRoman(i));
		} else {
			throw new IllegalArgumentException("Only '1' and '2' allowed");
		}
  }
}
