class Solution {
public:
    int minOperations(vector<string>& logs) {
         int count = 0;
    for (const std::string& log : logs) {
        if (log == "../") {
            if (count > 0) {
                count--;
            }
        } else if (log != "./") {
            count++;
        }
    }
    return count;
    }
};