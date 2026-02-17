# Проект по автоматизации тестовых сценариев для сайта вакансий Альфа-Банка
![Основная информация](images/screenshots/alfa.jpg)
___
📋 Содержание
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

---
<p align="center">
   <abbr title="Java"><img src="images/icons/java.svg" alt="Java" width="40" height="32"></abbr>
   <abbr title="Gradle"><img src="images/icons/gradle_logo_icon_248152.svg" alt="Gradle" width="40" height="32"></abbr>
   <abbr title="Selenoid"><img src="images/icons/selenide.png" alt="Selenide" width="40" height="32"></abbr>
   <abbr title="JUnit 5"><img src="images/icons/JUnit5.svg" alt="JUnit 5" width="40" height="32"></abbr>
   <abbr title="Jenkins"><img src="images/icons/jenkins.svg" alt="Jenkins" width="40" height="32"></abbr>
   <abbr title="Selenoid"><img src="images/icons/selenoid.png" alt="Selenoid" width="32" height="32"></abbr>
   <abbr title="Allure"><img src="images/icons/allure.Default" alt="Allure" width="32" height="32"></abbr>
   <abbr title="Allure TestOps"><img src="images/icons/Allure2.svg" alt="Allure TestOps" width="40" height="32"></abbr>
   <abbr title="Jira"><img src="images/icons/atlassian_jira.svg" alt="Jira" width="40" height="32"></abbr>
   <abbr title="Telegram"><img src="images/icons/telegram.png" alt="Telegram" width="40" height="32"></abbr>
</p>

## <a id="описание-проекта">Описание проекта</a>
UI-автотесты написаны на языке `Java` c использованием `JDK 17`, `Gradle`, а также библиотек `Selenide` и `JUnit 5`.
Удаленный запуск тестов происходит через джобу в [Jenkins](https://jenkins.autotests.cloud/view/java_students/job/AbramovaS_Ready_project_for_Alfa_Bank/), 
которая также отвечает за генерацию [Allure-отчетов](https://jenkins.autotests.cloud/view/java_students/job/AbramovaS_Ready_project_for_Alfa_Bank/14/allure/) и отправку уведомлений о 
результатах в Telegram. Для комплексного анализа результатов настроена интеграция с 
системами [Allure TestOps](https://allure.autotests.cloud/jobrun/51167) и [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1578).
## <a id="запуск-автотестов">Запуск автотестов</a>
## <a id="сборка-в-jenkins">Сборка в Jenkins</a>
![Основная информация](images/screenshots/jenkins_1.jpg)
## <a id="пример-allure-отчета">Пример Allure-отчета</a>
### Обзорная информация
![Основная информация](images/screenshots/allure_report_dashbord.jpg)
### Тест-кейсы
![Основная информация](images/screenshots/allure_report_test.jpg)
## <a id="интеграция-с-Allure-TestOps">Интеграция с Allure TestOps</a>
### Дашборд
![Основная информация](images/screenshots/allure_testops_dashbord.jpg)
### Тест-кейсы
![Основная информация](images/screenshots/allure_testops_test.jpg)
## <a id="интеграция-с-Jira">Интеграция с  Jira</a>
![Основная информация](images/screenshots/jira_3.jpg)
## <a id="уведомление-в-telegram">Уведомление в Telegram</a>
![Основная информация](images/screenshots/telegram_1.jpg)
## <a id="пример-видео-из-selenoid">Пример видео из Selenoid</a>
![описание](images/video/selenoid_gif.gif)









