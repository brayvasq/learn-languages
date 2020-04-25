import re
from .farm import Farm

class Commands:
    """
    Class that works as a kind of UI

    ...
    Attributes
    ----------
    app : Farm
        The app that will handle the actions
    data : list
        Input array taken from sys.argv
    data_len : int
        Input array length

    Methods
    -------
    process()
        Obtain the command and process the input data

    get_command()
        Return the command

    __verify_command()
        Identify the acction to execute

    __list_command()
        Process the [list | l] command

    __create_command()
        Process the [create | c] command

    __delete_command()
        Process the [delete | c] command

    __search_command()
        Process the [search | s] command

    __food_command()
        Process the [food   | f] command

    __wash_command()
        Process the [wash   | w] command

    __alive_command()
        Process the [alive  | a] command

    __get_param(value, data_type)
        Returns the queried param

    __create_command_help()
        Shows help for the [create | c] command

    __delete_command_help()
        Shows help for the [delete | c] command

    __search_command_help()
        Shows help for the [search | s] command

    __food_command_help()
        Shows help for the [food   | f] command

    __wash_command_help()
        Shows help for the [wash   | w] command

    __alive_command_help()
        Shows help for the [alive  | a] command

    __help()
        Shows help for the app
    """
    def __init__(self, data):
        """
        Parameters
        ----------
        data : list
            The input array
        """
        self.app = Farm()
        self.data = data
        self.data_len = len(self.data)

    def process(self):
        """
        Obtain the command and process the input data

        Return
        ------
        None
        """
        command = self.get_command()

        if command:
            self.__verify_command(command)
        else:
            self.__help()

    def get_command(self):
        """
        Returns the command

        Return
        ------
        command : str
            The second item in the input array, if it's given
        None
            otherwise
        """
        command = None

        if self.data_len > 1:
            command = self.data[1]

        return command

    def __verify_command(self, command):
        """
        Identify the specific action to execute and call the respective action

        ...
        Parameters
        ----------
        command : str
            Command obtained from get_command() method

        Return
        ------
        None
        """
        if command in ["list", "l"]:
            self.__list_command()
        elif command in ["create", "c"]:
            if self.__create_command():
                self.__list_command()   # Showing animals
        elif command in ["delete", "d"]:
            if self.__delete_command():
                self.__list_command()   # Showing animals
        elif command in ["search", "s"]:
            self.__search_command()
        elif command in ["food", "f"]:
            self.__food_command()
        elif command in ["wash", "w"]:
            self.__wash_command()
        elif command in ["alive", "a"]:
            self.__alive_command()
        elif command in ["h", "help"]:
            self.__help()
        else:
            self.__help()

    def __list_command(self):
        """
        Process the [list | l] command

        Return
        ------
        None
        """
        age = self.__get_param("age=", "(\d+)")
        animal_type = self.__get_param("type=", "([a-zA-Z]+)")

        self.app.list_animals(age=age, animal_type=animal_type)

    def __create_command(self):
        """
        Process the [create | c] command

        Return
        ------
        True
            if the animal was created
        """
        name = self.__get_param("name=", "([a-zA-Z]+)")
        animal_type = self.__get_param("type=", "([a-zA-Z]+)")

        created = False

        if name:
            created = self.app.create_animal(name, animal_type)
        else:
            print("Error!: A name is required to create an animal")
            self.__create_command_help()

        return created

    def __delete_command(self):
        """
        Process the [delete | c] command

        Return
        ------
        True
            if the animal was deleted
        """
        name = self.__get_param("name=", "([a-zA-Z]+)")

        deleted = False
        if name:
            deleted = self.app.delete_animal(name)
        else:
            print("Error!: A name is required to delete a animal")
            self.__delete_command_help()
        return deleted

    def __search_command(self):
        """
        Process the [search | s] command

        Return
        ------
        None
        """
        name = self.__get_param("name=", "([a-zA-Z]+)")
        if name:
            self.app.search(name)
        else:
            print("Error!: A name is required to search a animal")
            self.__search_command_help()

    def __food_command(self):
        """
        Process the [food   | f] command

        Return
        ------
        None
        """
        name = self.__get_param("name=", "([a-zA-Z]+)")
        if name:
            self.app.food(name)
        else:
            print("Error!: A name is required to give food to a animal")
            self.__food_command_help()

    def __wash_command(self):
        """
        Process the [wash   | w] command

        Return
        ------
        None
        """
        name = self.__get_param("name=", "([a-zA-Z]+)")
        if name:
            self.app.wash(name)
        else:
            print("Error!: A name is required to give a shower to a animal")
            self.__wash_command_help()

    def __alive_command(self):
        """
        Process the [alive  | a] command

        Return
        ------
        None
        """
        name = self.__get_param("name=", "([a-zA-Z]+)")
        if name: 
            self.app.alive(name)
        else:
            print("Error!: A name is required to show if a animal is alive")
            self.__alive_command_help()

    def __get_param(self, value, data_type):
        """
        Returns the queried param using regex

        Parameters
        ----------
        value : str
            variable name to search
        data_type : str
            variable pattern equivalent

        Return
        ------
        param : str
            the param value if a match occurs
        None
            otherwise
        """
        param = None

        if self.data_len > 2:
            data_str = ';'.join(self.data[2:])
            param = re.search(value+data_type, data_str)
            if param:
                param = param.group(1).replace(value, '') if param.group(1) else None

        return param

    def __create_command_help(self):
        """
        Shows help for the [create | c] command

        Return
        ------
        None
        """
        print("The Python Farm - a simple command line animals app")
        print()
        print("Command Usage:")
        print("  [create  | c]   <name=> <type=>    creates a animal with name")
        print("")
        print("Examples:")
        print("  python main.py [create  | c]  name=my_animal_name")
        print("  python main.py [create  | c]  name=my_animal_name type=pig")

    def __delete_command_help(self):
        """
        Shows help for the [delete | c] command

        Return
        ------
        None
        """
        print("The Python Farm - a simple command line animals app")
        print()
        print("Command Usage:")
        print("  [delete  | d]   <name=>        deletes a animal by name")
        print("")
        print("Examples:")
        print("  python main.py [delete  | d]  name=my_animal_name")

    def __search_command_help(self):
        """
        Shows help for the [search | s] command

        Return
        ------
        None
        """
        print("The Python Farm - a simple command line animals app")
        print()
        print("Command Usage:")
        print("  [search  | s]   <name=>       searchs a animal by name")
        print("")
        print("Examples:")
        print("  python main.py [search  | s]  name=my_animal_name")

    def __food_command_help(self):
        """
        Shows help for the [food   | f] command

        Return
        ------
        None
        """
        print("The Python Farm - a simple command line animals app")
        print()
        print("Command Usage:")
        print("  [food  | f]   <name=>       gives food to a animal by name")
        print("")
        print("Examples:")
        print("  python main.py [food  | f]  name=my_animal_name")

    def __wash_command_help(self):
        """
        Shows help for the [wash   | w] command

        Return
        ------
        None
        """
        print("The Python Farm - a simple command line animals app")
        print()
        print("Command Usage:")
        print("  [wash  | w]   <name=>       gives a shower to a animal by name")
        print("")
        print("Examples:")
        print("  python main.py [wash  | w]  name=my_animal_name")

    def __alive_command_help(self):
        """
        Shows help for the [alive  | a] command

        Return
        ------
        """
        print("The Python Farm - a simple command line animals app")
        print()
        print("Command Usage:")
        print("  [alive  | a]   <name=>       checks if an animal is alive by name")
        print("")
        print("Examples:")
        print("  python main.py [alive  | a]  name=my_animal_name")

    def __help(self):
        """
        Shows help for the app

        Return
        ------
        None
        """
        print("The Python Farm - a simple command line animals app")
        print()
        print("Usage:")
        print("  python main.py [command]")
        print()
        print("Available Commands:")
        print("  [list    | l]   <age=>  <type=>    list all available animals")
        print("  [create  | c]   <name=> <type=>    create a animal with name")
        print("  [delete  | d]   <name=>            delete a animal")
        print("  [search  | s]   <name=>            search a animal")
        print("  [food    | f]   <name=>            give food to a animal")
        print("  [wash    | w]   <name=>            give a shower to a animal")
        print("  [alive   | a]   <name=>            show if a animal is alive")
        print("  [help    | h]                      help about commands")
        print("")
        print("Flags:")
        print("  -v, --version  show the app version")
        print("")
        print("Use python main.py [command] --help for more information about a command.")

