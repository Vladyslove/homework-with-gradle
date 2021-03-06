Домашнее задание:

#### Часть 1

> В этой части ДЗ оcновной упор нужно сделать на написании unit-tests.

Напишите простой String calculator с методом `add`

```java
public class SimpleStringCalculator {
      public int add(String expression) {
              // your code here
                  return 0;
                    }
}
```
Условия следующие:
* Метод `add` вычисляет сумму чисел в переданной строке `expression`
* Строка `expression` может быть пустой. В таком случае метод `add` возвращает `0`
* Количество чисел в `expression` может быть любое, т.е. >= 0
* Разделителем чисел, в простейшем случае, может быть `+` или `,`. Например `1+2+3` или `1,2,3`
* Все виды разделителей чисел могут присутствовать одновременно. Например `1+2,3`
* Добавьте возможность использовать произвольный символ, в качестве разделителя. Если в начале строки присутствует любой символ, не являющийся цифрой, он считается разделителем. Например `#1#2,3+4` вычисляется как `1+2+3+4`
* Вызов метода с отрицательным числом или числами, возвращает `-1`
* В случае, если любое число в `expression`, больше 1000, оно игнорируется. Например для `1,2000,10`, результатом вычисления будет `11`

**На каждое из условий нужно написать как минимум один юнит-тест.**

Полезные ссылки:

[JUnit Cookbook](http://junit.org/junit4/cookbook.html)

[Hamcrest Tutorial](https://code.google.com/archive/p/hamcrest/wikis/Tutorial.wiki)


#### Часть 2

В этой части ДЗ нужно будет расчитать заработную плату за отработанный период для различных типов сотрудников. В директории `lesson_12/misc/src` вы найдете следущие классы:
```java
firm.Employee // abstract class
firm.Payable // interface
firm.PaymentPeriod // enum
```
Где `Employee` - абстрактный класс, который содержит в себе общий функционал для всех видов сотрудников, в данном случае `name`.
`Payable` - интерфейс, описывающий основной функционал необходимый для реализации подсчета оплаты труда - возможность установить кол-во отработанных часов и собственно метод, расчитывающий ЗП. Также в нем вы можете найти константу, описывающую кол-во рабочих часов в один рабочий день.
`PaymentPeriod` - enum, описывающий рабочие периоды, необходимые для корректного расчета ЗП работников с фиксированным доходом.

Создайте следующие классы:
```java
// employees
firm.stuff.FixedRateEmployee
firm.stuff.HourlyRateEmployee
firm.stuff.Manager
firm.stuff.Volunteer
```

`FixedRateEmployee` - самый сложный, как с точки зрения реализации, так и для понимания, вид работника.
Должен иметь конструктор, принимающий имя, дневной заработок и период, который учитывается при расчете ЗП.

Например:
```
FixedRateEmployee("Jane Roe", 10.00f, PaymentPeriod.WEEKLY)
```
В случае, если Джейн отработала 5 рабочих дней, по 8 часов (значение отработанных часов задается через метод `setWorkingHours`), она получит ЗП в 10 у.е. * на кол-во отработанных дней, то есть 50 у.е.

В случае, если Джейн отработала 6 рабочих дней, по 8 часов, она все равно получит 50 у.е. так как учитывается только указанный период. Все, что отработанно сверху, при этом меньше чем целый период, не учитывается. За две недели, Джейн получит 100 у.е., за две с половиной, 100 у.е., за три недели 150 у.е., итп.

`Manager` тоже является FixedRateEmployee. Все правила, применимые к FixedRateEmployee также применяются к Manager, включая PaymentPeriod. Особенностью класса Manager является возможность получить бонус. Вызов метода `setBonus` повлияет на конечную сумму ЗП.

`HourlyRateEmployee` достаточно прост - оплата производится по факту отработанных часов. Должен иметь конструктор, принимающий имя и почасовую ставку.

Например:
```
HourlyRateEmployee("Jane Roe", 1.00f)
```
В случае, если Джейн отработала 4 рабочих дня по 8 часов, она получит ЗП в 4 * 8 * 1.00, то есть 32 у.е.

Для `Volunteer` используется самый простой алгоритм расчета ЗП. Вне зависимости от кол-ва отработанных часов, ЗП будет равняться нулю так как волонтер не получает денег за свою работу.

> Для лучшего понимания ожидаемого алгоритма работы, разберитесь в тест-кейсах из `AcceptanceTest/src/AcceptanceTest.java`
