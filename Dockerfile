FROM openjdk:11
ADD ./target/searchservice-0.0.1-SNAPSHOT.jar /usr/src/searchservice-0.0.1-SNAPSHOT.jar
EXPOSE 8099
WORKDIR /usr/src
ENTRYPOINT ["java","-jar","searchservice-0.0.1-SNAPSHOT.jar"]