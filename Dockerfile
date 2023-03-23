# compilation environnement
FROM maven:3.9.0-eclipse-temurin-17-alpine AS build-stage
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
FROM eclipse-temurin:17-alpine AS production-stage
RUN mkdir /app
COPY --from=build-stage /jukebox/target/jukebox.jar /app
WORKDIR /app
ENTRYPOINT ["java","-jar","jukebox.jar"]
EXPOSE 8080
