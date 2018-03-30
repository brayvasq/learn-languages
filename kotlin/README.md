| Lenguaje | Versión                  | SO                |
| -------- | -------------------------| ----------------- |
| Kotlin   | Kotlin version "0.6.2.0" | Linux - Fedora 27 |

## Variables
#### Tipos de Datos
```kotlin
//Accesores
{var|val|} variable : {Int|String|Double ...} 
//Cadenas
var variable_cadena : String = "Hola Mundo"
//Enteros
var var_entera : Int = 5
//Decimales
var var_float : Float = 10
var var_double : Double = 12.3
//Booleana
var var_booleana : Boolean = true
```
#### Tipos de variable
```kotlin
//Variable local - accesible solo en su scope
var var_local : String = "Soy una variable local"
//Variable de objeto - accesible en toda la clase
var var_objeto : String = ""
this.var_objeto = "Soy una variable de objeto"

//Variable de clase - una sola variable para todos los objetos o instacia de la clase
static var var_clase : String = "Soy una variable de clase"

//Constante
val var_constante : "Hola"
```
#### Estructuras de Control

##### Condicionales
Estructura condicional If
```kotlin
if(condicion){
    println("condición if")
}
else if (condicion_dos){
    println("condución else if");    
}
else{
    println("default");        
}
```

Operador Ternario
```kotlin
// no hay pero se fuede emular
Boolean var_bool = when{ condicion -> true else -> false}
Boolean var_bool = if (condicion) true else false
```

Estructura condicional Switch
```kotlin
when{
    condicion -> println("Es valor 1")
    
    else -> println("default")
}
```

##### Bucles o Ciclos
Estructura ciclica for

```kotlin
// For normal
for(i in 1 until limit){
    println(i);  
}
// For each
for(e in this.animals){
    println(i.atributo) 
}

//For each arraylist
arraylist.iterator().forEach{
    print("valor ${it}")
}
```

Estructura ciclica while
```kotlin
while(condicion){
    println("Iterando") 
}
```
#### Estructuras de Datos
Arreglos o Listas
```kotlin
//Arreglo estatico
var var_arreglo = Array(5)
//Arreglo dinámico
var var_arreglo_dinamico : ArrayList<Int>  = new ArrayList<>()
//Añadir elemento
var_arreglo[1] = 1
var_arreglo_dinamico.add(1)
//Borrar elemento
var_arreglo_dinamico.remove(1)

//Obtener valor
var_arreglo[1]
var_arreglo.dinamico.get(1)
```
#### Métodos y Objetos
Definir Métodos
```kotlin
func nombre(String param,...) : {String|Int|...}{}
//Ejemplo
fun saludar(nombre:String) : String{
    println("Hola : ${nombre}");  
}
```

Definir Clases
```kotlin
class Clase{

}


//Constructor
class Clase(var param1 : String){
    init{
        this.param1 = ""
    }
}

//Instanciar
var objeto : Clase = Clase(params...)
```

Herencia e Implementación
```kotlin

//Herencia
abstract class Padre(var attr1 : String){
  
    init{

    }

    fun info(){/*Code*/}

    //Métodos abstractos
    abstract fun saludar()
}

class Hijo(attr1 : String) : Padre(attr1){

    
    override fun saludar(){/*Code*/}
}


var objeto : Padre = Hijo(params...)
objeto.info()
objeto.saludar()


//Implementación
interface Padre{
    abstract fun metodo1(): Int
    abstract fun metodo2(params ...)
}

public class Hijo : Padre{
    
    override fun metodo1() : Int{/*Code*/}
    
    override fun metodo2(params...){/*Code*/}
}

var objeto : Padre = Hijo(params...)
objeto.metodo1()
objeto.metodo2(params...)
```