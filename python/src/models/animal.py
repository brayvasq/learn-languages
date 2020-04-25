# -*- coding: utf-8 -*-
import datetime
from src.utils.dates import Dates
from typing import abstractmethod

class Animal:
    """
    A parent class representing a general Animal.

    ...
    Attributes
    ----------
    name : str
        the name of the animal
    age : str
        the  age of the animal
    last_wash : datetime
        the last time the animal showered
    last_food : datetime
        the last time the animal ate
    alive : bool
        represents if the animal is still alive
    kind : str
        It represents the animal type
    _limit_wash_days : int
        limit of minutes in which the animal didn't take a shower
    _limit_food : int
        limit of minutes in which the animal doesn't eat

    Methods
    -------
    get_info()
        Method that return the animal info, it's implemented in the child classes

    @abstractmethod
    get_character()
        Abstract method that return the animal character, it's implemented in the child classes

    @abstractmethod
    speak()
        Abstract method that return the animal sound, it's implemented in the child classes

    eat()
        Gives food to the animal

    wash()
        Gives the animal a shower

    is_alive()
        Calculates if the animal is still alive
    """

    def __init__(self, name : str =""):
        """
        Parameters
        ----------
        name : str
            the name of the animal
        """
        self.name : str = name
        self.age : int = 0
        self.last_wash : any = datetime.datetime.now()
        self.last_food : any = datetime.datetime.now()
        self.alive : bool = True
        self._limit_wash : int = 0
        self._limit_food : int = 0
        self.kind : str = ""

    def get_info(self):
        """
        returns the Animal info.

        Return
        ------
        info : str, the full Animal info
        """
        character = self.get_character()
        animal = "#"*50 + "\n"
        animal += character + "\n"
        animal += "Name: "+ str(self.name) + "\n"
        animal += "Alive: " + str(self.alive) + "\n"
        animal += "Sound: " + self.speak() + "\n"
        animal += "Wash time limit: " + str(self._limit_food - Dates.get_diff_in_minutes(self.last_wash)) + "\n"
        animal += "Food time limit: " + str(self._limit_food - Dates.get_diff_in_minutes(self.last_food)) + "\n"
        animal += "#"*50 + "\n"

        return animal

    @abstractmethod
    def speak(self):
        """
        Abstract method, it return the animal sound. it's implemented in the child classes
        """
        pass

    @abstractmethod
    def get_character(self):
        """
        Abstract method, it return the animal character. it's implemented in the child classes
        """
        pass

    def eat(self):
        """
        Gives food to the animal. It changes the last_food attribute and assign the actual date
        """
        self.last_food = datetime.datetime.now()

    def wash(self):
        """
        Gives the animal a shower. It changes the last_food attribute and assign the actual date
        """
        self.last_wash = datetime.datetime.now()

    def is_alive(self):
        """
        Calculates if the animal is still alive. Uses the util Date to determinate the
        difference in minutes between the last_wash and last_food attributes and their
        respective limits

        Return
        ------
        False
            if one of the limits was exceeded
        True
            otherwise
        """
        if Dates.is_greatter(self.last_wash, self._limit_wash):
            self.alive = False

        if Dates.is_greatter(self.last_food, self._limit_food):
            self.alive = False

        return self.alive
