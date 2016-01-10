N = int(input())
count = 0
for i in range(N):
    num = int(input())
    count += (lambda x: 1 if x == 0 else 0)(num)  
print(count)