using System;
using System.Text.RegularExpressions;

namespace dotnet
{
    ///<summary>
    /// Class that works as a kind of UI.
    ///</summary>
    public class Commands
    {
        private Farm farm;
        private string[] data;

        ///<summary>
        /// Class constructor, setup the farm
        ///</summary>
        ///<param name="data">The input array.</param>
        public Commands(string[] data)
        {
            this.farm = new Farm();
            this.data = data;
        }

        ///<summary>
        /// Obtain the command and process the input data
        ///</summary>
        public void Process()
        {
            String command = this.GetCommand();
            if (command != null)
            {
                this.VerifyCommand(command);
            }
            else
            {
                this.Help();
            }
        }

        ///<summary>
        /// Returns the command
        ///</summary>
        ///<returns>The first item in the input array, if it's given</returns>
        private String GetCommand()
        {
            return data.Length > 0 ? data[0] : null;
        }

        ///<summary>
        /// Identify the specific action to execute and call the respective action
        ///</summary>
        private void VerifyCommand(string command)
        {
            if (Array.Exists(new[] { "list", "l" }, element => element == command))
            {
                this.ListCommand();
            }
            else if (Array.Exists(new[] { "create", "c" }, element => element == command))
            {
                if (this.CreateCommand())
                {
                    this.ListCommand();
                }
            }
            else if (Array.Exists(new[] { "delete", "d" }, element => element == command))
            {
                if (this.DeleteCommand())
                {
                    this.ListCommand();
                }
            }
            else if (Array.Exists(new[] { "search", "s" }, element => element == command))
            {
                this.SearchCommand();
            }
            else if (Array.Exists(new[] { "food", "f" }, element => element == command))
            {
                this.FoodCommand();
            }
            else if (Array.Exists(new[] { "wash", "w" }, element => element == command))
            {
                this.WashCommand();
            }
            else if (Array.Exists(new[] { "alive", "a" }, element => element == command))
            {
                this.AliveCommand();
            }
            else if (Array.Exists(new[] { "help", "h" }, element => element == command))
            {
                this.Help();
            }
            else
            {
                this.Help();
            }
        }

        ///<summary>
        ///  Process the [list | l] command
        ///</summary>
        private void ListCommand()
        {
            string age = this.GetParam("age=", "(\\d+)");
            string type = this.GetParam("type=", "([a-zA-Z]+)");

            this.farm.ListAnimals(age, type);
        }

        ///<summary>
        ///  Process the [create | c] command
        ///</summary>
        ///<returns>true, if the animal was created</returns>
        private bool CreateCommand()
        {
            string name = this.GetParam("name=", "([a-zA-Z]+)");
            string type = this.GetParam("type=", "([a-zA-Z]+)");

            bool created = false;

            if (!string.IsNullOrEmpty(name))
            {
                Console.WriteLine("Name: create Animal");
                created = this.farm.CreateAnimal(name, type);
            }
            else
            {
                Console.WriteLine("Error!: A name is required to create an animal");
                this.CreateCommandHelp();
            }

            return created;
        }

        ///<summary>
        ///  Process the [delete | c] command
        ///</summary>
        ///<returns>true if the animal was deleted</returns>
        private bool DeleteCommand()
        {
            string name = this.GetParam("name=", "([a-zA-Z]+)");

            bool deleted = false;

            if (!string.IsNullOrEmpty(name))
            {
                deleted = this.farm.DeleteAnimal(name);
            }
            else
            {
                Console.WriteLine("Error!: A name is required to delete a animal");
                this.DeleteCommandHelp();
            }

            return deleted;
        }

        ///<summary>
        ///  Process the [search | s] command
        ///</summary>
        private void SearchCommand()
        {
            string name = this.GetParam("name=", "([a-zA-Z]+)");

            if (!string.IsNullOrEmpty(name))
            {
                this.farm.Search(name);
            }
            else
            {
                Console.WriteLine("Error!: A name is required to search a animal");
                this.SearchCommandHelp();
            }
        }

        ///<summary>
        ///  Process the [food | f] command
        ///</summary>
        private void FoodCommand()
        {
            string name = this.GetParam("name=", "([a-zA-Z]+)");

            if (name != null)
            {
                this.farm.Food(name);
            }
            else
            {
                Console.WriteLine("Error!: A name is required to give food to a animal");
                this.FoodCommandHelp();
            }
        }

        ///<summary>
        ///  Process the [wash | w] command
        ///</summary>
        private void WashCommand()
        {
            string name = this.GetParam("name=", "([a-zA-Z]+)");

            if (!string.IsNullOrEmpty(name))
            {
                this.farm.Wash(name);
            }
            else
            {
                Console.WriteLine("Error!: A name is required to give a shower to a animal");
                this.WashCommandHelp();
            }
        }

        ///<summary>
        ///  Process the [alive | a] command
        ///</summary>
        private void AliveCommand()
        {
            string name = this.GetParam("name=", "([a-zA-Z]+)");

            if (!string.IsNullOrEmpty(name))
            {
                this.farm.Alive(name);
            }
            else
            {
                Console.WriteLine("Error!: A name is required to show if a animal is alive");
                this.AliveCommandHelp();
            }
        }

