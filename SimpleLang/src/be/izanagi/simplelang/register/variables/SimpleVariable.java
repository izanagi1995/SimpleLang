package be.izanagi.simplelang.register.variables;

public class SimpleVariable{
	private Class classe;
	private Object value;
	private String name;
	public SimpleVariable(Class classe, String name, Object value){
		this.classe = classe;
		this.name = name;
		this.value = value;
	}
	public boolean equals(SimpleVariable sv){
		return (this.getName().equals(sv.getName()));
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String toString(){
		return classe + " " + name + " = "+value;
	}
}
