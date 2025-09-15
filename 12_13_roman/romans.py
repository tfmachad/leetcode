class Solution:
    value_symbols = [
        (1000, 'M'), (900, 'CM'), (500, 'D'), (400, 'CD'), (100, 'C'), (90, 'XC'), (50, 'L'), (40, 'XL'), (10, 'X'), (9, 'IX'), (5, 'V'), (4, 'IV'), (1, 'I')
    ]

    def intToRoman(self, num: int) -> str:
        l = []
        i = 0
        while num > 0:
            if num < self.value_symbols[i]:
                i += 1
            else:
                num -= self.value_symbols[i][0]
                l.append(self.value_symbols[i][1])

        return ''.join(l)
    
    def romanToInt(self, s: str) -> int:
        num = 0
        i = 0 # string
        j = 0 # list
        while i < len(s):
            if s[i] == self.value_symbols[j][1]:
                num += self.value_symbols[j][0]
                i += 1
            elif i < len(s) - 1 and s[i:i+2] == self.value_symbols[j][1]:
                num += self.value_symbols[j][0]
                i += 2
            else:
                j += 1
        return num
            


