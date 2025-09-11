import sys 

input = sys.stdin.readline 
write = sys.stdout.write 

def solution(): 
    n = int(input())
    dna = list(input())
    table = [['A', 'C', 'A', 'G'],
	    ['C', 'G', 'T', 'A'],
	    ['A', 'T', 'C', 'G'],
	    ['G', 'A', 'G', 'T']]
    
    def index(c):
        if c == 'A':
            return 0
        elif c == 'G':
            return 1
        elif c == 'C':
            return 2
        elif c == 'T':
            return 3

    while(n != 1):
        dna[n-2] = table[index(dna[n-2])][index(dna[n-1])]
        n -= 1
    
    write(dna[0])
    
if __name__ == "__main__":
    solution()
