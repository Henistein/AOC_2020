import java.util.regex.Matcher;

public class Classe {
    private int minRange;
    private int maxRange;
    private char key;
    private String password;
    private boolean keyIsEnough;

    Classe() {
        minRange = 0;
        maxRange = 0;
        key = ' ';
        password = "";
        keyIsEnough = false;
    }

    Classe(int minRange, int maxRange, char key, String password) {
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.key = key;
        this.password = password;
        keyIsEnough = false;
    }

    public int getMinRange() {
        return minRange;
    }

    public void setMinRange(int minRange) {
        this.minRange = minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getKeyisEnough() {
        return this.keyIsEnough;
    }

    @Override
    public String toString() {
        return "Classe{" + "minRange=" + minRange + ", maxRange=" + maxRange + ", key=" + key + ", password='"
                + password + '\'' + ", keyIsEnough=" + keyIsEnough + '}';
    }

    public void checkLetra() {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == key)
                count++;
        }
        keyIsEnough = count <= maxRange && count >= minRange;
    }

    public void verify(){
        if(password.charAt(minRange-1) == key && password.charAt(maxRange-1) != key){
            keyIsEnough = true;
        }
        else if(password.charAt(minRange-1) != key && password.charAt(maxRange-1) == key){
            keyIsEnough = true;
        }
        else{
            keyIsEnough = false;
        }
    }

}