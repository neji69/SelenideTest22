# language: ru

Функционал: Отображение информации в блоке финансовая свобода

Сценарий: Действия на сайте
  Дано пользователь входит на сайт "https://idemo.bspb.ru"
  Тогда открывается страница Авторизации и пользователь авторизируется используя логин и пароль
  Затем открывается страница двухфакторной авторизации где пользователь вводит смс код и кнопку подтверждения
  Тогда открывается домашняя страница где пользователь кликает по кнопке Обзор
  Затем проверяем что открылась страница Обзор
  И проверяем что на странице отобразился блок Финансовая свобода и рядом отображаеться сумма в нужном формате
  И наводим курсор на сумму и проверяем появление строки мои средства с суммой в нужном формате