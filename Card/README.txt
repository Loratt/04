1. � ������� ���������������� ���������� Boot2Docker ������������� ����������� ������ � ��������� Docker.

2. ��������� � ������ ����������� � dockerfile ��� Server.py
cd /directory_with_dockerfile/

3. ������� ����� 
docker build -t docker-server .

4. ������� � ��������� ��������� �� ������� ������ 
docker run --rm docker-server

5. ��������� ������� ����� ��� CuchDB
docker run -d -p 5984:5984 --name couchdb klaemo/couchdb

6. ��������� � ����������� cd .../android-sdk/platform-tools

7. ��������� ����������� ���������� �� ������������ ����������
adb install .../"Card.apk"

8. ��������� � ����������� cd .../DropBox/Skanatek/04/Card

9. ��������������� ����������
calabash-android resign "Card.apk"

10. ��������� ����
calabash-android run "Card.apk"