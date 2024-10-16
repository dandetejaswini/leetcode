class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();
        while (a > 0 || b > 0 || c > 0) {
            if (result.length() >= 2 && result.charAt(result.length() - 1) == result.charAt(result.length() - 2)) {
                if (result.charAt(result.length() - 1) == 'a') {
                    if (b >= c && b > 0) {
                        result.append('b');
                        b--;
                    } else if (c > 0) {
                        result.append('c');
                        c--;
                    } else {
                        break;
                    }
                } else if (result.charAt(result.length() - 1) == 'b') {
                    if (a >= c && a > 0) {
                        result.append('a');
                        a--;
                    } else if (c > 0) {
                        result.append('c');
                        c--;
                    } else {
                        break;
                    }
                } else {
                    if (a >= b && a > 0) {
                        result.append('a');
                        a--;
                    } else if (b > 0) {
                        result.append('b');
                        b--;
                    } else {
                        break;
                    }
                }
            } else {
                if (a >= b && a >= c && a > 0) {
                    result.append('a');
                    a--;
                } else if (b >= c && b > 0) {
                    result.append('b');
                    b--;
                } else if (c > 0) {
                    result.append('c');
                    c--;
                }
            }
        }
        return result.toString();
    }
}