import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) {
         int count =0;
         ArrayList<String> dict=new ArrayList<>();
         File file = new File("input_01 or input_02.txt");//Enter the location of the input.txt file
         Scanner sc = new Scanner(file);
         while(sc.hasNext())
         {
            String word1=sc.next();
            dict.add(word1);    
         }
         Collections.sort(dict, Comparator.comparing(String::length));
         while(dict.size()>0){
             int len=dict.size();
             String word=dict.get(len-1);
             dict.remove(word);
             if(isCompoundWord(word,dict)){
                count++;
                if(count == 1) 
                System.out.println("Longest compound word : "+word);
                if(count==2){
                System.out.println("Second Longest compound word : "+word);    
                break;
                }
             }
         }
	}
	public static boolean isCompoundWord(String word, ArrayList<String> dictionary) {
        if (dictionary.contains(word))
            return true;
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            if (isCompoundWord(prefix, dictionary)) {
                String remainder = word.substring(i, word.length());
                if (remainder.length() == 0)
                    return true;
                if(isCompoundWord(remainder, dictionary))
                return true;
                else
                continue;
            }
        }
        return false;
    }
}


