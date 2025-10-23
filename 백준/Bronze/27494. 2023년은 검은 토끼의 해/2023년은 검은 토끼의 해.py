import sys 

input = sys.stdin.readline 
write = sys.stdout.write 

def solution():    
    def is_winner(serial):
        target = '2023'
        idx = 0
        for c in serial:
            if c == target[idx]:
                idx += 1
                if idx == 4:
                    return True
        return False
                   
    n = int(input())
    count = 0
    for num in range(1, n + 1):
        s = str(num)
        if len(s) >= 4 and is_winner(s):
            count += 1
    write(str(count))
    
if __name__ == "__main__":
    solution()