package it.polito.tdp.alien.model;

import it.polito.tdp.alien.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Model {

	private Map <String, ArrayList <String>> dictionary; 
	
	public Map <String, ArrayList <String>> getDictionary() {
		return dictionary;
	}

	public Model ()
	{
		dictionary = new HashMap <String, ArrayList <String>> ();
	}
	
	public int addWord (String alien, String word)
	{
		ArrayList <String> traduzioni;
		if (dictionary.containsKey(alien))
		{
			traduzioni = dictionary.get(alien);
			traduzioni.add(word);
			dictionary.put(alien, traduzioni);
			return traduzioni.size();
		}
		else
		{
			traduzioni = new ArrayList <String> ();
			traduzioni.add(word);
			dictionary.put(alien, traduzioni);
			return traduzioni.size();
		}
		
		
	}
	
	public ArrayList<String> searchWord (String input)
	{
		return dictionary.get(input);
	}
	
	public void reset() {
		
		dictionary.clear();
				
	}
	
}
