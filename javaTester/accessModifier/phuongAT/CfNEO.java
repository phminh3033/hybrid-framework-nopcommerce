package accessModifier.phuongAT;

public class CfNEO {
    public String cf = "Da";
    protected String fruit = "Cam";
    String water = "Suoi";
    private String candy = "Matcha";

    public void shipCf() {
        System.out.println("Ship public: " + cf);
    }

    protected void shipFruit() {
        System.out.println("Ship protected: " + fruit);
    }

    void shipWater() {
        System.out.println("Ship: " + water);
    }

    private void shipCandy() {
        System.out.println("Ship private: " + candy);
    }

    public static void main(String[] args) {
        CfNEO cfneo = new CfNEO();
        cfneo.shipCf();
        cfneo.shipFruit();
        cfneo.shipWater();
        cfneo.shipCandy();
    }
}
