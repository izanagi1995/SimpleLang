package be.izanagi.simplelang;

import be.izanagi.simplelang.exceptions.FormatParserInvalid;
import be.izanagi.simplelang.exceptions.VariableNotFoundException;
import be.izanagi.simplelang.register.variables.SimpleVariable;
import be.izanagi.simplelang.register.variables.VarMemory;

public class Main {
	public static void main(String[] args) {
		try {
			String[] input = new String[]{"string test = qw", "integer chiffre = 3 + 3", "echo chiffre", "recall test"}; 
			new Parser().parse(input);
			new Parser().parse("string mot = az");
			new Parser().parse("integer chiffre = 3 + 3");
			new Parser().parse("echo mot");
			new Parser().parse("recall chiffre");
			new Parser().parse("chiffre = 4 - 2");
			new Parser().parse("recall chiffre");
			new Parser().parse("chiffre=3*3");
			new Parser().parse("recall chiffre");
			new Parser().parse("chiffre= 18 / 3");
			new Parser().parse("recall chiffre");
		} catch (FormatParserInvalid e) {
			e.printStackTrace();
		}
	}
}
