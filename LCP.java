import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LCP {
    
    public static void main(String[] args) {
        System.out.println("The opening String is ab1234cd");

        String str = "ab1234cd";

        List<String> list = letterCasePermutation(str);
    }

    private static List<String> letterCasePermutation(String str) {
        int size = str.length();
        int letterCount = 0;
        str = str.toLowerCase();
        char[] cArray = str.toCharArray();
        List<String> myList = new LinkedList<>();

        for (int x = 0; x < str.length(); x ++){
            if(Character.isLetter(cArray[x])){
                letterCount ++;
            }
        }

        int sizeSquared = (int) Math.pow(2, letterCount);

        System.out.println("The number of letter characters is " + letterCount + ", and the number of permutations is " + sizeSquared + " for the string " + str);

        boolean[][] myArray = getMyArray(letterCount);

        for (int y = 0; y < sizeSquared; y ++){
            char[] temp = cArray.clone();
            int counter = 0; //counter is the index of the second dimension of myArray
            for (int z = 0; z < size; z ++){//z is the index within the char array, 
                if (Character.isLetter(temp[z])){
                    if (myArray[y][counter] == true){
                        temp[z] = Character.toUpperCase(temp[z]);
                    }
                    counter++;
                }
            }
            String tempString = new String(temp);
            myList.add(tempString);
        }

        return myList;
    }

    private static boolean[][] getMyArray(int size) {
        
        int sizeSquared = (int)Math.pow(2, size);
        boolean[][] temp = new boolean[(int)Math.pow(2, size)][size];

        for (int x = 0; x < sizeSquared; x++){
            temp[x] = getBoolArray(x, size);
        }
        return temp;
    }

    private static boolean[] getBoolArray(int sizeSquared, int size) {
        
        boolean[] bits = new boolean[size];
        for (int i = size-1; i >= 0; i--){
            bits[i] = (sizeSquared & (1 << i)) != 0;
        }

        return bits;
    }
}