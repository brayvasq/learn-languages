import datetime
from .animal import Animal

class Cow(Animal):
    """
    A child class, representing a Cow. It extends from Animal class

    ...
    Attributes
    ----------
    name : str
        the name of the Cow.
    age : str
        the  age of the Cow
    last_wash : datetime
        the last time the Cow showered
    last_food : datetime
        the last time the Cow ate
    alive : bool
        represents if the Cow is still alive
    kind : str
        It represents the Cow type
    _limit_wash_days : int
        limit of minutes in which the Cow didn't take a shower
    _limit_food : int
        limit of minutes in which the Cow doesn't eat

    Methods
    -------
    get_info()
        Return the Cow info.

    get_character()
        Return the Cow character. It implements the parent method.

    speak()
        Return the Cow sound. It implements the parent method.

    eat()
        Gives food to the Cow.

    wash()
        Gives the Cow a shower

    is_alive()
        Calculates if the Cow is still alive
    """

    def __init__(self, name : str):
        """
        Parameters
        ----------
        name : str
            the name of the Cow
        """
        Animal.__init__(self, name)
        self._limit_food : int = 3
        self._limit_wash : int = 10
        self.kind : str = "cow"

    def get_character(self):
        """
        returns the Cow character. depending on the is_alive() method

        Return
        ------
        character : str 
            The Cow character
        """
        character =  "  (....)  \n"
        character += "（0 .. 0）" if self.is_alive() else "（X .. X）"
        return character

    def speak(self):
        """
        returns the Cow sound.

        Return
        ------
        sound : str 
            The Cow sound
        """
        return  "Muuu Muuu!!!"

    def __str__(self):
        return self.get_info()
