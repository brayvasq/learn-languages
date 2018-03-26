| Lenguaje | Versión              | SO                |
| -------- | ---------------------| ----------------- |
| C#       | dotnet core 2.1.4    | Linux - Fedora 27 |

## Variables
#### Tipos de Datos
```c#
//Accesores
{public|private|protected} {int|string|double ...} variable;
//Cadenas
string variable_cadena = "Hola Mundo";
//Enteros
int var_entera = 5;
//Decimales
float var_float = 10;
double var_double = 12.3;
//Booleana
bool var_booleana = true;
```
#### Tipos de variable
```c#
//Variable local - accesible solo en su scope
string var_local = "Soy una variable local";
//Variable de objeto - accesible en toda la clase
string var_objeto;
this.var_objeto = "Soy una variable de objeto";

//Variable de clase - una sola variable para todos los objetos o instacia de la clase
static string var_clase = "Soy una variable de clase";
```
#### Estructuras de Control

##### Condicionales
Estructura condicional If
```c#
if(condicion){
    Console.WriteLine("condición if");
}
else if(condicion_dos){
    Console.WriteLine("condución else if");    
}
else{
    Console.WriteLine("default");        
}
```

Operador Ternario
```c#
bool var_bool = condicion? true:false;
```

Estructura condicional Switch
```c#
switch(variable){
    case valor:
        System.out.println("Es valor 1");  
        break;
    default:
        System.out.println("default");  
        break;
}
```

##### Bucles o Ciclos
Estructura ciclica for

```c#
// For normal
for(var i;i<10;i++){
    Console.WriteLine(i);  
}
// For each
for(Object i in lista){
    Console.WriteLine(i.atributo);  
}
```

Estructura ciclica while
```c#
while(condicion){
    Console.WriteLine("Iterando");  
}
```
#### Estructuras de Datos
Arreglos o Listas
```c#
//Arreglo estatico
int[] var_arreglo = new int[5];
//Lista
List<int> var_lista = new List<>();
//Añadir elemento
var_arreglo[1] = 1;
var_lista.Add(1);
//Borrar elemento
var_lista.Remove(1);


//Obtener valor
var_arreglo[1];
var_lista.[1];
```
#### Métodos y Objetos
Definir Métodos
```c#
{public|private|protected} {void|int|String...} nombre(String param,...){}
//Ejemplo
public void saludar(String nombre){
    Console.WriteLine("Hola : "+nombre);  
}
```

Definir Clases
```c#
namespace ejemplo{
    public class Clase{

    }
}


//Constructor
namespace ejemplo{
    class Clase{
        public Clase(params...){
            this.param1 = param1;
        }
    }
}

//Instanciar
Clase objeto = new Clase(params...);
```

Herencia e Implementación
```c#

//Herencia
namespace ejemplo{
    public abstract class Padre{
        string attr1;
        public Padre(string attr1){
            this.attr1 = attr1;
        }

        public void info(){/*Code*/}

        //Métodos abstractos
        public abstract void saludar();
    }
}

namespace ejemplo{
    class Hijo : Padre{
        public Hijo(string attr1):base(attr1){

        }

        public override void saludar(){/*Code*/}
    }
}


Padre objeto = new Hijo(params...)
objeto.info();
objeto.saludar();


//Implementación
namespace ejemplo{
    public interface Padre{
        public abstract int metodo1();
        public abstract void metodo2();
    }
}
namespace ejemplo{
    public class Hijo : Padre{
        
        public override int metodo1(){/*Code*/}
        
        public override void metodo2(params...){/*Code*/}
    }
}

Padre objeto = new Hijo(params...);
objeto.metodo1();
objeto.metodo2(params...);
```