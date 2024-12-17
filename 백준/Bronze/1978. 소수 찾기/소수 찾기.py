input()
l=list(map(int,input().split()))
if 1 in l: l.remove(1)
for i in l[::]:
    for j in range(2,int(i**0.5)+1):
        if i%j==0: l.remove(i);break
print(len(l))