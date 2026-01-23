# oopd-gu-chalmers Lab 1
Lab assignment 1 in the course Object-oriented Programming and Design, GU/Chalmers

## Instruktioner för testning.
Från root-katalogen, skriv följande kommando.
```
mvn test

```

## Testresultat med coverage
```
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------------------< se.gu.lab:lab1 >---------------------------
[INFO] Building lab1 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- clean:3.2.0:clean (default-clean) @ lab1 ---
[INFO] Deleting C:\Users\durim\VT-2026\OOP-design\LAB1\target
[INFO]
[INFO] --- jacoco:0.8.14:prepare-agent (default) @ lab1 ---
[INFO] argLine set to -javaagent:C:\\Users\\durim\\.m2\\repository\\org\\jacoco\\org.jacoco.agent\\0.8.14\\org.jacoco.agent-0.8.14-runtime.jar=destfile=C:\\Users\\durim\\VT-2026\\OOP-design\\LAB1\\target\\jacoco.exec
[INFO]
[INFO] --- resources:3.3.1:resources (default-resources) @ lab1 ---
[INFO] skip non existing resourceDirectory C:\Users\durim\VT-2026\OOP-design\LAB1\src\main\resources
[INFO]
[INFO] --- compiler:3.12.1:compile (default-compile) @ lab1 ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 5 source files with javac [debug release 25] to target\classes
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ lab1 ---
[INFO] skip non existing resourceDirectory C:\Users\durim\VT-2026\OOP-design\LAB1\src\test\resources
[INFO]
[INFO] --- compiler:3.12.1:testCompile (default-testCompile) @ lab1 ---
[INFO] Recompiling the module because of changed dependency.
[INFO] Compiling 1 source file with javac [debug release 25] to target\test-classes
[INFO]
[INFO] --- surefire:3.2.5:test (default-test) @ lab1 ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running lab1.VehicleTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.081 s -- in lab1.VehicleTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- jar:3.4.1:jar (default-jar) @ lab1 ---
[INFO] Building jar: C:\Users\durim\VT-2026\OOP-design\LAB1\target\lab1-1.0-SNAPSHOT.jar
[INFO]
[INFO] --- jacoco:0.8.14:report (report) @ lab1 ---
[INFO] Loading execution data file C:\Users\durim\VT-2026\OOP-design\LAB1\target\jacoco.exec
[INFO] Analyzed bundle 'lab1' with 3 classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.695 s
[INFO] Finished at: 2026-01-23T13:08:12+01:00
[INFO] ------------------------------------------------------------------------
```

## Svar på frågor från Lab1 - Uppgift 1.
```
-------------------------------------------------------------------------------
|  Svar på frågor i uppgift 1                                                 |
-------------------------------------------------------------------------------
|1.  Bör ni använda implementationsarv (subclassing) eller specifikationsarv  |
|   (interfaces)? Varför? Kan båda användas? Vilka för- och nackdelar ser ni? |
|                                                                             |
|Svar: Implementationsarv används när man vill undvika kodduplicering på två  |
|      eller fler klasser med variabler och metoder som är lika.              |
|                                                                             |
|      Specifikationsarv används när man vill säkerställa att klassmetoder    |
|      beter sig på ett förutsagt sätt.                                       |
|------------------------------------------------------------------------------
|2.  Vilken synlighet bör ni använda för de olika metoder och variabler som   |
|    klasserna innehåller? Vilket gränssnitt bör ni exponera?                 |
|                                                                             |
|Svar: Getters och setters som inte används inom klasshierarkin exponeras     |
|      globalt. Likaså med metoderna för att starta och stoppa motorn samt    |
|      höja och sänka farten. Variabler och objekt som kan modifiera          |
|      klassobjektets interna tillstånd bör inte exponeras.                   |
|------------------------------------------------------------------------------
```

## Projekt struktur.
```
C:\USERS\DURIM\VT-2026\OOP-DESIGN\LAB1
│   .classpath
│   .project
│   diff.txt
│   pom.xml
│   README.md
│
├───.settings
│       org.eclipse.core.resources.prefs
│       org.eclipse.jdt.apt.core.prefs
│       org.eclipse.jdt.core.prefs
│       org.eclipse.m2e.core.prefs
│
├───src
│   ├───main
│   │   └───java
│   │       └───lab1
│   │               Movable.java
│   │               README.txt
│   │               Saab95.java
│   │               TurboCharged.java
│   │               Vehicle.java
│   │               Volvo240.java
│   │
│   └───test
│       └───java
│           └───lab1
│                   VehicleTest.java
│
└───target
    │   spotless-index
    │
    ├───classes
    │   └───lab1
    │           Movable.class
    │           README.txt
    │           Saab95.class
    │           TurboCharged.class
    │           Vehicle.class
    │           Volvo240.class
    │
    ├───generated-sources
    │   └───annotations
    ├───generated-test-sources
    │   └───test-annotations
    ├───maven-status
    │   └───maven-compiler-plugin
    │       ├───compile
    │       │   └───default-compile
    │       │           createdFiles.lst
    │       │           inputFiles.lst
    │       │
    │       └───testCompile
    │           └───default-testCompile
    │                   createdFiles.lst
    │                   inputFiles.lst
    │
    ├───surefire-reports
    │       lab1.VehicleTest.txt
    │       TEST-lab1.VehicleTest.xml
    │
    └───test-classes
        └───lab1
                VehicleTest.class
```
