| Lenguaje | Versión              | SO                |
| -------- | ---------------------| ----------------- |
| PHP      | PHP 7.2.3 (cli)      | Linux - Fedora 27 |

## Variables
#### Tipos de Datos
```php
//Accesores
{public|private|protected} $variable;
//Cadenas
$variable_cadena = "Hola Mundo";
//Enteros
$var_entera = 5;
//Decimales
$var_float = 10.3;
//Booleana
$var_booleana = true;
```
#### Tipos de variable
```php
//Variable local - accesible solo en su scope
$var_local = "Soy una variable local";
//Variable de objeto - accesible en toda la clase
$var_objeto;
$this->var_objeto = "Soy una variable de objeto";

//Variable de clase - una sola variable para todos los objetos o instacia de la clase
static $var_clase = "Soy una variable de clase";
```
#### Estructuras de Control

##### Condicionales
Estructura condicional If
```php
if(condicion){
    echo "condición if";
}
elseif(condicion_dos){
    echo "condución else if";    
}
else{
    echo "default";        
}
```

Operador Ternario
```php
$var_bool = condicion? true:false;
```

Estructura condicional Switch
```php
switch($variable){
    case 1:
        echo "Es valor 1";  
        break;
    default:
        echo "default";  
        break;
}
```

##### Bucles o Ciclos
Estructura ciclica for

```php
// For normal
for($i=0;$i<10;$i++){
    echo $i;  
}
// For each
for($array as $item){
    echo $i->atributo;  
}
```

Estructura ciclica while
```php
while(condicion){
    echo "Iterando";  
}
```
#### Estructuras de Datos
Arreglos o Listas
```php
//Lista
$var_lista = array();
//Añadir elemento
array_push($var_lista,1);
//Borrar elemento
unset($var_lista[1]);


//Obtener valor
$var_lista[1];
```
#### Métodos y Objetos
Definir Métodos
```php
{public|private|protected} function nombre(String param,...) : {int|String...}{}
//Ejemplo
public function saludar(String nombre){
    echo "Hola : ".$nombre;  
}
```

Definir Clases
```php
namespace ejemplo;
class Clase{
}

//Constructor
namespace ejemplo;
class Clase{
    function __construct(type params...){
        $this->param1 = $param1;
    }
}


//Instanciar
$objeto = new Clase($params...);
```

Herencia e Implementación
```php

//Herencia
namespace ejemplo;
abstract class Padre{
    public $attr1;
    public __construct(string $attr1){
        $this->attr1 = $attr1;
    }

    public function info(){/*Code*/}

    //Métodos abstractos
    public abstract function saludar();
}


namespace ejemplo;
class Hijo extends Padre{
    public __construct(string $attr1){
        parent::__construct($attr1);
    }

    public function saludar(){/*Code*/}
}


$objeto = new Hijo($params...);
$objeto->info();
$objeto->saludar();


//Implementación
namespace ejemplo;
public interface Padre{
    public abstract int metodo1();
    public abstract void metodo2($params...);
}

namespace ejemplo;
public class Hijo implements Padre{
        
    function __construct($params...){}

    public function metodo1(){/*Code*/}
        
    public function metodo2($params...){/*Code*/}
}


$objeto = new Hijo($params...);
$objeto->metodo1();
$objeto->metodo2($params...);
```