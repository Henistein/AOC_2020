with open('input') as file:
  data = file.readlines()
  data = [int(line.strip()) for line in data]

#Part 1
def count_jolts():
  data.append(0)
  data.sort()
  d1 = 0
  d3 = 1

  for i in range(len(data)-1):
    xs = data[i+1] - data[i]  
    if xs == 1:
      d1+=1
    if xs == 3:
      d3+=1
  return d1*d3

#Part 2
S = {}
def arrangements(inc):
  if inc == len(data)-1:
    return 1
  if inc in S:
    return S[inc]
  res = 0
  for i in range(inc+1, len(data)):
    if data[i] - data[inc] <= 3:
      res += arrangements(i)
  S[inc] = res
  return res

inc = 0
print(count_jolts())
print(arrangements(inc))
