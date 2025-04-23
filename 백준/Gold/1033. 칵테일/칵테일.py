import sys


input = sys.stdin.readline
print = sys.stdout.write


def solution():
    N = int(input())
    graph = [[] for _ in range(N)]
    visit = [False] * N
    ingredients = [0] * N
    lcm = 1

    def gcd(a, b):
        if b == 0:
            return a
        else:
            return gcd(b, a % b)

    def dfs(start):
        visit[start] = True
        for i in graph[start]:
            next = i[0]
            if not visit[next]:
                ingredients[next] = ingredients[start] * i[2] // i[1]
                dfs(next)

    for _ in range(N - 1):
        a, b, p, q = map(int, input().split())
        graph[a].append((b, p, q))
        graph[b].append((a, q, p))
        lcm *= p * q // gcd(p, q)

    ingredients[0] = lcm
    dfs(0)

    ingredients_gcd = lcm
    for ingredient in ingredients:
        ingredients_gcd = gcd(ingredients_gcd, ingredient)

    for ingredient in ingredients:
        print(str(ingredient // ingredients_gcd) + " ")


if __name__ == "__main__":
    solution()
