package be.izanagi.simplelang.utils;

public class SimpleMath {

	public static Integer interpret(String value, String matchPattern) {
		switch(matchPattern){
			case "math_plus": return domath("\\+", value, "pl");
			case "math_minus": return domath("-", value, "mi");
			case "math_prod": return domath("\\*", value, "pr");
			case "math_div": return domath("/", value, "di");
			default: return null;
		}
		
	}

	private static Integer domath(String pattern, String value, String op) {
		int one = Integer.parseInt(value.split(pattern)[0].trim());
		int two = Integer.parseInt(value.split(pattern)[1].trim());
		switch(op){
			case "pl": return one+two;
			case "mi": return one-two;
			case "pr": return one*two;
			case "di": return one/two;
			default: return null;
		}
	}

}
