class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        n = len(nums)

        if n < 3:
            return result # can't make triplets out of 2 or less numbers
        
        nums = sorted(nums)
        for i in range(n - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue # to avoid duplicates
            if nums[i] > 0:
                break # since no possible sums left

            left = i + 1
            right = n - 1
            while left < right:
                sum = nums[i] + nums[left] + nums[right]
                if sum == 0:
                    result.append([nums[i], nums[left], nums[right]])
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    left += 1
                    right -= 1
                elif sum < 0:
                    left += 1
                else: # sum > 0
                    right -= 1
        return result