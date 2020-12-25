k1 = 12320657
k2 = 9659666 

def transform(k, l):
  return pow(k, l, 20201227)

l1 = 0
while(transform(7, l1) != k1):
  l1 += 1

l2 = 0
while(transform(7, l2) != k2):
  l2 += 1

print(transform(k1, l2))
 


  
