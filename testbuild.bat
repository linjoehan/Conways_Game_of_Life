mkdir testbin
set PATH=C:\Java\jdk1.8.0_281\bin;%PATH%
set CLASSPATH=C:\Junit\junit-4.10.jar;%CLASSPATH%

javac ^
-cp %CLASSPATH% ^
-d ./testbin/ ^
-sourcepath ./src;./testsrc/ ^
./testsrc/*.java

pause