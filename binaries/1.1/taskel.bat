@echo off
set p=%~dp0
java -cp "%p%\taskel.jar;%p%\jansi-1.11.jar" com.matt.taskel.Taskel %1