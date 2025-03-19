public boolean isPalindrome(int n) {
    int newNum = 0;
    int ori = n;
    while (n != 0) {
        int d = n % 10;
        newNum = (newNum * 10) + d;
        n = n / 10;

    }
    ;
    if (newNum == ori) {
        return true;
    }
    return false;

}
