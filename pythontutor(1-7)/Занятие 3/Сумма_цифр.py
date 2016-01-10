from math import ceil
a = int(input())
print(int(a/100)+ceil((a%100-a%10)/10)+a%10)