# compilation environnement
FROM maven:3.6.3-adoptopenjdk-15 AS build-stage
ENV run_env=prod
# copy src
COPY pom.xml /jukebox/pom.xml
COPY src /jukebox/src
WORKDIR /jukebox

# package
# skip test - issue #7
# RUN mvn package
RUN mvn package -P$run_env -DskipTests

# execute on new environnement
FROM openjdk:12-alpine3.9 AS production-stage
RUN mkdir /app
COPY --from=build-stage /jukebox/target/jukebox.jar /app
WORKDIR /app
ENTRYPOINT ["java","-jar","jukebox.jar"]
EXPOSE 8080
