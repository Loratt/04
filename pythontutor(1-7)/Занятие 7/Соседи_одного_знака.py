r = input()
i = 1
while i<=(len(r)):
    if r[i-1]<0 and r[i]<0 or r[i-1]>0 and r[i]>0:
        print(r[i-1]+" "+r[i])
    i+=1