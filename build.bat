mkdir bin
set PATH=C:\Java\jdk1.8.0_281\bin;%PATH%

javac ^
-d ./bin/ ^
-sourcepath ./src/ ^
./src/*.java

pause