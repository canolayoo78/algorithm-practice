import sys

input = sys.stdin.readline


def is_parenthesis_string(input_str):
    while True:
        if "()" in input_str:
            input_str = input_str.replace("()", "")
        else:
            break

    if input_str:
        return "NO"
    else:
        return "YES"


T = int(input())
for _ in range(T):
    print(is_parenthesis_string(input().strip()))
