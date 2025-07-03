import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    integer = input().strip()

    while integer != "0":
        while len(integer) != 1:
            digit_root = 0
            for i in integer:
                digit_root += int(i)
            integer = str(digit_root)
        write(integer + "\n")
        integer = input().strip()


if __name__ == "__main__":
    solution()
