1. С помощью вспомогательного приложения Boot2Docker устанавливаем вирутальную машину и запускаем Docker.

2. Переходим в нужную деррикторию с dockerfile для Server.py
cd /directory_with_dockerfile/

3. Создаем образ 
docker build -t docker-server .

4. Создаем и запускаем контейнер из данного образа 
docker run --rm docker-server

5. Запускаем готовый образ для CuchDB
docker run -d -p 5984:5984 --name couchdb klaemo/couchdb

6. Переходим в деррикторию cd .../android-sdk/platform-tools

7. Установим тестируемое приложение на подключенное устройство
adb install .../"Card.apk"

8. Переходим в деррикторию cd .../DropBox/Skanatek/04/Card

9. Переподписываем приложение
calabash-android resign "Card.apk"

10. Запускаем тест
calabash-android run "Card.apk"