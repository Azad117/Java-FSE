public class Main
{
    public static void main(String[] args) {

        Computer.Builder builder = new Computer.Builder();
        builder.setCPU("Intel Core i7");
        builder.setRAM(16);
        builder.setStorage(512);

        Computer computer = builder.build();
        computer.displayConfiguration();
        
        
    }
}