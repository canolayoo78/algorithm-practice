import sys
from queue import PriorityQueue

input = sys.stdin.readline
print = sys.stdout.write


def solution():
    N = int(input())
    queue = PriorityQueue()

    for _ in range(N):
        request = int(input())
        if request == 0:
            if queue.empty():
                print("0\n")
            else:
                temp = queue.get()
                print(str((temp[1])) + "\n")
        else:
            queue.put((abs(request), request))


if __name__ == "__main__":
    solution()
