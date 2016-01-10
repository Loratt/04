r = input()
i = 1
while i<=(len(r)):
    if r[i-1]<r[i]:
        print(r[i])
    i+=1