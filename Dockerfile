FROM openjdk:11
ADD target/comunika-configuracao-0.0.1-SNAPSHOT.jar comunika-configuracao-0.0.1-SNAPSHOT.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "comunika-configuracao-0.0.1-SNAPSHOT.jar"]