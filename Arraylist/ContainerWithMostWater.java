package Arraylist;

import java.util.*;

public class ContainerWithMostWater {
    public static int storeWater(ArrayList<Integer> height) {

        // Brute force approch

        // int maxWater = 0;
        // for (int i = 0; i < height.size(); i++) {
        //     for (int j = i + 1; j < height.size(); j++) {
        //         int ht = Math.min(height.get(i), height.get(j));
        //         int width = j - i;
        //         int currWater = ht * width;
        //         maxWater = Math.max(maxWater, currWater);
        //     }
        // }



        // @ pointer approch

        int maxWater = 0;
        int lp = 0, rp = height.size()-1;
        while(lp<rp){
            // area of water
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp ;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);

            // Update pointer
            if(height.get(lp)<height.get(rp)){
                lp++;
            }
            else{
                rp--;
            }
        }

        return maxWater;
    }

    public static void main(String args[]) {
        ArrayList<Integer> height = new ArrayList<>();
        
        // For continuous input from user until -1 is entered

        // System.out.println("Enter the elements & -1 for stop: ");
        // Scanner sc = new Scanner(System.in);
        // while (true) {
        //     int x = sc.nextInt();
        //     if (x == -1)
        //         break;
        //     height.add(x);
        // }

        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println("Maximum water stored: " + storeWater(height));

    }
}
