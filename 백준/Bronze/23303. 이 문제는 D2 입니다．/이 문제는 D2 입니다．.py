import sys

input = sys.stdin.readline
write = sys.stdout.write

def solution():
    string = input().strip()

    if "d2" in string or "D2" in string:
        write("D2")
    else:
        write("unrated")


if __name__ == "__main__":
    solution()
