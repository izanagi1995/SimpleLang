package be.izanagi.simplelang.interpretation;

import java.util.HashMap;

public class InterConstants {
	public static HashMap<String, Class> TYPE_TO_CLASS = new HashMap<String, Class>(){{
		put("string",String.class); put("int", Integer.class);
	}};
	public static HashMap<Class, String> CLASS_TO_TYPE = new HashMap<Class, String>(){{
		put(String.class, "string"); put(Integer.class, "int");
	}};
}
