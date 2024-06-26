import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class УчебнаяГруппа {
    // Реализация класса УчебнаяГруппа (может содержать какие-то свойства и методы)
}

class Поток implements Iterable<УчебнаяГруппа> {
    private List<УчебнаяГруппа> группы;

    public Поток(List<УчебнаяГруппа> группы) {
        this.группы = группы;
    }

    public List<УчебнаяГруппа> getГруппы() {
        return группы;
    }

    @Override
    public Iterator<УчебнаяГруппа> iterator() {
        return группы.iterator();
    }
}

class StreamComparator implements Comparator<Поток> {
    @Override
    public int compare(Поток p1, Поток p2) {
        return Integer.compare(p1.getГруппы().size(), p2.getГруппы().size());
    }
}

class ПотокСервис {
    public void сортироватьПотоки(List<Поток> потоки) {
        Collections.sort(потоки, new StreamComparator());
    }
}

class Контроллер {
    private ПотокСервис потокСервис;

    public Контроллер() {
        this.потокСервис = new ПотокСервис();
    }

    public void сортироватьПотоки(List<Поток> потоки) {
        потокСервис.сортироватьПотоки(потоки);
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем учебные группы
        УчебнаяГруппа группа1 = new УчебнаяГруппа();
        УчебнаяГруппа группа2 = new УчебнаяГруппа();
        УчебнаяГруппа группа3 = new УчебнаяГруппа();

        // Создаем потоки с группами
        Поток поток1 = new Поток(Arrays.asList(группа1, группа2));
        Поток поток2 = new Поток(Arrays.asList(группа1));
        Поток поток3 = new Поток(Arrays.asList(группа1, группа2, группа3));

        // Список потоков
        List<Поток> потоки = new ArrayList<>();
        потоки.add(поток1);
        потоки.add(поток2);
        потоки.add(поток3);

        // Создаем контроллер и сортируем потоки
        Контроллер контроллер = new Контроллер();
        контроллер.сортироватьПотоки(потоки);

        // Выводим результат
        for (Поток поток : потоки) {
            System.out.println("Поток с " + поток.getГруппы().size() + " группами");
        }
    }
}
