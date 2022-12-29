package java_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

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

    public static void main(String[] args) {
        List<Notebook> notebooks = createNotebookList();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие: ");
            System.out.println("1 - Вывести все");
            System.out.println("2 - Фильтры");
            System.out.println("3 - Выход");

            System.out.print("Введите число: ");
            int num = in.nextInt();
            if (num == 3)
                break;
            else if (num == 1) {
                System.out.print("\033[H\033[J");
                for (Notebook notebook : notebooks) {
                    notebook.getNotebook();
                }
                System.out.println();
            } else if (num == 2) {
                System.out.print("\033[H\033[J");
                filteringNotebooksList(notebooks);
                System.out.println();
            }

        }
        in.close();
        System.out.print("\033[H\033[J");

    }

    public static Map<String, String> filteringNotebooksList(List<Notebook> notebooks) {
        Map<String, String> filters = new HashMap<>();
        filters.put("brand", "");
        filters.put("screenSize", "");
        filters.put("hardDiskSize", "");
        filters.put("cpuModel", "");
        filters.put("ramSize", "");
        filters.put("graphicsCard", "");
        filters.put("operatingSystem", "");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Выбраные фильтры: ");
            if (filters.get("brand") != "")
                System.out.print("Бренд: " + filters.get("brand") + " ");
            if (filters.get("screenSize") != "")
                System.out.print("Размер экрана(Больше): " + filters.get("screenSize") + " ");
            if (filters.get("hardDiskSize") != "")
                System.out.print("Размер HDD(Больше): " + filters.get("hardDiskSize") + " ");
            if (filters.get("cpuModel") != "")
                System.out.print("Процессор: " + filters.get("cpuModel") + " ");
            if (filters.get("ramSize") != "")
                System.out.print("Размер RAM(Больше): " + filters.get("ramSize") + " ");
            if (filters.get("graphicsCard") != "")
                System.out.print("Видеокарта: " + filters.get("graphicsCard") + " ");
            if (filters.get("operatingSystem") != "")
                System.out.print("ОС: " + filters.get("operatingSystem") + " ");

            System.out.println();
            System.out.println("Выберите фильтр: ");
            System.out.println("1 - Производитель");
            System.out.println("2 - Размер экрана");
            System.out.println("3 - Обьем жесткого диска");
            System.out.println("4 - Модель процессора");
            System.out.println("5 - Объем оперативной памяти");
            System.out.println("6 - Модель видеокарты");
            System.out.println("7 - Операционная система");
            System.out.println();
            System.out.println("Применить фильтры - 0");
            System.out.println();
            System.out.print("Введите число: ");
            int num = sc.nextInt();
            if (num == 0) {
                System.out.print("\033[H\033[J");
                List<Notebook> searchresult = findNotebooks(notebooks, filters);
                if (searchresult.size() != 0) {
                    for (Notebook notebook : searchresult) {
                        notebook.getNotebook();
                    }
                } else {
                    System.out.println("По введенным критериям нет результатов");
                }
                System.out.println("Нажмите Enter для продолжения...");
                try {
                    System.in.read();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return filters;
            } else if (num == 1) {
                System.out.print("\033[H\033[J");
                System.out.print("Введите название производителя: ");
                filters.put("brand", sc.next());
            } else if (num == 2) {

                System.out.print("\033[H\033[J");
                System.out.print("Введите минимальный размер экрана: ");
                filters.put("screenSize", sc.next());
            } else if (num == 3) {

                System.out.print("\033[H\033[J");
                System.out.print("Введите минимальный размер HDD: ");
                filters.put("hardDiskSize", sc.next());
            } else if (num == 4) {

                System.out.print("\033[H\033[J");
                System.out.print("Введите часть названия процессора: ");
                filters.put("cpuModel", sc.next());
            } else if (num == 5) {

                System.out.print("\033[H\033[J");
                System.out.print("Введите минимальный размер RAM: ");
                filters.put("ramSize", sc.next());
            } else if (num == 6) {

                System.out.print("\033[H\033[J");
                System.out.print("Введите название видеокарты: ");
                filters.put("graphicsCard", sc.next());
            } else if (num == 7) {

                System.out.print("\033[H\033[J");
                System.out.print("Введите операционную систему: ");
                filters.put("operatingSystem", sc.next());
            }
        }
    }

    public static List<Notebook> findNotebooks(List<Notebook> notebooks, Map<String, String> search) {
        List<Notebook> result = new ArrayList<>();
        for (Notebook notebook : notebooks) {
            if (search.get("screenSize") == "") search.put("screenSize", "0");
            if (search.get("hardDiskSize") == "") search.put("hardDiskSize", "0");
            if (search.get("ramSize") == "") search.put("ramSize", "0");
            if (notebook.brand.toLowerCase().contains(search.get("brand").toLowerCase()) &&
                    notebook.screenSize >= Double.parseDouble(search.get("screenSize")) &&
                    notebook.hardDiskSize >= Integer.parseInt(search.get("hardDiskSize")) &&
                    notebook.cpuModel.toLowerCase().contains(search.get("cpuModel").toLowerCase()) &&
                    notebook.ramSize >= Integer.parseInt(search.get("ramSize")) &&
                    notebook.graphicsCard.toLowerCase().contains(search.get("graphicsCard").toLowerCase()) &&
                    notebook.operatingSystem.toLowerCase().contains(search.get("operatingSystem").toLowerCase())) {
                result.add(notebook);
            }
        }
        return result;
    }

    public static List<Notebook> createNotebookList() {
        List<String> brandList = Arrays.asList("Acer", "Asus", "HP", "Dell", "MSI", "Lenovo", "Samsung", "Sony");
        List<String> cpuList = Arrays.asList("Intel Core i9-12900H", "Intel Core i7-12700H", "Intel Core i5-12500H",
                "AMD Ryzen 7 6800H", "AMD Ryzen 7 6800HS", "Intel Core i7-10700K", "Intel Core i7-1280P",
                "AMD Ryzen 9 5900HS", "AMD Ryzen 9 6900HX", "Intel Core i5-12600H", "AMD Ryzen 7 PRO 6850H",
                "AMD Ryzen 9 5900HX", "Intel Core i9-9900K", "AMD Ryzen 7 5800H", "Intel Core i7-10700",
                "Intel Core i7-11800H", "Intel Core i9-11900H", "Intel Core i7-11850H", "AMD Ryzen 7 5800HS",
                "Intel Core i9-11950H", "Intel Core i9-11980HK", "AMD Ryzen 7 6800U", "Intel Core i7-12650H",
                "AMD Ryzen 9 5980HX", "AMD Ryzen 7 PRO 6850U", "AMD Ryzen 7 4800H", "AMD Ryzen 9 4900H",
                "AMD Ryzen 9 4900HS", "Intel Xeon W-11955M", "Intel Core i7-12800H", "Intel Core i9-9980HK",
                "Intel Core i7-11600H", "Intel Xeon W-10885M", "AMD Ryzen 7 5825U", "AMD Ryzen 5 6600H",
                "Intel Core i7-1260P", "AMD Ryzen 5 6600HS", "AMD Ryzen 7 5800U", "AMD Ryzen 7 4800HS",
                "AMD Ryzen 5 6600U", "Intel Core i5-11260H", "Intel Core i7-10875H", "Intel Core i9-10980HK",
                "AMD Ryzen 5 5600H", "Intel Core i7-8700", "AMD Ryzen 7 5850U", "Intel Core i7-1270P",
                "Intel Core i7-9700K", "Intel Core i7-10870H", "Intel Core i5-11500H", "Intel Core i5-1240P",
                "AMD Ryzen 7 2700", "AMD Ryzen 7 5700U", "Intel Core i9-10885H", "Intel Core i9-9880H",
                "Intel Core i5-10500H", "Intel Core i7-1265U", "Intel Core i5-11400H", "AMD Ryzen 5 4600H",
                "AMD Ryzen 7 4800U", "Apple M1 Max", "AMD Ryzen 7 1700 (Laptop)", "Intel Core i5-1245U",
                "AMD Ryzen 5 5625U", "AMD Ryzen 7 PRO 4750U", "AMD Ryzen 5 5600U", "Intel Core i7-1250U",
                "Intel Core i9-8950HK", "Intel Core i7-1255U", "Intel Core i5-1235U", "Intel Core i7-10750H",
                "AMD Ryzen 5 5500U", "Intel Core i7-8850H", "Apple M1 Pro (10-core)", "Intel Xeon E-2276M",
                "AMD Ryzen 7 4700U", "Intel Core i7-9750HF", "AMD Ryzen 5 PRO 4650U", "Intel Core i7-11370H",
                "Intel Core i7-9750H", "Intel Core i7-11375H", "AMD Ryzen 5 4600U", "Apple M1 Pro (8-core)",
                "Intel Core i5-11300H", "Apple M2 (10-core GPU)", "Intel Core i7-8750H", "Intel Core i7-9850H",
                "Intel Core i5-1250P", "Apple M2 (8-core GPU)", "Intel Core i5-11320H", "Intel Core i5-8500B",
                "AMD Ryzen 3 5425U", "AMD Ryzen 5 4500U", "Intel Core i7-11390H", "Intel Core i7-1195G7",
                "Intel Core i7-10810U", "Intel Core i7-10710U", "Intel Core i7-1185G7", "Intel Core i5-9300HF",
                "Apple M1", "AMD Ryzen 3 5300U", "Intel Core i7-1165G7", "Intel Core i7-8809G", "Intel Core i5-1038NG7",
                "Intel Core i5-1135G7", "Intel Core i5-10300H", "Intel Core i5-1145G7", "Intel Core i5-10400H",
                "Intel Core i5-9300H", "Intel Core i7-7820HK", "Intel Core i7-8569U", "Intel Core i7-7700HQ",
                "Intel Core i7-8557U", "Intel Core i7-1068NG7", "Intel Core i7-1068G7", "Intel Core i7-8705G",
                "AMD Ryzen 5 3550H", "AMD Ryzen 7 3750H", "Intel Core i5-8279U", "Intel Core i7-1160G7",
                "Intel Core i7-8559U", "Intel Core i5-8300H", "Intel Core i5-8259U", "AMD Ryzen 3 4300U",
                "Intel Core i7-1060NG7", "AMD Ryzen 7 3780U", "Intel Core i5-8350U", "Intel Core i3-1215U",
                "AMD Ryzen 7 3700U", "Intel Core i7-1065G7", "AMD Ryzen 5 3580U", "Intel Core i7-1180G7",
                "Intel Core i7-1060G7", "Intel Core i7-10610U", "AMD Ryzen 7 PRO 3700U", "Intel Core i5-8257U",
                "AMD Ryzen 5 PRO 3500U", "Intel Core i5-1035G7", "Intel Core i7-10510U", "Intel Core i5-8365U",
                "Intel Core i5-10310U", "AMD Ryzen 5 3500U", "Intel Core i5-10210U", "Intel Core i7-8665U",
                "Snapdragon 8cx Gen 3", "Intel Core i7-8565U", "Intel Core i5-8265U", "AMD Ryzen 5 3450U",
                "AMD Ryzen 5 PRO 2500U", "Intel Core i5-1035G1", "Intel Core i5-1035G4", "Intel Core i7-8650U",
                "Intel Core i3-1115G4", "Intel Core i7-8550U", "Intel Core i5-8250U", "AMD Ryzen 3 2300U",
                "AMD Ryzen 3 PRO 2300U", "AMD Ryzen 7 PRO 2700U", "AMD Ryzen 3 3300U", "Intel Core i7-6567U",
                "Intel Core i5-1030NG7", "Intel Core i3-10110U", "Intel Core i3-1005G1", "Intel Core i5-7300U",
                "Intel Core i3-8145U", "Intel Core i7-7560U", "Intel Core i7-7500U", "AMD Ryzen 3 3250U",
                "Intel Core i5-6200U", "AMD Ryzen 3 3200U", "Intel Core i7-7600U", "Intel Pentium Silver N6000",
                "Intel Core i5-7200U", "Intel Core i5-8200Y", "Intel Core i5-8310Y", "AMD Athlon 300U",
                "Intel Core i5-8210Y", "Intel Core i3-1000NG4", "Intel Core i5-L16G7", "Intel Celeron N4100",
                "AMD Ryzen 3 2200U", "AMD Athlon Gold 3150U", "Intel Pentium Silver N5030", "Intel Pentium Gold 5405U",
                "Intel Core i7-8500Y", "Intel Core i7-7Y75", "Intel Pentium Silver N5000", "Intel Pentium 4417U",
                "Intel Celeron N5100", "Intel Core i3-7100U", "Intel Core m3-8100Y", "Intel Celeron N4500", "AMD 3020e",
                "Intel Pentium N4200", "Intel Celeron N4120", "AMD Ryzen 5 2500U", "Intel Celeron N3450",
                "AMD A10 PRO-7350B", "Intel Celeron N4020", "AMD A9-9425", "AMD A6-9225", "Intel Pentium N3710",
                "Intel Atom x7-Z8750", "Intel Celeron N3350", "Intel Atom x5-Z8350", "Intel Celeron 3867U",
                "AMD A6-9220e", "AMD A4-9120e", "");
        List<Double> screenSizeList = Arrays.asList(11.0, 11.6, 12.0, 13.0, 13.3, 14.0, 15.0, 15.4, 15.0, 16.0, 16.1,
                17.0, 17.3);
        List<Integer> hardSizeList = Arrays.asList(120, 240, 500, 1000, 1500, 2000, 3000);
        List<Integer> ramSizeList = Arrays.asList(2, 4, 6, 8, 12, 16, 32, 64, 128);
        List<String> graficsCardList = Arrays.asList("AMD Radeon 660M", "AMD Radeon 680M", "AMD Radeon R3",
                "AMD Radeon RX 5300M", "AMD Radeon RX 640", "AMD Radeon RX 6600M", "AMD Radeon RX 6700M",
                "AMD Radeon RX 6700S", "AMD Radeon RX 6850M XT", "AMD Radeon RX Vega 10", "AMD Radeon RX Vega 3",
                "AMD Radeon RX Vega 6", "AMD Radeon RX Vega 7", "AMD Radeon RX Vega 8", "Intel Arc A550M",
                "Intel Arc A730M", "Intel Iris Plus Graphics G7", "Intel Iris Xe Graphics G4",
                "Intel Iris Xe Graphics G7", "Intel Iris Xe Max", "Intel UHD Graphics", "Intel UHD Graphics 600",
                "Intel UHD Graphics 605", "Intel UHD Graphics 630", "Intel UHD Graphics G1", "NVIDIA GeForce GTX 1650",
                "NVIDIA GeForce GTX 1650 Max-Q", "NVIDIA GeForce GTX 1650 Ti", "NVIDIA GeForce GTX 1650 Ti Max-Q",
                "NVIDIA GeForce GTX 1660 Ti", "NVIDIA GeForce GTX 1660 Ti Max-Q", "NVIDIA GeForce MX130",
                "NVIDIA GeForce MX250", "NVIDIA GeForce MX330", "NVIDIA GeForce MX350", "NVIDIA GeForce MX350",
                "NVIDIA GeForce MX450", "NVIDIA GeForce MX450", "NVIDIA GeForce MX550", "NVIDIA GeForce MX550",
                "NVIDIA GeForce MX570", "NVIDIA GeForce RTX 2050", "NVIDIA GeForce RTX 2060",
                "NVIDIA GeForce RTX 2070 Max-Q", "NVIDIA GeForce RTX 2070 SUPER Max-Q", "NVIDIA GeForce RTX 2080 SUPER",
                "NVIDIA GeForce RTX 2080 SUPER Max-Q", "NVIDIA GeForce RTX 3050", "NVIDIA GeForce RTX 3050 Ti",
                "NVIDIA GeForce RTX 3060", "NVIDIA GeForce RTX 3070", "NVIDIA GeForce RTX 3070 Ti",
                "NVIDIA GeForce RTX 3080", "NVIDIA GeForce RTX 3080 Ti", "NVIDIA Quadro P520", "NVIDIA Quadro P620",
                "NVIDIA Quadro T1000 Max-Q", "NVIDIA Quadro T2000", "NVIDIA Quadro T2000 Max-Q", "NVIDIA Quadro T500",
                "NVIDIA Quadro T550", "NVIDIA RTX A1000", "NVIDIA RTX A2000", "NVIDIA RTX A3000", "NVIDIA T1200",
                "NVIDIA T600");
        List<String> osList = Arrays.asList("Windows 10", "Windows 11", "Windows 7", "no OS", "Linux", "Dos", "FreeBSD",
                "Astra Linux");

        Random rand = new Random();

        List<Notebook> result = new ArrayList<>();

        int numberOfElements = 20;

        for (int i = 0; i < numberOfElements; i++) {
            Notebook note = new Notebook(
                    brandList.get(rand.nextInt(brandList.size())),
                    screenSizeList.get(rand.nextInt(screenSizeList.size())),
                    hardSizeList.get(rand.nextInt(hardSizeList.size())),
                    cpuList.get(rand.nextInt(cpuList.size())),
                    ramSizeList.get(rand.nextInt(ramSizeList.size())),
                    graficsCardList.get(rand.nextInt(graficsCardList.size())),
                    osList.get(rand.nextInt(osList.size())));
            result.add(note);
        }
        return result;
    }

}
