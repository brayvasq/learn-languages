| Lenguaje | Versión        | SO                |
| -------- | -------------- | ----------------- |
| Ruby     | ruby 2.4.3p205 | Linux - Fedora 27 |

> :warning: This project has not yet been updated to the Farm Game project. Also, the documentation is not up to date.

## Variables
#### Tipos de Datos
```ruby
#Cadenas
variable_cadena = "Hola Mundo"
#Enteros
var_entera = 5
#Decimales
var_decimal = 10.4
#Booleana
var_booleana = true
```
#### Tipos de variable
```ruby
#Variable local - accesible solo en su scope
var_local = "Soy una variable local"
#Variable de objeto - accesible en toda la clase
@var_objeto = "Soy una variable de objeto"
## Tambien se puede representar de la siguiente manera
self.var_objeto = "También soy una variable de objeto"
#Variable de clase - una sola variable para todos los objetos o instacia de la clase
@@var_clase = "Soy una variable de clase"
```
#### Estructuras de Control

##### Condicionales
Estructura condicional If
```ruby
if condicion 
    puts "condición if"
elsif condicion_dos
    puts "condución elsif"
else
    puts "default"
end
```

Operador Ternario
```ruby
var_bool = if condicion then valor else valor_dos end
```

Estructura condicional Switch
```ruby
case var
when valor_uno
    puts "Es valor 1"
else
    puts "default"
end
```

##### Bucles o Ciclos
Estructura ciclica for

```ruby
for i in 0..limite
    puts "Soy #{i}"
end
```

Estructura ciclica while
```ruby
while condicion do
    puts "Iterando"
end
```
#### Estructuras de Datos
Arreglos o Listas
```ruby
var_arreglo = []
# Añadir elemento
var_arreglo.push(5)
# Borrar elemento
var_arreglo.delete(5)

# Ordenar
var_arreglo.sort_by {|a| a==valor}

# Buscar
var_arreglo.select {|a| a==valor}

# Recorrer
var_arreglo.each {|a| puts "Valor : #{a}"}

#Acceder a una posición
var_item = var_arreglo[pos]
```
#### Métodos y Objetos
Definir Métodos
```ruby
def metodo
    5 # Retorno implicicto
end

# Método con parametro
def metodo(valor = 0)
    return valor
end
```

Definir Clases
```ruby
class Clase
end

#Constructor
class Clase
    def initialize(valor)
        @valor = valor
    end
end

# Instanciar
objeto = Clase.new 5
# Lo anterior también es equivalente a:
obtejo_dos = Clase.new(5)
```

Herencia
```ruby
class Padre
    def metodo
        puts "Hola"
    end
end

class Hijo < Padre

end

objeto = Hijo.new
objeto.metodo
```
