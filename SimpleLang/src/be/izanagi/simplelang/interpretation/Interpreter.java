package be.izanagi.simplelang.interpretation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import be.izanagi.simplelang.ASTAdd;
import be.izanagi.simplelang.ASTArgs;
import be.izanagi.simplelang.ASTAssignation;
import be.izanagi.simplelang.ASTDeclaration;
import be.izanagi.simplelang.ASTFactor;
import be.izanagi.simplelang.ASTFuncCall;
import be.izanagi.simplelang.ASTFuncDecl;
import be.izanagi.simplelang.ASTFuncName;
import be.izanagi.simplelang.ASTIfBlock;
import be.izanagi.simplelang.ASTIntBoolean;
import be.izanagi.simplelang.ASTNumber;
import be.izanagi.simplelang.ASTReturns;
import be.izanagi.simplelang.ASTStart;
import be.izanagi.simplelang.ASTStringBoolean;
import be.izanagi.simplelang.ASTStringLit;
import be.izanagi.simplelang.ASTTerm;
import be.izanagi.simplelang.ASTType;
import be.izanagi.simplelang.ASTTypedArgs;
import be.izanagi.simplelang.ASTVarName;
import be.izanagi.simplelang.ASTWhileBlock;
import be.izanagi.simplelang.Node;
import be.izanagi.simplelang.ParseException;
import be.izanagi.simplelang.SimpleNode;

public class Interpreter {
	
	public Object dispatch(Node a){
			Method method;
			try {
				method = getClass().getMethod("interpret", a.getClass());
				return method.invoke(this, a);
			} catch (NoSuchMethodException e) {
				interpret((SimpleNode) a);
			} catch (SecurityException e) {
				System.err.println("Security of "+a.getClass());
				System.exit(1);
			} catch (IllegalAccessException e) {
				System.err.println("Access of "+a.getClass());
				System.exit(1);
			} catch (IllegalArgumentException e) {
				System.err.println("Args of "+a.getClass());
				System.exit(1);
			} catch (InvocationTargetException e) {
				System.err.println("Invocation of "+a.getClass());
				e.printStackTrace();
				System.exit(1);
			}
			return null;
	}
	/**
	 * Interpretation of ASTStart (entry point)
	 * @param s
	 * @param p
	 * @throws ParseException
	 */
	public void interpret(ASTStart s){
		for(int i=0;i<s.jjtGetNumChildren()&&s.jjtGetChild(i)!=null;i++){
			dispatch(s.jjtGetChild(i));
		}
	}
	/*
	 * First Level
	 */
	
	public void interpret(ASTIfBlock i){
		boolean condition = (boolean) dispatch(i.jjtGetChild(0));
		if(condition){
			for(int j=0;j<=i.jjtGetNumChildren();j++){
				dispatch(i.jjtGetChild(j));
			}
		}
		//Else do nothing
		
	}
	public void interpret(ASTWhileBlock w){
		boolean condition = (boolean) dispatch(w.jjtGetChild(0));
		if(condition){
			
		}
	}
	public void interpret(ASTFuncDecl f){
		System.out.println("func");
	}
	/*
	 * Second level
	 */
	public String interpret(ASTFuncName f){
		return f.jjtGetValue().toString();
	}
	public HashMap<String, Class<?>> interpret(ASTTypedArgs t){
		HashMap<String, Class<?>> args = new HashMap<String, Class<?>>();
		for(int i=0; i<=t.jjtGetNumChildren(); i=i+2){
			Class<?> clazz = (Class<?>) dispatch(t.jjtGetChild(i));
			String name = dispatch(t.jjtGetChild(i+1)).toString();
			args.put(name, clazz);
		}
		return args;
	}
	public void interpret(ASTReturns t){
		((SimpleNode) t.jjtGetChild(0)).jjtGetValue();
	}
	public void interpret(ASTFuncCall f){
		System.out.println("FuncCall");
	}
	public void interpret(ASTDeclaration d){
		Class<?> clazz = (Class<?>) dispatch(d.jjtGetChild(0));
		String varname = (String) dispatch(d.jjtGetChild(1));
		Object v = dispatch(d.jjtGetChild(2));
	}
	public void interpret(ASTAssignation a){
		String varname = (String) dispatch(a.jjtGetChild(0));
		Object v = dispatch(a.jjtGetChild(1));
	}
	
	/*
	 * Third level
	 */
	public boolean interpret(ASTIntBoolean i){
		int one = (int) dispatch(i.jjtGetChild(0));
		int two = (int) dispatch(i.jjtGetChild(1));
		switch((String)i.jjtGetValue()){
			case "==" : return one==two;
			case ">"  : return one>two;
			case "<"  : return one<two;
			case ">=" : return one>=two;
			case "<=" : return one<=two;
			case "!=" : return one!=two;
			default   : return false;
		}
	}
	public boolean interpret(ASTStringBoolean s){
		String a=(String) dispatch(s.jjtGetChild(0));
		String b=(String) dispatch(s.jjtGetChild(1));
		return a.equals(b);
	}
	public Class<?> interpret(ASTType t){
		String raw_type = (String) t.jjtGetValue();
		Class<?> clazz = InterConstants.TYPE_TO_CLASS.get(raw_type);
		return clazz;
	}
	public String interpret(ASTVarName v){
		return (String) v.jjtGetValue();
	}
	public ArrayList<Node> interpret(ASTArgs a){
		ArrayList<Node> j_args = new ArrayList<Node>();
		for(int i=0;i<a.jjtGetNumChildren()&&a.jjtGetChild(i)!=null;i++){
			j_args.add(a.jjtGetChild(i));
		}
		return j_args;
	}
	
	/*
	 * Fourth level
	 */
	//Number go further due to math
	public String interpret(ASTStringLit s){
		return (s.jjtGetValue().toString().replace("\"", ""));
	}
	/*
	 * Fifth level - Math
	 */
	public int interpret(ASTAdd a){
		if(a.jjtGetValue() == null){
			int v = (int) dispatch(a.jjtGetChild(0));
			return v;
		}else{
			if(a.jjtGetValue().equals("+")){
				int v1 = (int) dispatch(a.jjtGetChild(0));
				int v2 = (int) dispatch(a.jjtGetChild(1));
				return v1+v2;
			}else{
				int v1 = (int) dispatch(a.jjtGetChild(0));
				int v2 = (int) dispatch(a.jjtGetChild(1));
				return v1-v2;
			}
		}
	}
	public int interpret(ASTTerm t){
		if(t.jjtGetValue() == null){
			int v = (int) dispatch(t.jjtGetChild(0));
			return v;
		}else{
			if(t.jjtGetValue().equals("*")){
				int v1 = (int) dispatch(t.jjtGetChild(0));
				int v2 = (int) dispatch(t.jjtGetChild(1));
				return v1*v2;
			}else{
				int v1 = (int) dispatch(t.jjtGetChild(0));
				int v2 = (int) dispatch(t.jjtGetChild(1));
				return v1/v2;
			}
		}
	}
	public int interpret(ASTFactor s){
		return (int) dispatch(s.jjtGetChild(0));
	}
	public int interpret(ASTNumber n){
		return Integer.parseInt(n.jjtGetValue().toString());
	}
	
	/**
	 * Normally, this function is never called because {dispatch(Node a)} find the correct method.
	 * This function is called on NoSuchMethodException
	 * @param n the general SimpleNode
	 */
	private void interpret(SimpleNode n) {
		System.err.println("Missing interpreter for Node "+n.getClass().getSimpleName());
	}
	
}
