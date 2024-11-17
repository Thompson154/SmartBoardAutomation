
# Proyecto Refactorizado - Android Game


---

## **Nueva Estructura del Proyecto**
El proyecto fue reorganizado para seguir buenas prácticas de diseño y modularización. La nueva estructura es la siguiente:

```
app/
└── src/
    ├── main/
    │   ├── java/
    │   │   ├── edu.upb.lp/
    │   │   │   ├── core/              # Componentes reutilizables y utilidades
    │   │   │   │   ├── adapter/       # Interfaces para conexión entre UI y lógica
    │   │   │   │   └── util/          # Métodos utilitarios (como dpToPixel)
    │   │   │   ├── feature/           # Funcionalidades específicas
    │   │   │   │   ├── ui/            # Elementos de la interfaz de usuario
    │   │   │   │   │   ├── activities/ # Actividades principales
    │   │   │   │   │   ├── helpers/   # Clases auxiliares para la UI
    │   │   │   │   │   └── views/     # Vistas personalizadas
    │   │   │   ├── data/              # Persistencia de datos
    │   │   │   │   └── local/         # Configuración local (SharedPreferences)
```

---

## **Cambios Principales**

### **1. Modulares Helpers**
Se extrajo lógica repetitiva de `AndroidGameActivity` a clases auxiliares (`helpers`):
- **`ButtonManager`**: Maneja la creación, actualización y eliminación de botones.
- **`TextFieldManager`**: Gestiona la creación y actualización de campos de texto.
- **`BoardManager`**: Controla la configuración y manejo del tablero de juego.

### **2. Clase de Utilidades**
Se creó una clase en `core.util` llamada `UiUtils` para manejar funciones comunes:
- Conversión de `dp` a `px` (`dpToPixel`).
- Generación de IDs únicos para vistas (`generateViewId`).

### **3. Organización de Clases**
- Las actividades principales (`AndroidGameActivity`) se movieron a `feature.ui.activities`.
- Vistas personalizadas (`MyTextView`) ahora están en `feature.ui.views`.
- Lógica del tablero y otros elementos específicos están en `feature.ui.helpers`.

---

## **Cómo Navegar el Proyecto**
- **UI Principal**: 
  - La actividad principal se encuentra en `feature.ui.activities.AndroidGameActivity`.
  - Utiliza `BoardManager`, `ButtonManager`, y `TextFieldManager` para modularizar su lógica.

- **Tablero**:
  - El manejo del tablero está encapsulado en `BoardManager`.
  - Es configurable con métodos como `configureScreen`.

- **Botones**:
  - Los botones ahora son gestionados por `ButtonManager`, lo que simplifica la lógica de agregar y eliminar botones.

- **Persistencia**:
  - Métodos relacionados con `SharedPreferences` se pueden mover a `data.local` en el futuro para mayor claridad.

---

## **Próximos Pasos**
- **Soporte para nuevas funcionalidades**:
  - Añadir menús iniciales.
  - Implementar más juegos utilizando esta estructura modular.
- **Pruebas**:
  - Escribir casos de prueba para las clases auxiliares y utilitarias.
- **Documentación**:
  - Completar comentarios en el código con ejemplos de uso para cada clase y método.

---

## **Contribución**
Si deseas contribuir, sigue estos pasos:
1. Clona el repositorio.
2. Asegúrate de seguir la estructura definida.
3. Envía un Pull Request con los cambios propuestos.

---

## **Contacto**
Para dudas o sugerencias, puedes contactar al equipo de desarrollo.

