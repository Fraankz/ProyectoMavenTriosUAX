# Proyecto: Sistema de Gestión de Invitados

## 📌 Contexto y Objetivos del Proyecto
Este proyecto se desarrolla en el marco del curso de **Desarrollo de Aplicaciones Web**. El objetivo es crear un **sistema de gestión de invitados** para eventos como conferencias, bodas o seminarios. 

Se busca aplicar los conocimientos adquiridos en **Java, JSP y Maven**, así como desplegar la aplicación en una **plataforma gratuita** sin necesidad de verificación con tarjeta de crédito.

---

## 📝 Descripción del Proyecto
El sistema permitirá:
1. **Consultar invitados** registrados en la base de datos.
2. **Agregar invitados** mediante un formulario.
3. **Eliminar invitados** de la lista.
4. (Opcional) **Buscar y actualizar invitados**.

Cada funcionalidad se implementará en **páginas JSP independientes** para mejorar la organización del código.

---

## 🔧 Requisitos Técnicos
### **1️⃣ Proyecto Maven**
- Se utiliza **Maven** para la gestión de dependencias y estructura del código.
- La estructura del proyecto sigue la convención estándar:
  ```
  src/main/java -> Código Java
  src/main/webapp -> Páginas JSP y recursos estáticos
  ```

### **2️⃣ Gestión de la Base de Datos**
- Se utiliza **MySQL en Railway**.
- La base de datos contiene una tabla `invitados` con:
  - `id` (INT, auto-incremental, clave primaria).
  - `nombre` (VARCHAR(100), obligatorio).
- Se implementan las operaciones **CRUD** en `InvitadoDAO.java`.

### **3️⃣ Despliegue de la Aplicación en Railway**
- Se usa **Webapp Runner** para ejecutar la aplicación en **Apache Tomcat**.
- Configuración en `pom.xml`:
  ```xml
  <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-dependency-plugin</artifactId>
      <version>3.0.2</version>
      <executions>
          <execution>
              <phase>package</phase>
              <goals>
                  <goal>copy</goal>
              </goals>
              <configuration>
                  <artifactItems>
                      <artifactItem>
                          <groupId>com.github.jsimone</groupId>
                          <artifactId>webapp-runner</artifactId>
                          <version>8.5.31.0</version>
                          <destFileName>webapp-runner.jar</destFileName>
                      </artifactItem>
                  </artifactItems>
              </configuration>
          </execution>
      </executions>
  </plugin>
  ```

- **Comando de despliegue en Railway:**
  ```sh
  java $JAVA_OPTS -jar target/dependency/webapp-runner.jar --port $PORT target/*.war
  ```

### **4️⃣ Configuración de la Base de Datos**
- Servicio MySQL gratuito (**Railway**).
- Configuración en `ConexionBD.java`:
  ```java
  private static final String URL = "jdbc:mysql://host:puerto/nombre_bd?autoReconnect=true&useSSL=false";
  private static final String USUARIO = "usuario";
  private static final String PASSWORD = "contraseña";
  ```

### **5️⃣ Gestión de Formularios JSP**
- Se usan **campos ocultos** en los formularios para diferenciar las acciones:
  ```html
  <input type="hidden" name="action" value="alta"/>
  ```

### **6️⃣ Pruebas y Verificación del Despliegue**
- Se revisan los **logs en Railway** para corregir errores.
- Se verifica la correcta funcionalidad accediendo a la URL del despliegue.

---

## 📌 Pasos del Desarrollo
✅ **Inicio del Proyecto Maven** → Configuración de estructura y dependencias.
✅ **Desarrollo Backend** → Implementación de **DAO y conexión con MySQL**.
✅ **Creación de JSPs** → Formularios para **insertar, listar y eliminar invitados**.
✅ **Configuración Webapp Runner** → Para ejecutar en **Tomcat en Railway**.
✅ **Despliegue en Railway** → Subir proyecto a **GitHub** y configurarlo en **Railway**.
✅ **Pruebas y Depuración** → Corrección de errores en **logs y base de datos**.

---

## 🚀 Cómo Ejecutar el Proyecto
### **1️⃣ Clonar el repositorio**
```sh
 git clone https://github.com/usuario/proyecto-invitados.git
```

### **2️⃣ Compilar el proyecto con Maven**
```sh
mvn clean package
```

### **3️⃣ Ejecutar localmente**
```sh
java -jar target/dependency/webapp-runner.jar --port 8080 target/*.war
```

### **4️⃣ Acceder a la aplicación**
📌 **Local:** `http://localhost:8080`
📌 **Railway:** `https://tu-proyecto.railway.app`

---

## **👨‍💻 Equipo de Desarrollo**
- **Integrante 1** - Desarrollo Backend
- **Integrante 2** - Desarrollo Frontend JSP
- **Integrante 3** - Despliegue y Base de Datos

✉ **Contacto:** `email@ejemplo.com`

