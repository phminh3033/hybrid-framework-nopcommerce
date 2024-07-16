package phoneFactory;

public interface PhoneFatoryInterface {
    /*
    *  Acccess modifier la public
    *  Du co khai bao keyword abstract hay khong thi trong interface
    *   + method: deu la abstract method het,
    *   + Bien: la hang so het
    * */

    String PHONE_NAME = "";
    abstract void setPhoneName(String phoneName);

    abstract String getPhoneName();

    public void touchPhone();
}
