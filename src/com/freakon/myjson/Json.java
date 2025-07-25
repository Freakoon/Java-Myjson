package com.freakon.myjson;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Json
{
	//impormant vars
	private String fileName = "";
	private String cahce = "";
	private String[] defaultKey;
	private Object[] defaultValue;
	private HashMap<String,Object> hashMap = new HashMap<>();
	private int index = 0;
	Json(String[] key,Object[] value,String filename,int index) throws IOException
	{
		/*
		*@param defaultKey a string array
		*@param defaultValue a object array
		*@param Filename write a file name withon .*
		*@param index write number of your key
		*Note: arrays only eqaul !
		*/
		this.defaultKey = key;
		this.defaultValue = value;
		this.fileName = filename;
		this.index = index;
		cahce = filename + ".cache";
		config();
		checkCache();
	}
	//setting cache file to hashmap
	private void checkCache() throws FileNotFoundException, IOException
	{
		File file = new File(cahce);
		if(file.exists())
		{
		String content = new String(Files.readAllBytes((Paths.get(cahce))));
		Parser parse = new Parser(content,index);
		hashMap = parse.stringToHashMp();
		} else {
			FileWriter fileWriter = new FileWriter(cahce);
			fileWriter.write(hashMap.toString());
			fileWriter.close();
		}
	}
	//update cache file
	private void updateCache() throws IOException
	{
		FileWriter fileWriter = new FileWriter(cahce);
		fileWriter.write(hashMap.toString());
		fileWriter.close();
	}
	//set defaults key,value to hashmap
	private void config() throws IOException
	{
		int length = defaultKey.length;
		for(int i = 0;i<length;i++)
		{
			hashMap.put(defaultKey[i],defaultValue[i]);
		}
		updateCache();
	}
	//getter for other class
	public String _getFileName()
	{
		/*
		*Note: this method is not for use !
		*/
		return fileName;
	}
	//add key and value
	public void add(String k,Object v) throws IOException
	{
		/*
		*@param key: add a string key
		*@param value: add a object value
		*/
		hashMap.put(k,v);
		updateCache();
	}
	//remove a key
	public void rem(String key) throws IOException 
	{
		/*
		*@param key: write a key
		*/
		hashMap.remove(key);
		updateCache();
	}
	//get value of key
	public Object get(String key)
	{
		/*
		*@param key: name
		*/
		return hashMap.get(key);
	}
	//save to file
	public void saveToJson(String name) throws IOException
	{
		/*
		*@param name: file name to save json without .*
		*/
		FileWriter fw = new FileWriter(name+".json");
		String result = "";
		result += hashMap;
		result = result.replaceAll("=",":");
		fw.write(result);
		fw.close();
	}
	//return hashMap var
	public HashMap show()
	{
		return hashMap;
	}
	
}
