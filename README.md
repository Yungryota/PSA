# Bienvenido a la guía sobre PSA

# Contexto
Se realizó una investigación y se determinó que los pacientes de establecimientos CESFAM que estan entre
las cateogrias 4 y 5 solo suelen ir por resfriados leves o estados de salud no criticos,por lo que vienen
en busca de una licencia médica o una reteca medica. Al paciente se le realiza una categorización entre
el rango númerico 1 hasta 5 (el 1 siendo el estado mas critico  para el paciente). Estos deben esperar en 
promedio más de una hora para ser atendidos.

PSA tiene como finalidad ser un proyecto el cual pueda ayudar a reducir los tiempos de espera para los pacientes menos criticos en establecimientos CESFAM.


EL equipo de trabajo fue conformado por:

[Lukas Espejo] (https://github.com/Yungryota)
[Javiera Espina] (https://github.com/javiesp)
[Hugo Gonzalez] (https://github.com/Svboibg20)



Quienes determinaron y documentaron todo un sistema para poder realizar esta solución informatica.


# Funcionamiento Sistema
El sistema se comunica con un arduino y con una web para realizar el servicio. El cual hace preguntas sobre como 
se siente el paciente y también toma la temperatura corporal del mismo.


Como funciones principales se puede Categorizar al paciente atravez de un cuestionario de unas pocas preguntas, con esto
se le envia el resultado al medico con todo los detalles que necesita para que realize el diagnostico y derive al paciente a farmacia o mesón
para recibir su licencia medica.

A futuro se busca hacer que el servicio pueda determinar recetas medicas por si mismo con los datos recopilados del cuestionario realizado

## Detalles Frontend

El front tuvo muchas modificaciones pero se termino por escoger realizarlo atravez de angular y hacer llamado a servicios como si de 
una integración se tratara, Se a utilizado Angular principalmente, para diseño se ocupo Bootstrap

## Detalles Backend

El codigo principal (Realizado en JAVA) Fue compuesto por el framework springboot, el cual determina los puertos con los que se puede comunicar 
para así no tener problemas entre otros puertos que puedan ser utilizados a futuro, tambien para mantener de manera mas segura la linea donde
transitan los datos por la red. 

Las clases desarrolladas en el codigo son llamadas dentro de una clase controladora la cual utiliza las funciones de estas para que los datos puedan moverse
a una base de datos no relacional, en este caso se trabajo con OCI (Oracle Cloud Infraestructure) dentro de sus bases de datos NOSQL.

La conexión a la base de datos es realizada atravez de autorización de usuario principal (AUP), internamente
tambien necesita una credencial, esta puede ser un archivo PEM para que la base de datos tenga una mejor confidencialidad al momento
de que el proyecto entre a producción.


# AVISO
Las llaves son del periodo de pruebas realizado en diciembre de 2023 por lo que la llave PEM tanto la privada como la publica se encuentran obsoletas, 
así que para aquellos que quieran utilizar el programa deberan utilizar sus propias bases de datos ORACLE
ya que nuestro periodo de prueba finalizó.


Ante cualquier consulta respecto a la conexion a NOSQL OCI mediante Java puedes utilizar este repositorio oficial de Oracle : https://github.com/oracle/nosql-java-sdk
