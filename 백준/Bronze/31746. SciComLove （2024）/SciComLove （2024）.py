import sys

input = sys.stdin.readline
write = sys.stdout.write
string = "SciComLove"


def solution():
    N = int(input())
    if N % 2 == 0:
        write(string)
    else:
        write("".join(s for s in string[::-1]))


if __name__ == "__main__":
    solution()