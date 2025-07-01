import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    A, B = map(int, input().split())

    integer_part = A // B
    write(str(integer_part) + ".")

    for _ in range(1000):
        A -= integer_part * B
        A *= 10
        integer_part = A // B
        write(str(integer_part))


if __name__ == "__main__":
    solution()
