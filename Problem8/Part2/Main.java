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

        boolean b = true;
        int accumulator = 0;
        int inc = 0;
        int last = 0;
        int counter = 0;
        String [] aux = new String[2];
        ArrayList<Integer> jmp = new ArrayList<Integer>();
        ArrayList<Integer> nop = new ArrayList<Integer>();
        
        for(int i=0; i<list.size(); i++){
          if(list.get(i).contains("jmp")){
            jmp.add(i);
          }
          if(list.get(i).contains("nop")){
            nop.add(i);
          }
        }

        for(int i=0; i<jmp.size(); i++){
          list.set(jmp.get(i), list.get(jmp.get(i)).replace("jmp", "nop"));

          while(counter < 1000 && inc < list.size()){
              counter++;
              if(list.get(inc).contains("jmp")){
                aux = list.get(inc).split(" ");
                inc += Integer.parseInt(aux[1]);
              }
              else if(list.get(inc).contains("acc")){
                aux = list.get(inc).split(" ");
                accumulator += Integer.parseInt(aux[1]);
                inc += 1;
              }
              else{
                inc += 1;
              } 
          }
          if(counter >= 1000){
            counter = 0;
            inc = 0;
            accumulator = 0;
          }
          else{
            break;
          }
          list.set(jmp.get(i), list.get(jmp.get(i)).replace("nop", "jmp"));
        }

        System.out.println("Acc: "+ accumulator);
   } 
    
}
