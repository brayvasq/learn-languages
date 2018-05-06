| Lenguaje | Versión              | SO                |
| -------- | --------------       | ----------------- |
| Golang   | go version go1.9.5   | Linux - Fedora 27 |


## Variables
#### Tipos de Datos
```go
//Cadenas
var variable_cadena  string 
variable_cadena = "Hola Mundo"
//Enteros
var var_entera int
var_entera = 5
//Decimales
var var_decimal float = 10.4
var_decimal = 10.4
//Booleana
var var_booleana bool
var_booleana = true

// Inferencia de tipos
var_t := "Valor"
```
**Nota :** *El tipo de dato se puede omitir* 

#### Estructuras de Control

##### Condicionales
Estructura condicional If
```go
if condicion{
    fmt.Println("condición if")
}
else if condicion_dos{
    fmt.Println("condución elsif")
}
else{
    fmt.Print("default")
}
```

Operador Ternario
```go
variable := func() bool {if cow.Age <= 25 {return true }else{return false}}()
c := map[bool]int{true: 1, false: 0} [5 > 4]
```

Estructura condicional Switch
```go
i := 2
switch i {
case 1:
    fmt.Println("one")
case 2:
    fmt.Println("two")
case 3:
    fmt.Println("three")
}
```

##### Bucles o Ciclos
Estructura ciclica for

```go
// Clasic
for i:=0; i<limit; i++{

}

// foreach
for _,val := range list{

}

// While
for i < limit{

}

// Infinite
for {

}

```

#### Estructuras de Datos
Arreglos o Listas
```go

var_arreglo := []int
var_arreglo[0] = 1

var_lista:= make([]int,0)
// Añadir elemento
var_lista = append(var_arreglo,item)

// Recorrer
for _,i := range var_lista{
    print(i)
}

// Acceder a una posición
var_item = var_lista[pos]
```
#### Métodos y Objetos
Definir Métodos
```go
func Metodo(){
    return 5
}

// Método con parametro
func Metodo(valor int) int{
    return valor
}
```

Definir Clases
```go
type Clase struct

// Constructor
type Clase struct{
    valor int
}


// Instanciar
objeto := Clase{5}
```

Composición
```go
type Padre struct{
    valor int
}

func (p *Padre) Metodo(){
    fmt.Println("Hola")
}

type Hijo struct{
    Padre
}

objeto := Hijo(Padre{5})
objeto.metodo()
```