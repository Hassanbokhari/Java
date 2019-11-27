import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailTest {

	@Test
	void testVerify_email_address() {
		Email email = new Email();
		assertEquals(true, email.verify_email_address("hbokhari18@gmail.com"));
		assertEquals(false, email.verify_email_address("hbokhari18!@gmail.com"));
		assertEquals(false, email.verify_email_address("hbokhari18@@gmail.com"));
		assertEquals(false, email.verify_email_address("hbokhari18@local.com"));
		assertEquals(true, email.verify_email_address("p17-6059@hotmail.com"));
		assertEquals(true, email.verify_email_address("p17.6059@hotmail.com"));
	}
}
