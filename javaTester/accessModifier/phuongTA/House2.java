package accessModifier.phuongTA;

import accessModifier.phuongAT.CfNEO;

public class House2 {
    public static void main(String[] args) {
        CfNEO neo = new CfNEO();

        System.out.println("Get: " + neo.cf);
        neo.shipCf();

        /*
        protected
        System.out.println("Get: " + neo.fruit);
        neo.shipFruit();

        default
        System.out.println("Get: " + neo.water);
        neo.shipWater();

        private
        System.out.println("Get: " + neo.candy);
        neo.shipCandy();
        */
    }
}
