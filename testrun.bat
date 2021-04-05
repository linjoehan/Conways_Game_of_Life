set PATH=C:\Java\jdk1.8.0_281\bin;%PATH%
set CLASSPATH=C:\Junit\junit-4.10.jar;%CLASSPATH%

java ^
-cp %CLASSPATH%;testbin ^
TestRunner

pause