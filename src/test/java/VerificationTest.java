import org.junit.Test;
import servlet.valid.Verification;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class VerificationTest {

    @Test
    public void isNumber(){

        boolean a = Verification.isNumber("233",4);
        assertEquals(a,true);
        boolean b = Verification.isNumber("10000",4);
        assertEquals(b,false);
        boolean c = Verification.isNumber("19A0",4);
        assertEquals(c,false);
        boolean d = Verification.isNumber("12OO",4);
        assertEquals(d,false);
        boolean f = Verification.isNumber("1",4);
        assertEquals(f,true);

    }


    public void testPassword(){

        boolean valid1 = Verification.correctPassword("vasya_sosat pisky");
        assertEquals(false,valid1);

        boolean valid2 = Verification.correctPassword("610917");
        assertEquals(true,valid2);

        boolean valid3 = Verification.correctPassword("AAaa_s9");
        assertEquals(true,valid3);

    }



    public void testPhone(){

        boolean valid1 = Verification.correctPhone("vasya_sosat pisky");
        assertEquals(false,valid1);


        boolean valid3 = Verification.correctPhone("ij8922jh3232");
        assertEquals(false,valid3);

        boolean valid4 = Verification.correctPhone("32323232");
        assertEquals(false,valid4);




    }



    public void testEmail(){

        boolean valid1 = Verification.correctEmail("vasya_sosat pisky");
        assertEquals(false,valid1);

        boolean valid2 = Verification.correctEmail("vlad@nagaev");
        assertEquals(false,valid2);

        boolean valid3 = Verification.correctEmail("610917");
        assertEquals(true,valid3);

        boolean valid4 = Verification.correctEmail("SELECT * FROM user");
        assertEquals(false,valid4);

        boolean valid5 = Verification.correctEmail("AAaa_s9");
        assertEquals(true,valid5);

    }

}
