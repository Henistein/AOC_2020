import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
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

        /*for(int i=0; i<list.size(); i++){
            
        }*/

        System.out.println(list.get(0));

   
  }
    
    
}
