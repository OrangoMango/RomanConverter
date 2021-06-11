package com.orangomango.romanconverter;

public enum RomanNumber {
	M(1000, -1, 0),
	CM(900, 1, 3),
	D(500, 1, 1),
	CD(400, 1, 1),
	C(100, 3, 0),
	XC(90, 1, 3),
	L(50, 1, 1),
	XL(40, 1, 1),
	X(10, 3, 0),
	IX(9, 1, 3),
	V(5, 1, 1),
	IV(4, 1, 1),
	I(1, 3, 0);

	private int value;
	private int repeats;
	private int skips;

	private RomanNumber(int v, int r, int s){
		this.value = v;
		this.repeats = r;
		this.skips = s;
	}

	public static int toNumber(String roman){
		int number = 0;
		roman = roman.toUpperCase();
		RomanNumber[] numbers = RomanNumber.values();
		for (int i = 0; i < numbers.length; i++){
			RomanNumber n = numbers[i];
			int repeats = 0;
			while (roman.startsWith(n.name())){
				repeats++;
				if (n.repeats != -1 && repeats > n.repeats){
					throw new IllegalArgumentException("Too many repeats for roman number "+n);
				}
				number += n.value;
				roman = roman.substring(n.name().length());
			}
			if (repeats > 0){
				i += n.skips;
			}
		}
		if (roman.length() > 0){
			throw new IllegalArgumentException("Could not parse all roman number, remaining: "+roman);
		}
		return number;
	}

	public static String toRoman(int number){
		StringBuilder output = new StringBuilder();
		if (number < 0){
			output.append("-");
			number *= -1;
		}
		RomanNumber[] numbers = RomanNumber.values();
		for (int i = 0; i < numbers.length; i++){
			RomanNumber n = numbers[i];
			while (number >= n.value){
				number -= n.value;
				output.append(n.name());
			}
		}
		return output.toString();
	}
}
