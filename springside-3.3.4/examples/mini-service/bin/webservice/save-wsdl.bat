@echo off
echo [INFO] ȷ������pathϵͳ������ANT1.7���ϰ汾��binĿ¼.
echo [INFO] ȷ������WebServiceӦ��������.

set local_driver=%cd:~0,2%
set local_path=%cd%

set exec_path=%0
set exec_path=%exec_path:~0,-14%"
set exec_driver=%exec_path:~1,2%

%exec_driver%
cd %exec_path%

call ant -f save-wsdl-build.xml

%local_driver%
cd %local_path%

echo [INFO] WSDL�ѱ��浽webapp/wsdl/mini-service.wsdl.
pause