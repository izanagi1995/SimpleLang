package be.izanagi.simplelang.interpretation;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import be.izanagi.simplelang.ASTAssignation;
import be.izanagi.simplelang.ASTFuncCall;
import be.izanagi.simplelang.ASTStart;
import be.izanagi.simplelang.Node;
import be.izanagi.simplelang.ParseException;
import be.izanagi.simplelang.SimpleNode;
import be.izanagi.simplelang.builtin.functions.Functions;
import be.izanagi.simplelang.memory.MemoryVar;
import be.izanagi.simplelang.memory.single.SimpleVariable;

public class Interpreter {
	public void interpret(ASTStart s) throws ParseException{
		for(int i=0;i<s.jjtGetNumChildren()&&s.jjtGetChild(i)!=null;i++){
			SimpleNode sn = (SimpleNode) s.jjtGetChild(i);
			if (sn instanceof ASTAssignation) {
				interpret((ASTAssignation) sn);
			}else if(sn instanceof ASTFuncCall){
				interpret((ASTFuncCall) sn);
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
		String type=(String) ((SimpleNode)a.jjtGetChild(0)).jjtGetValue();
		String name=(String) ((SimpleNode)a.jjtGetChild(1)).jjtGetValue();
		Object value=((SimpleNode)a.jjtGetChild(2)).jjtGetValue();
		Class c = InterConstants.TYPE_TO_CLASS.get(type);
		SimpleVariable p=new SimpleVariable(name, value, c);
	}
	/**
	 * First child : Func name
	 * Second child : Args
	 * 	Who have children : Each is one arg
	 * @param f
	 */
	public void interpret(ASTFuncCall f){
		ArrayList<Object> args = new ArrayList<Object>();
		String name = (String) ((SimpleNode)f.jjtGetChild(0)).jjtGetValue();
		SimpleNode argsnode = ((SimpleNode)f.jjtGetChild(1));
		for(int i=0;i<argsnode.jjtGetNumChildren();i++){
			args.add(((SimpleNode)argsnode.jjtGetChild(i)).jjtGetValue());
		}
		Object r=Functions.findCorrectAndReturn(name, args.toArray());
	}
	/**
	 * Normally, this function is never called because Java calls always the functions with more precise params first
	 * @param n
	 */
	private void interpret(Node n) {
		System.out.println("Pas normal!... "+n.getClass().toString());
	}
	
}
