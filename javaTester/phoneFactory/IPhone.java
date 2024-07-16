package phoneFactory;

public class IPhone extends PhoneFactory {

    @Override
    protected void setPhoneName(String phoneName) {
        // super: goi den bien cua ham CHA
        super.phoneName = phoneName;
    }

    @Override
    protected String getPhoneName() {
        return super.phoneName;
    }

    public void testIPhone() {
        touchPhone();
    }
}
