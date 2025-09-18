import unittest
from solution import Solution

class SolutionTest(unittest.TestCase):

    def test(self):
        self.assertEqual(Solution().threeSumClosest([4,0,5,-5,3,3,0,-4,-5], -2), -2)