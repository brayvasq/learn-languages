import datetime
from .animal import Animal

class Pig(Animal):
    """
    A child class, representing a Pig. It extends from Animal class

    ...
    Attributes
    ----------
    name : str
        the name of the Pig.
    age : str
        the  age of the Pig
    last_wash : datetime
        the last time the Pig showered
    last_food : datetime
        the last time the Pig ate
    alive : bool
        represents if the Pig is still alive
    kind : str
        It represents the Pig type
    _limit_wash_days : int
        limit of minutes in which the Pig didn't take a shower
    _limit_food : int
        limit of minutes in which the Pig doesn't eat

    Methods
    -------
    get_info()
        Return the Pig info.

    get_character()
        Return the Pig character. It implements the parent method.

    speak()
        Return the Pig sound. It implements the parent method.

    eat()
        Gives food to the Pig.

    wash()
        Gives the Pig a shower

    is_alive()
        Calculates if the Pig is still alive
    """

    def __init__(self, name : str):
        """
        Parameters
        ----------
        name : str
            the name of the Pig
        """
        Animal.__init__(self, name)
        self._limit_food : int = 2
        self._limit_wash : int = 5
        self.kind : str = "pig"

    def get_character(self):
        """
        returns the Pig character.

        Return
        ------
        character : str 
            The Pig character
        """
        return  "（`（●●）´）" if self.is_alive() else "（x（●●）x）"

    def speak(self):
        """
        returns the Pig sound.

        Return
        ------
        sound : str
            The Pig sound
        """
        return  "Oink Oink!!!"

    def __str__(self):
        return self.get_info()
