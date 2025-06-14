class Solution:
    def minMaxDifference(self, num: int) -> int:
        s = str(num)
        return int(s.replace((s+'_').lstrip('9')[0],'9'))-int(s.replace(s[0],'0'))