import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline


def solution():
    def find(n):
        if rep[n] == n:
            return n
        else:
            rep[n] = find(rep[n])
            return rep[n]

    def union(a, b):
        a_rep = find(a)
        b_rep = find(b)

        if a_rep == b_rep:
            return
        elif a_rep < b_rep:
            rep[b_rep] = a_rep
        else:
            rep[a_rep] = b_rep

    v, e = map(int, input().split())
    edges = []
    ans = []
    rep = [i for i in range(v + 1)]
    for _ in range(e):
        start, end, weight = map(int, input().split())
        edges.append((start, end, weight))
    edges.sort(key=lambda x: x[2])
    
    i = 0
    while len(ans) < v - 1:
        start, end, weight = edges[i]
        if find(start) != find(end):
            union(start, end)
            ans.append(weight)
        i += 1
    print(sum(ans))


if __name__ == "__main__":
    solution()
