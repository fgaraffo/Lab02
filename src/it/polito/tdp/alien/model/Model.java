package it.polito.tdp.alien.model;

import it.polito.tdp.alien.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Model {

	private Map <String, String> dictionary; 
	
	public Map <String, String> getDictionary() {
		return dictionary;
	}

	public Model ()
	{
		dictionary = new HashMap <String, String> ();
	}
	
	public String addWord (String alien, String word)
	{
		return dictionary.put(alien, word);
	}
	
	public String searchWord (String input)
	{
		return dictionary.get(input);
	}
	
	public Set <String> prova ()
	{
		Set <String> prova = new HashSet <String> ();
		prova = dictionary.keySet();
		return prova;
	}

	public void reset() {
		
		dictionary.clear();
				
	}
	
}
