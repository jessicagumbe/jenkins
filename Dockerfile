FROM openjdk:17
WORKDIR /
ADD target/utilizandoJenkins-0.0.1-SNAPSHOT.jar utilizandoJenkins-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","utilizandoJenkins-0.0.1-SNAPSHOT.jar"]