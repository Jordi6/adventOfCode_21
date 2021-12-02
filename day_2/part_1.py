

def readFile():
    with open("input.txt") as f:
        lines = f.readlines()
        nums = [line.rstrip() for line in lines]
        return nums

def calculate(nums):
    horizontal = 0
    depth = 0

    for i in range(len(nums)):
        s = nums[i].split()
        command = s[0]
        amount = int(s[1])
    
        if command == "forward":
            horizontal += amount
        elif command == "down":
            depth += amount
        elif command == "up":
            depth -= amount
        
    print(horizontal * depth)
 
data = readFile()
calculate(data)

# test data 
# nums = [
# "forward 5",
# "down 5",
# "forward 8",
# "up 3",
# "down 8",
# "forward 2"
# ]



