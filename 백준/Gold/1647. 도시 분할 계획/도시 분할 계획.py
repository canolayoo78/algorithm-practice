import sys 

input = sys.stdin.readline 

def solution():
    n, m = map(int, input().split())
    edges = []
    parent = [i for i in range(n + 1)]
    size = [1] * (n+1)
    
    for _ in range(m):
        s, e, w = map(int, input().split())
        edges.append((s, e, w))
        
    edges.sort(key=lambda x: x[2])
 
    def find(x):
        if parent[x] == x:
            return x
        parent[x] = find(parent[x])
        return parent[x]
    
    def union(a, b):
        parent_of_a = find(a)
        parent_of_b = find(b)
        
        if parent_of_a == parent_of_b:
            return False
        
        if size[parent_of_a] < size[parent_of_b]:
            parent_of_a, parent_of_b = parent_of_b, parent_of_a
        parent[parent_of_b] = parent_of_a
        size[parent_of_a] += size[parent_of_b]
        return True
    
    mst_sum = 0
    mst_max = 0
    picked_edges = 0
    for s, e, w in edges:
        if union(s, e):
            mst_sum += w
            mst_max = max(mst_max, w)
            picked_edges += 1
            if picked_edges == n-1:
                break
    print(mst_sum - mst_max)
    
if __name__ == "__main__":
    solution()
