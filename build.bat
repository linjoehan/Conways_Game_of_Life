mkdir bin
set PATH=C:\Program Files (x86)\Java\jdk1.8.0_281\bin;%PATH%

javac ^
-d ./bin/ ^
-sourcepath ./src/ ^
./src/HelloWorld.java