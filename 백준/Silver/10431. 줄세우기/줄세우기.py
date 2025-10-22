import sys 

input = sys.stdin.readline 
write = sys.stdout.write

def solution():
    data = list(map(int, input().split()))
    test_num = data[0]
    heights = data[1:]
    line = []
    moves = 0
    for h in heights:
        insert_pos = len(line)
        for i in range(len(line)):
            if line[i] > h:
                insert_pos = i
                break
        moves += len(line) - insert_pos
        line.insert(insert_pos, h)
    write(str(test_num) +" " + str(moves) +"\n")
                   
if __name__ == "__main__":
    t = int(input())
    for i in range(t):
        solution()