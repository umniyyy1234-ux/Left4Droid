# L4D2 Launcher для Android

Android-лаунчер для запуска Left 4 Dead 2 через слой совместимости Wine/Proton.

## 🚀 Быстрая сборка APK

### Вариант 1: Через Android Studio (рекомендуется)

1. Установите [Android Studio](https://developer.android.com/studio)
2. Откройте папку проекта в Android Studio
3. Соберите APK: `Build -> Build Bundle(s) / APK(s) -> Build APK(s)`
4. Найдите APK в: `app/build/outputs/apk/release/app-release.apk`

### Вариант 2: Через командную строку

```bash
# Требуется: Java JDK 17+, Android SDK
# 1. Установите SDK tools:
sdkmanager "build-tools;34.0.0" "platforms;android-34" "ndk;26.1.10909125"

# 2. Создайте local.properties:
echo "sdk.dir=/путь/к/android/sdk" > local.properties

# 3. Соберите:
./gradlew assembleRelease

# APK будет в app/build/outputs/apk/release/
```

## 📱 Требования к устройству

- **Минимальная версия**: Android 11 (API 30)
- **Архитектура**: arm64-v8a
- **Поддерживаемые SoC**: Snapdragon 680–8 Gen 3
- **Дополнительно**: Termux (для backend-слоя Wine)

## 📦 Структура проекта

```
L4D2-Launcher/
├── app/
│   ├── build.gradle.kts     # Конфигурация сборки
│   ├── proguard-rules.pro   # Правила оптимизации
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/            # Kotlin исходники
│       │   ├── MainActivity.kt
│       │   ├── ui/          # Jetpack Compose UI
│       │   ├── steam/       # Авторизация и установка
│       │   ├── device/      # Определение устройства
│       │   ├── orchestrator/ # Запуск Wine
│       │   └── profile/     # Управление профилями
│       └── res/             # Ресурсы (strings, drawables)
├── scripts/                 # Backend скрипты для Termux
│   ├── install-dependencies.sh
│   └── start-wine.sh
└── .github/workflows/       # CI/CD
    └── build.yml
```

## 🎮 Как это работает

1. **Определение устройства**: анализируется SoC, GPU, RAM
2. **Установка зависимостей**: через Termux устанавливаются Wine, DXVK, Box64
3. **Импорт игры**: через SAF или SteamCMD
4. **Настройка профиля**: выбор между "Макс. FPS", "Баланс", "Экономия энергии"
5. **Запуск игры**: один клик в UI стартует Wine с нужными настройками

## 📊 Поддерживаемые конфигурации

| Устройство       | Разрешение | Качество | Ожидаемый FPS |
|------------------|:----------:|:--------:|:-------------:|
| Snapdragon 870   | 720p       | Low/Medium | 45-60 FPS   |
| Snapdragon 680   | 480p       | Low      | 30-45 FPS     |
| Snapdragon 8 Gen 3 | 1080p    | Medium   | 60+ FPS       |

## ⚙️ Профили производительности

- **Макс. FPS**: 720p, Low текстуры, FPS limiter отключён
- **Баланс**: 720p, Medium текстуры, 60 FPS лимит
- **Энергосбережение**: 540p, Low текстуры, 45 FPS лимит
- **Стабильность**: 480p, Low текстуры, максимальная стабильность

## 🔧 Диагностика и логи

- Встроенный экран диагностики
- Экспорт логов
- Автоматический crash recovery
- Сброс настроек к исходным

## ⚖️ Лицензия

- Этот лаунчер не включает L4D2
- Пользователь должен предоставить легальную копию игры
- Все зависимости (Wine, DXVK) используют открытые лицензии
- Steam требуется только для скачивания официальных файлов

## 🆘 Поддержка

Если игра не запускается:
1. Проверьте логи в разделе "Диагностика"
2. Убедитесь что Termux и все зависимости установлены
3. Проверьте свободное место на устройстве (не менее 5GB)
4. Попробуйте сбросить настройки в Settings