import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,5,8,8,100,100,100,100,101,102,103};

        System.out.println("test array is: " + nums.toString());

        int num = removeDuplicates(nums);
        System.out.println(num);
        
    }

    private static int removeDuplicates(int[] nums) {
        int diffCount = 0;
        int indexReceive = 0;
        int indexGive = 0;

        while(indexGive < nums.length){
            if (nums[indexGive] > nums[indexReceive]){
                nums[indexReceive] = nums[indexGive];
                indexReceive++;
                diffCount++;
            }
            indexGive++;
        }
        
        return diffCount;  
    }
}