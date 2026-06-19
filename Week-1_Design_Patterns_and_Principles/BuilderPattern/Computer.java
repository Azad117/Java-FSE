public class Computer
{
    String CPU;
    int RAM;
    int storage;

    Computer(Builder builder)
    {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
    }

    void displayConfiguration()
    {
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM + " GB");
        System.out.println("Storage: " + storage + " GB");
    }

    static class Builder
    {
        String CPU;
        int RAM;
        int storage;

        public void setRAM(int RAM)
        {
            this.RAM = RAM;
        }
        

        public void setStorage(int storage)
        {
            this.storage = storage;
        }

        public void setCPU(String CPU)
        {
            this.CPU = CPU;
        }

        public Computer build()
        {
            return new Computer(this);
        }
    }
}
