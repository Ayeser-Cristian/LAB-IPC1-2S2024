## Requisitos:
- Tener instalado NodeJs 
  - Vídeo tutorial para instalar Nodejs:  <a href="https://youtu.be/v0x1Ku5Tgac?si=hjCcf9fNVRWJ4teH" target="_blank">Enlace Vídeo</a>
- Tenes instalado un Editor de Código (Se recomienda VisualCode)
  - Vídeo tutorial para instalar VsCode:  <a href="https://youtu.be/fw9QLJ46VGQ?si=zeiwcA26q-MywPyf" target="_blank">Enlace Vídeo</a>

- Una herramienta de Pruebas de EndPoints
  - Se recomienda instalar instalar Postman en su computadora, ya que debera hacer la documentación por medio de esta herramienta: <a href="https://youtu.be/xjO9pltaPLQ?si=O9zKm-u_g9qN1vjO" target="_blank">Vídeo Instalar Postman</a>

- Si lo desea se puede instalar una extensión en VsCode como "Thunder Client" o "Postman".



## ¿Cómo levantar el Backend al momento de descagarlo?

Para levantar este ejemplo al momento de descargalo/clonarlo, se deben ejecutar los siguientes comandos: 
- ```npm install ```: este comando descarga todas las dependecias necesarias para el proyecto (descaga la carpeta node_modules).
- ```node app.js```: este comando ejecuta el programa, es decir levanta la API (en el puerto 5000).


Nota: Para ejecutar los comandos anteriomente mencionados es necesario abrir una consola y estar dentro de la carpeta Ejemplo1.

## ¿Cómo Iniciar desde 0 este ejemplo?

- Creamos nuestra carpeta, por ejemplo ```Ejemplo1```.
- En la ruta de la carpera creada, abrimos Visual Code (o otro editor de código que tengan).
- Dentro de la carpeta que creamos anteriomente en una consola ejecutamos el comando ```npm init -y```.
- Instalamos las dependecias necesarias:
  - ```npm install express```

- Ahora creamos un archivo llamado: ```.gitignore```
  - Dentro del archivo colocamos:
    ```
    node_modules/
    ```
  - Con este archivo evitamos que los ```node_modules``` se suban al repositorio, debido a que estos pesan demasiado y es una mala práctica subirlo al repositorio.

  - Por el mismo motivo que no subimos los ```node_modules``` al repositorio, es necesario ejecutar el comando ```npm install``` al momento de descargar/clonar un proyecto en el cual se usa Nodejs.

- Ahora se puede levanar el backend usando el comando: ```node app.js```.


