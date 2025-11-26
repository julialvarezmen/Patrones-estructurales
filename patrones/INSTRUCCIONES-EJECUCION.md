# Instrucciones para Ejecutar los Archivos del Patrón Composite

## Opción 1: Usando Gradle (Recomendado para AntiPattern)

### Ejecutar AntiPattern:
```bash
.\gradlew.bat runAntiPattern
```

### Ejecutar WithoutComposite:
```bash
.\gradlew.bat runWithoutComposite
```

### Ejecutar CompositeExample:
```bash
.\gradlew.bat runCompositeExample
```

## Opción 2: Usando el Script Batch (Windows)

### Ejecutar todos los ejemplos:
```bash
.\ejecutar-composite.bat todos
```

### Ejecutar un ejemplo específico:
```bash
.\ejecutar-composite.bat AntiPattern
.\ejecutar-composite.bat WithoutComposite
.\ejecutar-composite.bat CompositeExample
```

## Opción 3: Usando Java directamente

Primero, compila el proyecto:
```bash
.\gradlew.bat compileJava
```

Luego, compila manualmente los archivos que faltan:
```bash
javac -encoding UTF-8 -d "build\classes\java\main" -sourcepath "src\main\java" "src\main\java\com\patrones\Composite\CompositeExample.java"
javac -encoding UTF-8 -d "build\classes\java\main" -sourcepath "src\main\java" "src\main\java\com\patrones\Composite\WithoutComposite.java"
```

Finalmente, ejecuta:
```bash
java -cp "build\classes\java\main" com.patrones.Composite.AntiPattern
java -cp "build\classes\java\main" com.patrones.Composite.WithoutComposite
java -cp "build\classes\java\main" com.patrones.Composite.CompositeExample
```

## Nota Importante

El archivo `AntiPattern.java` se compila automáticamente con Gradle. Los archivos `CompositeExample.java` y `WithoutComposite.java` pueden requerir compilación manual si Gradle no los detecta automáticamente.

