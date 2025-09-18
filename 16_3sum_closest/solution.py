class Solution:
    def threeSumClosest(self, nums, target: int) -> int:
        # if nums is ordered, we can make positional inferences about the numbers found as we traverse the list
        nums = sorted(nums) # O(n log n)
        count = len(nums)

        closest = None
        if count < 3:
            return closest

        # we can traverse the list one number at a time and then dealing with the rest of the array as a two-sum problem, with left and right pointers starting at the next and last positions

        for i in range(count - 2):
            left = i + 1
            right = count - 1

            while left < right:
                number = self.get_sum(nums, i, left, right)
                if number == target:
                    return number
                
                if closest == None or abs(number - target) < abs(closest - target): # if we got a number closer to the target
                    closest = number

                # move to increase or lower the sum as appropriate, skipping duplicate numbers
                if number < target:
                    while left < right - 1 and nums[left] == nums[left + 1]: left += 1
                    left += 1
                elif number > target:
                    while right > left and nums[right] == nums[right - 1]: right -= 1
                    right -= 1

        return closest


    def get_sum(self, nums, i, j, k):
        return nums[i] + nums[j] + nums[k]
