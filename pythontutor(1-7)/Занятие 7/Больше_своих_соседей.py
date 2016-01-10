r = input()
i = 1
n = 0
while i<=(len(r)-2):
    if r[i-1]<r[i]>r[i+1]:
        n+=1 
    i+=1
print(n)