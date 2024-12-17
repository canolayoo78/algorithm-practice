N = int(input())
numbers = list(map(int, input().split()))


def is_prime(number):
    if number <= 1:
        return False
    for i in range(2, number):
        if number % i == 0:
            return False
    return True


sum = 0

for number in numbers:
    if is_prime(number):
        sum += 1

print(sum)
