package be.izanagi.simplelang.builtin.functions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import be.izanagi.simplelang.interpretation.InterConstants;

public class Functions {
	public static Object findCorrectAndReturn(String lbl, Object[] args){
		Class[] classes = new Class[args.length];
		for(int i=0;i<args.length;i++){
			classes[i] = args[i].getClass();
		}
		try {
			Method m = Functions.class.getMethod(lbl, classes);
			Object ret = m.invoke(null, args);
			return ret;
		} catch (NoSuchMethodException e) {
			System.err.print("Method not found : "+lbl+"(");
			for(Class clazz:classes){
				System.err.print(InterConstants.CLASS_TO_TYPE.get(clazz)+ ", ");
			}
			System.err.println(")");
			return null;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			System.err.println("Security exception "+e.getCause());
			System.exit(-1);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.err.println("Illegal Access : "+e.getCause());
			System.exit(-1);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.err.println("Illegal Args (Java-Sided) : "+e.getCause());
			System.exit(-1);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			System.err.println("Function exception : "+e.getCause());
			System.exit(-1);
		}
		return null;
	}
	/*
	public static void echo(String a){
		if(a.startsWith("\"")&&(a.endsWith("\""))){
			System.out.println(a.substring(1, a.length()-1));
		}else if(MemoryVar.isVariable(a)){
			System.out.println(MemoryVar.getByName(a).getValue());
		}else{
			System.err.println("Variable unknown");
		}
		
		return;
	}
	*/
	public static void echo(Integer a){
		System.out.println(a);
	}
	public static int exempleMath(Integer a, Integer b){
		return a+b;
	}
}
