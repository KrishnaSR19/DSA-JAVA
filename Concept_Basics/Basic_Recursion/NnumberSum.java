package Concept_Basics.Basic_Recursion;

public class NnumberSum {
    public int NnumbersSum(int N) {
        //your code goes here
        if(N==0){
            return 0;
        }

        return N+NnumbersSum(N-1);
    }
}
