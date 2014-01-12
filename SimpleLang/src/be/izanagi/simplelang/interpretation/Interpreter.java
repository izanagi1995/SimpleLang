package be.izanagi.simplelang.interpretation;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import be.izanagi.simplelang.ASTAssignation;
import be.izanagi.simplelang.ASTStart;
import be.izanagi.simplelang.Node;
import be.izanagi.simplelang.ParseException;
import be.izanagi.simplelang.SimpleNode;

public class Interpreter {
	public void interpret(ASTStart s) throws ParseException{
		for(int i=0;i<s.jjtGetNumChildren()&&s.jjtGetChild(i)!=null;i++){
			SimpleNode sn = (SimpleNode) s.jjtGetChild(i);
			if (sn instanceof ASTAssignation) {
				interpret((ASTAssignation) sn);
			}else{
				interpret(sn);
			}
		}
	}
	/**
	 * In this function, we are sure of the children's number
	 * <TYPE> <VNAME> = < CONTENT > => 3
	 * @param a
	 */
	public void interpret(ASTAssignation a){
		System.out.println("Assignator");
		String type=(String) ((SimpleNode)a.jjtGetChild(0)).jjtGetValue();
		String name=(String) ((SimpleNode)a.jjtGetChild(1)).jjtGetValue();
		Object value=((SimpleNode)a.jjtGetChild(2)).jjtGetValue();
		System.out.println(type+" "+name+ " = "+value);
		
	}
	/**
	 * Normally, this function is never called because Java calls always the functions with more precise params first
	 * @param n
	 */
	private void interpret(Node n) {
		System.out.println("Pas normal!... "+n.getClass().toString());
	}
	
}
