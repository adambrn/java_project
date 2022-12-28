import java.util.Arrays;
import java.util.List;

/* Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям. */

public class Main {
    public class Notebook {

        String brand;
        double screenSize;
        int hardDiskSize;
        String cpuModel;
        int ramSize;
        String operatingSystem;
        String graphicsCard;

        public Notebook(String brand, 
            double screenSize,
            int hardDiskSize,
            String cpuModel,
            int ramSize,
            String graphicsCard,
            String operatingSystem
            ){
                this.brand = brand;
                this.screenSize = screenSize;
                this.hardDiskSize = hardDiskSize;
                this.cpuModel = cpuModel;
                this.ramSize = ramSize;
                this.graphicsCard = graphicsCard;
                this.operatingSystem = operatingSystem;

            }
        void getNotebook(){
            System.out.println(brand + " " + screenSize);

        }

    }

    public static void main(String[] args) {
        List<String> brandList = Arrays.asList("Acer", "Asus", "HP", "Dell","MSI","Lenovo","Samsung","Sony");
        List<String> cpuList = Arrays.asList("Acer", "Asus", "HP", "Dell","MSI","Lenovo","Samsung","Sony");
      
        
        Main obj = new Main();
        Notebook acer = obj.new Notebook("Acer", 15.6, 1024, "Intel Core i5", 16, "integrated", "Windows 11");
        Notebook asus = obj.new Notebook("Asus", 15.6, 1024, "Intel Core i5", 16, "integrated", "Windows 11");
        acer.getNotebook();
        asus.getNotebook();
    }
}
