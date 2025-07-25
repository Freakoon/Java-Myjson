package com.freakon.myjson;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		String text = "{A=1,B=2,C=3}";
		Parser parser = new Parser(text,3);
		System.out.println(parser.stringToHashMp());
	}
}
