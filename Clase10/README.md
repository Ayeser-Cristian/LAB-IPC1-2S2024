# Requisitos:
- Tener instalado NodeJs 
  - Vídeo tutorial para instalar Nodejs:  <a href="https://youtu.be/v0x1Ku5Tgac?si=hjCcf9fNVRWJ4teH" target="_blank">Enlace Vídeo</a>
- Tenes instalado un Editor de Código (Se recomienda VisualCode)
  - Vídeo tutorial para instalar VsCode:  <a href="https://youtu.be/fw9QLJ46VGQ?si=zeiwcA26q-MywPyf" target="_blank">Enlace Vídeo</a>

- Una herramienta de Pruebas de EndPoints
  - Se recomienda instalar instalar Postman en su computadora, ya que debera hacer la documentación por medio de esta herramienta: <a href="https://youtu.be/xjO9pltaPLQ?si=O9zKm-u_g9qN1vjO" target="_blank">Vídeo Instalar Postman</a>

- Si lo desea se puede instalar una extensión en VsCode como "Thunder Client" o "Postman".

# Frontend (client)

## ¿Cómo levantar el Frontend al momento de descagarlo?

Para levantar el frontend al momento de descargalo/clonarlo, se deben ejecutar los siguientes comandos: 
- ```npm install ```: este comando descarga todas las dependecias necesarias para el proyecto (descaga la carpeta node_modules).
- ```npm run dev```: este comando ejecuta el frontend, es decir levanta la aplicación en puerto 5173.

Nota: Para ejecutar los comandos anteriomente mencionados es necesario abrir una consola y estar en la ruta de la carpeta ```client```.

## ¿Cómo Iniciar en un proyecto de React+Vite?

- Nos ubicamos en la ruta donde queremos crear nuestro frontend y abrimos una terminal.
- En la terminal ejecutamos el siguiente comando: ```npm create vite@latest```
- Al ejecutar dicho comando nos solicitará ingresar lo siguiente:
  - Ingresar el nombre del Proyecto (client por ejemplo)
  - Escoger el Framework (React en este caso)
  - Escojer el lenguaje (JavaScript en este caso)
- Luego de haber realizado los pasos anteriores se nos creará una carpeta con el nombre que le hayamos colocado al proyecto.
- Ingresamos en nuestro proyecto e instalamos las dependecias, por ejemplo si nuestro proyecto lo nombramos ```client```:

```
cd client
npm install
```
- Finalmente podemos levantar la aplicación con el siguiente comando: ```npm run dev```

Nota: Para levantar la aplicación debemos estar ubicados dentro de nuestro proyecto.

## ¿Qué librerías y dependencias se usaron en este ejemplo de frontend ?

 - ```npm install react-router-dom```: Maneja la navegación entre páginas en React.
 - ```npm install bootstrap```: Proporciona estilos y componentes listos para usar.  
 Nota: Es necesario colocar en el main.jsx lo siguiente: ```import 'bootstrap/dist/css/bootstrap.min.css'```. Ejemplo:

```js
import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.jsx'
import 'bootstrap/dist/css/bootstrap.min.css';

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
```

 - ```npm install react-router-dom```: Añade íconos de Font Awesome a la interfaz.  
 Nota: Es necesario colocar en el main.jsx lo siguiente: ```  import
'@fortawesome/fontawesome-free/css/all.min.css';```. Ejemplo:

```js
import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.jsx'
import 'bootstrap/dist/css/bootstrap.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css';

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
```


# BACKEND (server)

## ¿Cómo levantar el Backend al momento de descagarlo?

Para levantar este ejemplo el backend de descargalo/clonarlo, se deben ejecutar los siguientes comandos: 
- ```npm install ```: este comando descarga todas las dependecias necesarias para el proyecto (descaga la carpeta node_modules).
- ```npm start```: este comando ejecuta el programa, es decir levanta la API en el puerto 5000. Cabe resaltar que en este proyecto se utiliza nodemon.


Nota: Para ejecutar los comandos anteriomente mencionados es necesario abrir una consola y estar en la ruta de la carpeta ```server``` y dentro de la carpeta ```src```.


### Estructura de Carpetas

- src

  - controllers
    - Aquí se encuentran todos los archivos js que realizan las acciones de las solicitudes HTTP.
  - DataList
    - Aquí se encuentra ```dataList.js``` en la cual se manejan las listas que se usarán para almacenar los datos en memoria.
  - modals
    - Aquí se encuentran las clases creadas, por ejemplo ```Empleado.js``` para guardar los datos de los empleados que se registran en el sistema por la carga masiva.
  - routes
    - Aquí se encuentra ```routee.js``` en la cual se manejan las rutas de las solicitudes HTTP.
  - app.js 
    - Es el archivo donde se configura la API REST.
  - index.js 
    - Es el archivo principal de la API REST, inicia la aplicación y esucha las solicitudes HTTP.

