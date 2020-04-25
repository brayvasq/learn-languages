# -*- coding: utf-8 -*-
from .factories.animal_factory import AnimalFactory
from .utils.store import Store

class Farm:
    """
    A class that works as a kind of controller.

    ...
    Attributes
    ----------
    store: Store
        Object that will help to persist and do CRUD operations for animals objects

    Methods
    -------
    list_animals(age=None, animal_type=None)
        List all the animals stored. Also, it can filter the animals by animal type and age

    create_animal(name, animal_type):
        Uses the AnimalFactory to create a new animal

    delete_animal(name)
        Deletes a animal by name

    search(name)
        Search a animal by name

    food(name)
        Gives food to a animal

    wash(name)
        Gives a shower to a animal

    alive(name)
        Tell if a animal is alive
    """

    def __init__(self):
        """
        Parameters
        ----------
        """
        self.store : Store = Store()
        self.store.load()

    def list_animals(self, age=None, animal_type=None):
        """
        List all the animals stored. Also, it can filter the animals by animal type and age

        Parameters
        ----------
        age : int
            The value to filter animals by age (default: None).
        animal_type : str
            The value to filter animals by animal type (default: None).

        Return
        ------
        None
        """
        animal_list : list = self.store.animals

        if age: animal_list = list(filter(lambda x: x.age == age, animal_list))
        if animal_type: animal_list = list(filter(lambda x: x.kind == animal_type, animal_list))

        for animal in animal_list:
            print(animal)

    def create_animal(self, name, animal_type):
        """
        Uses the AnimalFactory to create a new animal

        Parameters
        ----------
        name : str
            The name of the animal
        animal_type : str
            The animal type

        Return
        ------
        True
            if the animal was created successfully
        False
            otherwise
        """
        created = False
        animal = AnimalFactory(animal_type).get_animal(name)

        if animal:
            self.store.add(animal)
            created = True

        return created

    def delete_animal(self, name):
        """
        Deletes a animal by name

        Parameters
        ----------
        name : str
            The name of the animal

        Return
        ------
        True
            if the animal was deleted successfully
        False
            otherwise
        """
        return self.store.remove(name)

    def search(self, name):
        """
        Search a animal by name and print the animal info

        Parameters
        ----------
        name : str
            the name of the animal

        Return
        ------
        None
        """
        animal = self.store.find(name)
        if animal:
            print(animal)
        else:
            print("Animal not found")

    def food(self, name):
        """
        Gives food to an animal

        Parameters
        ----------
        name : str
            the name of the animal

        Return
        ------
        None
        """
        animal = self.store.find(name)
        if animal:
            animal.eat()
            self.store.save()

    def wash(self, name):
        """
        Gives a shower to an animal

        Parameters
        ----------
        name : str
            the name of the animal

        Return
        ------
        None
        """
        animal = self.store.find(name)
        if animal:
            animal.wash()
            self.store.save()

    def alive(self, name):
        """
        Prints if an animal is alive

        Parameters
        ----------
        name : str
            the name of the animal

        Return
        ------
        None
        """
        animal = self.store.find(name)
        if animal:
            print(animal.is_alive())
