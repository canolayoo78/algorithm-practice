import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    hour, minute, second = map(int, input().split())
    cook_time_sec = int(input())

    cook_time_hour = cook_time_sec // 3600
    cook_time_sec %= 3600
    cook_time_min = cook_time_sec // 60
    cook_time_sec %= 60

    second += cook_time_sec
    if second >= 60:
        second -= 60
        minute += 1

    minute += cook_time_min
    if minute >= 60:
        minute -= 60
        hour += 1

    hour += cook_time_hour
    if hour >= 24:
        hour -= 24 * (hour // 24)

    print(hour, minute, second)


if __name__ == "__main__":
    solution()
