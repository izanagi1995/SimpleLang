package be.izanagi.simplelang.register.variables;

public enum AllowedTypes {
	string(String.class),
	integer(Integer.class);
	
	private Class c;
	AllowedTypes(Class c){
		this.c = c;
	}
	public Class getInterpretClass(){
		return c;
	}
}
