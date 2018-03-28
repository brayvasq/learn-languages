<?
    namespace App;
    include_once './Animals/Cow.php';
    include_once './Animals/Sheep.php';
    include_once './Farm/Farm.php';
    /**
     * @author brayvasq <brayvasq@gmail.com>
     * @version 0.1
     * @since 2018-03-25
     * This is the principal in to program. 
     * This class interact with the user through a inputs.
     */
    class Main{
        /**
         * This methods is the constructor of the class.
         * This create the function readline for input of user if not exist
         */
        function __construct(){
            echo "The PHP Farm\n";
            if(!function_exists("readline")) {
                function readline($prompt = null){
                    if($prompt){
                        echo $prompt;
                    }
                    $fp = fopen("php://stdin","r");
                    $line = rtrim(fgets($fp, 1024));
                    return $line;
                }
            }
        }

        /**
         * This is the main method. Use the other class in the app and
         * Interact with the user.
         */
        public function main(){
            $option = 0;
            $message = "\n\n1.Add Animal\n".
                        "2.Del Animal\n".
                        "3.Get Info Farm\n".
                        "4.Get Info Animals\n".
                        "5.Search Animal\n".
                        "6.Sort by price\n".
                        "7.Exit\n";

            $farm = new Farm("My Farm","Av 34");

            while($option!=7){
                echo $message;
                $option = (int)readline("Option : ");
                if($option==1){
                    echo "\n\n Create Animal : \n";
                    $id = (String)readline("Id : ");
                    $name = (String)readline("Name : ");
                    $age = (int)readline("Age : ");
                    $weight = (float)readline("Weight : ");
                    $price = (float)readline("Price : ");

                    $type_animal = (int)readline("Type : 1.Sheep - 2.Cow : ");
                    $animal = null;
                    switch ($type_animal) {
                        case 1:
                            $animal = new Sheep($id,$name,$age,$weight,$price);
                            break;
                        case 2:
                            $animal = new Cow($id,$name,$age,$weight,$price);  
                            break;
                        default:
                            echo "Error in type";
                            break;
                    }
                    $farm->addAnimal($animal);
                }elseif($option==2){
                    $id = (String)readline("Id to delete : ");
                    $farm->delAnimal($id);
                }elseif($option==3){
                    $farm->getInfo();
                }elseif($option==4){
                    $farm->getAnimalsInfo();
                }elseif($option==5){
                    $id = (String)readline("Id to search : ");
                    $animal = $farm->searchAnimal($id);
                    $animal->getInfo();
                }elseif($option==6){
                    $animals = $farm->sortByPrice();
                    foreach ($animals as $i) {
                        echo "Id : {$i->getId()} - Price : {$i->getPrice()}";
                    }
                }
            }
        }
    }
    
    $main = new Main();
    $main->main();
?>