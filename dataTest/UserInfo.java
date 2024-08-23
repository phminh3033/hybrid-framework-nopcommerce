package jsonData.nopcommerce;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class UserInfoJsonData {
    public static UserInfoJsonData getUserInfo(String fileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // cover truong hop neu ben file json co bien > bien ben mapping file thi se KHONG loi
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.RESOURCE_PATH + fileName), UserInfoJsonData.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("payment")
    Payment payment;

    static class Payment {
        @JsonProperty("visa")
        String visaNum;

        @JsonProperty("ccv")
        String ccvNum;
    }

    public String getVisaNum() {
        return payment.visaNum;
    }

    public String getCcvNum() {
        return payment.ccvNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }


}
