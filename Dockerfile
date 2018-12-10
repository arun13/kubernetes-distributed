FROM openjdk:8
ADD target/kubernetes-distributed.jar kubernetes-distributed.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","kubernetes-distributed.jar"]