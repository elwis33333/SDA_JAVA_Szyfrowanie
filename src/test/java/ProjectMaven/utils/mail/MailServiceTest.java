package ProjectMaven.utils.mail;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

class MailServiceTest {
    @Test
    void send() {
        //given
        final MailService service = new MailService
                .MailBuilder("elwis33333@wp.pl", "test mail")
                .addBody("test")
                .build();
        //when
        service.send();
        //then
        assertThat(service.getInformation(), is(notNullValue()));
    }

}