How to start server: (netbeans)

1. Download and install Netbeans java EE version
2. During installation choose to install tomcat
3. Open ServerTrello project in netbeans
4. Import Hibernate
4. Right click on project -> clean and build
5. Right click on project -> properties - > run - > choose installed tomcat server
6. Right click on project -> run


Aby odpalić serwer: (eclipse)
1. Pobierz najnowszy Eclipse Neon
2. Importuj projekt maven'owski
3. Zainstaluj server Tomcat
4. Zaimportuj Hibernate
5. Prawy przycisk myszy na projekcie -> run as -> run on server


Aby wczytac framework hibernate do projektu.
W tym celu nalezy(eclipse)

1) ściągnąć Hibernate minimum 5.2.3

2) build path -> configure build path -> Add library -> user libraries -> new -> wpisujemy Hibernate -> ok -> Add external Jar's. I dodajemy biblotek� hibernate

interesuj� nas pliki (na moich dzia�a)
lib\required\antlr-2.7.7.jar
lib\required\cdi-api-1.1.jar
lib\required\classmate-1.3.0.jar
lib\required\dom4j-1.6.1.jar
lib\required\el-api-2.2.jar
lib\required\geronimo-jta_1.1_spec-1.1.1.jar
lib\required\hibernate-commons-annotations-5.0.1.Final.jar
lib\required\hibernate-core-5.2.3.Final.jar
lib\required\hibernate-jpa-2.1-api-1.0.0.Final.jar
lib\required\jandex-2.0.0.Final.jar
lib\required\javassist-3.20.0-GA.jar
lib\required\javax.inject-1.jar
lib\required\jboss-interceptors-api_1.1_spec-1.0.0.Beta1.jar
lib\required\jboss-logging-3.3.0.Final.jar
lib\required\jsr250-api-1.0.jar
lib\jpa-metamodel-generator\hibernate-jpamodelgen-5.2.3.Final.jar

oraz
sqljdbc41.jar (JDBC, do �ci�gni�cia)

3) build path -> configure build path -> Add Library ->wybieramy Hibernate -> OK

4) ustawienia projektu -> deployment assembly -> add -> java build path entries -> hibernate -> ok

gotowe