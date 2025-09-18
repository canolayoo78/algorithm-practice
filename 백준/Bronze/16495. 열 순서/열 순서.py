import sys 

input = sys.stdin.readline 

def solution(): 
    col = input().strip()
    result = 0
    for ch in col:
        result = result * 26 + (ord(ch) - ord('A') + 1)
    print(result)
    

if __name__ == "__main__":
    solution()
