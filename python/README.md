| Lenguaje | Versión        | SO                |
| -------- | -------------- | ----------------- |
| Python   | Python 3.6.4   | Linux - Fedora 27 |


## Variables
#### Tipos de Datos
```python
#Cadenas
variable_cadena : str = "Hola Mundo"
#Enteros
var_entera : int = 5
#Decimales
var_decimal : float = 10.4
#Booleana
var_booleana : bool = True
```
**Nota :** *El tipo de dato se puede omitir* 

#### Tipos de variable
```python
#Variable local - accesible solo en su scope
var_local = "Soy una variable local"
#Variable de objeto - accesible en toda la clase
self.var_objeto = "También soy una variable de objeto"
```
#### Estructuras de Control

##### Condicionales
Estructura condicional If
```python
if condicion:
    print("condición if")
elif condicion_dos:
    print("condución elsif")
else:
    print("default")
```

Operador Ternario
```python
var_bool = valor if condicion else valor_dos
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