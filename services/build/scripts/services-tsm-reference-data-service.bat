@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  services-tsm-reference-data-service startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

@rem Add default JVM options here. You can also use JAVA_OPTS and SERVICES_TSM_REFERENCE_DATA_SERVICE_OPTS to pass JVM options to this script.
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

set CLASSPATH=%APP_HOME%\lib\services-tsm-reference-data-service-1.0.0-SNAPSHOT.jar;%APP_HOME%\lib\dropwizard-core-0.9.2.jar;%APP_HOME%\lib\dropwizard-guicey-3.2.0.jar;%APP_HOME%\lib\guava-19.0.jar;%APP_HOME%\lib\elasticsearch-2.3.3.jar;%APP_HOME%\lib\guice-4.0.jar;%APP_HOME%\lib\application-dropwizard_2.10-9.2.0.jar;%APP_HOME%\lib\mongodb_2.10-9.2.0.jar;%APP_HOME%\lib\metrics_2.10-9.2.0.jar;%APP_HOME%\lib\dropwizard-util-0.9.2.jar;%APP_HOME%\lib\jsr305-3.0.1.jar;%APP_HOME%\lib\jackson-datatype-jdk7-2.6.3.jar;%APP_HOME%\lib\jackson-datatype-guava-2.6.3.jar;%APP_HOME%\lib\jackson-module-afterburner-2.6.3.jar;%APP_HOME%\lib\hibernate-validator-5.2.2.Final.jar;%APP_HOME%\lib\dropwizard-jackson-0.9.2.jar;%APP_HOME%\lib\javax.el-3.0.0.jar;%APP_HOME%\lib\metrics-logback-3.1.2.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.12.jar;%APP_HOME%\lib\log4j-over-slf4j-1.7.12.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.12.jar;%APP_HOME%\lib\jetty-util-9.2.13.v20150730.jar;%APP_HOME%\lib\dropwizard-validation-0.9.2.jar;%APP_HOME%\lib\jersey-server-2.22.1.jar;%APP_HOME%\lib\dropwizard-configuration-0.9.2.jar;%APP_HOME%\lib\dropwizard-logging-0.9.2.jar;%APP_HOME%\lib\jersey-metainf-services-2.22.1.jar;%APP_HOME%\lib\jersey-bean-validation-2.22.1.jar;%APP_HOME%\lib\metrics-jersey2-3.1.2.jar;%APP_HOME%\lib\jackson-jaxrs-json-provider-2.6.3.jar;%APP_HOME%\lib\dropwizard-metrics-0.9.2.jar;%APP_HOME%\lib\jersey-container-servlet-2.22.1.jar;%APP_HOME%\lib\jetty-server-9.2.13.v20150730.jar;%APP_HOME%\lib\dropwizard-jersey-0.9.2.jar;%APP_HOME%\lib\dropwizard-servlets-0.9.2.jar;%APP_HOME%\lib\jetty-webapp-9.2.13.v20150730.jar;%APP_HOME%\lib\dropwizard-jetty-0.9.2.jar;%APP_HOME%\lib\jetty-continuation-9.2.13.v20150730.jar;%APP_HOME%\lib\dropwizard-lifecycle-0.9.2.jar;%APP_HOME%\lib\metrics-core-3.1.2.jar;%APP_HOME%\lib\metrics-annotation-3.1.2.jar;%APP_HOME%\lib\metrics-jetty9-3.1.2.jar;%APP_HOME%\lib\jetty-servlet-9.2.13.v20150730.jar;%APP_HOME%\lib\jetty-servlets-9.2.13.v20150730.jar;%APP_HOME%\lib\jetty-http-9.2.13.v20150730.jar;%APP_HOME%\lib\metrics-jvm-3.1.2.jar;%APP_HOME%\lib\metrics-json-3.1.2.jar;%APP_HOME%\lib\jboss-logging-3.2.1.Final.jar;%APP_HOME%\lib\classmate-1.1.0.jar;%APP_HOME%\lib\metrics-servlets-3.1.2.jar;%APP_HOME%\lib\jersey-common-2.22.1.jar;%APP_HOME%\lib\metrics-healthchecks-3.1.2.jar;%APP_HOME%\lib\argparse4j-0.6.0.jar;%APP_HOME%\lib\jetty-setuid-java-1.0.3.jar;%APP_HOME%\lib\jersey-client-2.22.1.jar;%APP_HOME%\lib\javax.ws.rs-api-2.0.1.jar;%APP_HOME%\lib\guice-servlet-4.0.jar;%APP_HOME%\lib\guice-multibindings-4.0.jar;%APP_HOME%\lib\guice-bridge-2.4.0-b31.jar;%APP_HOME%\lib\jersey-media-jaxb-2.22.1.jar;%APP_HOME%\lib\generics-resolver-2.0.1.jar;%APP_HOME%\lib\javax.annotation-api-1.2.jar;%APP_HOME%\lib\lucene-core-5.5.0.jar;%APP_HOME%\lib\javax.inject-2.4.0-b31.jar;%APP_HOME%\lib\hk2-locator-2.4.0-b31.jar;%APP_HOME%\lib\lucene-backward-codecs-5.5.0.jar;%APP_HOME%\lib\jersey-container-servlet-core-2.22.1.jar;%APP_HOME%\lib\lucene-analyzers-common-5.5.0.jar;%APP_HOME%\lib\javax.servlet-api-3.1.0.jar;%APP_HOME%\lib\jetty-io-9.2.13.v20150730.jar;%APP_HOME%\lib\lucene-queries-5.5.0.jar;%APP_HOME%\lib\jetty-xml-9.2.13.v20150730.jar;%APP_HOME%\lib\lucene-memory-5.5.0.jar;%APP_HOME%\lib\lucene-highlighter-5.5.0.jar;%APP_HOME%\lib\lucene-queryparser-5.5.0.jar;%APP_HOME%\lib\lucene-suggest-5.5.0.jar;%APP_HOME%\lib\lucene-join-5.5.0.jar;%APP_HOME%\lib\jetty-security-9.2.13.v20150730.jar;%APP_HOME%\lib\jersey-guava-2.22.1.jar;%APP_HOME%\lib\lucene-spatial-5.5.0.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.1.jar;%APP_HOME%\lib\securesm-1.0.jar;%APP_HOME%\lib\hppc-0.7.1.jar;%APP_HOME%\lib\joda-convert-1.2.jar;%APP_HOME%\lib\jackson-core-2.6.6.jar;%APP_HOME%\lib\jackson-databind-2.6.3.jar;%APP_HOME%\lib\jackson-dataformat-smile-2.6.6.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.6.6.jar;%APP_HOME%\lib\jackson-dataformat-cbor-2.6.6.jar;%APP_HOME%\lib\netty-3.10.5.Final.jar;%APP_HOME%\lib\compress-lzf-1.0.2.jar;%APP_HOME%\lib\t-digest-3.0.jar;%APP_HOME%\lib\HdrHistogram-2.1.6.jar;%APP_HOME%\lib\commons-cli-1.3.1.jar;%APP_HOME%\lib\jsr166e-1.1.0.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\joda-time-2.9.jar;%APP_HOME%\lib\aopalliance-1.0.jar;%APP_HOME%\lib\scala-library-2.10.2.jar;%APP_HOME%\lib\slf4j-api-1.7.12.jar;%APP_HOME%\lib\metadata-dropwizard_2.10-9.2.0.jar;%APP_HOME%\lib\error-registry-dropwizard_2.10-9.2.0.jar;%APP_HOME%\lib\request-validation-dropwizard_2.10-9.2.0.jar;%APP_HOME%\lib\dropwizard-guice-0.7.2.jar;%APP_HOME%\lib\error-registry_2.10-9.2.0.jar;%APP_HOME%\lib\healthcheck_2.10-9.2.0.jar;%APP_HOME%\lib\logback-classic-1.1.3.jar;%APP_HOME%\lib\metadata_2.10-9.2.0.jar;%APP_HOME%\lib\mongo-java-driver-3.0.2.jar;%APP_HOME%\lib\metrics-healthchecks-3.0.2.jar;%APP_HOME%\lib\metrics-core-3.0.2.jar;%APP_HOME%\lib\jackson-annotations-2.6.0.jar;%APP_HOME%\lib\metrics-json-3.0.2.jar;%APP_HOME%\lib\metrics-jvm-3.0.2.jar;%APP_HOME%\lib\metrics-logback-3.0.2.jar;%APP_HOME%\lib\metrics-graphite-3.0.2.jar;%APP_HOME%\lib\hk2-api-2.4.0-b31.jar;%APP_HOME%\lib\logback-core-1.1.3.jar;%APP_HOME%\lib\stax2-api-3.1.4.jar;%APP_HOME%\lib\jackson-datatype-joda-2.6.3.jar;%APP_HOME%\lib\lucene-sandbox-5.5.0.jar;%APP_HOME%\lib\commons-lang3-3.4.jar;%APP_HOME%\lib\lucene-misc-5.5.0.jar;%APP_HOME%\lib\lucene-grouping-5.5.0.jar;%APP_HOME%\lib\lucene-spatial3d-5.5.0.jar;%APP_HOME%\lib\spatial4j-0.5.jar;%APP_HOME%\lib\jackson-jaxrs-base-2.6.3.jar;%APP_HOME%\lib\snakeyaml-1.15.jar;%APP_HOME%\lib\request-validation_2.10-9.2.0.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.6.3.jar;%APP_HOME%\lib\utils_2.10-9.2.0.jar;%APP_HOME%\lib\reference-data-client_2.10-9.2.0.jar;%APP_HOME%\lib\annotations-3.0.0.jar;%APP_HOME%\lib\reflections-0.9.9.jar;%APP_HOME%\lib\jackson-core-lgpl-1.9.13.jar;%APP_HOME%\lib\logstash-logback-encoder-4.2.jar;%APP_HOME%\lib\hk2-utils-2.4.0-b31.jar;%APP_HOME%\lib\aopalliance-repackaged-2.4.0-b31.jar;%APP_HOME%\lib\logback-json-classic-0.1.2.jar;%APP_HOME%\lib\logback-json-core-0.1.2.jar;%APP_HOME%\lib\logback-jackson-0.1.2.jar;%APP_HOME%\lib\httpclient-4.3.1.jar;%APP_HOME%\lib\commons-io-2.4.jar;%APP_HOME%\lib\jackson-dataformat-xml-2.5.0.jar;%APP_HOME%\lib\jackson-jaxrs-xml-provider-2.5.0.jar;%APP_HOME%\lib\validation-api-1.1.0.Final.jar;%APP_HOME%\lib\javassist-3.18.2-GA.jar;%APP_HOME%\lib\httpcore-4.3.jar;%APP_HOME%\lib\commons-logging-1.1.3.jar;%APP_HOME%\lib\commons-codec-1.6.jar;%APP_HOME%\lib\woodstox-core-asl-4.4.0.jar;%APP_HOME%\lib\stax-api-1.0-2.jar

@rem Execute services-tsm-reference-data-service
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %SERVICES_TSM_REFERENCE_DATA_SERVICE_OPTS%  -classpath "%CLASSPATH%" com.travelsupermarket.referencedata.ReferenceDataApplication %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable SERVICES_TSM_REFERENCE_DATA_SERVICE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%SERVICES_TSM_REFERENCE_DATA_SERVICE_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
