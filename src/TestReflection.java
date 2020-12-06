import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //мы считаем из консоли название двух  классов и мы создадим объекты этих двух классов с помощию рефлексии.
        // затем мы считаем из консоли название метода и вызовим этот метод на объекте первого класса
        // и в качестве  аргумента для этого вызова метода  передадим объект второго класса.
        Scanner scanner = new Scanner(System.in);
        Class classObject1 = Class.forName(scanner.next()); //название первого класса.
        Class classObject2 = Class.forName(scanner.next()); //название второго класса
        //получение объекта класс Class и обрабатываем исключение.
        String methodName =  scanner.next(); //название метода 1 класса.
        //название_класса1 название_класса2 название_метода.
        // будет возращен объект класса метод (getMethod получит конкретный метод, которы равняет названии этого метода methodName
        //
        Method m =classObject1.getMethod(methodName, classObject2); // 1 аргумент названия метода, 2 аргумент будет объектом вызова этого метода, переадавать свой тип.
        Object o1 = classObject1.newInstance(); // будет создан новый объект с пустым конструктором(1 класса)
        Object o2 = classObject2.getConstructor(String.class).newInstance("String value"); // будет создан новый объект с конструктором(2 класса).

        m.invoke(o1, o2); //вызываешь наш метод с пустым конструктором объекта o1 и передаем параметры объекта o2 тип аргумента String value.
        System.out.println(o1); //передаем значения: Person java.lang.String setName
        //получаем наш вывод: Person{id=-1, name='String value'}

    }
}
