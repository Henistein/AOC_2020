import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int number(String s){
        String aux = "";
        
        for(int i=0; i<s.length(); i++){
            int temp = aux.indexOf(s.charAt(i));
            if(temp == -1){
                aux = aux + s.charAt(i);
            }    
        }
        
        System.out.println(aux);
        return aux.length()-1;
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