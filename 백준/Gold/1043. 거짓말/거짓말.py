import sys

input = sys.stdin.readline


def solution():
    def find(n):
        if set_list[n] == n:
            return n
        else:
            set_list[n] = find(set_list[n])
            return set_list[n]

    def union(a, b):
        a_rep = find(a)
        b_rep = find(b)

        if a_rep == b_rep:
            return
        elif a_rep > b_rep:
            set_list[b_rep] = a_rep
        else:
            set_list[a_rep] = b_rep

    N, M = map(int, input().split())
    set_list = [i for i in range(N + 1)]
    true_people = list(map(int, input().split()))
    parties = [list(map(int, input().split())) for _ in range(M)]

    for i in range(1, true_people[0]):
        union(true_people[i], true_people[i + 1])

    for party in parties:
        for i in range(1, party[0]):
            union(party[i], party[i + 1])

    ans = 0
    for party in parties:
        if find(party[-1]) == find(true_people[-1]):
            union(party[-1], true_people[-1])
        else:
            ans += 1

    print(ans)


if __name__ == "__main__":
    solution()
