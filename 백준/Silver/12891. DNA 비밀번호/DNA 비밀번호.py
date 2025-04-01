import sys

input = sys.stdin.readline
# print = sys.stdout.write


def solution():
    P, S = map(int, input().split())
    DNA_string = input().strip()
    target = list(map(int, input().split()))

    start = DNA_string[:S]

    now = [0] * (4)
    now[0] = start.count("A")
    now[1] = start.count("C")
    now[2] = start.count("G")
    now[3] = start.count("T")
    ans = 0
    for i in range(S, P + 1):
        sol = True
        for j in range(4):
            if now[j] < target[j]:
                sol = False
        if sol is True:
            ans += 1

        if i == P:
            break

        last = DNA_string[i - S]
        if last == "A":
            now[0] -= 1
        elif last == "C":
            now[1] -= 1
        elif last == "G":
            now[2] -= 1
        else:
            now[3] -= 1

        new = DNA_string[i]
        if new == "A":
            now[0] += 1
        elif new == "C":
            now[1] += 1
        elif new == "G":
            now[2] += 1
        else:
            now[3] += 1

    print(ans)


if __name__ == "__main__":
    solution()
