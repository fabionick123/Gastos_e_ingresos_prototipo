# Gastos e Ingresos API

Este readme sirve para poder ver el prototipo de gastos e ingresos

## URL Base
La ruta principal para acceder a la API en entorno local es:
*`http://localhost:8080/api/v1/gastos`

*`http://localhost:8080/api/v1/ingresos`

---

## Endpoints de la API

### 1. Consultas (GET)
- **Buscar todos**: `GET /todo`
- **Buscar por ID**: `GET /{id}`
- **Cálculo total gastado**: `GET /total`
- **Filtrar por fecha específica**: `GET /fecha?fecha=dd-MM-yyyy`
- **Filtrar por rango de fechas**: `GET /rango?inicio=dd-MM-yyyy&fin=dd-MM-yyyy`
- **Filtrar por monto mayor a**: `GET /mayor?monto=valor`

### 2. Creación (POST)
- **Añadir gasto**: `POST /anadir`

### 3. Eliminación (DELETE)
- **Eliminar por ID**: `DELETE /{id}`

---

## Guía de Pruebas - Plantillas JSON

### 1. Añadir nuevo gasto o ingreso
```json
{
  "monto": 50.0,
  "descripcion": "Compra de supermercado",
  "fechaGasto": "17-04-2026"
}
{
  "monto": 105.0,
  "descripcion": "Compra de herramientas",
  "fechaIngreso": "10-04-2026"
}
