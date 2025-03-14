import sys

input = sys.stdin.readline

def solution():
    S = input().split('-') 
    temp = []
    for i in S: 
        mid_sum = 0
        for j in i.split('+'): 
            mid_sum += int(j) 
        temp.append(mid_sum) 

    result = temp[0]
    for i in temp[1:]:
        result -= i
    
    print(result)

if __name__ == "__main__":
    solution()
