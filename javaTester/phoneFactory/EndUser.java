package phoneFactory;

public class EndUser {
    public static void main(String[] args) {
        PhoneFactory phone;
        phone = getPhone("iphone");
        phone.setPhoneName("ip 14");
        System.out.println(phone.getPhoneName());
    }

    public static PhoneFactory getPhone (String phoneType){
        PhoneFactory phoneFactory;
        if (phoneType.equals("iphone")){
            phoneFactory = new IPhone();
        } else {
            phoneFactory = new Samsung();
        }
        return phoneFactory;
    }
}
