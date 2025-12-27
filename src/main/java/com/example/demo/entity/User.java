coder@747b8fdc51f6:~/Workspace/demo$ mvn clean install
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------------< com.example:demo >--------------------------
[INFO] Building demo 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.3.2:clean (default-clean) @ demo ---
[INFO] Deleting /home/coder/Workspace/demo/target
[INFO] 
[INFO] --- maven-resources-plugin:3.3.1:resources (default-resources) @ demo ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Copying 0 resource from src/main/resources to target/classes
[INFO] 
[INFO] --- maven-compiler-plugin:3.13.0:compile (default-compile) @ demo ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 44 source files with javac [debug parameters release 17] to target/classes
[INFO] /home/coder/Workspace/demo/src/main/java/com/example/demo/util/JwtUtil.java: /home/coder/Workspace/demo/src/main/java/com/example/demo/util/JwtUtil.java uses or overrides a deprecated API.
[INFO] /home/coder/Workspace/demo/src/main/java/com/example/demo/util/JwtUtil.java: Recompile with -Xlint:deprecation for details.
[INFO] -------------------------------------------------------------
[WARNING] COMPILATION WARNING : 
[INFO] -------------------------------------------------------------
[WARNING] /home/coder/Workspace/demo/src/main/java/com/example/demo/config/SecurityConfig.java:[23,13] csrf() in org.springframework.security.config.annotation.web.builders.HttpSecurity has been deprecated and marked for removal
[WARNING] /home/coder/Workspace/demo/src/main/java/com/example/demo/config/SecurityConfig.java:[24,13] sessionManagement() in org.springframework.security.config.annotation.web.builders.HttpSecurity has been deprecated and marked for removal
[WARNING] /home/coder/Workspace/demo/src/main/java/com/example/demo/config/SecurityConfig.java:[25,13] and() in org.springframework.security.config.annotation.SecurityConfigurerAdapter has been deprecated and marked for removal
[INFO] 3 warnings 
[INFO] -------------------------------------------------------------
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/repository/ServiceCounterRepository.java:[3,31] cannot access com.example.demo.entity.ServiceCounter
  bad source file: /home/coder/Workspace/demo/src/main/java/com/example/demo/entity/ServiceCounter.java
    file does not contain class com.example.demo.entity.ServiceCounter
    Please remove or make sure it appears in the correct subdirectory of the sourcepath.
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/entity/ServiceCounter.java:[7,8] class User is public, should be declared in a file named User.java
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/entity/User.java:[7,8] duplicate class: com.example.demo.entity.User
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/repository/ServiceCounterRepository.java:[9,65] cannot find symbol
  symbol: class ServiceCounter
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/FullProjectTest.java:[27,13] cannot find symbol
  symbol:   class ServiceCounter
  location: class com.example.demo.FullProjectTest
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/repository/ServiceCounterRepository.java:[10,10] cannot find symbol
  symbol:   class ServiceCounter
  location: interface com.example.demo.repository.ServiceCounterRepository
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/ServiceCounterService.java:[7,31] cannot find symbol
  symbol:   class ServiceCounter
  location: interface com.example.demo.service.ServiceCounterService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/ServiceCounterService.java:[7,5] cannot find symbol
  symbol:   class ServiceCounter
  location: interface com.example.demo.service.ServiceCounterService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/ServiceCounterService.java:[8,10] cannot find symbol
  symbol:   class ServiceCounter
  location: interface com.example.demo.service.ServiceCounterService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/ServiceCounterServiceImpl.java:[16,38] cannot find symbol
  symbol:   class ServiceCounter
  location: class com.example.demo.service.impl.ServiceCounterServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/ServiceCounterServiceImpl.java:[16,12] cannot find symbol
  symbol:   class ServiceCounter
  location: class com.example.demo.service.impl.ServiceCounterServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/ServiceCounterServiceImpl.java:[20,17] cannot find symbol
  symbol:   class ServiceCounter
  location: class com.example.demo.service.impl.ServiceCounterServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/FullProjectTest.java:[17,12] cannot find symbol
  symbol: class TestResultListener
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/FullProjectTest.java:[42,30] cannot find symbol
  symbol:   class ServiceCounter
  location: class com.example.demo.FullProjectTest
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/FullProjectTest.java:[71,40] cannot find symbol
  symbol:   method saveToken(com.example.demo.entity.Token)
  location: variable tokenService of type com.example.demo.service.impl.TokenServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/FullProjectTest.java:[91,18] cannot find symbol
  symbol:   class ServiceCounter
  location: class com.example.demo.FullProjectTest
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/FullProjectTest.java:[102,17] onCreate() has protected access in com.example.demo.entity.TokenLog
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[28,9] cannot find symbol
  symbol:   class ServiceCounter
  location: class com.example.demo.service.impl.TokenServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[36,14] cannot find symbol
  symbol:   method setTokenNumber(java.lang.String)
  location: variable token of type com.example.demo.entity.Token
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[38,14] cannot find symbol
  symbol:   method setStatus(java.lang.String)
  location: variable token of type com.example.demo.entity.Token
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[39,14] cannot find symbol
  symbol:   method setIssuedAt(java.time.LocalDateTime)
  location: variable token of type com.example.demo.entity.Token
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[48,22] cannot find symbol
  symbol:   method setUpdatedAt(java.time.LocalDateTime)
  location: variable queuePosition of type com.example.demo.entity.QueuePosition
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[54,12] cannot find symbol
  symbol:   method setLogMessage(java.lang.String)
  location: variable log of type com.example.demo.entity.TokenLog
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[55,12] cannot find symbol
  symbol:   method setLoggedAt(java.time.LocalDateTime)
  location: variable log of type com.example.demo.entity.TokenLog
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[65,37] cannot find symbol
  symbol:   method getStatus()
  location: variable token of type com.example.demo.entity.Token
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[72,14] cannot find symbol
  symbol:   method setStatus(java.lang.String)
  location: variable token of type com.example.demo.entity.Token
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[75,18] cannot find symbol
  symbol:   method setCompletedAt(java.time.LocalDateTime)
  location: variable token of type com.example.demo.entity.Token
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[83,12] cannot find symbol
  symbol:   method setLogMessage(java.lang.String)
  location: variable log of type com.example.demo.entity.TokenLog
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[84,12] cannot find symbol
  symbol:   method setLoggedAt(java.time.LocalDateTime)
  location: variable log of type com.example.demo.entity.TokenLog
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/AuthController.java:[33,77] cannot find symbol
  symbol:   method getEmail()
  location: variable user of type com.example.demo.entity.User
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/AuthController.java:[34,81] cannot find symbol
  symbol:   method getEmail()
  location: variable user of type com.example.demo.entity.User
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/UserServiceImpl.java:[20,66] cannot find symbol
  symbol:   method getEmail()
  location: variable user of type com.example.demo.entity.User
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/security/CustomUserDetailsService.java:[30,21] cannot find symbol
  symbol:   method getEmail()
  location: variable user of type com.example.demo.entity.User
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/QueueServiceImpl.java:[33,22] cannot find symbol
  symbol:   method setUpdatedAt(java.time.LocalDateTime)
  location: variable queuePosition of type com.example.demo.entity.QueuePosition
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenLogServiceImpl.java:[27,12] cannot find symbol
  symbol:   method setLogMessage(java.lang.String)
  location: variable log of type com.example.demo.entity.TokenLog
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenLogServiceImpl.java:[28,12] cannot find symbol
  symbol:   method setLoggedAt(java.time.LocalDateTime)
  location: variable log of type com.example.demo.entity.TokenLog
