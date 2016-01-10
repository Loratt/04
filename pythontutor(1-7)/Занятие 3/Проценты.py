P = int(input())
X = int(input())
Y = int(input())

p =  float (100 + P) / 100
y = Y + X * 100
y = y * p
x = int (y // 100)               
y = int (y % 100)     
                                                  
print (x, y) 