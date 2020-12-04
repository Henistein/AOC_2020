import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // import the ArrayList class
import java.io.*;

public class Main {
    static int[] removerInt(String s) {
        int a = 0, b = 0;
        s = s.replace('-', ' ');
        Scanner stringscanner = new Scanner(s);
        a = stringscanner.nextInt();
        b = stringscanner.nextInt();
        return new int[] { a, b };
    }

    static char removerLetra(String s) {
        char ch = s.charAt(0);
        return ch;
    }

    public static void main(String[] args) {
        Classe cl = new Classe();
        ArrayList<String> lines = new ArrayList<String>();
        ArrayList<Classe> lista = new ArrayList<Classe>();
        String s = " ";
        int[] a = new int[2];
        char ch;

        try {
            File myObj = new File("pass.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                cl = new Classe();
                s = myReader.next();
                a = removerInt(s);
                cl.setMinRange(a[0]);
                cl.setMaxRange(a[1]);
                s = myReader.next();
                ch = removerLetra(s);
                cl.setKey(ch);
                cl.setPassword(myReader.next());
                lista.add(cl);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int count = 0;
        for (Classe c : lista) {
            c.checkLetra();
            if (c.getKeyisEnough()) {
                count++;
            }
        }

        System.out.println(count);

    }
}