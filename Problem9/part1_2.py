def check(n, list1):
  for i in list1:
    for j in list1:
      if (i + j) == n:
        return True
  return False

def sum(list1):
  count = 0
  for i in list1:
    count += i 
  return count

data = []
with open("input.txt") as f:
  for i in f:
    data.append(int(i.strip()))

for i in range(0, len(data)-25):
  if check(data[i+25], data[i:i+25]) == False:
    result = data[i+25]
    resultIndex = i+25
    print("Part 1: ", result)
    break

for i in range(0, resultIndex):
  inc = 0
  j = i 
  while j < resultIndex:
    inc = sum(data[i:j+1])  
    if inc != result:
      j+=1
    else: 
      a = data[i:j]
      a.sort()
      print("Part 2: ", a[0] + a[len(a)-1])
      break
