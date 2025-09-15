import unittest
from romans import Solution

class TestSolution(unittest.TestCase):
    rti_cases = [
        ('III', 3), ('LVIII', 58), ('MCMXCIV', 1994)
    ]

    def test_rti(self):
        for roman, integer in self.rti_cases:
            self.assertEqual(Solution().romanToInt(roman), integer)