import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	static boolean verify(String sb){
		Scanner r;
		r = new Scanner(sb);
		String[] aux;
		String temp = "";
		int count = 0;
		while(r.hasNext()){
			temp = r.next();
			//BYR
			if(temp.contains("byr")){
				
				aux = temp.split(":", 2);
				if(Integer.parseInt(aux[1]) >= 1920 && Integer.parseInt(aux[1]) <= 2002){
					count++;
					System.out.println(temp);
				}
			}
			//IYR
			if(temp.contains("iyr")){
				
				aux = temp.split(":", 2);
				if(Integer.parseInt(aux[1]) >= 2010 && Integer.parseInt(aux[1]) <= 2020){
					count++;
					System.out.println(temp);
				}
			}
			//EYR
			if(temp.contains("eyr")){
				
				aux = temp.split(":", 2);
				if(Integer.parseInt(aux[1]) >= 2020 && Integer.parseInt(aux[1]) <= 2030){
					count++;
					System.out.println(temp);
				}
			}
			//HGT
			
			int y = 0;
			if(temp.contains("hgt")){
				
				if(temp.contains("cm")){
					aux = temp.split(":", 2);
					aux[1] = aux[1].replace("cm", "");
					if(Integer.parseInt(aux[1]) >= 150 && Integer.parseInt(aux[1]) <= 193){
						count++;
						System.out.println(temp);
					}
				}
				if(temp.contains("in")){
					
					aux = temp.split(":", 2);
					aux[1] = aux[1].replace("in", "");
					if(Integer.parseInt(aux[1]) >= 59 && Integer.parseInt(aux[1]) <= 76){
						count++;
						System.out.println(temp);
					}
				}
			}
			//HCL
			if(temp.contains("hcl")){
				
				if(temp.contains("#")){
					count++;
					System.out.println(temp);
				}
			}
			//ECL
			if(temp.contains("ecl")){
				
				if(temp.contains("amb") || temp.contains("blu") || temp.contains("brn") || 
				   temp.contains("gry") || temp.contains("grn") || temp.contains("hzl") || 
				   temp.contains("oth")){
					count++;
					System.out.println(temp);
				}
			}
			
			//PID
			int countn = 0;
			if(temp.contains("pid")){
			
				aux = temp.split(":", 2);
				for(int k=0; k<aux[1].length(); k++){
					countn++;
				}
				if(countn == 9){
					count++;
					System.out.println(temp);
				}
				
			}
			
			
		}
		if(count == 7){
			return true;
		}
		else{
			return false;
		}
	}
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
		int result = 0;
		//StringBuilder sb = new StringBuilder();
		String sb = "";
		for(int i=0; i<list.size()-1; i++){
			if(!list.get(i).isBlank()){
				//sb.append(list.get(i));
				sb = sb + list.get(i) + " ";
			}
			else{
				
				if(sb.contains("byr") && sb.contains("iyr") && sb.contains("eyr") && sb.contains("hgt") && sb.contains("hcl") && sb.contains("ecl") && sb.contains("pid")){
					count++;
				}
					sb = "";
				}
			
				//System.out.println(sb);
				if(list.get(i+1).isBlank()){
					if(verify(sb) == true){
						result++;
					}
				}
			}
			System.out.println(result);
		}

		

}
