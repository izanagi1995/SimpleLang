package be.izanagi.simplelang;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		pattern.put("[ \t\n\r\f]*[a-zA-Z]+( )+[a-zA-Z]+( )*=( )*[^=]+", "var_decl");
		pattern.put("[ \t\n\r\f]*[a-zA-Z]+( )*=( )*[^=]+", "var_upgrade");
		pattern.put("[ \t\n\r\f]*echo( )+.+", "echo");
		pattern.put("[ \t\n\r\f]*recall( )+[a-zA-Z]+", "recall");
		pattern.put("[ \t\n\r\f]*( )*[0-9]+( )?\\+( )?[0-9]+", "math_plus");
		pattern.put("[ \t\n\r\f]*( )*[0-9]+( )?-( )?[0-9]+", "math_minus");
		pattern.put("[ \t\n\r\f]*( )*[0-9]+( )?\\*( )?[0-9]+", "math_prod");
		pattern.put("[ \t\n\r\f]*( )*[0-9]+( )?/( )?[0-9]+", "math_div");
		pattern.put("^[ \t\n\r\f]*if .+ do$", "if_statment");
		pattern.put("^[ \t\n\r\f]*end$", "end");
	}
	public static Set<String> getPatterns(){
		return pattern.keySet();
	}
	public static String matchPattern(String ln){
		for(Map.Entry<String, String> ent:pattern.entrySet()){
			Pattern p = Pattern.compile(ent.getKey());
			Matcher m = p.matcher(ln);
			if(m.matches()){
				return ent.getValue();
			}
		}
		return null;
	}
}
