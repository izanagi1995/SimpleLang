package be.izanagi.simplelang.interpretation;

import java.util.HashMap;

public class InterConstants {
	public static HashMap<String, Class> TYPE_TO_CLASS = new HashMap<String, Class>(){{
		put("string",String.class); put("integer", Integer.class);
	}};
}
