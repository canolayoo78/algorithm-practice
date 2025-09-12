import sys 

input = sys.stdin.readline 

def solution(): 
    nums = [int(input()) for _ in range(3)]
    bits = ""
    for n in nums:
        bits += format(n & 0b1111, "04b")
    password = int(bits, 2)
    
    print(f"{password:04d}")
        
if __name__ == "__main__":
    solution()
