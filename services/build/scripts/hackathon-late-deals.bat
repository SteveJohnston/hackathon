@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  hackathon-late-deals startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

@rem Add default JVM options here. You can also use JAVA_OPTS and HACKATHON_LATE_DEALS_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windowz variants

if not "%OS%" == "Windows_NT" goto win9xME_args
if "%@eval[2+2]" == "4" goto 4NT_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*
goto execute

:4NT_args
@rem Get arguments from the 4NT Shell from JP Software
set CMD_LINE_ARGS=%$

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\hackathon-late-deals-1.0.37.jar;%APP_HOME%\lib\dropwizard-client-1.0.4.jar;%APP_HOME%\lib\dropwizard-guicey-3.2.0.jar;%APP_HOME%\lib\guice-4.0.jar;%APP_HOME%\lib\dropwizard-validation-1.0.4.jar;%APP_HOME%\lib\guava-19.0.jar;%APP_HOME%\lib\joda-money-0.10.0.jar;%APP_HOME%\lib\http-errors-1.11.8.jar;%APP_HOME%\lib\utils-jackson-2.0.4-SNAPSHOT.jar;%APP_HOME%\lib\application-dropwizard_2.10-9.2.0.jar;%APP_HOME%\lib\mongodb_2.10-9.2.0.jar;%APP_HOME%\lib\metrics-core-3.1.2.jar;%APP_HOME%\lib\hibernate-validator-5.2.4.Final.jar;%APP_HOME%\lib\javax.el-3.0.0.jar;%APP_HOME%\lib\jboss-logging-3.2.1.Final.jar;%APP_HOME%\lib\classmate-1.1.0.jar;%APP_HOME%\lib\dropwizard-configuration-1.0.4.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.7.8.jar;%APP_HOME%\lib\snakeyaml-1.15.jar;%APP_HOME%\lib\dropwizard-logging-1.0.4.jar;%APP_HOME%\lib\metrics-jvm-3.1.2.jar;%APP_HOME%\lib\metrics-servlets-3.1.2.jar;%APP_HOME%\lib\metrics-logback-3.1.2.jar;%APP_HOME%\lib\metrics-healthchecks-3.1.2.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.21.jar;%APP_HOME%\lib\log4j-over-slf4j-1.7.21.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.21.jar;%APP_HOME%\lib\jetty-setuid-java-1.0.3.jar;%APP_HOME%\lib\jetty-util-9.3.9.v20160517.jar;%APP_HOME%\lib\jersey-client-2.23.2.jar;%APP_HOME%\lib\httpclient-4.5.2.jar;%APP_HOME%\lib\metrics-httpclient-3.1.2.jar;%APP_HOME%\lib\dropwizard-metrics-1.0.4.jar;%APP_HOME%\lib\jersey-apache-connector-2.23.2.jar;%APP_HOME%\lib\guice-servlet-4.0.jar;%APP_HOME%\lib\dropwizard-jersey-1.0.4.jar;%APP_HOME%\lib\guice-multibindings-4.0.jar;%APP_HOME%\lib\jersey-server-2.23.2.jar;%APP_HOME%\lib\guice-bridge-2.4.0-b31.jar;%APP_HOME%\lib\generics-resolver-2.0.1.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\jersey-metainf-services-2.23.2.jar;%APP_HOME%\lib\jersey-bean-validation-2.23.2.jar;%APP_HOME%\lib\metrics-jersey2-3.1.2.jar;%APP_HOME%\lib\jackson-jaxrs-json-provider-2.7.8.jar;%APP_HOME%\lib\jersey-container-servlet-2.23.2.jar;%APP_HOME%\lib\aopalliance-1.0.jar;%APP_HOME%\lib\jetty-server-9.3.9.v20160517.jar;%APP_HOME%\lib\commons-lang3-3.4.jar;%APP_HOME%\lib\jetty-webapp-9.3.9.v20160517.jar;%APP_HOME%\lib\jetty-continuation-9.3.9.v20160517.jar;%APP_HOME%\lib\validation-api-1.1.0.Final.jar;%APP_HOME%\lib\jersey-media-jaxb-2.23.2.jar;%APP_HOME%\lib\metrics-annotation-3.1.2.jar;%APP_HOME%\lib\jongo-1.1.jar;%APP_HOME%\lib\jersey-container-servlet-core-2.23.2.jar;%APP_HOME%\lib\akka-actor_2.11-2.3.8.jar;%APP_HOME%\lib\javax.servlet-api-3.1.0.jar;%APP_HOME%\lib\logback-jackson-0.1.2.jar;%APP_HOME%\lib\jetty-http-9.3.9.v20160517.jar;%APP_HOME%\lib\logback-json-classic-0.1.2.jar;%APP_HOME%\lib\jetty-io-9.3.9.v20160517.jar;%APP_HOME%\lib\async-http-client-1.9.3.jar;%APP_HOME%\lib\jolt-core-0.0.12.jar;%APP_HOME%\lib\json-utils-0.0.12.jar;%APP_HOME%\lib\jetty-xml-9.3.9.v20160517.jar;%APP_HOME%\lib\metadata-dropwizard_2.10-9.2.0.jar;%APP_HOME%\lib\jetty-servlet-9.3.9.v20160517.jar;%APP_HOME%\lib\error-registry-dropwizard_2.10-9.2.0.jar;%APP_HOME%\lib\request-validation-dropwizard_2.10-9.2.0.jar;%APP_HOME%\lib\dropwizard-guice-0.7.2.jar;%APP_HOME%\lib\error-registry_2.10-9.2.0.jar;%APP_HOME%\lib\jetty-security-9.3.9.v20160517.jar;%APP_HOME%\lib\dropwizard-servlets-1.0.4.jar;%APP_HOME%\lib\dropwizard-jetty-1.0.4.jar;%APP_HOME%\lib\metrics-jetty9-3.1.2.jar;%APP_HOME%\lib\healthcheck_2.10-9.2.0.jar;%APP_HOME%\lib\jetty-servlets-9.3.9.v20160517.jar;%APP_HOME%\lib\metadata_2.10-9.2.0.jar;%APP_HOME%\lib\dropwizard-lifecycle-1.0.4.jar;%APP_HOME%\lib\mongo-java-driver-3.0.2.jar;%APP_HOME%\lib\argparse4j-0.7.0.jar;%APP_HOME%\lib\metrics-healthchecks-3.0.2.jar;%APP_HOME%\lib\jackson-annotations-2.7.8.jar;%APP_HOME%\lib\jersey-common-2.23.2.jar;%APP_HOME%\lib\hk2-api-2.5.0-b05.jar;%APP_HOME%\lib\joda-time-2.9.4.jar;%APP_HOME%\lib\javax.inject-2.5.0-b05.jar;%APP_HOME%\lib\jackson-core-2.7.8.jar;%APP_HOME%\lib\hk2-locator-2.5.0-b05.jar;%APP_HOME%\lib\httpcore-4.4.4.jar;%APP_HOME%\lib\jackson-databind-2.7.8.jar;%APP_HOME%\lib\commons-codec-1.9.jar;%APP_HOME%\lib\bson4jackson-2.4.0.jar;%APP_HOME%\lib\config-1.2.1.jar;%APP_HOME%\lib\logback-json-core-0.1.2.jar;%APP_HOME%\lib\netty-3.9.5.Final.jar;%APP_HOME%\lib\commons-lang-2.6.jar;%APP_HOME%\lib\request-validation_2.10-9.2.0.jar;%APP_HOME%\lib\utils_2.10-9.2.0.jar;%APP_HOME%\lib\reference-data-client_2.10-9.2.0.jar;%APP_HOME%\lib\annotations-3.0.0.jar;%APP_HOME%\lib\reflections-0.9.9.jar;%APP_HOME%\lib\jackson-datatype-joda-2.7.8.jar;%APP_HOME%\lib\jackson-core-lgpl-1.9.13.jar;%APP_HOME%\lib\slf4j-api-1.7.21.jar;%APP_HOME%\lib\logstash-logback-encoder-4.2.jar;%APP_HOME%\lib\javax.annotation-api-1.2.jar;%APP_HOME%\lib\jersey-guava-2.23.2.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.1.jar;%APP_HOME%\lib\aopalliance-repackaged-2.5.0-b05.jar;%APP_HOME%\lib\hk2-utils-2.5.0-b05.jar;%APP_HOME%\lib\javassist-3.20.0-GA.jar;%APP_HOME%\lib\commons-io-2.4.jar;%APP_HOME%\lib\jackson-dataformat-xml-2.5.0.jar;%APP_HOME%\lib\logback-classic-1.1.7.jar;%APP_HOME%\lib\jackson-jaxrs-xml-provider-2.5.0.jar;%APP_HOME%\lib\stax2-api-3.1.4.jar;%APP_HOME%\lib\woodstox-core-asl-4.4.0.jar;%APP_HOME%\lib\stax-api-1.0-2.jar;%APP_HOME%\lib\jackson-jaxrs-base-2.7.8.jar;%APP_HOME%\lib\dropwizard-core-1.0.4.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.7.8.jar;%APP_HOME%\lib\dropwizard-request-logging-1.0.4.jar;%APP_HOME%\lib\metrics-json-3.1.2.jar;%APP_HOME%\lib\logback-access-1.1.7.jar;%APP_HOME%\lib\javax.ws.rs-api-2.0.1.jar;%APP_HOME%\lib\scala-library-2.11.4.jar;%APP_HOME%\lib\logback-core-1.1.7.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\dropwizard-util-1.0.4.jar;%APP_HOME%\lib\jsr305-3.0.1.jar;%APP_HOME%\lib\dropwizard-jackson-1.0.4.jar;%APP_HOME%\lib\jackson-datatype-guava-2.7.8.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.7.8.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.7.8.jar;%APP_HOME%\lib\jackson-module-afterburner-2.7.8.jar

@rem Execute hackathon-late-deals
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %HACKATHON_LATE_DEALS_OPTS%  -classpath "%CLASSPATH%" com.travelsupermarket.latedeals.LateDealsApplication %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable HACKATHON_LATE_DEALS_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%HACKATHON_LATE_DEALS_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
