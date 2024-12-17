n, m = map(int, input().split())
cards = list(map(int, input().split()))
ans = 0

cards.sort()

for i in range(n):
  a = i
  left = i+1
  right = n-1
  while left<right:
    total = cards[left] + cards[right] + cards[a]
    if total <= m:
      if total > ans:
        ans = total
      left += 1
    else:
      right -= 1
    
print(ans)