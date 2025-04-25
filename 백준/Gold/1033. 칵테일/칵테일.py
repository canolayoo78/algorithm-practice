import sys

input = sys.stdin.readline
print = sys.stdout.write


def solution():
    N = int(input())
    graph = [[] for _ in range(N)]
    visit = [False] * N
    ingredients = [1] * N

    def gcd(a, b):
        while b != 0:
            a, b = b, a % b
        return a

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
        ingredients[0] *= p * q // gcd(p, q)

    ingredients_gcd = ingredients[0]
    dfs(0)

    for ingredient in ingredients:
        ingredients_gcd = gcd(ingredients_gcd, ingredient)

    for ingredient in ingredients:
        print(str(ingredient // ingredients_gcd) + " ")


if __name__ == "__main__":
    solution()
