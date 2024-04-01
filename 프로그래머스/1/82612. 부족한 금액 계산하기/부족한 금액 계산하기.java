class Solution {
    public long solution(int price, int money, int count) {
        long balance = money;
        
        for (int i = 1; i <= count; i++) {
            balance -= price * i;
        }
        
        if (balance >= 0) {
            return 0;
        }
        
        return Math.abs(balance);
    }
}