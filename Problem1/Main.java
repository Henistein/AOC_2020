import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // import the ArrayList class

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        try {
            File myObj = new File("nums.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                lista.add(myReader.nextInt());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.size(); j++) {
                for (int k = 0; k < lista.size(); k++) {
                    if (lista.get(i) + lista.get(j) + lista.get(k) == 2020) {
                        System.out.println(lista.get(i) + " " + lista.get(j) + " " + lista.get(k));
                        System.out.println(lista.get(i) * lista.get(j) * lista.get(k));
                    }
                }

            }

        }
    }
}