# Используем базовый образ с Java 17
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файл с зависимостями
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Устанавливаем переменные окружения
ENV SPRING_PROFILES_ACTIVE=prod

# Запуск приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
