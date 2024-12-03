@echo off
REM El classpath para incluir bin y las bibliotecas en lib
set CLASSPATH=bin;lib\*

REM Nombre de la clase principal del sistema
set MAIN_CLASS=noventagrados.textui.NoventaGrados

REM Ejecutar la clase principal en modo texto
java %MAIN_CLASS% arbitros



pause