        ///<summary>
        /// Returns the queried param using regex
        ///</summary>
        ///<param name="values">variable name to search.</param>
        ///<param name="dataType">variable pattern equivalent.</param>
        ///<returns>param, the param value if a match occurs</returns>
        private string GetParam(string value, string dataType)
        {
            string param = null;

            if (this.data.Length > 1)
            {
                string dataString = String.Join(";", this.data);
                string pattern = value+dataType;
                Regex rgx = new Regex(pattern);
                MatchCollection matches = rgx.Matches(dataString);

                if(matches.Count > 0){
                    var result = matches[0].Value.Replace(value, "");
                    if(!String.IsNullOrEmpty(result)){
                        param = result;
                    }
                }
            }

            return param;
        }

        ///<summary>
        /// Shows help for the [create | c] command
        ///</summary>
        private void CreateCommandHelp()
        {
            Console.WriteLine("The DotNET Farm - a simple command line animals app");
            Console.WriteLine();
            Console.WriteLine("Command Usage:");
            Console.WriteLine("  [create  | c]   <name=> <type=>    creates a animal with name");
            Console.WriteLine("");
            Console.WriteLine("Examples:");
            Console.WriteLine("  dotnet run [create  | c] name=my_animal_name ");
            Console.WriteLine("  dotnet run [create  | c] name=my_animal_name type=pig ");
        }

        ///<summary>
        /// Shows help for the [delete | c] command
        ///</summary>
        private void DeleteCommandHelp()
        {
            Console.WriteLine("The DotNET Farm - a simple command line animals app");
            Console.WriteLine();
            Console.WriteLine("Command Usage:");
            Console.WriteLine("  [delete  | d]   <name=>        deletes a animal by name");
            Console.WriteLine("");
            Console.WriteLine("Examples:");
            Console.WriteLine("  dotnet run [delete  | d] name=my_animal_name ");
        }

        ///<summary>
        /// Shows help for the [search | s] command
        ///</summary>
        private void SearchCommandHelp()
        {
            Console.WriteLine("The DotNET Farm - a simple command line animals app");
            Console.WriteLine();
            Console.WriteLine("Command Usage:");
            Console.WriteLine("  [search  | s]   <name=>       searchs a animal by name");
            Console.WriteLine("");
            Console.WriteLine("Examples:");
            Console.WriteLine("  dotnet run [search  | s] name=my_animal_name ");
        }

        ///<summary>
        /// Shows help for the [food | f] command
        ///</summary>
        private void FoodCommandHelp()
        {
            Console.WriteLine("The DotNET Farm - a simple command line animals app");
            Console.WriteLine();
            Console.WriteLine("Command Usage:");
            Console.WriteLine("  [food  | f]   <name=>       gives food to a animal by name");
            Console.WriteLine("");
            Console.WriteLine("Examples:");
            Console.WriteLine("  dotnet run [food  | f] name=my_animal_name ");
        }

        ///<summary>
        /// Shows help for the [wash | w] command
        ///</summary>
        private void WashCommandHelp()
        {
            Console.WriteLine("The DotNET Farm - a simple command line animals app");
            Console.WriteLine();
            Console.WriteLine("Command Usage:");
            Console.WriteLine("  [wash  | w]   <name=>       gives a shower to a animal by name");
            Console.WriteLine("");
            Console.WriteLine("Examples:");
            Console.WriteLine("  dotnet run [wash  | w] name=my_animal_name ");
        }

        ///<summary>
        /// Shows help for the [alive | a] command
        ///</summary>
        private void AliveCommandHelp()
        {
            Console.WriteLine("The DotNET Farm - a simple command line animals app");
            Console.WriteLine();
            Console.WriteLine("Command Usage:");
            Console.WriteLine("  [alive  | a]   <name=>       checks if an animal is alive by name");
            Console.WriteLine("");
            Console.WriteLine("Examples:");
            Console.WriteLine("  dotnet run [alive  | a] name=my_animal_name ");
        }

        ///<summary>
        /// Shows help for the app
        ///</summary>
        private void Help()
        {
            Console.WriteLine("The DotNET Farm - a simple command line animals app");
            Console.WriteLine("");
            Console.WriteLine("Usage:");
            Console.WriteLine("  dotnet run [command] ");
            Console.WriteLine("");
            Console.WriteLine("Available Commands:");
            Console.WriteLine("  [list    | l]   <age=>  <type=>    list all available animals");
            Console.WriteLine("  [create  | c]   <name=> <type=>    create a animal with name");
            Console.WriteLine("  [delete  | d]   <name=>            delete a animal");
            Console.WriteLine("  [search  | s]   <name=>            search a animal");
            Console.WriteLine("  [food    | f]   <name=>            give food to a animal");
            Console.WriteLine("  [wash    | w]   <name=>            give a shower to a animal");
            Console.WriteLine("  [alive   | a]   <name=>            show if a animal is alive");
            Console.WriteLine("  [help    | h]                      help about commands");
            Console.WriteLine("");
            Console.WriteLine("Flags:");
            Console.WriteLine("Use dotnet run help  for more information about a command.");
        }

    }
}
