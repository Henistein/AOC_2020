import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        ArrayList<Integer> coll = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
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
       
        int minRow = 0;
        int maxRow = 127;
        int minColl = 0;
        int maxColl = 7;
        int finalRow = 0;
        int finalColl = 0;
        int half = 0;
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<7; j++){
                half = minRow + (maxRow - minRow + 1)/2;
                if(list.get(i).charAt(j) == 'F'){
                    maxRow = half - 1;
                }
                if(list.get(i).charAt(j) == 'B'){
                    minRow = half;
                }

            }
            row.add(minRow);
            minRow = 0;
            maxRow = 127;
        }

        for(int i=0; i<list.size(); i++){
            for(int j=7; j<10; j++){
                half = minColl + (maxColl - minColl + 1)/2;
                if(list.get(i).charAt(j) == 'L'){
                    maxColl = half-1;
                }
                if(list.get(i).charAt(j) == 'R'){
                    minColl = half;
                }
            }
            coll.add(minColl);
            minColl = 0;
            maxColl = 7;
        }
        int max = 0;
        int aux = 0;
        for(int i=0; i<coll.size(); i++){
            aux = row.get(i)*8 + coll.get(i);
            result.add(aux);
            if(aux > max){
                max = aux;
            }
        }
        Collections.sort(result);
        for(int i=0; i<result.size(); i++){
            if(!result.contains(i+1)){
                System.out.println(i+1);
            }
        }

	}
}