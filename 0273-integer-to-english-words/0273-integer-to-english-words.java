class Solution {
    private final String[] thousands = {"", "Thousand", "Million", "Billion"};
    private final String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder words = new StringBuilder();
        int thousandIndex = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                words.insert(0, convertLessThanOneThousand(num % 1000) + " " + thousands[thousandIndex] + " ");
            }
            num /= 1000;
            thousandIndex++;
        }
        return words.toString().trim();
    }

    private String convertLessThanOneThousand(int num) {
        if (num == 0) return "";
        else if (num < 20) return belowTwenty[num];
        else if (num < 100) return tens[num / 10] + (num % 10 != 0 ? " " + belowTwenty[num % 10] : "");
        else return belowTwenty[num / 100] + " Hundred" + (num % 100 != 0 ? " " + convertLessThanOneThousand(num % 100) : "");
    }
}