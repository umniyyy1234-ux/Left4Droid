#!/bin/bash
# Скрипт запуска L4D2 через Wine

set -e

# Настройка переменных окружения
export WINEPREFIX="/data/data/com.termux/files/usr/var/lib/wine"
export LD_LIBRARY_PATH="$PREFIX/lib:/system/lib64:$LD_LIBRARY_PATH"
export PATH="$PREFIX/bin:$PATH"

# Путь к игре
GAME_DIR="/storage/emulated/0/Android/data/com.l4d2.launcher/files/steamapps/common/left4dead2"
DXVK_CONFIG="$PREFIX/dxvk/dxvk.conf"

# Проверка наличия установленной игры
if [ ! -d "$GAME_DIR" ]; then
  echo "Ошибка: Игра не найдена в $GAME_DIR"
  exit 1
fi

# Проверка наличия Wine
if ! command -v wine &> /dev/null; then
  echo "Ошибка: Wine не установлен. Выполните установку зависимостей."
  exit 1
fi

# Автоматическая настройка DXVK при необходимости
if [ -d "$PREFIX/dxvk" ]; then
  export DXVK_CONFIG_FILE="$DXVK_CONFIG"
  export DXVK_HUD=1
  echo "DXVK активирован"
fi

# Определение профиля из аргументов
PROFILE="${1:-BALANCE}"
RESOLUTION="${2:-1280x720}"

echo "Запуск L4D2 с профилем: $PROFILE"
echo "Разрешение: $RESOLUTION"

# Запуск игры
cd "$GAME_DIR"
wine left4dead2.exe -w ${RESOLUTION%x*} -h ${RESOLUTION#*x}

echo "Игра завершена"