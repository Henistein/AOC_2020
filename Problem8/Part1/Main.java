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
        String [] aux = new String[2];
        ArrayList<Integer> arr = new ArrayList<Integer>();
        //for(int i=0; i<list.size(); i++){
          //  arr.add(-1);
       // }
        while(b){
            if(arr.contains(inc)){
                b = false;
            }
            if(list.get(inc).contains("jmp")){
                aux = list.get(inc).split(" ");
                arr.add(inc);
                inc += Integer.parseInt(aux[1]);
            }
            else if(list.get(inc).contains("acc")){

                aux = list.get(inc).split(" ");
                accumulator += Integer.parseInt(aux[1]);
                last = Integer.parseInt(aux[1]);
                arr.add(inc);
                inc += 1;
            }
            else{
                    arr.add(inc);
                    inc += 1;
            } 
        }
        int result = last - accumulator;
        result = Math.abs(result);
        System.out.println("Acc: "+result);
   } 
    
}
