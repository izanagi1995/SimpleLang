package be.izanagi.simplelang.register.variables;

import java.util.ArrayList;

import be.izanagi.simplelang.exceptions.AlreadyInMemoryException;
import be.izanagi.simplelang.exceptions.VariableNotFoundException;

public class VarMemory {
	private static ArrayList<SimpleVariable> mem = new ArrayList<SimpleVariable>();
	public static void pushToMemory(SimpleVariable add) throws AlreadyInMemoryException{
		if(!exists(add)){
			mem.add(add);
		}else{
			throw new AlreadyInMemoryException("Variable alreay in memory!!");
		}
	}
	private static boolean exists(SimpleVariable a){
		return mem.contains(a);
	}
	public static SimpleVariable recallFromName(String k) throws VariableNotFoundException{
		for(SimpleVariable sv:mem){
			if(sv.getName().equals(k)){
				return sv;
			}
		}
		throw new VariableNotFoundException("Variable not found");
	}
}
