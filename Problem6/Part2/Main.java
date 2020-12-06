import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static int number(String s){
      String aux = "";
      
      for(int i=0; i<s.length(); i++){
          int temp = aux.indexOf(s.charAt(i));
          if(temp == -1){
              aux = aux + s.charAt(i);
          }    
      }
      aux = aux.substring(1);
      s = s.substring(1);
      if(s.equals(aux)){
        //System.out.println(s);
        return aux.length();
      }
      else{
        
        ArrayList<Character> str1 = new ArrayList<Character>();
        
        System.out.println(s);
        
        String [] arr = s.split(" ", 2);
        for(int i=0; i<arr[0].length(); i++){
          str1.add(arr[0].charAt(i));
        }
        Scanner r = new Scanner(arr[1]);
  
        while(r.hasNext()){
          String h = r.next();
          ArrayList<Character> str2 = new ArrayList<Character>();
          for(int j=0; j<h.length(); j++){
            str2.add(h.charAt(j));
          }
          str1.retainAll(str2);
          System.out.println(str1);
        }
        System.out.println(str1.size());
        return str1.size();
      }
      
      
    }
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        
        try {
            File f = new File("input.txt");
            Scanner read = new Scanner(f);
            while (read.hasNextLine()) {
                list.add(read.nextLine());
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
   
        String s = "";
        int count  = 0;
        for(int i=0; i<list.size(); i++){
            if(!list.get(i).isBlank()){
                s = s + " " +list.get(i);
            }
            else{
                count = count + number(s);
                s = "";
            }
            
        }

        System.out.println(count);
    }
    
    
}