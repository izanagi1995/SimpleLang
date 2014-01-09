package be.izanagi.simplelang.register;

import java.util.Set;

import be.izanagi.simplelang.ConstGraml;
import be.izanagi.simplelang.exceptions.AlreadyInMemoryException;
import be.izanagi.simplelang.register.variables.AllowedTypes;
import be.izanagi.simplelang.register.variables.SimpleVariable;
import be.izanagi.simplelang.register.variables.VarMemory;

public class SimpleRegister {
	public SimpleRegister(String action, String[] args){
		if(action.equals("var_decl")){
			String type = args[0];
			String name = args[1];
			Object value = args[3];
			Class clazz = AllowedTypes.valueOf(type).getInterpretClass();
			if(ConstGraml.DEBUG){
				System.out.println(clazz.getName());
			}	
			if(clazz.getName().equals("java.lang.Integer")){
				value = new Integer(Integer.parseInt(args[3]));
			}else{
				value = clazz.cast(args[3]);
			}
			SimpleVariable sv = new SimpleVariable(clazz, name, value);
			try {
				VarMemory.pushToMemory(sv);
			} catch (AlreadyInMemoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
