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
		pattern.put("echo( )+[a-zA-Z]+", "echo");
		pattern.put("recall( )+[a-zA-Z]+", "recall");
	}
	public static Set<String> getPatterns(){
		return pattern.keySet();
	}
}
