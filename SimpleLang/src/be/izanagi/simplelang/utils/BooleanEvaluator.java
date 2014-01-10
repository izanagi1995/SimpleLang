package be.izanagi.simplelang.utils;

import be.izanagi.simplelang.ConstGraml;
import be.izanagi.simplelang.register.variables.SimpleVariable;
import be.izanagi.simplelang.register.variables.VarMemory;

public class BooleanEvaluator {
	public static boolean evaluate(String s){
		if(s.contains("==")){
			String left = s.split("==")[0].trim();
			String right = s.split("==")[1].trim();
			if(ConstGraml.DEBUG){
				System.out.println(left+ " AND "+right);
			}
			SimpleVariable vl = VarMemory.isVariable(left);
			SimpleVariable vr = VarMemory.isVariable(right);
			Object cl = null;
			Object cr = null;
			if(vl!=null){
				if(ConstGraml.DEBUG){
					System.out.println("Vl is variable");
				}
				cl = vl.getValue();
			}else{
				try{
					cl = new Integer(Integer.parseInt(left));
					if(ConstGraml.DEBUG){
						System.out.println(cl + " is a number");
					}
				}catch(NumberFormatException e){
					cl = left;
					if(ConstGraml.DEBUG){
						System.out.println(cl + " is a string");
					}
				}
			}
			if(vr!=null){
				if(ConstGraml.DEBUG){
					System.out.println("Vr is variable");
				}
				cr = vr.getValue();
			}else{
				try{
					cr = new Integer(Integer.parseInt(right));
					if(ConstGraml.DEBUG){
						System.out.println(cr + " is a number");
					}
				}catch(NumberFormatException e){
					cr = right;
					if(ConstGraml.DEBUG){
						System.out.println(cr + " is a string");
					}
				}
			}
			return cl.equals(cr);
			
		}
		return false;
	}
}
