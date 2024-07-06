class Solution {
public:
    int passThePillow(int n, int time) {
           int current = 1;
    bool forward = true;

    for (int t = 1; t <= time; ++t) {
        if (forward) {
            if (current == n) {
                forward = false;
                current--;
            } else {
                current++;
            }
        } else {
            if (current == 1) {
                forward = true;
                current++;
            } else {
                current--;
            }
        }
    }

    return current;
    }
};