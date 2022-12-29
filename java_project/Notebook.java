package java_project;
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
            String operatingSystem) {

        this.brand = brand;
        this.screenSize = screenSize;
        this.hardDiskSize = hardDiskSize;
        this.cpuModel = cpuModel;
        this.ramSize = ramSize;
        this.graphicsCard = graphicsCard;
        this.operatingSystem = operatingSystem;

    }

    void getNotebook() {
        System.out.println(brand + "/" + screenSize + "\"/" + cpuModel + "/" + ramSize + "GB/" + hardDiskSize + "GB/" + graphicsCard + "MB/" + operatingSystem);

    }

} 
