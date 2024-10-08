#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . /app/
RUN mvn clean package

#
# Package stage
#
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.war /app/app.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.war"]

# 使用官方 MySQL 映像
FROM mysql:latest

# 環境變數設置
ENV MYSQL_ROOT_PASSWORD=123456
ENV MYSQL_DATABASE=test_db
ENV MYSQL_USER=user001
ENV MYSQL_PASSWORD=000000

# 端口設定
EXPOSE 3306
