import java.util.*;

public class SingleNumber {

    public int Solution(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int nums[] = {4,1,2,1,2};

        SingleNumber sn = new SingleNumber();

        System.out.println(sn.Solution(nums));
    }
}