[INFO] 36 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  11.195 s
[INFO] Finished at: 2025-12-27T16:39:57Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.13.0:compile (default-compile) on project demo: Compilation failure: Compilation failure: 
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/repository/ServiceCounterRepository.java:[3,31] cannot access com.example.demo.entity.ServiceCounter
[ERROR]   bad source file: /home/coder/Workspace/demo/src/main/java/com/example/demo/entity/ServiceCounter.java
[ERROR]     file does not contain class com.example.demo.entity.ServiceCounter
[ERROR]     Please remove or make sure it appears in the correct subdirectory of the sourcepath.
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/entity/ServiceCounter.java:[7,8] class User is public, should be declared in a file named User.java
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/entity/User.java:[7,8] duplicate class: com.example.demo.entity.User
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/repository/ServiceCounterRepository.java:[9,65] cannot find symbol
[ERROR]   symbol: class ServiceCounter
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/FullProjectTest.java:[27,13] cannot find symbol
[ERROR]   symbol:   class ServiceCounter
[ERROR]   location: class com.example.demo.FullProjectTest
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/repository/ServiceCounterRepository.java:[10,10] cannot find symbol
[ERROR]   symbol:   class ServiceCounter
[ERROR]   location: interface com.example.demo.repository.ServiceCounterRepository
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/ServiceCounterService.java:[7,31] cannot find symbol
[ERROR]   symbol:   class ServiceCounter
[ERROR]   location: interface com.example.demo.service.ServiceCounterService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/ServiceCounterService.java:[7,5] cannot find symbol
[ERROR]   symbol:   class ServiceCounter
[ERROR]   location: interface com.example.demo.service.ServiceCounterService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/ServiceCounterService.java:[8,10] cannot find symbol
[ERROR]   symbol:   class ServiceCounter
[ERROR]   location: interface com.example.demo.service.ServiceCounterService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/ServiceCounterServiceImpl.java:[16,38] cannot find symbol
[ERROR]   symbol:   class ServiceCounter
[ERROR]   location: class com.example.demo.service.impl.ServiceCounterServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/ServiceCounterServiceImpl.java:[16,12] cannot find symbol
[ERROR]   symbol:   class ServiceCounter
[ERROR]   location: class com.example.demo.service.impl.ServiceCounterServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/ServiceCounterServiceImpl.java:[20,17] cannot find symbol
[ERROR]   symbol:   class ServiceCounter
[ERROR]   location: class com.example.demo.service.impl.ServiceCounterServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/FullProjectTest.java:[17,12] cannot find symbol
[ERROR]   symbol: class TestResultListener
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/FullProjectTest.java:[42,30] cannot find symbol
[ERROR]   symbol:   class ServiceCounter
[ERROR]   location: class com.example.demo.FullProjectTest
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/FullProjectTest.java:[71,40] cannot find symbol
[ERROR]   symbol:   method saveToken(com.example.demo.entity.Token)
[ERROR]   location: variable tokenService of type com.example.demo.service.impl.TokenServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/FullProjectTest.java:[91,18] cannot find symbol
[ERROR]   symbol:   class ServiceCounter
[ERROR]   location: class com.example.demo.FullProjectTest
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/FullProjectTest.java:[102,17] onCreate() has protected access in com.example.demo.entity.TokenLog
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[28,9] cannot find symbol
[ERROR]   symbol:   class ServiceCounter
[ERROR]   location: class com.example.demo.service.impl.TokenServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[36,14] cannot find symbol
[ERROR]   symbol:   method setTokenNumber(java.lang.String)
[ERROR]   location: variable token of type com.example.demo.entity.Token
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[38,14] cannot find symbol
[ERROR]   symbol:   method setStatus(java.lang.String)
[ERROR]   location: variable token of type com.example.demo.entity.Token
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[39,14] cannot find symbol
[ERROR]   symbol:   method setIssuedAt(java.time.LocalDateTime)
[ERROR]   location: variable token of type com.example.demo.entity.Token
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[48,22] cannot find symbol
[ERROR]   symbol:   method setUpdatedAt(java.time.LocalDateTime)
[ERROR]   location: variable queuePosition of type com.example.demo.entity.QueuePosition
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[54,12] cannot find symbol
[ERROR]   symbol:   method setLogMessage(java.lang.String)
[ERROR]   location: variable log of type com.example.demo.entity.TokenLog
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[55,12] cannot find symbol
[ERROR]   symbol:   method setLoggedAt(java.time.LocalDateTime)
[ERROR]   location: variable log of type com.example.demo.entity.TokenLog
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[65,37] cannot find symbol
[ERROR]   symbol:   method getStatus()
[ERROR]   location: variable token of type com.example.demo.entity.Token
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[72,14] cannot find symbol
[ERROR]   symbol:   method setStatus(java.lang.String)
[ERROR]   location: variable token of type com.example.demo.entity.Token
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[75,18] cannot find symbol
[ERROR]   symbol:   method setCompletedAt(java.time.LocalDateTime)
[ERROR]   location: variable token of type com.example.demo.entity.Token
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[83,12] cannot find symbol
[ERROR]   symbol:   method setLogMessage(java.lang.String)
[ERROR]   location: variable log of type com.example.demo.entity.TokenLog
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenServiceImpl.java:[84,12] cannot find symbol
[ERROR]   symbol:   method setLoggedAt(java.time.LocalDateTime)
[ERROR]   location: variable log of type com.example.demo.entity.TokenLog
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/AuthController.java:[33,77] cannot find symbol
[ERROR]   symbol:   method getEmail()
[ERROR]   location: variable user of type com.example.demo.entity.User
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/AuthController.java:[34,81] cannot find symbol
[ERROR]   symbol:   method getEmail()
[ERROR]   location: variable user of type com.example.demo.entity.User
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/UserServiceImpl.java:[20,66] cannot find symbol
[ERROR]   symbol:   method getEmail()
[ERROR]   location: variable user of type com.example.demo.entity.User
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/security/CustomUserDetailsService.java:[30,21] cannot find symbol
[ERROR]   symbol:   method getEmail()
[ERROR]   location: variable user of type com.example.demo.entity.User
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/QueueServiceImpl.java:[33,22] cannot find symbol
[ERROR]   symbol:   method setUpdatedAt(java.time.LocalDateTime)
[ERROR]   location: variable queuePosition of type com.example.demo.entity.QueuePosition
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenLogServiceImpl.java:[27,12] cannot find symbol
[ERROR]   symbol:   method setLogMessage(java.lang.String)
[ERROR]   location: variable log of type com.example.demo.entity.TokenLog
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/TokenLogServiceImpl.java:[28,12] cannot find symbol
[ERROR]   symbol:   method setLoggedAt(java.time.LocalDateTime)
[ERROR]   location: variable log of type com.example.demo.entity.TokenLog
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
coder@747b8fdc51f6:~/Workspace/demo$ 