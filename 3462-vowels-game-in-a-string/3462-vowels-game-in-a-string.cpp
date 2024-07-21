class Solution {
public:
    bool doesAliceWin(string s) {
        string s1 = "aeiou";
        for(int i =0; i<s.length();i++){
            for(int j=0; j<s1.length();j++){
                if(s[i]==s1[j]) return true;
            }
        }
        return false;
    }
};