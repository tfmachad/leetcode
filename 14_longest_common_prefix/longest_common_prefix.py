class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        index = 0
        while index < len(strs[0]):
            c = strs[0][index]
            for s in strs[1:]:
                if index >= len(s) or s[index] != c:
                    return s[0:index]
            index += 1
        return strs[0]
