import sys

input = sys.stdin.readline
write = sys.stdout.write


def solution():
    N, M = map(int, input().split())
    pokedex_num = [""] * (N + 1)
    pokedex_name = {}

    for i in range(1, N + 1):
        name = input().strip()
        pokedex_num[i] = name
        pokedex_name[name] = str(i)

    for _ in range(M):
        request = input().strip()
        if request[0].isdigit():
            write(pokedex_num[int(request)] + "\n")
        else:
            write(pokedex_name[request] + "\n")


if __name__ == "__main__":
    solution()
