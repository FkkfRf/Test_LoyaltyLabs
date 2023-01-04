# Проект по автоматизации тестирования
# сайта компании Loyalty Labs

![Logo-LoyLabs.svg](images/icons/Logo-LoyLabs.svg)
### <a target="_blank" href="https://loylabs.ru/">© Loyalty Labs 2013-2020</a>

![Logo-Sloj.svg](images/icons/Logo-Sloj.svg)
# :cyclone:	Содержание

> - [Технологии и инструменты](#cyclone-технологии-и-инструменты)
>
> - [Реализованы проверки](#cyclone-реализованы-проверки)
>
> - [Запуск тестов из терминала](#cyclone-Запуск-тестов-из-терминала)
>
> - [Запуск тестов в Jenkins](#-запуск-тестов-в-jenkins)
>
> - [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-allure-report)
>
> - [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
>
> - [Интеграция с Jira](#-интеграция-с-jira)
>
> - [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
>
> - [Пример запуска теста в Selenoid](#-пример-запуска-теста-в-selenoid)

##  :cyclone: Технологии и инструменты

<p  align="center"

<code><img width="5%" title="GitHub" src="images/logo/GitHub-logo.svg"></code>
<code><img width="5%" title="IntelliJ IDEA" src="images/logo/IntelijIDEA-logo.svg"></code>
<code><img width="5%" title="Java" src="images/logo/Java-logo.svg"></code>
<code><img width="5%" title="Selenide" src="images/logo/Selenide-logo.svg"></code>
<code><img width="5%" title="Gradle" src="images/logo/Gradle-logo.svg"></code>
<code><img width="5%" title="Junit5" src="images/logo/JUnit5-logo.svg"></code>
<code><img width="5%" title="Selenoid" src="images/logo/Selenoid-logo.svg"></code>
<code><img width="5%" title="Allure Report" src="images/logo/AllureReport-logo.svg"></code>
<code><img width="5%" title="Allure TestOps" src="images/logo/AllureTO-logo.svg"></code>
<code><img width="5%" title="RestAssured" src="images/logo/RestAssured-logo.svg"></code>
<code><img width="5%" title="Jenkins" src="images/logo/Jenkins-logo.svg"></code>
<code><img width="5%" title="Jira" src="images/logo/Jira-logo.svg"></code>
<code><img width="5%" title="Telegram" src="images/logo/Telegram-logo.svg"></code>
</p>

>- *В данном проекте использовались:*
>- *<code><strong>*Java*</strong></code> с использованием фреймворка <code><strong>*Selenide*</strong></code> - автотесты для UI*
>- *<code><strong>*Gradle*</strong></code> - сборка проекта*
>- *<code><strong>*JUnit 5*</strong></code> - фреймворк для модульного тестирования*
>- *<code><strong>REST Assured</strong></code> - тестирования REST-сервисов*
>- *<code><strong>*Jenkins*</strong></code> - запуск тестов*
>- *<code><strong>*Selenoid*</strong></code> - запуска браузеров в контейнерах <code><strong>*Docker*</strong></code>.*
>- *<code><strong>*Allure Report*</strong></code> - визуализации результатов тестирования*
>- *<code><strong>*Allure TestOps*</strong></code> - управление тестами*
>- *<code><strong>*Jira, Telegram Bot*</strong></code> - уведомление  о результатах тестирования*


## :cyclone: Реализованы проверки

### UI
#### ✓ Тест 1
>- [x] *Открыть сайт __loylabs.ru__*
>- [x] *На главной странице проверить элементы основного меню*
>- [x] *При клике на элемент главного меню должна открыться страница с соответствующим заголовком*
#### ✓ Тест 2
>- [x] *Открыть сайт __loylabs.ru__*
>- [x] *На главной странице проверить элементы раздела "Вчем мы сильны"*
>- [x] *При клике на элемент раздела  должна открыться страница с соответствующим заголовком*
#### ✓ Тест 3
>- [x] *Открыть сайт __loylabs.ru__*
>- [x] *На главной странице проверить элементы раздела "Проекты"*
>- [x] *При клике на кнопку "Все проекты"должна открыться страница с заголовком "Проекты"*

##  :cyclone: Запуск тестов из терминала

#### ✓ Локальный запуск тестов

```bash
gradle test -Denv=local  
```

#### ✓ Удаленный запуск тестов

```bash
gradle test -Denv=remote 
```
> где <code>remote</code> определяет <code>property</code> файл, в котором указаны параметры для запуска теста:

> <code>baseUrl</code> – адрес удаленного сервера, на котором будут запускаться тесты.
>
> <code>browser</code> – браузер, в котором будут выполняться тесты
>
> <code>browserVersion</code> – версия браузера, в которой будут выполняться тесты
>
> <code>browserSize</code> – размер окна браузера, в котором будут выполняться тесты

> <code>Property</code> файл расположен в директории <code>src/test/resources/config/</code>. 

##  :cyclone: Запуск тестов в  [Jenkins](https://jenkins.autotests.cloud/job/C15-FkkfRf-Test-LoyaltyLabs/) <img width="4%" title="Jenkins" src="images/logo/Jenkins-logo.svg">
*Для запуска теста с необходимыми параметрами, указываем  Property файл в настройках сборки проета *

<p align="center">
  <img src="images/screenshots/JenkinsParam.png" alt="job" width="800">
</p>

*Основная страница проекта в Jenkins*

<p align="center">
  <img src="images/screenshots/JenkinsMain.png" alt="job" width="800">
</p>

*После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки появится
значок <img width="2%" title="Allure Report" src="images/logo/AllureREport-logo.svg"><code><strong>*Allure
Report*</strong></code>, кликнув по которому, откроется страница с сформированным html-отчетом.*

##  :cyclone: Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/AUTO-638/8/allure/) <img width="4%" title="Allure Report" src="images/logo/AllureReport-logo.svg">

#### ✓ Главная страница Allure-отчета содержит следующие информационные блоки:

> <code>*ALLURE REPORT*</code> - отображает дату и время прохождения теста, общее количество прогнанных кейсов, а также диаграмму с указанием процента и количества успешных, упавших и сломавшихся в процессе выполнения тестов

> <code>*TREND*</code> - отображает тренд прохождения тестов от сборки к сборке

> <code>*SUITES*</code> - отображает распределение результатов тестов по тестовым наборам

> <code>*ENVIRONMENT*</code> - отображает тестовое окружение, на котором запускались тесты (в данном случае информация не задана)

> <code>*CATEGORIES*</code> - отображает распределение неуспешно прошедших тестов по видам дефектов

> <code>*FEATURES BY STORIES*</code> - отображает распределение тестов по функционалу, который они проверяют

> <code>*EXECUTORS*</code> - отображает исполнителя текущей сборки (ссылка на сборку в Jenkins)

<p align="center">
  <img src="images/screenshots/Allure1.png" alt="Allure Report" width="900">
</p>

#### ✓ В разделе Behaviors тесты отображаются  сгруппироваными в многоуровневый список:*
<p align="center">
  <img src="images/screenshots/Allure2.png" alt="Allure Report" width="900">
</p>

##  :cyclone:  Интеграция с [Allure TestOps](https://allure.autotests.cloud/launch/10145) <img width="4%" title="Allure TestOPS" src="images/logo/AllureTO-logo.svg">

#### ✓ Основной дашборд

<p align="center">
  <img src="images/screenshots/TestOpsMainDashboard.png" alt="dashboards" width="900">
</p>

#### ✓ Тест-кейсы

<p align="center">
  <img src="images/screens/Alure_TO3.png" alt="test cases" width="900">
</p>

##  :cyclone:  Интеграция с [Jira](https://jira.autotests.cloud/browse/AUTO-638) <img width="4%" title="Jira" src="images/logo/Jira-logo.svg">

<p align="center">
  <img src="images/screens/Jira.png" alt="jira" width="1000">
</p>

##  :cyclone: Уведомления в Telegram с использованием бота <img width="4%" title="Telegram" src="images/logo/Telegram-logo.svg">

> После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img title="Telegram Notifications" src="images/screens/Telegram.png">
</p>

##  :cyclone:  Пример запуска теста в Selenoid <img width="4%" title="Selenoid" src="images/logo/Selenoid-logo.svg">

> К каждому тесту в отчете прилагается видео.
<p align="center">
  <img title="Selenoid Video" src="images/gif/test.gif">
</p>

