package be.izanagi.simplelang.builtin.functions;

import java.util.Arrays;

import be.izanagi.simplelang.memory.MemoryVar;

public class Functions {
	public static Object findCorrectAndReturn(String lbl, Object[] args){
		if(lbl.equals("echo")){
			StringBuilder a = new StringBuilder();
			//String[] stringArgs = Arrays.copyOf(args, args.length, String[].class);
			for(Object b:args){
				a.append(b);
			}
			echo(a.toString(), a.toString().startsWith("\"")&&a.toString().endsWith("\""));
			a = null;
			return null;
		}
		return null;
	}
	public static void echo(String a, boolean trueLit){
		if(!trueLit){
			if(MemoryVar.isVariable(a)){
				System.out.println(MemoryVar.getByName(a).getValue());
			}else{
				System.err.println("Variable unknown");
			}
		}else{
			System.out.println(a.substring(1, a.length()-1));
		}
		return;
	}
}
