package by.mozolevskij.pharmacy.example.learning.docker;

public class ABasicComponents1 {

    /*
    * 1. Docker - сервис для запуска приложений в контейнерах.
    * для запуска в продакшене используют с надстрокой Kubernates,
    * для упровления разными контейнерами Docker на разных серверах
    *
    * Причины импользования:
    * Контенер в котором запускается приложение изолирован от конмпьютера и других
    * контейнеров, каждый контейнер изолированная среда,
    *
    * Легко запускать приложение на разных серверах, приложение на разных
    * серверах работает одинаково
    *
    * Зависимости устанавливаются внутри контейнеров, не нужно устанавливать
    *  зависимость на самом сервере, компьютере. Созданеи дополнительного компонента
    * по типу базы данных легко воздать внутри контейнера
    *
    * Легко масштабировать, одно приложение можно запустить в разных контейнерах
    *
    * 2.В одном КОНТЕЙНЕРЕ не должно быть более 2 приложений, самый маленький
    * элемент (компонент) в мире Docker
    *
    * 3.Другие компоненты Docker:
    *  * КОНТЕЙНЕР
    *  * КЛИЕНТ (CLIENT)
    *  * СЛУЖБА (DEAMON/SERVICE)
    *  * HOST
    *  * ОБРАЗ (IMAGE)
    *
    * КЛИЕНТ запускается в cmd с его помощью можно подключаться к СЛУЖБЕ Docker,
    * эта СЛУЖБА может находится как на компьютере так и удаленно, (чаще всего
    * подключение идет к той же СЛУЖБЕ где находится КЛИЕНТ)
    * СЛУЖБА отвечает за создание контейнеров, обработку запросов от КЛИЕНТА,
    * это Docker сервер
    * HOST - компьютер на котором запущен Docker
    * По итогу КЛИЕНТ взаимодействует с СЛУЖБОЙ, а служба запущена на HOST
    * IMAGE - используется как основа для создания контейнеров, из одного
    * IMAGE можно создать много разных контейнеров, независимых друг
    * от друга
    *
    *  * REPOSITORY
    *  * REISTRY (РЕЕСТР)
    *
    * в РЕПОЗИТОРИИ находятся различные версии одного образа,
    * в РЕЕСТРЕ находятся различные репозитории, можнет быть
    * локальный и удаленный (Docker.hub) - удаленный реестр
    *
    * КОНТЕЙНЕРЫ создаются на компютере Linux,
    * Компоненты Linux и минимальный надор для создания контейнеров:
    * * Core - Linux Kernel
    * * RAM - оперативная память
    * * CPU - процессор
    * * Network - сетевые ресурсы (сетевой адаптер)
    * * Disk - хранит данные (жесткий диск)
    * * DOCKER ENGINE - необходим для создания контейнеров, он и запускает
    * СЛУЖБУ
    *
    * Принцип создания контейнеров:
    * Создаем Container1, для этого контейнера на Disk создадутся файлы
    * которые будут доступны ТОЛЬКО этому контейнеру ConFiles1, далее
    * у Conteiner1 запустится ПРОЦЕСС (Process), CORE - общий, поэтому
    * процессы исользуют общее ядро, это же CORE используется DOCKER ENGINE,
    * можно запустить еще кнотейнеры, изолированные друг от друга,
    * ресурсы контейнеров - обшие, файлы и процессы - изолированные
    *
    * Общие файлы с одинаковых образов будут находится в одном месте
    * и не будут копироваться (ресурсы используются эффективнее)
    * При остановке и удалении контейнера удаляются и общие файлы.
    * Если у кнотейнера нет активных процессов (задача выполнена и завершена)
    * Docker их останавливает.
    *
    * Запуск Docker под управлением Mac or Windows - создается виртуальная машина.
    * Для ее создания устанавлисается Docker Desktop (виртуальная машина Linux),
    * внутри созданной программой машины Linux запустится Docker СЛУЖБА.
    * В продакшене Docker Engine (CORE) устанавливается непосредственно на Linux
    *
    * 4. IMAGE - набор файлов, статичен, из одного сожно создать много разных
    * контейнеров, можно скачать официальный обрас Java с Docker.hub, этот образ
    * будет находится локально в КЕШЕ Docker, можно создать разные контенеры
    * Java и запускать там разные приложения
    * Container отличается от IMAGE тем, что он работает, в нем есть запущенные процессы
    * В образе находиться информация о процессе который запуститься в контейнере
    * находиться в образе в виде текстовой информации
    *
    * IMAGE (ОБРАЗ) состоит из слоев: БАЗОВЫЙ слой и слои которые добавляются к
    * базовому слою, сдлй представляет из себя файл, FSLayers (File System Layer)
    * Многослойные образы нужны для переиспользования слоев в разных образах, не надо
    * сохранять пересекающиеся слои много раз
    * Слои являеются READ-ONLY после их создания их нельзя именять, можно
    * перемещать и удалять т.к. это файлы
    *
    * 7.РЕПОЗИТОРИЙ - версии одного образа, у версии могут быть несколько тегов,
    * теги могут быть 7.2, 7.3 или у другой версии 8.1, 8.12,
    * тег latest указывает на последнюю версию образа, РЕПОЗИТОРИЙ может быть
    * локальным или загруженным на dockerhub
    *
    * 8. Docker Desktop Settings Resources - упроавление ресурсами,
    * Все контейнеры распределяют эти ресурсы между собой
    * */

}