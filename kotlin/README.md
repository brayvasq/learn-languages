| Lenguaje | Versión              | SO                |
| -------- | ---------------------| ----------------- |
| Java     | java version "9.0.4" | Linux - Fedora 27 |

## Variables
#### Tipos de Datos
```java
//Accesores
{public|private|protected} {int|String|double ...} variable;
//Cadenas
String variable_cadena = "Hola Mundo";
//Enteros
int var_entera = 5;
//Decimales
float var_float = 10;
double var_double = 12.3
//Booleana
boolean var_booleana = true;
```
#### Tipos de variable
```java
//Variable local - accesible solo en su scope
String var_local = "Soy una variable local";
//Variable de objeto - accesible en toda la clase
String var_objeto;
this.var_objeto = "Soy una variable de objeto";

//Variable de clase - una sola variable para todos los objetos o instacia de la clase
static String var_clase = "Soy una variable de clase";
```
#### Estructuras de Control

##### Condicionales
Estructura condicional If
```java
if(condicion){
    System.out.println("condición if");
}
else if condicion_dos{
    System.out.println("condución else if");    
}
else{
    System.out.println("default");        
}
```

Operador Ternario
```java
boolean var_bool = condicion? true:false;
```

Estructura condicional Switch
```java
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

```java
// For normal
for(int i;i<10;i++){
    System.out.println(i);  
}
// For each
for(Object i: lista){
    System.out.println(i.atributo);  
}
```

Estructura ciclica while
```java
while(condicion){
    System.out.println("Iterando");  
}
```
#### Estructuras de Datos
Arreglos o Listas
```java
//Arreglo estatico
int[] var_arreglo = new int[5];
//Arreglo dinámico
ArrayList<Integer> var_arreglo_dinamico = new ArrayList<>();
//Lista
LinkedList<Integer> var_lista = new LinkedList<>();
//Añadir elemento
var_arreglo[1] = 1;
var_arreglo_dinamico.add(1);
var_lista.add(1);
//Borrar elemento
var_arreglo_dinamico.remove(1);
var_lista.remove(1);


//Obtener valor
var_arreglo[1];
var_arreglo.dinamico.get(1);
var_lista.get(1);
```
#### Métodos y Objetos
Definir Métodos
```java
{public|private|protected} {void|int|String...} nombre(String param,...){}
//Ejemplo
public void saludar(String nombre){
    System.out.println("Hola : "+nombre);  
}
```

Definir Clases
```java
public class Clase{

}


//Constructor
class Clase{
    public Clase(params...){
        this.param1 = param1;
    }
}

//Instanciar
Clase objeto = new Clase(params...);
```

Herencia e Implementación
```java

//Herencia
public abstract class Padre{
    String attr1;
    public Padre(String attr1){
        this.attr1 = attr1;
    }

    public void info(){/*Code*/}

    //Métodos abstractos
    public abstract void saludar();
}

class Hijo extends Padre{
    public Hijo(String attr1){
        super(att1)
    }

    @Override
    public void saludar(){/*Code*/}
}


Padre objeto = new Hijo(params...)
objeto.info();
objeto.saludar();


//Implementación
public interface Padre{
    public abstract int metodo1();
    public abstract void metodo2();
}

public class Hijo implements Padre{
    @Override
    public int metodo1(){/*Code*/}
    @Override
    public void metodo2(params...){/*Code*/}
}

Padre objeto = new Hijo(params...);
objeto.metodo1();
objeto.metodo2(params...);
```