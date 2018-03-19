### Comprender los componentes básicos un lenguaje de programación

A continuación se presenta la lista de items que se deberían abarcar en el ejercicio.

#### Tipos de Datos

Dentro de los tipos de datos es necesario inclur los siguientes:

- Cadenas.
- Numeros Enteros.
- Numeros Decimales.
- Variables lógicas o Booleanas.

#### Estructuras de control

##### Condicionales.

En este apartado se deben abarcar las estructuras condicionales básicas, tales como:

- If
- Switch o equivalentes.

##### Bucles o Ciclos

- For.
- While.

#### Estructuras de datos

Aquí se explorarán principalmente los arreglos o listas, Aunque también es posible que se estudie los diccionarios.

#### Métodos y Objetos

Es necesario usar métodos para qué la aplicación sea más entendible. También se usarán clases u objetos en caso de que el lenguaje lo permita.

Finalmente es necesario usar los metodos que usa cada lenguaje para la entrada y salida de datos de manera que se garantice la interacción con el usuario.

No se explorará interfaces gráficas o GUI debido a que son componentes más específicos y variantes en cada lenguaje. La idea del ejercicio es abarcar los ítems más básicos de un lenguaje de programación.

#### Enunciado

La aplicación propuesta es la de una granja que permitirá realizar compras y ventas de animales. De manera que se establece los siguientes parametros:

Clase padre Animal:

Atributos

- Id -> Tipo Cadena.
- Nombre - name-> Tipo Cadena.
- Edad - age -> Tipo Entero.
- Peso - weight -> Tipo Decimal.
- Precio - price-> Tipo Decimal.
- Vivo - alive -> Tipo Boolean.

Métodos Abstractos.

- Calcular Precio -> Tipo Decimal
- Comer -> Tipo Void.
- Hablar -> Tipo Void. Emite sonido característico
- Obtener Esperanza de vida -> Tipo Void

Métodos normales

- Getters y Setters


- Obtener Información -> Tipo Void

Animales a usar

| Animal          | Esperanza de vida |
| --------------- | ----------------- |
| Oveja - Sheep   | 15 años           |
| Cerdo - Pig     | 15 años           |
| Pollo - Chicken | 10 años           |
| Ternera - Cow   | 25-30 años        |
| Conejo - Rabbit | 6-8 años          |

Clase Granja

Atributos

- Animales -> Tipo Array.
- Nombre -> Tipo String.
- Dirección -> Tipo String.

Métodos.

- Obtener Información granja.
- Obtener número animales.
- Obtener Información animales.
- Buscar animal.
- Obtener precio total animales.
- Registrar un animal.
- Borrar un animal.
- Ordenar animal por precio.
- Ordenar animal por edad.