## ¿Cómo Iniciar desde 0 este ejemplo?

- Creamos nuestra carpeta, por ejemplo ```Proyecto```.
- En la ruta de la carpera creada, abrimos Visual Code (o otro editor de código que tengan).
- Dentro de la carpeta que creamos anteriomente en una consola ejecutamos el comando ```npm init -y```.
- Instalamos las dependecias necesarias:
  - ```npm install express```
  - ```npm install cors```
  - ```npm install nodemon --save-dev``` (opcional)


- Ahora creamos un archivo llamado: ```.gitignore```
  - Dentro del archivo colocamos:
    ```
    node_modules/
    ```
  - Con este archivo evitamos que los ```node_modules``` se suban al repositorio, debido a que estos pesan demasiado y es una mala práctica subirlo al repositorio.

  - Por el mismo motivo que no subimos los ```node_modules``` al repositorio, es necesario ejecutar el comando ```npm install``` al momento de descargar/clonar un proyecto en el cual se usa Nodejs.
- Si lo deseamos creamos la estructura de las carpetas anterimente mostradas o se implementa una propia estructura. 

- Si se instalo nodemon (npm install nodemon --save-dev) y se seguío la misma estructura de las carpetas, realizar lo siguiente:
  - Ir a ```package.json```
  - En la parte donde dice ```scripts``` agregar lo siguiente ```"start": "nodemon src/index.js"```.
  - Ejemplo de cómo quedaría la estructura:
    ```sh
    "scripts": {
        "test": "echo \"Error: no test specified\" && exit 1",
        "start": "nodemon src/index.js"
    }
    ```
  - Pero... ¿Qué es nodemon?
    - Es una herramienta de desarrollo para Node.js que ayuda a automatizar el proceso de reiniciar la aplicación después de cada cambio en el código fuente. En lugar de tener que detener manualmente y reiniciar la aplicación cada vez que se hace un cambio en el código, nodemon monitorea los archivos del proyecto y reinicia automáticamente la aplicación cuando detecta cambios.

- Con nodemon instalado, para levantar el proyecto debemos ejecutar el comando ```npm start``` .


### Estructura de los JSON para cada solicitud HTTP

- http://localhost:5000/cargarempleado (post)

  ```
    [
        {
            "codigo": "EMP-P01",
            "nombre": "Sofía Martínez",
            "contrasenia": "pas123",
            "edad": 34
        },
        {
            "codigo": "EMP-P02",
            "nombre": "Ricardo Sánchez",
            "contrasenia": "123abc",
            "edad": 45
        },
        {
            "codigo": "EMP-P03",
            "nombre": "Valentina Ruiz",
            "contrasenia": "qwerty",
            "edad": 29
        }
    ]

  ```
  Respuesta
  ```
    {
        "mensaje": "Empleados Agregados correctamente",
        "state": true
    }
  ```

- http://localhost:5000/getEmpleados (get)
  ```
    //No se envían datos por ser un una petición get
  ```

  Respuesta
  ```
    {
        "usuarios": [
            {
                "codigo": "EMP-P01",
                "nombre": "Sofía Martínez",
                "password": "pas123",
                "edad": 34
            },
            {
                "codigo": "EMP-P02",
                "nombre": "Ricardo Sánchez",
                "password": "123abc",
                "edad": 45
            },
            {
                "codigo": "EMP-P03",
                "nombre": "Valentina Ruiz",
                "password": "qwerty",
                "edad": 29
            }
        ],
        "state": true
    }
  ```

- http://localhost:5000/cargargerente (post)

  ```
    [
        {
            "codigo": "GER-P01",
            "nombre": "Juan Pérez",
            "contrasenia": "1234",
            "edad": 28
        },
        {
            "codigo": "GER-P02",
            "nombre": "Ana Gómez",
            "contrasenia": "abcd",
            "edad": 32
        },
        {
            "codigo": "GER-P03",
            "nombre": "Luis Torres",
            "contrasenia": "qwer",
            "edad": 25
        }
    ]

  ```
  Respuesta
  ```
    {
        "mensaje": "Gerentes Agregados correctamente",
        "state": true
    }
  ```

- http://localhost:5000/getGerentes (get)
  
  ```
    //No se envían datos por ser un una petición get
  ```

  Respuesta
  ```
    {
        "usuarios": [
            {
                "codigo": "GER-P01",
                "nombre": "Juan Pérez",
                "password": "1234",
                "edad": 28,
                "proyectos": []
            },
            {
                "codigo": "GER-P02",
                "nombre": "Ana Gómez",
                "password": "abcd",
                "edad": 32,
                "proyectos": []
            },
            {
                "codigo": "GER-P03",
                "nombre": "Luis Torres",
                "password": "qwer",
                "edad": 25,
                "proyectos": []
            }
        ],
        "state": true
    }
  ```



