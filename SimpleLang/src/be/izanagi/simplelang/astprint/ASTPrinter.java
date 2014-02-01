package be.izanagi.simplelang.astprint;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import be.izanagi.simplelang.SimpleNode;

public class ASTPrinter {
	PrintWriter pw;
	SimpleNode start;
	public ASTPrinter(String file, SimpleNode start) {
		try {
			this.pw = new PrintWriter(new File(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.start = start;
	}
	public void dump(String prefix, SimpleNode start) {
		Object v = start.jjtGetValue();
		String p = (v!=null)?(" : "+v.toString()):"";
		pw.append(start.toString(prefix)+p+System.lineSeparator());
		System.out.println(start.toString(prefix)+p);
		if (start.jjtGetNumChildren() != 0) {
			for (int i = 0; i < start.jjtGetNumChildren(); ++i) {
				SimpleNode n = (SimpleNode)start.jjtGetChild(i);
				if (n != null) {
					dump("	"+prefix, n);
				}
			}
		}
	}
	public void close(){
		pw.append("END"+System.lineSeparator());
		pw.flush();
		pw.close();
	}


}
