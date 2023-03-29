package admin;
import java.util.ArrayList;
import java.util.Arrays;



public class KeyWordsFind {
 static String [] removeWords(String question){
	 
	 String [] conjuctions={"a","and","that","but","or","as","if","than","because","so","the","is","was","it"};
	 String [] prepositions ={"about","as","of","in","to","for","with","on","at","from"
	                         +"by","into","through","after","over","between","out","aganist","during"};
	 
	 String delimiters = "\\s+|,\\s*|\\.\\s*";
	 String [] str=question.split(delimiters);
	 int pos=0;
	 for(String s:str)
		 str[pos++]=s.toLowerCase();

	ArrayList<String> arrayList= new ArrayList<String>(Arrays.asList(str));
	/* for(String pun:punctuations){
		if(arrayList.contains(pun)){
			arrayList.remove(pun);
		}
	 }*/
	 for(String con:conjuctions){
			if(arrayList.contains(con)){
				arrayList.removeAll(Arrays.asList(con));
			}
	 }
			 for(String pre:prepositions){
					if(arrayList.contains(pre)){
						arrayList.removeAll(Arrays.asList(pre));
					}
			 }

	// return (String)arrayList.toString().replaceAll("\\[|\\]", "").replaceAll(", "," ");
	 return arrayList.toArray(new String[arrayList.size()]);
	 
	 
	
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String question="of type and scrambled it to make a type specimen book.";
		//long startTime = System.nanoTime();
		String []ss=KeyWordsFind.removeWords(question);
		for(String ass:ss)
		System.out.println(ass);
		//long endTime = System.nanoTime();
		//System.out.println("Took "+(endTime - startTime) + " ns"); 
		
	}
 
}
