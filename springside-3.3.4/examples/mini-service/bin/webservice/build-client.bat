@echo off
echo [INFO] ȷ������CXF_HOMEϵͳ������cxf����Ŀ¼.
echo [INFO] ȷ������JAVA_HOMEϵͳ������JDK5.0���ϵ�JDKĿ¼.
echo [INFO] ȷ������WebServiceӦ��������.

if exist "%CXF_HOME%/bin/" goto begin
echo [ERROR] δ����CXF_HOMEϵͳ����
goto end

:begin
call "%CXF_HOME%/bin/wsdl2java.bat" -client -b build-client-binding.xml -exsh true http://localhost:8080/mini-service/ws/userservice?wsdl

echo [INFO] �����������ڵ�ǰĿ¼��.
:end
pause