#!/bin/bash
set -e

# Установка зависимостей для запуска L4D2 на Android через Wine
echo "Установка зависимостей..."

# Обновление пакетов Termux
pkg update -y
pkg upgrade -y

# Установка необходимых пакетов
pkg install -y \
 wine \
 box64 \
 dxvk \
 vulkan-tools \
 libX11 \
 libXcursor \
 libXrandr \
 libXi \
 libXrender \
 mesa \
 gcc \
 make \
 git \
 proot-distro

echo "Настройка DXVK..."
# Скачивание и установка DXVK
wget https://github.com/doitsujin/dxvk/releases/latest/download/dxvk-master.tar.gz -O /data/data/com.termux/files/usr/tmp/dxvk.tar.gz
mkdir -p $PREFIX/dxvk
tar -xzf /data/data/com.termux/files/usr/tmp/dxvk.tar.gz -C $PREFIX/dxvk
rm /data/data/com.termux/files/usr/tmp/dxvk.tar.gz

echo "Настройка Wine префикса..."
export WINEPREFIX="/data/data/com.termux/files/usr/var/lib/wine"
wineboot -u

echo "Готово! Зависимости установлены успешно."