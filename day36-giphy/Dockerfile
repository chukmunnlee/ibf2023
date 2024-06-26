# Build Angular
FROM node:22 AS ngbuild

WORKDIR /frontend

# Install angular 
RUN npm i -g @angular/cli@17.3.8

COPY frontend/angular.json .
COPY frontend/package*.json .
COPY frontend/tsconfig*.json .
COPY frontend/src src

# Install modules
RUN npm ci 
RUN ng build

# Build Spring Boot
FROM openjdk:21 AS javabuild

WORKDIR /giphy

COPY giphy/mvnw .
COPY giphy/pom.xml .
COPY giphy/.mvn .mvn
COPY giphy/src src

# copy angular files to spring boot
COPY --from=ngbuild /frontend/dist/frontend/browser/ src/main/resources/static

# produce target/giphy-0.0.1-SNAPSHOT.jar
RUN ./mvnw package -Dmaven.test.skip=true

# Run container
FROM openjdk:21 

WORKDIR /app

COPY --from=javabuild /giphy/target/giphy-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=8080 GIPHY_KEY=abc123

EXPOSE ${PORT}

ENTRYPOINT SERVER_PORT=${PORT} java -jar app.jar