package be.izanagi.simplelang;

import java.util.IllegalFormatException;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Infos :
 * Status : 0 : normal
 * Status : 1 : if ok (execute)
 * Status : -1 : if not ok (ignore)
 * Status : 2 : while ok (execute)
 * For while not ok, we use if not ok (ignore)
 */



import be.izanagi.simplelang.exceptions.FormatParserInvalid;
import be.izanagi.simplelang.exceptions.UnknownTokenException;
import be.izanagi.simplelang.exceptions.VariableNotFoundException;
import be.izanagi.simplelang.register.SimpleRegister;
import be.izanagi.simplelang.register.variables.VarMemory;
import be.izanagi.simplelang.utils.BooleanEvaluator;
import be.izanagi.simplelang.utils.SimpleMath;

public class Parser {
	private int status=0;
	private Stack<Integer> previous = new Stack<Integer>();
	public Parser(){
		ConstGraml.init();
	}
	private void setStatus(int st){
		this.previous.push(this.status);
		status = st;
		if(ConstGraml.DEBUG){
			System.out.println("Status changed : "+status);
		}
	}
	private void resetStatus(){
		this.status = this.previous.pop();
		if(ConstGraml.DEBUG){
			System.out.println("Status reset : "+status);
		}
	}
	public void parse(String line) throws FormatParserInvalid{
		for(String pat:ConstGraml.getPatterns()){
			Pattern pat2 = Pattern.compile(pat);
			Matcher m = pat2.matcher(line);
			if(m.matches()){
				if(ConstGraml.DEBUG){
					System.out.print(pat);
					System.out.println(" => "+ConstGraml.actionFromPattern(pat));
				}
				try {
					String act=ConstGraml.actionFromPattern(pat);
					if(act.equals("end")){
						this.resetStatus();
					}
					if(this.status==-1){
						if(act.equals("if_statment")){
							dispatch(act, line);
						}
					}
					if(this.status==0||this.status==1){
						dispatch(act, line);
					}
				} catch (UnknownTokenException e) {
					e.printStackTrace();
				}
				return;
			}
		}
		throw new FormatParserInvalid("Line not matched...");
	}
	public void parse(String[] input) throws FormatParserInvalid {
		for(String line:input){
			parse(line);
		}
		
	}
	private String[] dispatch(String action, String line) throws UnknownTokenException {
		if(action.equals("var_decl")){
			String[] sp = Pattern.compile("=").split(line);
			String instr = sp[0].trim();
			String value = sp[1].trim();
			String type = instr.split(" ")[0];
			String name = instr.split(" ")[1];
			String eq = "=";
			String patt = ConstGraml.matchPattern(value);
			if(patt!=null){
				value = SimpleMath.interpret(value, patt).toString();
			}
			String[] ret = new String[]{type, name, eq, value};
			if(ConstGraml.DEBUG){
				System.out.println(value);
			}
			new SimpleRegister("var_decl", ret);
			return sp;
		}
		if(action.equals("var_upgrade")){
			//Decoupage
			String[] sp = Pattern.compile("=").split(line);
			String instr = sp[0];
			String value = sp[1];
			String name = instr.split(" ")[0];
			String eq = "=";
			String patt = ConstGraml.matchPattern(value);
			if(patt!=null){
				value= SimpleMath.interpret(value, patt).toString();
			}
			if(ConstGraml.DEBUG){
				
			}
			String[] ret = new String[]{name, eq, value};
			new SimpleRegister("var_upgrade", ret);
			return sp;
		}
		if(action.equals("echo")){
			String sp=line.trim().substring(4);
			System.out.println(sp.trim());
			return new String[]{sp};
		}
		if(action.equals("recall")){
			try {
				System.out.println(VarMemory.recall(line.split(" ")[1]));
				return line.split(" ");
			} catch (VariableNotFoundException e) {
				e.printStackTrace();
			}
			return line.split(" ");
		}
		if(action.equals("if_statment")){
			if(ConstGraml.DEBUG){
				System.out.println("if");
			}
			String sp = line.replaceAll("if( )*|( )*do", "");
			boolean b=BooleanEvaluator.evaluate(sp);
			if(ConstGraml.DEBUG){
				System.out.println(b);
			}
			if(b){
				this.setStatus(1);
			}else{
				this.setStatus(-1);
			}
			return null;
		}
		if(action.equals("end")){
			if(ConstGraml.DEBUG){
				System.out.println("end");
			}
			return null;
		}
		throw new UnknownTokenException("Unknow token action : "+action);
		
	}
}
