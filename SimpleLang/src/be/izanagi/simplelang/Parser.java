package be.izanagi.simplelang;

import java.util.IllegalFormatException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import be.izanagi.simplelang.exceptions.FormatParserInvalid;
import be.izanagi.simplelang.exceptions.UnknownTokenException;
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
				try {
					dispatch(ConstGraml.actionFromPattern(pat), line);
				} catch (UnknownTokenException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
		}
		throw new FormatParserInvalid("Line not matched...");
	}
	private String[] dispatch(String action, String line) throws UnknownTokenException {
		if(action.equals("var_decl")){
			//Decoupage
			String[] sp = Pattern.compile("( )+").split(line);
			if(ConstGraml.DEBUG){
				for(String sp1:sp){
					System.out.println(sp1);
				}
			}
			new SimpleRegister("var_decl", sp);
			return sp;
		}
		if(action.equals("var_upgrade")){
			//Decoupage
			String[] sp = Pattern.compile("( )+").split(line);
			if(ConstGraml.DEBUG){
				for(String sp1:sp){
					System.out.println(sp1);
				}
			}
			new SimpleRegister("var_upgrade", sp);
			return sp;
		}
		if(action.equals("echo")){
			String sp=line.split(" ")[1];
			System.out.println(sp);
		}
		if(action.equals("recall")){
			try {
				System.out.println(VarMemory.recallFromName(line.split(" ")[1]).getValue());
				return line.split(" ");
			} catch (VariableNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(action.equals("math_plus")){
			String[] sp = Pattern.compile("\\+").split(line);
			for(String sp1:sp){
				System.out.println("Plus-op => "+sp1.trim());
			}
			return sp;
		}
		if(action.equals("math_minus")){
			String[] sp = Pattern.compile("-").split(line);
			for(String sp1:sp){
				System.out.println("Minus-op => "+sp1.trim());
			}
			return sp;
		}
		if(action.equals("math_prod")){
			String[] sp = Pattern.compile("\\*").split(line);
			for(String sp1:sp){
				System.out.println("Prod-op => "+sp1.trim());
			}
			return sp;
		}
		if(action.equals("math_div")){
			String[] sp = Pattern.compile("/").split(line);
			for(String sp1:sp){
				System.out.println("Div-op => "+sp1.trim());
			}
			return sp;
		}
		if(action.equals("unitary_value")){
			System.out.println("Unit => "+line.trim());
			return new String[]{line};
		}
		throw new UnknownTokenException("Unknow token action : "+action);
		
	}
}
