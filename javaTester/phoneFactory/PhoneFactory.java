package phoneFactory;

public abstract class PhoneFactory {
    protected String phoneName;

    /*
    Cac class khac ONLY ke thua cac ham abstract
    Ham abstract: KHONG co phan than

    INTERFACE:
    + thi tat ca cac ham la abstract
    + Bien la const
    */
    protected abstract void setPhoneName(String phoneName);

    protected abstract String getPhoneName();

    protected void touchPhone() {
        System.out.println("Touch!!!");
    }
}
