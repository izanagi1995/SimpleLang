package be.izanagi.simplelang;

import be.izanagi.simplelang.exceptions.FormatParserInvalid;
import be.izanagi.simplelang.exceptions.VariableNotFoundException;
import be.izanagi.simplelang.register.variables.SimpleVariable;
import be.izanagi.simplelang.register.variables.VarMemory;

public class Main {
	public static void main(String[] args) {
		try {
			Parser p = new Parser();
			String[] input = new String[]{"string test = qw", "integer chiffre = 3 + 3", "echo chiffre", "recall test"}; 
			p.parse(input);
			p.parse("bool b = true");
			p.parse("string mot = az");
			p.parse("integer chiffre = 3 + 3");
			p.parse("echo mot");
			p.parse("recall chiffre");
			p.parse("chiffre = 4 - 2");
			p.parse("recall chiffre");
			p.parse("chiffre=3*3");
			p.parse("recall chiffre");
			p.parse("chiffre= 18 / 3");
			p.parse("recall chiffre");
			p.parse("if 4==4 do");//-----------------|
			p.parse("	echo oui avant");//-------------|
			p.parse("	if 3==4 do");//-|---------------|
			p.parse("		echo non");//---|---------------|
			p.parse("	end");//--------|---------------|
			p.parse("	echo oui apres");//-------------|
			p.parse("	integer a = 6");//--------------|
			p.parse("	integer c = 6");//--------------|
			p.parse("	if a==c do");//---------|-------|
			p.parse("		echo oui variable");//--|-------|
			p.parse("	end");//----------------|-------|
			p.parse("end");//------------------------|
		} catch (FormatParserInvalid e) {
			e.printStackTrace();
		}
	}
}
