package be.izanagi.simplelang.memory;

import java.util.ArrayList;

import be.izanagi.simplelang.memory.single.SimpleVariable;

public class MemoryVar {
	private static ArrayList<SimpleVariable> memory=new ArrayList<SimpleVariable>(10);
	public static void put(SimpleVariable e){
		if(memory.contains(e)){
			System.out.println("Insertion of already defined variable!");
		}else{
			memory.add(e);
		}
	}
	public static SimpleVariable getByName(String n){
		for(int i=0;i<memory.size();i++){
			if(memory.get(i).getName().equals(n)){
				return memory.get(i);
			}
		}
		return null;
	}
	public static boolean isVariable(String n){
		return getByName(n)!=null;
	}
}
