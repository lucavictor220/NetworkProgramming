/**
 * Created by vitiok on 9/15/17.
 */
public interface PhoneNrProtocol {
    int VALID_LENGTH = 9;
    String PHONE_NUMBER = "ph";
    String STATUS = "st";
    String PROVIDER = "pr";

    String MOLDCELL = "078";
    String ORANGE = "069";

    String processPhoneNumber(String phone);
}
