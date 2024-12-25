import sys

read = sys.stdin.readline
write = sys.stdout.write

x = [False] * 21

m = int(read())
for _ in range(m):
    command = read().split()
    num = 0
    if len(command) > 1:
        num = int(command[1])
    if command[0] == 'add':
        x[num] = True
    elif command[0] == 'remove':
        x[num] = False
    elif command[0] == 'check':
        write(str(1 if x[num] else 0) + '\n')
    elif command[0] == 'toggle':
        x[num] = not x[num]
    elif command[0] == 'all':
        x = [True] * 21
    elif command[0] == 'empty':
        x = [False] * 21