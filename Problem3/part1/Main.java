import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static int solution(int x, int y, ArrayList<String> list) {
        int r = 0;
        int count = 0;
        int i = 0;
        while (i < list.size()) {

            r += x;

            i += y;

            if (r > 30) {
                r -= 31;
                if (i + y >= 323)
                    break;
            }

            try {
                if (list.get(i).charAt(r) == '#') {
                    count++;
                }
            } catch (IndexOutOfBoundsException e) {
            }

        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            File f = new File("input.txt");
            Scanner read = new Scanner(f);
            while (read.hasNextLine()) {
                list.add(read.next());
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(solution(3, 1, list));

    }
}
