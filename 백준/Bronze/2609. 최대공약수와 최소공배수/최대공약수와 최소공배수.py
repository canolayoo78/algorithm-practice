x, y = map(int, input().split())

a, b = x, y
while b != 0:
    a, b = b, a % b
gcd = a
lcm = (x * y) // gcd

print(gcd)
print(lcm)
