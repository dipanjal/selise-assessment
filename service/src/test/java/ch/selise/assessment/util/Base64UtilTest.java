package ch.selise.assessment.util;

import ch.selise.assessment.utils.Base64Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author dipanjal
 * @since 0.0.1
 */
@SpringBootTest
public class Base64UtilTest {

    @Test
    public void testBase64Decode() {
        String expected = "TRANSFER";
        String encoded = "VFJBTlNGRVI=";
        String decoded = Base64Utils.decodeToString(encoded);
        Assertions.assertEquals(expected, decoded);
    }
}
