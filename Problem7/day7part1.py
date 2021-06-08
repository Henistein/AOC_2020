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
                  

print(len(get_bags('shiny gold')))
