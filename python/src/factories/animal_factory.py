from src.models.cow import Cow
from src.models.pig import Pig

class AnimalFactory:
    """
    Factory to create a new animal

    ...
    Attributes
    ----------
    type: str
        The animal type to know what kind of animal creates (default: "cow").

    Methods
    -------
    get_animal(name)
        Return a specific type of animal.
    """

    def __init__(self, animal_type : str ="cow"):
        """
        Parameters
        ----------
        animal_type : str
            The type of the animal to create (default: "cow").
        """
        self.type = animal_type if animal_type else "cow"

    def get_animal(self, name : str):
        """
        Return a specific type of animal, depending of the type of animal

        Parameters
        ----------
        name : str
            the name of the animal to create

        Return
        ------
        animal
            A new specific animal
        """
        animal = None
        if self.type == "cow":
            animal = Cow(name)
        elif self.type == "pig":
            animal = Pig(name)

        return animal
