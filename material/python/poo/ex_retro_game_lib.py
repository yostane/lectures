class VideoGameConsole:
  def __init__(self, name: str, manufacturer: str, release_year: int):
    self.name = name
    self.release_year = release_year
    self.manufacturer = manufacturer
    
  def __str__(self):
    return f"The {self.name} was release in {self.release_year} and manufactured by {self.manufacturer}"
  
  def __repr__(self):
    return self.__str__()
  
class VideoGame:
  def __init__(self, name: str, developer: str, release_year: int):
    self.name = name
    self.release_year = release_year
    self.developer = developer
    
  def __str__(self):
    return f"The game {self.name} was release in {self.release_year} and was developed by {self.developer}"
  
  def __repr__(self):
    return self.__str__()
  
consoles: list[VideoGameConsole] = [
  VideoGameConsole("DegaDrive", "Dega", 1992),
  VideoGameConsole("Satourne", "Dega", 1995),
  VideoGameConsole("Super Nontendo", "Nontendo", 1991),
  VideoGameConsole("Nontendo", "Nontendo", 1983),
  VideoGameConsole("Ponystation", "Pony", 1996)
]

games: list[VideoGame] = [
  VideoGame("Sanic", "Dega", 1991),
  VideoGame("Spodermin", "Morvel", 1992),
  VideoGame("Y-Men", "Morvel", 1993),
  VideoGame("Nario", "Nontendo", 1985),
  VideoGame("Zebda", "Nontendo", 1986),
  VideoGame("First Fantasy", "Rectangle", 1987),
  VideoGame("Paper Gear", "Bonami", 1987)
]

nontendo_consoles: list[VideoGameConsole] = []
ninety_consoles : list[VideoGameConsole] = []
for console in consoles:
  if console.manufacturer == "Nontendo":
    nontendo_consoles.append(console)
  if console.release_year >= 1990:
    ninety_consoles.append(console)

print("La liste des consoles fabriquées par Nontendo", nontendo_consoles)
print("La liste des consoles fabriquées par Nontendo méthode 2", [c for c in consoles if c.manufacturer == "Nontendo"])

print("La liste des consoles >= 1990", ninety_consoles)
print("La liste des consoles >= 1990 méthode 2", [c for c in consoles if c.release_year >= 1990])

morvel_games: list[VideoGame] = []
eighty_five_consoles : list[VideoGame] = []
for game in games:
  if game.developer == "Morvel":
    morvel_games.append(game)
  if game.release_year >= 1985:
    eighty_five_consoles.append(game)
    
print("La liste des jeux développés par Morvel", morvel_games)
print("La liste des jeux développés par Morvel méthode 2", [g for g in games if g.developer == "Morvel"])

print("La liste des jeux >= 1990", eighty_five_consoles)
print("La liste des jeux >= 1990 méthode 2", [g for g in games if g.release_year >= 1985])