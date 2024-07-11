package accessModifier.phuongTA;

import accessModifier.phuongAT.CfNEO;

public class CfMEO extends CfNEO {
    public static void main(String[] args) {

    }

    public void createCf () {
        System.out.println("Get: " + cf);
        shipCf();
        System.out.println("Get: " + fruit);
        shipFruit();

        /*
        default
        System.out.println("Get: " + water);
        shipWater();

        private
        System.out.println("Get: " + candy);
        shipCandy();
        */
    }
}
