# -*- coding: utf-8 -*-
import io
import json
import datetime
from src.factories.animal_factory import AnimalFactory

class Store:
    """
    A util class to operate with files

    ...
    Attributes
    ----------
    file : str
        file path to save the data
    animals : list
        Array contains all the animals
    default_file_doc
        contains the default file path to save the data

    Methods
    -------
    load(file=DEFAULT_FILE_LOC)
        Read the animals file

    read_animals(data)
        Creates the animals from the data parsed in load() method

    find(name)
        Search a animal in the list of animal by name

    add(animal)
        Add a new animal object

    remove(name)
        Deletes a animal by name

    save()
        Parse the animal list into json data and store in a file
    """
    DEFAULT_FILE_LOC : str = "animals.json"

    def __init__(self, file : str = DEFAULT_FILE_LOC):
        """
        Parameters
        ----------
        file : str
            file path to save the data
        """
        self.file : str = file
        self.animals : list = []
        self.default_file_doc : str = file

    def load(self, file : str = DEFAULT_FILE_LOC):
        """
        Read the animals file and calls the read_animals() method to store the animals in a list

        Return
        ------
        None

        Raises
        ------
        JSONDecodeError
            if the data couldn't be parsed, or if the data is empty
        IOError
            if a problem occurs when opening, writing or closing
        """
        try:
            animals_file = io.open(self.default_file_doc)

            data = json.load(animals_file)
            if data:
                self.read_animals(data)
        except:
            print("Data couldn't be loaded")

    def read_animals(self, data : dict):
        """
        Creates the animals from the data parsed.

        Parameters
        ----------
        data : dict
            json dict parsed from file

        Return
        ------
        None
        """
        for i in data:
            animal = AnimalFactory(i['kind']).get_animal(i['name'])
            animal.last_wash = datetime.datetime.strptime(i['last_wash'], "%Y-%m-%d %H:%M:%S.%f")
            animal.last_food = datetime.datetime.strptime(i['last_food'], "%Y-%m-%d %H:%M:%S.%f")
            animal.alive = i['alive']
            self.animals.append(animal)

    def find(self, name : str):
        """
        Search a animal in the list of animal by name

        Parameters
        ----------
        name : str
            the name of the animal

        Return
        ------
        animal : Animal
            The equivalent animal object to the given name
        """
        animal = list(filter(lambda x: x.name == name, self.animals))
        return animal[0] if len(animal) > 0 else None

    def add(self, animal : any):
        """
        Add a new animal object

        Parameters
        ----------
        animal : Animal
            the animal object to add

        Return
        ------
        True
            if the animal was added successfully
        False
            otherwise
        """
        self.animals.append(animal)
        added = self.save()
        return added

    def remove(self, name : str):
        """
        Deletes an animal by name

        Parameters
        ----------
        name : str
            the name of the animal

        Return
        ------
        True
            if the animal was deleted successfully\n
        False
            otherwise
        """
        animal = self.find(name)
        deleted = False

        if animal:
            self.animals.remove(animal)
            deleted = self.save()

        return deleted

    def save(self):
        """
        Parse the animal list into json data and store in a file

        Return
        ------
        True
            if the data was saved successfully
        False
            if an error occurs

        Raises
        ------
        JSONDecodeError
            if the given JSON document is not valid
        IOError
            if a problem occurs when opening, writing or closing
        """
        try:
            animals_data = list(map(lambda x: x.__dict__, self.animals))

            animals_file = io.open(self.default_file_doc, "w")

            data = json.dumps(animals_data, default=str)

            animals_file.write(data)

            animals_file.close()

            return True
        except:
            return False



