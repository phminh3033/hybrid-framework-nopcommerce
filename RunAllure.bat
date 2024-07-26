set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%lib\libAllureReport\aspectjweaver-1.9.22.jar" -classpath "%ProjectPath%bin;%ProjectPath%lib\libAllureReport\*;%ProjectPath%lib\extendReportV4\*;%ProjectPath%libLog\*;%ProjectPath%libraries\*;%ProjectPath%libReportNG\*;%ProjectPath%libWebDriverManager\*" org.testng.TestNG "%ProjectPath%bin\runUserGuruTestcases.xml"
pause