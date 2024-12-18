l=open(0).readlines()
for i in range(len(l)-1):
	a=l[i].replace("\n","")
	print("yes" if a==a[::-1] else "no")