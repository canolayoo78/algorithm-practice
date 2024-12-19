import sys
N = int(sys.stdin.readline())
words = list(set([sys.stdin.readline().strip() for _ in range(N)]))
words.sort()
print('\n'.join(sorted(words, key=len)))