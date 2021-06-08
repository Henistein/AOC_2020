with open('input') as file:
  data = file.readlines()
  data = [line.strip() for line in data]

def get_bags(color):
  lines = [ line for line in data if color in line and line.index(color) != 0]
  all_colors = set()
  
  if len(lines) != 0:
    colors = set()
    for i in lines:
      colors.add(i[:i.index(' bags')])

    for i in colors:
      all_colors.add(i)
      all_colors = set.union(all_colors, get_bags(i))

  return all_colors

def individual_bags(color):
  lines = [ line for line in data if color in line and line.index(color) == 0 ] 
  shiny_colors = []
  
  for i in lines:
    shiny_colors += i.split(' contain ')[1].split(', ')

  aux = []
  for i in shiny_colors:  
    aux.append(i.replace(' bags', '').replace(' bag', '').replace('.', ''))

  shiny_colors = aux

  if 'no other' in shiny_colors:
    return 1

  inc = 1
  for i in shiny_colors:
    inc += int(i[:i.index(' ')]) * individual_bags(i[i.index(' ')+1:])

  return inc
    

if __name__ == '__main__':
  #Part1
  print(len(get_bags('shiny gold')))

  #Part2
  print(individual_bags('shiny gold') - 1)
