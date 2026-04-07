class NumberPrinting {
// Print numbers from n to 1 in decreasing order using recursion
public static void DecreasingPrint(int n){
    if (n ==1){
        System.out.print(n);
        return;
    }
    System.out.print(n+ " ");
    DecreasingPrint(n-1);
}


// Print numbers from 1 to n in increasing order using recursion
public static void IncreasingPrint (int n){
    if (n ==1){
        System.out.print(n +" ");
        return;
    }
    IncreasingPrint(n-1);
    System.out.print(n+ " ");
}

// calling main method
    public static void main(String[] args) {
        int n = 10;
        DecreasingPrint(n);
        System.out.println();
        IncreasingPrint(n);
    }
}