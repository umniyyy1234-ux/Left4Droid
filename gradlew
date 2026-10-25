#!/bin/sh

# Gradle wrapper script - скачивает и запускает Gradle автоматически

echo "Запуск Gradle..."
curl -L https://services.gradle.org/distributions/gradle-8.7-bin.zip -o /tmp/gradle.zip
unzip -o /tmp/gradle.zip -d /tmp/gradle
export PATH="/tmp/gradle/gradle-8.7/bin:$PATH"

# Проверка наличия Android SDK
if [ ! -d "/c/Users/shuric/AppData/Local/Android/Sdk" ]; then
  echo "Ошибка: Android SDK не найден"
  echo "Установите Android Studio или укажите путь к SDK в local.properties"
  exit 1
fi

exec gradle "$@"