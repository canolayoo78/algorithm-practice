import sys 

input = sys.stdin.readline 
write = sys.stdout.write 

def solution(): 
    N = int(input())
    
    ans = "%.300f" % (1 / 2 ** N)
    
    slice_index = len(ans)
    for i in range(slice_index - 1, -1, -1):
        if ans[i] != '0':
            slice_index = i + 1
            break
    write(ans[:slice_index])
    

if __name__ == "__main__":
    solution()
