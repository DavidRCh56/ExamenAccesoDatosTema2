# Importación de datos de aplicación desde Excel

Nos piden crear una aplicación en Java para importar los datos de una aplicación de reservas de pistas deportivas. Hay que procesar el Excel adjunto de manera que cada el nombre de cada hoja sea una tabla y las celdas de la primera fila sean los nombres (fíjate que nos dan separado por un guión el tipo de dato).

Luego, para cada fila, tenemos que insertar los datos en la tabla correspondiente.

Para comprobar que ha funcionado, haz las siguientes consultas en SQL, debes proporcionar tanto el SQL (incrustar el código en el Readme.md) como el resultado de la consulta en la documentación (hay que hacer una captura de pantalla y añadirla en el Readme.md). El programa también debe hacer estas consultas al terminar de cargar el Excel. Nos mostrará por pantalla un menú donde, según el número que pulsemos, hará una u otra consulta:

1) Ver todas las reservas con la información del usuario, instalación y horario 
2) Ver el historial de reservas para cada usuario
3) Ver los horarios disponibles para cada instalación
0) Salir de la aplicación 

En esta prueba evaluamos los siguientes RAs y CEs:

**RA 1. Desarrolla aplicaciones que gestionan información almacenada en ficheros identificando el campo de aplicación de los mismos y utilizando clases específicas. Criterios de evaluación:**

\# | CRITERIO | Explicación 
---|----------|------------
a | Se han utilizado clases para la gestión de ficheros y directorios. | Abres el fichero excel
c | Se han utilizado clases para recuperar información almacenada en ficheros. | Lees el fichero excel
d | Se han utilizado clases para almacenar información en ficheros. | Muestras por salida estándar información
e | Se han utilizado clases para realizar conversiones entre diferentes  formatos de ficheros. | Pasas de Excel a BBDD
f | Se han previsto y gestionado las excepciones. | usas try con recursos
g | Se han probado y documentado las aplicaciones desarrolladas. |  documentas

 **R.A 2: Desarrolla aplicaciones que gestionan información almacenada en bases de datos relacionales identificando y utilizando mecanismos de conexión.**

\# | CRITERIO | Explicación 
---|----------|------------
a | Se han valorado las ventajas e inconvenientes de utilizar conectores. | Documentas cómo usar JDBC
b | Se han utilizado gestores de bases de datos embebidos e independientes. | Preparas servicio MySQL
c | Se utilizado el conector idóneo en la aplicación. | Usas MySQL
d | Se ha establecido la conexión. | Conectas a la BBDD
e | Se ha definido la estructura de la base de datos. | Creas las tablas
f | Se han desarrollado aplicaciones que modifican el contenido de la base de datos. | Insertas datos
g | Se han definido los objetos destinados a almacenar el resultado de las consultas. | Recorres el excel para cargar los datos/tablas
h | Se han desarrollado aplicaciones que efectúan consultas. | haces las consultas finales
i | Se han eliminado los objetos una vez finalizada su función. | usas try con recursos

La rúbrica de corrección está en la plataforma.
