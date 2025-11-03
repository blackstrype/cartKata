package cart.model;

public class Client {
    private ClientType clientType;
    private String companyName;
    private String SIREN;
    private String TVANumber;
    private int turnover;

    private String firstName;
    private String lastName;

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSIREN() {
        return SIREN;
    }

    public void setSIREN(String SIREN) {
        this.SIREN = SIREN;
    }

    public String getTVANumber() {
        return TVANumber;
    }

    public void setTVANumber(String TVANumber) {
        this.TVANumber = TVANumber;
    }

    public int getTurnover() {
        return turnover;
    }

    public void setTurnover(int turnover) {
        this.turnover = turnover;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
