| Lenguaje | Versión              | SO                |
| -------- | --------------       | ----------------- |
| Golang   | go version go1.9.5   | Linux - Fedora 27 |


## Variables
#### Tipos de Datos
```go
#Cadenas
var variable_cadena  string 
variable_cadena = "Hola Mundo"
#Enteros
var var_entera int
var_entera = 5
#Decimales
var var_decimal float = 10.4
var_decimal = 10.4
#Booleana
var var_booleana bool
var_booleana = true

# Inferencia de tipos
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
```python
#En python no hay una estructura de control llamada switch
```

##### Bucles o Ciclos
Estructura ciclica for

```python
for i in range(0,limite):
    print("Soy "+str(i))
```

Estructura ciclica while
```python
while condicion:
    print("Iterando")
```
#### Estructuras de Datos
Arreglos o Listas
```python
var_arreglo : list = []
# Añadir elemento
var_arreglo.append(5)
# Borrar elemento
var_arreglo.remove(5)

# Ordenar
sorted(var_arreglo, key=lambda item: item.valor)

# Buscar
item = [x for x in var_arreglo if condicion]

# Recorrer
for i in var_arreglo:
    print(i)

#Acceder a una posición
var_item = var_arreglo[pos]
```
#### Métodos y Objetos
Definir Métodos
```python
def metodo():
    return 5

# Método con parametro
def metodo(valor = 0)
    return valor
```

Definir Clases
```python
class Clase:

#Constructor
class Clase:
    def __init__(self,valor):
        self.valor = valor

# Instanciar
objeto = Clase(5)
```

Herencia
```ruby
class Padre:
    def metodo(self):
        print("Hola")

class Hijo(Padre):
    def __init__(self):
        Padre.__init__(self)

objeto = Hijo()
objeto.metodo()
```