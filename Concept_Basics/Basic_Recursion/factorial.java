package Concept_Basics.Basic_Recursion;

public class factorial {
    public long factorial(int n) {
        //your code goes here
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
}
