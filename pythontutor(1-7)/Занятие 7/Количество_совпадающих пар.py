a=list(input().split(' '))
c = 0;
for i in a:
    for j in a:
        if i == j:
           c+=1
    c-=1
print (int(c/2))