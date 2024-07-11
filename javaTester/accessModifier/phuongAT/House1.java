package accessModifier.phuongAT;

public class House1 {
    public static void main(String[] args) {
        // Khoi tao
        CfNEO neo = new CfNEO();

        System.out.println("Get: " + neo.cf);
        neo.shipCf();
        System.out.println("Get: " + neo.fruit);
        neo.shipFruit();
        System.out.println("Get: " + neo.water);
        neo.shipWater();

        /*
        private
        System.out.println("Get: " + neo.candy);
        neo.shipCandy();
        */
    }
}
