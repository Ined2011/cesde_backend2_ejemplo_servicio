# Solución - Pruebas de Endpoints

Base URL: `http://localhost:8080/api/usuarios`

---

## 1. Listar todos los Usuarios
**Método:** `GET`  
**Endpoint:** `/api/usuarios`

**Respuesta exitosa (200 OK):**
```json
[
  {
    "id": 1,
    "nombre": "Juan Pérez",
    "email": "juan.perez@example.com",
    "edad": 25
  }
]
```

---

## 2. Crear un Nuevo Usuario (Caso Exitoso)
**Método:** `POST`  
**Endpoint:** `/api/usuarios`

**Cuerpo enviado:**
```json
{
  "nombre": "Juan Pérez",
  "email": "juan.perez@example.com",
  "edad": 25
}
```

**Respuesta exitosa (201 Created):**
```json
{
  "id": 1,
  "nombre": "Juan Pérez",
  "email": "juan.perez@example.com",
  "edad": 25
}
```

---

## 3. Probar Lógica de Negocio (Casos Fallidos)

### A. Menor de edad
**Cuerpo enviado:**
```json
{
  "nombre": "Luisito",
  "email": "luis@example.com",
  "edad": 15
}
```

**Respuesta (400 Bad Request):**
```json
{
  "error": "Lógica de Negocio: El usuario debe ser mayor de 18 años."
}
```

### B. Email Duplicado
**Cuerpo enviado:**
```json
{
  "nombre": "Carlos López",
  "email": "juan.perez@example.com",
  "edad": 30
}
```

**Respuesta (400 Bad Request):**
```json
{
  "error": "Lógica de Negocio: El email ya está en uso."
}
```

---

## 4. Buscar Usuario por ID
**Método:** `GET`  
**Endpoint:** `/api/usuarios/1`

**Respuesta exitosa (200 OK):**
```json
{
  "id": 1,
  "nombre": "Juan Pérez",
  "email": "juan.perez@example.com",
  "edad": 25
}
```

**Respuesta si no existe (404 Not Found):**
```json
{
  "error": "Usuario no encontrado."
}
```

---

## 5. Buscar por Rango de Edad
**Método:** `GET`  
**Endpoint:** `/api/usuarios/por-edad?min=20&max=30`

**Respuesta exitosa (200 OK):**
```json
[
  {
    "id": 1,
    "nombre": "Juan Pérez",
    "email": "juan.perez@example.com",
    "edad": 25
  }
]
```

---

## 6. Eliminar un Usuario
**Método:** `DELETE`  
**Endpoint:** `/api/usuarios/1`

**Respuesta exitosa (200 OK):**
```json
{
  "mensaje": "Usuario eliminado correctamente."
}
```

**Respuesta si no existe (404 Not Found):**
```json
{
  "error": "Usuario no encontrado."
}
```