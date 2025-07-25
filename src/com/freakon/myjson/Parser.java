package com.freakon.myjson;
import java.util.*;

public class Parser
{
	private String text = "";
	private int indexNumber;
	Parser(String text,int indexnumber)
	{
		this.text = text;
		this.indexNumber = indexnumber;
	}
	public HashMap stringToHashMp()
	{
		//vars
		String word = "";
		String valueLen = "";
		String keyLen = "";
		String[] keys = new String[indexNumber];
		Object[] values = new Object[indexNumber];
		int pos = 0;
		int valueIndex = 0;
		int keyIndex = 0;
		//find in string
		for (int i = 0;i<text.length();i++)
		{
			if (text.charAt(i) == '=')
			{
				valueLen = text.substring(i);
				//parse values
				for(int a = 1;a<valueLen.length();a++)
				{
					if (valueLen.charAt(a) == ',')
					{
						break;
					}
					else if(valueLen.charAt(a) == '}' || valueLen.charAt(a) == '{')
					{
						break;
					}
					word += valueLen.charAt(a);
				}
				values[valueIndex] = word;
				valueIndex += 1;
				word = "";
				//parse keys
				keyLen = text.substring(0,i);
				for(int b = i - 1;b>0;b--)
				{
					if (keyLen.charAt(b) == ',')
					{
						break;
					}
					else if (keyLen.charAt(b) == '}' || keyLen.charAt(b) == '{')
					{
						break;
					}
					word += keyLen.charAt(b);
				}
				keys[keyIndex] = word;
				keyIndex += 1;
				word = "";
			}
		}
		HashMap<String,Object> hm = new HashMap<>();
		for (int i = 0;i<keys.length;i++)
		{
			hm.put(keys[i],values[i]);
		}
		return hm;
	}
}
