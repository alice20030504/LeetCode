class Solution:
    def romanToInt(self, s: str) -> int:
        roman = {'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000}
        total = 0
        prev = 0
        #在这里由于只有一个char比较好识别，没有对4之类的进行额外的定义。所以进行了如下推理：如果一个数字是由几个字母代表的值简单相加-->比如165=100+50+10+5=CLXV，那么前面的数字一定比后面大；但是如果一个数字是4或者9或者90(IV/IX/XC)，那么这个数字一定是前面比后面的小。这样如果从后往前看，那么数字变大就加这个数字，数字变小就减这个数字，得到的结果就是准确的。
        for char in reversed(s):
            curr = roman[char]
            if curr < prev:
                total -= curr
            else:
                total += curr
            prev = curr
        return total