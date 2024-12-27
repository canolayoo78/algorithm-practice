import sys

sys.setrecursionlimit(10**4)
input = sys.stdin.readline


def solution():
    A = int(input())
    B = int(input())
    C = int(input())
    print(A + B - C)
    print(int(str(A) + str(B)) - C)


solution()
