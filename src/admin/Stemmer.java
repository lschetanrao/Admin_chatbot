/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

/**
 *
 * gives root word of given word
 */
import java.io.*;

/**
  * Stemmer, implementing the Porter Stemming Algorithm
  *
  * The Stemmer class transforms a word into its root form.  The input
  * word can be provided a character at time (by calling add()), or at once
  * by calling one of the various stem(something) methods.
  */

//public 
import net.didion.jwnl.*;
import net.didion.jwnl.data.*;
import net.didion.jwnl.dictionary.*;


import java.util.HashMap;

public class Stemmer
{  
    private int MaxWordLength = 50;
	private Dictionary dic;
	private MorphologicalProcessor morph;
	private boolean IsInitialized = false;  
	public HashMap AllWords = null;
        String propsFile;
        
        /**
	 * establishes connection to the WordNet database
	 */
	public Stemmer ()
	{
		AllWords = new HashMap ();
		propsFile = "C:\\Users\\Hp laptop\\Desktop\\chatbot_2017\\jwnl14-rc2\\config\\file_properties.xml";
		//propsFile="C:\\Users\\Hp laptop\\Desktop\\chatbot_2017\\properties.xml";
		System.out.println("instance created");
		try
		{
			JWNL.initialize(new FileInputStream(propsFile));
			dic = Dictionary.getInstance();
			morph = dic.getMorphologicalProcessor();
			// ((AbstractCachingDictionary)dic).
			//	setCacheCapacity (10000);
			IsInitialized = true;
			System.out.println("JWNL initialisation done");
		}
		catch ( FileNotFoundException e )
		{
			System.out.println ( "Error initializing Stemmer: JWNLproperties.xml not found" );
		}
		catch ( JWNLException e )
		{
			System.out.println ( "Error initializing Stemmer: " 
				+ e.toString() );
		} 
		
	}
        public void Unload ()
	{ 
		dic.close();
		//Dictionary.uninstall();
		JWNL.shutdown();
	}
         
         /* stems a word with wordnet
	 * @param word word to stem
	 * @return the stemmed word or null if it was not found in WordNet
	 */
	public String StemWordWithWordNet ( String word )
	{
		if ( !IsInitialized )
			return word;
		if ( word == null ) return null;
		if ( morph == null ) morph = dic.getMorphologicalProcessor();
		
		IndexWord w;
		try
		{
			w = morph.lookupBaseForm( POS.VERB, word );
			if ( w != null )
				return w.getLemma().toString ();
			w = morph.lookupBaseForm( POS.NOUN, word );
			if ( w != null )
				return w.getLemma().toString();
			w = morph.lookupBaseForm( POS.ADJECTIVE, word );
			if ( w != null )
				return w.getLemma().toString();
			w = morph.lookupBaseForm( POS.ADVERB, word );
			if ( w != null )
				return w.getLemma().toString();
		} 
		catch ( JWNLException e )
		{
		}
		return null;
        }
        
        /**
	 * Stem a single word
	 * tries to look up the word in the AllWords HashMap
	 * If the word is not found it is stemmed with WordNet
	 * and put into AllWords
	 * 
	 * @param word word to be stemmed
	 * @return stemmed word
	 */
        public boolean containsNumbers(String word)
        {
            boolean flag = false;
            Character c = null;
            for(int i = 0; i<word.length(); i++)
            {
                c = word.charAt(i);
                if(Character.isDigit(c))
                    flag = true;
            }
            return flag;
        }
	public String Stem( String word )
	{
            String stemmedword = "";
		// check if we already know the word
            if(AllWords.containsKey(word)){
		stemmedword = AllWords.get( word ).toString();
		if ( stemmedword != null )
			return stemmedword; // return it if we already know it
            }
		// don't check words with digits in them
		if ( containsNumbers (word) == true )
			stemmedword = null;
		else	// unknown word: try to stem it
			stemmedword = StemWordWithWordNet (word);
		
		if ( stemmedword != null )
		{
			// word was recognized and stemmed with wordnet:
			// add it to hashmap and return the stemmed word
			AllWords.put( word, stemmedword );
			return stemmedword;
		}
		// word could not be stemmed by wordnet, 
		// thus it is no correct english word
		// just add it to the list of known words so 
		// we won't have to look it up again
		AllWords.put( word, word );
		
		return word;
	}
        public static void main(String[] args) {
        	
        Stemmer s = new Stemmer();
        /*String sss="text of the printing and typesetting industry. Lorem Ipsum has been the industry's";
        String str[]= KeyWordsFind.removeWords(sss);
        for(int i=0;i<str.length;i++)
    	   str[i]=s.Stem(str[i]);
        for(String s1:str)
    	   System.out.println(s1);
        System.out.println(".................");*/
        System.out.println(s.Stem("writing"));
        s.Unload();
    }
    }