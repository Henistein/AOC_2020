import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> res = new ArrayList<String>();
		ArrayList<Passport> pass = new ArrayList<Passport>();
		Passport p = new Passport();
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
		int count = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<list.size(); i++){
			if(!list.get(i).isBlank() && i!=list.size()-1){
				sb.append(list.get(i));
			}
			else{
				System.out.println(sb.toString());
				if(sb.toString().contains("byr") && sb.toString().contains("iyr") && sb.toString().contains("eyr") && sb.toString().contains("hgt") && sb.toString().contains("hcl") && sb.toString().contains("ecl") && sb.toString().contains("pid")){
					count++;
				}
				sb.setLength(0);
			}
		}

		System.out.println(count);

		}
}