class Solution {
public:
    string reverseVowels(string s) {
        unordered_set<char> vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    int left = 0, right = s.length() - 1;

    while (left < right) {
        if (vowels.count(s[left]) == 0) {
            left++;
        } else if (vowels.count(s[right]) == 0) {
            right--;
        } else {
            std::swap(s[left++], s[right--]);
        }
    }

    return s;
    }
};