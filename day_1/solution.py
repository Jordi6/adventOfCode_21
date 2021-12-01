






# read file & create list
def read():
    with open("input.txt") as f:
        nums = [int(x) for x in f]
        return nums

def part_1(nums):
    count = 0
    for i in range(1,len(nums)):
        
        if nums[i-1] < nums[i]:
            count += 1
    print(count)
    

def part_2(nums):
    count = 0
    last = nums[0] + nums[1] + nums[2]
    
    for i in range(2,len(nums)-1):
        nxt = nums[i - 1] + nums[i] + nums[i + 1]
        if nxt > last:
            count += 1
        last = nxt    
            
    print(count)
    
            
def test():
    # first part should be 7 results
    nums = [199,200,208,210,200,207,240,269,260,263]
    count = 0
    for i in range(1,len(nums)):

        if nums[i-1] < nums[i]:
            count += 1

    print(count)
    #second part - should be 5 results
    count = 0
    last = nums[0] + nums[1] + nums[2]
    
    for i in range(2,len(nums)-1):
        nxt = nums[i - 1] + nums[i] + nums[i + 1]
        if nxt > last:
            count += 1
            last = nxt
            
    print(count)
    

 
myList = read()
part_1(myList)
part_2(myList)
    