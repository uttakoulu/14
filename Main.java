import java.util.Scanner;

class Computer {
    private String processor;
    private int ram;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;
    private String accessories;
    private String componentGrade;

    public Computer(String processor, int ram, String hardDrive, String graphicsCard, String operatingSystem, String accessories, String componentGrade) {
        this.processor = processor;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.graphicsCard = graphicsCard;
        this.operatingSystem = operatingSystem;
        this.accessories = accessories;
        this.componentGrade = componentGrade;
    }

    public void displayConfiguration() {
        System.out.println("Processor: " + processor);
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Hard Drive: " + hardDrive);
        System.out.println("Graphics Card: " + graphicsCard);
        System.out.println("Operating System: " + operatingSystem);
        System.out.println("Accessories: " + accessories);
        System.out.println("Component Grade: " + componentGrade);
        System.out.println("-----------------------------");
    }
}

interface ComputerBuilder {
    void buildProcessor();
    void buildRAM();
    void buildHardDrive();
    void buildGraphicsCard();
    void buildOperatingSystem();
    void buildAccessories();
    void buildComponentGrade();
    Computer getComputer();
}

class GamingComputerBuilder implements ComputerBuilder {
    private String processor;
    private int ram;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;
    private String accessories;
    private String componentGrade;

    public void buildProcessor() {
        processor = "Intel Core i9";
    }

    public void buildRAM() {
        ram = 32;
    }

    public void buildHardDrive() {
        hardDrive = "2 TB SSD";
    }

    public void buildGraphicsCard() {
        graphicsCard = "NVIDIA GeForce RTX 4080";
    }

    public void buildOperatingSystem() {
        operatingSystem = "Windows 11 Pro";
    }

    public void buildAccessories() {
        accessories = "Gaming Keyboard, Gaming Mouse, Headset";
    }

    public void buildComponentGrade() {
        componentGrade = "Premium";
    }

    public Computer getComputer() {
        return new Computer(processor, ram, hardDrive, graphicsCard, operatingSystem, accessories, componentGrade);
    }
}

class OfficeComputerBuilder implements ComputerBuilder {
    private String processor;
    private int ram;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;
    private String accessories;
    private String componentGrade;

    public void buildProcessor() {
        processor = "Intel Core i5";
    }

    public void buildRAM() {
        ram = 16;
    }

    public void buildHardDrive() {
        hardDrive = "512 GB SSD";
    }

    public void buildGraphicsCard() {
        graphicsCard = "Intel Integrated Graphics";
    }

    public void buildOperatingSystem() {
        operatingSystem = "Windows 11 Home";
    }

    public void buildAccessories() {
        accessories = "Wireless Keyboard, Wireless Mouse";
    }

    public void buildComponentGrade() {
        componentGrade = "Standard";
    }

    public Computer getComputer() {
        return new Computer(processor, ram, hardDrive, graphicsCard, operatingSystem, accessories, componentGrade);
    }
}

class ComputerDirector {
    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer constructComputer() {
        builder.buildProcessor();
        builder.buildRAM();
        builder.buildHardDrive();
        builder.buildGraphicsCard();
        builder.buildOperatingSystem();
        builder.buildAccessories();
        builder.buildComponentGrade();
        return builder.getComputer();
    }
}

public class Main {
    public static void main(String[] args) {
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector gamingDirector = new ComputerDirector(gamingBuilder);

        Computer gamingComputer = gamingDirector.constructComputer();

        System.out.println("GAMING COMPUTER CONFIGURATION");
        gamingComputer.displayConfiguration();

        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector officeDirector = new ComputerDirector(officeBuilder);

        Computer officeComputer = officeDirector.constructComputer();

        System.out.println("OFFICE COMPUTER CONFIGURATION");
        officeComputer.displayConfiguration();

        Scanner scanner = new Scanner(System.in);

        System.out.println("CUSTOM COMPUTER CONFIGURATION");

        System.out.print("Enter processor: ");
        String processor = scanner.nextLine();

        System.out.print("Enter RAM size (GB): ");
        int ram = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter hard drive: ");
        String hardDrive = scanner.nextLine();

        System.out.print("Enter graphics card: ");
        String graphicsCard = scanner.nextLine();

        System.out.print("Enter operating system: ");
        String operatingSystem = scanner.nextLine();

        System.out.print("Enter accessories: ");
        String accessories = scanner.nextLine();

        System.out.print("Enter component grade: ");
        String componentGrade = scanner.nextLine();

        Computer customComputer = new Computer(
            processor,
            ram,
            hardDrive,
            graphicsCard,
            operatingSystem,
            accessories,
            componentGrade
        );

        System.out.println("CUSTOM COMPUTER CONFIGURATION");
        customComputer.displayConfiguration();

        scanner.close();
    }
}
