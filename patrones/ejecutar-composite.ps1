# Script para ejecutar los ejemplos del patrón Composite
# Uso: .\ejecutar-composite.ps1 [CompositeExample|WithoutComposite|AntiPattern]

param(
    [Parameter(Mandatory=$false)]
    [ValidateSet("CompositeExample", "WithoutComposite", "AntiPattern", "todos")]
    [string]$ejemplo = "todos"
)

$proyectoDir = $PSScriptRoot
$buildDir = Join-Path $proyectoDir "build\classes\java\main"

# Compilar primero
Write-Host "Compilando proyecto..." -ForegroundColor Yellow
Set-Location $proyectoDir
& .\gradlew.bat compileJava | Out-Null

if ($LASTEXITCODE -ne 0) {
    Write-Host "Error al compilar el proyecto" -ForegroundColor Red
    exit 1
}

# Función para ejecutar un ejemplo
function EjecutarEjemplo {
    param([string]$clase)
    
    Write-Host "`n========================================" -ForegroundColor Cyan
    Write-Host "Ejecutando: $clase" -ForegroundColor Cyan
    Write-Host "========================================`n" -ForegroundColor Cyan
    
    java -cp $buildDir "com.patrones.Composite.$clase"
    
    if ($LASTEXITCODE -ne 0) {
        Write-Host "`nError al ejecutar $clase" -ForegroundColor Red
    }
}

# Ejecutar según el parámetro
switch ($ejemplo) {
    "CompositeExample" {
        EjecutarEjemplo "CompositeExample"
    }
    "WithoutComposite" {
        EjecutarEjemplo "WithoutComposite"
    }
    "AntiPattern" {
        EjecutarEjemplo "AntiPattern"
    }
    "todos" {
        EjecutarEjemplo "AntiPattern"
        Start-Sleep -Seconds 1
        EjecutarEjemplo "WithoutComposite"
        Start-Sleep -Seconds 1
        EjecutarEjemplo "CompositeExample"
    }
}

Write-Host "`n========================================" -ForegroundColor Green
Write-Host "Ejecución completada" -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Green

