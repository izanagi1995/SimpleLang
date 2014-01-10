package be.izanagi.simplelang;

import java.util.IllegalFormatException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import be.izanagi.simplelang.exceptions.FormatParserInvalid;
import be.izanagi.simplelang.exceptions.UnknownTokenException;
import be.izanagi.simplelang.exceptions.VariableNotFoundException;
import be.izanagi.simplelang.register.SimpleRegister;
import be.izanagi.simplelang.register.variables.VarMemory;
import be.izanagi.simplelang.utils.SimpleMath;

public class Parser {
	public Parser(){
		ConstGraml.init();
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
					dispatch(ConstGraml.actionFromPattern(pat), line);
				} catch (UnknownTokenException e) {
					e.printStackTrace();
				}
				return;
			}
		}
		throw new FormatParserInvalid("Line not matched...");
	}
	private String[] dispatch(String action, String line) throws UnknownTokenException {
		if(action.equals("var_decl")){
			String[] sp = Pattern.compile("=").split(line);
			String instr = sp[0];
			String value = sp[1];
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
			String sp=line.split(" ")[1];
			System.out.println(sp);
			return new String[]{sp};
		}
		if(action.equals("recall")){
			try {
				System.out.println(VarMemory.recallFromName(line.split(" ")[1]).getValue());
				return line.split(" ");
			} catch (VariableNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return line.split(" ");
		}
		throw new UnknownTokenException("Unknow token action : "+action);
		
	}
}
