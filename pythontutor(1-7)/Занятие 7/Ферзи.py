i=0
j=0
b=0
a=[]
while i < 8:
        a = input().split()
        i+=1
i=0
while i < 6:
            while j < 8:
                if (int(a[i]) - int(a[j]))>1 and int(a[i + 1]) != int(a[j + 1]) or int(a[i + 1]) - int(a[j + 1])>1 and int(a[i]) != int(a[j]):
                    b = 1;
                    print("YES")
                    break;
                j += 2
            if b == 1:
                break;
if b != 1:
        print("NO")