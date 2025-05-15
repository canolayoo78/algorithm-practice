import sys

input = sys.stdin.readline


def solution():
    N, M = map(int, input().split())
    true_people = list(map(int, input().split()))[1:]
    set_list = [i for i in range(N + 1)]
    party = [[] for _ in range(M)]

    def find(n):
        if set_list[n] == n:
            return n
        else:
            set_list[n] = find(set_list[n])
            return set_list[n]

    def union(a, b):
        a_rep = find(a)
        b_rep = find(b)

        if a_rep != b_rep:
            set_list[b_rep] = a_rep

    for i in range(M):
        party[i] = list(map(int, input().split()))[1:]
        p_rep = party[i][0]
        for p in party[i][1:]:
            union(p_rep, p)

    ans = 0

    for i in range(M):
        is_possible = True
        p_rep = party[i][0]
        for true_person in true_people:
            if find(p_rep) == find(true_person):
                is_possible = False
                break
        if is_possible:
            ans += 1

    print(ans)


if __name__ == "__main__":
    solution()
