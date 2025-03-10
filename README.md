# SnakeGame

## Описание

Это классическая игра "Змейка", написанная на языке Java с использованием движка `com.javarush.engine.cell`, 
используемого в образовательной платформе JavaRush для упрощенной разработки 2D-игр.
Он предоставляет удобные методы для работы с графикой, обработкой событий и логикой игры. 
Этот движок абстрагирует сложные детали работы с Swing и AWT, позволяя писать игры с минимальными усилиями. 
Он включает классы и методы для:

- Отрисовки игровых объектов (setCellValue, setCellColor)
- Обработки нажатий клавиш (onKeyPress, onKeyReleased)
- Управления игрой (setTurnTimer, stopTurnTimer, restartGame)

Игрок управляет змейкой,
которая движется по игровому полю, собирает еду и увеличивается в размерах. Цель игры — набрать как можно больше очков,
избегая столкновения с границами экрана и собственным хвостом.

## Функциональность

- Управление змейкой с помощью клавиш направления (вверх, вниз, влево, вправо)
- Генерация случайной еды на поле
- Увеличение длины змейки после поедания еды
- Завершение игры при столкновении со стеной или самой собой
- Подсчет очков
- Перезапуск игры с помощью Space

## Установка и запуск

1. Склонируйте репозиторий или скачайте исходный код:
   ```sh
   git clone https://github.com/your-repo/snake-game.git
   cd snake-game
   ```
2. Убедитесь, что у вас установлена Java 8+.
3. Импортируйте проект в вашу среду разработки (например, IntelliJ IDEA, Eclipse).
4. Запустите основной класс игры (`SnakeGame`).

## Управление

- Стрелка вверх (↑) — движение вверх
- Стрелка вниз (↓) — движение вниз
- Стрелка влево (←) — движение влево
- Стрелка вправо (→) — движение вправо



