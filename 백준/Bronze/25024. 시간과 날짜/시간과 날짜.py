import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    def is_time(x, y):
        if 0 <= x and x < 24 and 0 <= y and y < 60:
            return True
        else:
            return False

    def is_date(x, y):
        if 0 <= x and x <= 12 and 1 <= y:
            if x in (1, 3, 5, 7, 8, 10, 12) and y <= 31:
                return True
            elif x in (4, 6, 9, 11) and y <= 30:
                return True
            elif x == 2 and y <= 29:
                return True
            else:
                return False
        else:
            return False

    def ans(bool):
        return "Yes" if bool else "No"

    T = int(input())
    for _ in range(T):
        x, y = map(int, input().split())
        print(ans(is_time(x, y)), ans(is_date(x, y)))


if __name__ == "__main__":
    solution()
