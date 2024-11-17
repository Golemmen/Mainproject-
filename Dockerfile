# Устанавливаем базовый образ
FROM openjdk:17-jdk-alpine

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем артефакт JAR в контейнер
COPY target/smart-microwave-1.0.jar app.jar

# Открываем порт для приложения
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]