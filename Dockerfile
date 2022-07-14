FROM amazoncorretto

ENV MONGO_DB_USERNAME=admin \
    MONGO_DB_PWD=password
#
#RUN mkdir -p "/home/app"
#COPY . "/home/app"
EXPOSE 8086

ADD target/spring-boot-docker.jar spring-boot-docker.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-docker.jar"]