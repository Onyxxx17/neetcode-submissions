class Solution:
    def jump(self, nums: List[int]) -> int:
        farthest = math.inf
        r = len(nums) - 1
        total = 0
        while r > 0:
            for i in range (r-1,-1,-1):
                if nums[i] + i >= r:
                    farthest = min(farthest,i)

            r = farthest
            total+=1

        return total


            
