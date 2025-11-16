class Solution:
    def intToRoman(self, num: int) -> str:
        # List of tuples with Roman values and their symbols
        val_syms = [
            (1000,'M'),(900,'CM'),(500,'D'),(400,'CD'),
            (100,'C'),(90,'XC'),(50,'L'),(40,'XL'),
            (10,'X'),(9,'IX'),(5,'V'),(4,'IV'),(1,'I')
        ]
        res = ""
        for val, sym in val_syms:
        # While num is greater than or equal to the value, append the symbol and subtract the value
            while num >= val:
                res += sym
                num -= val
        return res
        