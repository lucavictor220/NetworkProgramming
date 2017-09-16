import java.util.Objects;
import java.util.stream.IntStream;

/**
 * Created by vitiok on 9/15/17.
 */
public class PhoneServer implements PhoneNrProtocol {

    public String processPhoneNumber(String message) {
        String tag;
        String value;
        String providerValue;

        if (message.length() < 3) {
            return STATUS + ":" + "error\n";
        }

        tag = message.substring(0, 2);
        value = message.substring(3);
        providerValue = message.substring(3, 6);

        if (value.length() != VALID_LENGTH) {
            return STATUS + ":" + "error\n";
        }
        if (Objects.equals(providerValue, MOLDCELL)) {
            return PROVIDER + ":" + "MOLDCELL\n";
        }
        if (Objects.equals(providerValue, ORANGE)) {
            return PROVIDER + ":" + "ORANGE\n";
        }

        return "UNHANDLED MESSAGE\n";
    }
}
