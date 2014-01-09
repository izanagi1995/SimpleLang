package be.izanagi.simplelang;

import java.util.HashMap;
import java.util.Set;

public class ConstGraml {
	public final static boolean DEBUG = false;
	private static HashMap<String, String> pattern = new HashMap<String, String>();
	public static void addToken(String pat, String type){
		pattern.put(pat, type);
	}
	public static String actionFromPattern(String pat){
		return pattern.get(pat);
	}
	public static void init(){
		pattern.put("[a-zA-Z]+( )+[a-zA-Z]+( )*=( )*.+", "var_decl");
		pattern.put("[a-zA-Z]+( )*=( )*.+", "var_upgrade");
		pattern.put("echo( )+[a-zA-Z]+", "echo");
		pattern.put("recall( )+[a-zA-Z]+", "recall");
		pattern.put("[0-9]+( )+\\+( )+[0-9]+", "math_plus");
		pattern.put("[0-9]+( )+-( )+[0-9]+", "math_minus");
		pattern.put("[0-9]+( )+\\*( )+[0-9]+", "math_prod");
		pattern.put("[0-9]+( )+/( )+[0-9]+", "math_div");
		pattern.put("[0-9A-Za-z]", "unitary_value");
	}
	public static Set<String> getPatterns(){
		return pattern.keySet();
	}
}
