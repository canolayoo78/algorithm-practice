import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    dict = {
        "NLCS": "North London Collegiate School",
        "BHA": "Branksome Hall Asia",
        "KIS": "Korea International School",
        "SJA": "St. Johnsbury Academy",
    }

    q = input().strip()
    write(dict[q])


if __name__ == "__main__":
    solution()
