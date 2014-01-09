package be.izanagi.simplelang;

import java.util.IllegalFormatException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import be.izanagi.simplelang.exceptions.FormatParserInvalid;
import be.izanagi.simplelang.exceptions.VariableNotFoundException;
import be.izanagi.simplelang.register.SimpleRegister;
import be.izanagi.simplelang.register.variables.VarMemory;

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
				dispatch(ConstGraml.actionFromPattern(pat), line);
				return;
			}
		}
		throw new FormatParserInvalid("Line not matched...");
	}
	private void dispatch(String action, String line) {
		if(action.equals("var_decl")){
			//Decoupage
			String[] sp = Pattern.compile("( )+").split(line);
			if(ConstGraml.DEBUG){
				for(String sp1:sp){
					System.out.println(sp1);
				}
			}
			new SimpleRegister("var_decl", sp);
		}
		if(action.equals("echo")){
			String sp=line.split(" ")[1];
			System.out.println(sp);
		}
		if(action.equals("recall")){
			try {
				System.out.println(VarMemory.recallFromName(line.split(" ")[1]).getValue());
			} catch (VariableNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
