'''
@author: Conor Murphy, Justin Palmer
'''


class College:
    def __init__(self, name):
        self.name = name.upper()

    def __eq__(self, other):
        return self.name == other.name

    def __lt__(self, other):
        if self.name == "SBCC" or self.name == "SANTA BARBARA CITY COLLEGE":
            return True
        elif other.name == "SBCC" or other.name == "SANTA BARBARA CITY COLLEGE":
            return False
        else:
            return self.name < other.name

    def __gt__(self, other):
        if self.name == "SBCC" or self.name == "SANTA BARBARA CITY COLLEGE":
            return False
        elif other.name == "SBCC" or other.name == "SANTA BARBARA CITY COLLEGE":
            return True
        else:
            return self.name > other.name

    def __ge__(self, other):
        if self.name == "SBCC" or self.name == "SANTA BARBARA CITY COLLEGE":
            return False
        elif other.name == "SBCC" or other.name == "SANTA BARBARA CITY COLLEGE":
            return True
        else:
            return self.name >= other.name
        return self.name == other.name

    def __le__(self, other):
        if self.name == "SBCC" or self.name == "SANTA BARBARA CITY COLLEGE":
            return True
        elif other.name == "SBCC" or other.name == "SANTA BARBARA CITY COLLEGE":
            return False
        else:
            return self.name <= other.name
