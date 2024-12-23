import sys

input = sys.stdin.readline

N = input()
nums = input().split()
nums_dict = {i: "1" for i in nums}

M = input()
print('\n'.join([nums_dict.get(v, '0') for v in input().rstrip().split(' ')]))
