package be.izanagi.simplelang.memory.single;

import be.izanagi.simplelang.memory.MemoryVar;

public class SimpleVariable {
	private Class type;
	private String name;
	private Object value;
	
	/**
	 * Constructor witout class, using the value's class
	 * @param name
	 * @param value
	 */
	public SimpleVariable(String name, Object value){
		this.name = name;
		this.type = value.getClass();
		this.value = value;
		MemoryVar.put(this);
	}
	public SimpleVariable(String name, Object value, Class c){
		this.name = name;
		this.type = c;
		this.value = value;
		MemoryVar.put(this);
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Class getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SimpleVariable){
			SimpleVariable e = (SimpleVariable)obj;
			return e.name.equals(this.name);
		}
		return false;
	}
	

}
