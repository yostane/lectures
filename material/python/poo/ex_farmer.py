class Animal:
    def __init__(self, date_naissance, etat_sante):
        """etat_stante est égal à 0 si tout va bien et 1 si l'animal est malade"""
        self.date_naissance = date_naissance
        self.etat_sante = etat_sante

    def __repr__(self):
        return f"({self.__class__.__name__}: {self.date_naissance})"


class Vache(Animal):
    pass


class Poule(Animal):
    pass


class ArbreFruitier:
    def __init__(self, hauteur):
        self.hauteur = hauteur
        
    def __repr__(self):
        return f"({self.__class__.__name__}: {self.hauteur})"


class Pommier(ArbreFruitier):
    pass


class Poirier(ArbreFruitier):
    pass

class Fermier:
    def __init__(self, nom, animaux = [], arbres_fruitiers = []):
        self.nom = nom
        self.animaux = animaux
        self.arbres_fruitiers = arbres_fruitiers
        
    def arroser(self):
        print("💦🌱")

    def __str__(self):
        return f"{self.nom}. Animaux: {self.animaux}. Fruits: {self.arbres_fruitiers}"



animaux = [
    Vache("2024-01-10", 0),
    Vache("2023-05-11", 1),
    Poule("2001-06-02", 0),
    Poule("2020-06-24", 0),
    Poule("2023-05-11", 0),
    Poule("2023-05-11", 0),
]

arbres_fruitiers = [
    Pommier(10),
    Poirier(50),
    Poirier(25)
]

fermier = Fermier("Fave", animaux, arbres_fruitiers)
print(fermier)