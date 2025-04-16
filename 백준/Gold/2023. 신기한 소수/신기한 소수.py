import sys

sys.setrecursionlimit(10000)
input = sys.stdin.readline
print = sys.stdout.write


def solution():
    N = int(input())

    def is_prime(num):
        for i in range(2, int((num ** (1 / 2))) + 1):
            if num % i == 0:
                return False

        return True

    def make_number(number):
        if len(str(number)) == N:
            print(str(number) + "\n")

        else:
            for i in range(1, 10, 2):
                next_number = number * 10 + i
                if is_prime(next_number):
                    make_number(next_number)

    make_number(2)
    make_number(3)
    make_number(5)
    make_number(7)


if __name__ == "__main__":
    solution()
