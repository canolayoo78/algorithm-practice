import re
import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    string = input().strip()

    parts = re.split(r"D2|d2", string)
    if len(parts) > 1:
        write("D2")
    else:
        write("unrated")


if __name__ == "__main__":
    solution()
