class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:   
        # Time: O(n) complexity
        # Hash map for O(n) time
        num_map = {} #Stores number and its index
        for i, num in enumerate(nums):
            complement = target - num
            if complemet in num_map:
                return [num_map[complement], i]
            num_map[num] = i #Store index of current number
        


