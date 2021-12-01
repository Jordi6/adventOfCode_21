






# read file & create list
def read():
    with open("input.txt") as f:
        nums = [int(x) for x in f]
        return nums

def sol(nums):
    count = 0
    for i in range(1,len(nums)):
        
        if nums[i-1] < nums[i]:
            count += 1
    return count
            
def test():
    nums = [199,200,208,210,200,207,240,269,260,263]
    count = 0
    for i in range(1,len(nums)):
        
        if nums[i-1] < nums[i]:
            count += 1
            
    return count
    
print(test())

myList = read()
print(sol(myList))

