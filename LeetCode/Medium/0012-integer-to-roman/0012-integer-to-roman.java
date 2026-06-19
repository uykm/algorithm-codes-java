class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int thousands = num / 1000;
        int hundreds = (num % 1000) / 100;
        int tens = (num % 100) / 10;
        int ones = num % 10;

        for (int i = 0; i < thousands; i++) {
            sb.append("M");
        }

        sb.append(convertDigit(hundreds, "C", "D", "M"));
        sb.append(convertDigit(tens, "X", "L", "C"));
        sb.append(convertDigit(ones, "I", "V", "X"));

        return sb.toString();
    }

    private String convertDigit(int digit, String one, String five, String ten) {
        switch (digit) {
            case 0:
                return "";
            case 1:
                return one;
            case 2:
                return one + one;
            case 3:
                return one + one + one;
            case 4:
                return one + five;
            case 5:
                return five;
            case 6:
                return five + one;
            case 7:
                return five + one + one;
            case 8:
                return five + one + one + one;
            case 9:
                return one + ten;
        }

        return "";
    }
}