import sys
from collections import deque

input = sys.stdin.readline


def is_parenthesis_string(input_str):
    stack = deque()
    for i in range(len(input_str)):
        if input_str[i] == "(":
            stack.append("(")
        elif input_str[i] == ")":
            if stack:
                stack.pop()
            else:
                return "NO"
    if stack:
        return "NO"
    else:
        return "YES"


T = int(input())
for _ in range(T):
    print(is_parenthesis_string(input()))
