# Проект по автоматизации тестовых сценариев для [сайта](https://job.alfabank.ru/) вакансий Альфа-Банка
![Основная информация](media/screenshots/alfa.jpg)

<abbr title="Java"><img src="images/icons/alfabank.gif" alt="Java" width="20" height="20"></abbr> Содержание
---
- [Инструменты и технологии](#инструменты-и-технологии)
- [Описание проекта](#описание-проекта)
- [Запуск автотестов](#запуск-автотестов)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Пример Allure-отчета](#пример-allure-отчета)
- [Интеграция с Allure TestOps](#интеграция-с-Allure-TestOps)
- [Интеграция с  Jira](#интеграция-с-Jira)
- [Уведомление в Telegram](#уведомление-в-telegram)
- [Пример видео из Selenoid](#пример-видео-из-selenoid)
---
## <a id="инструменты-и-технологии">Инструменты и технологии</a>

<p align="center">
   <abbr title="Java"><img src="media/icons/java.svg" alt="Java" width="50" height="50"></abbr>
   <abbr title="Gradle"><img src="media/icons/gradle_logo_icon_248152.svg" alt="Gradle" width="50" height="50"></abbr>
   <abbr title="Selenoid"><img src="media/icons/selenide.png" alt="Selenide" width="50" height="50"></abbr>
   <abbr title="JUnit 5"><img src="media/icons/JUnit5.svg" alt="JUnit 5" width="50" height="50"></abbr>
   <abbr title="Jenkins"><img src="media/icons/jenkins.svg" alt="Jenkins" width="50" height="50"></abbr>
   <abbr title="Selenoid"><img src="media/icons/selenoid.png" alt="Selenoid" width="50" height="50"></abbr>
   <abbr title="Allure"><img src="media/icons/allure.Default" alt="Allure" width="50" height="50"></abbr>
   <abbr title="Allure TestOps"><img src="media/icons/Allure2.svg" alt="Allure TestOps" width="50" height="50"></abbr>
   <abbr title="Jira"><img src="media/icons/atlassian_jira.svg" alt="Jira" width="50" height="50"></abbr>
   <abbr title="Telegram"><img src="media/icons/telegram.png" alt="Telegram" width="50" height="50"></abbr>
</p>

## <a id="описание-проекта">Описание проекта</a>

UI-автотесты написаны на языке `Java` c использованием `JDK 17`, `Gradle`, а также библиотек `Selenide` и `JUnit 5`.
Удаленный запуск тестов происходит через джобу в [Jenkins](https://jenkins.autotests.cloud/view/java_students/job/AbramovaS_Ready_project_for_Alfa_Bank/), 
которая также отвечает за генерацию Allure-отчетов и отправку уведомлений о 
результатах в Telegram. Для комплексного анализа результатов настроена интеграция с 
системами [Allure TestOps](https://allure.autotests.cloud/jobrun/51167) и [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1578).
## <a id="запуск-автотестов">Запуск автотестов</a>
**Локальный запуск через терминал**
```
gradle clean test
```
**Удалённый запуск в Jenkins**
```
clean test 
-DbaseUrl=${baseUrl}" 
-DremoteUrl=${remoteUrl}"
-Dbrowser=${browser}" 
-Dversion=${browserVersion}"
-DbrowserSize=${browserSize}" 
```
**Параметры сборки**
- `BASE_URL` - базовый URL-адрес веб-сайта или приложения
- `REMOTE_URL` - удаленный URL (=Selenoid Hub URL)
- `BROWSER` - браузер для выполнения автотестов
- `BROWSER_VERSION` - версия браузера
- `BROWSER_SIZE` - размер окна браузера (ширина × высота)
## <a id="сборка-в-jenkins">Сборка в Jenkins</a>
Для выбора параметров и запуска сборки необходимо нажать <kbd>Build with Parameters</kbd>

![Основная информация](media/screenshots/jenkins_1.jpg)
## <a id="пример-allure-отчета">Пример Allure-отчета</a>
Увидеть результаты автотестов позволяет интерактивный Allure-отчет
### Обзорная информация
![Основная информация](media/screenshots/allure_report_dashbord.jpg)
### Тест-кейсы
![Основная информация](media/screenshots/allure_report_test.jpg)
## <a id="интеграция-с-Allure-TestOps">Интеграция с Allure TestOps</a>
Интеграция с Jenkins позволяет автоматически передавать результаты тестов из 
сборки в TestOps

### Дашборд
![Основная информация](media/screenshots/allure_testops_dashbord.jpg)
### Тест-кейсы
![Основная информация](media/screenshots/allure_testops_test.jpg)
## <a id="интеграция-с-Jira">Интеграция с  Jira</a>
В проекте настроена автоматическая отправка данных о сборке из Jenkins в Jira

![Основная информация](media/screenshots/jira_3.jpg)
## <a id="уведомление-в-telegram">Уведомление в Telegram</a>
Результат прогона отправляется в чат мессенджера Telegram

![Основная информация](media/screenshots/telegram_1.jpg)
## <a id="пример-видео-из-selenoid">Пример видео из Selenoid</a>
![описание](media/video/selenoid_gif.gif)









