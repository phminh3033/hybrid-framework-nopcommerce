package pojoData.orangeHRM;

public class EmployeeInfo {
    private String employeeID;
    private String firstName;
    private String lastName;
    private String driverLicense;
    private String licenseExp;
    private String nationality;
    private String maritalStatus;
    private String dob;
    private String gender;

    /**
     * Su dung cac ham getter - setter
     * Tuan theo nguyen tac dong goi Encapsulation cua OOP
     */

    public static EmployeeInfo getEmployeeInfo() {
        return new EmployeeInfo();
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getLicenseExp() {
        return licenseExp;
    }

    public void setLicenseExp(String licenseExp) {
        this.licenseExp = licenseExp;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
