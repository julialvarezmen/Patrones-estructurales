@echo off
REM Script para ejecutar los ejemplos del patrón Composite
REM Uso: ejecutar-composite.bat [CompositeExample|WithoutComposite|AntiPattern|todos]

setlocal

set PROYECTO_DIR=%~dp0
cd /d "%PROYECTO_DIR%"

REM Compilar primero
echo Compilando proyecto...
call gradlew.bat compileJava >nul 2>&1

REM Compilar manualmente los archivos que Gradle no detecta
echo Compilando archivos manualmente...
javac -encoding UTF-8 -d "build\classes\java\main" -sourcepath "src\main\java" "src\main\java\com\patrones\Composite\CompositeExample.java" 2>nul
javac -encoding UTF-8 -d "build\classes\java\main" -sourcepath "src\main\java" "src\main\java\com\patrones\Composite\WithoutComposite.java" 2>nul

set CLASSPATH=build\classes\java\main

if "%1"=="" goto todos
if "%1"=="todos" goto todos
if "%1"=="AntiPattern" goto antipattern
if "%1"=="WithoutComposite" goto without
if "%1"=="CompositeExample" goto composite

:todos
echo.
echo ========================================
echo Ejecutando: AntiPattern
echo ========================================
java -cp "%CLASSPATH%" com.patrones.Composite.AntiPattern
echo.
timeout /t 2 /nobreak >nul

echo ========================================
echo Ejecutando: WithoutComposite
echo ========================================
java -cp "%CLASSPATH%" com.patrones.Composite.WithoutComposite
echo.
timeout /t 2 /nobreak >nul

echo ========================================
echo Ejecutando: CompositeExample
echo ========================================
java -cp "%CLASSPATH%" com.patrones.Composite.CompositeExample
goto end

:antipattern
echo.
echo ========================================
echo Ejecutando: AntiPattern
echo ========================================
java -cp "%CLASSPATH%" com.patrones.Composite.AntiPattern
goto end

:without
echo.
echo ========================================
echo Ejecutando: WithoutComposite
echo ========================================
java -cp "%CLASSPATH%" com.patrones.Composite.WithoutComposite
goto end

:composite
echo.
echo ========================================
echo Ejecutando: CompositeExample
echo ========================================
java -cp "%CLASSPATH%" com.patrones.Composite.CompositeExample
goto end

:end
echo.
echo ========================================
echo Ejecucion completada
echo ========================================
endlocal

