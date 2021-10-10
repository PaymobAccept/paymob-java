import com.github.underscore.lodash.U;
import com.paymob.resources.Intention;
import com.paymob.http.Request;
import org.apache.log4j.*;

import java.io.IOException;

public class TestExample {
    private static Logger log = Logger.getLogger(TestExample.class);
    public static void main(String[] args) throws IOException {
        //create layout
        Layout layout = new PatternLayout("%p %d %c %M %m %n");
        // Layout layout2 = new HTMLLayout();
        // Layout layout3 = new XMLLayout();
        //create appender + link layout
        // Appender app = new ConsoleAppender(layout);
        // Appender app2 = new WriterAppender(layout2);
        Appender app3 = new ConsoleAppender(layout);
        Appender app4 = new FileAppender(layout,"./logs/logs.log");
        // link appender with logger
        log.addAppender(app3);
        log.addAppender(app4);
        // TODO: log.debug("debug 1");
        // TODO  log.fatal("fatal 2");
        // TODO  log.error("error 3");
        // TODO log.warn("warn 4");
        // TODO  log.info("test info 5");

        U.formatJson("{\"a\":{\"b\":\"data\"}}");

        U.Builder builder = U.objectBuilder()
                .add("amount", "1000")
                .add("currency", "EGP")

                .add("payment_methods",U.arrayBuilder()
                        .add("card").add("kiosk"))

                .add("billing_data", U.objectBuilder()
                                .add("apartment", "803")
                                .add("email", "claudette9@exa.com")
                                .add("floor", "42")
                                .add("first_name", "Abdelrahman")
                                .add("street", "Ethan Land")
                                .add("building", "8028")
                                .add("phone_number", "01010101010")
                                .add("shipping_method", "PKG")
                                .add("postal_code", "01898")
                                .add("city", "Cairo")
                                .add("country", "EG")
                                .add("last_name", "Hassan")
                                .add("state", "Cairo"))

                .add("customer", U.objectBuilder()
                                .add("first_name", "test")
                                .add("last_name", "test2")
                                .add("email", "claudette9@exa.com"))

                .add("items", U.arrayBuilder()

                        .add(U.objectBuilder()
                                .add("name", "ASC1515")
                                .add("amount", "500")
                                .add("description", "Smart Watch")
                                .add("quantity", "1"))

                        .add(U.objectBuilder()
                                .add("name", "ERT6565")
                                .add("amount", "500")
                                .add("description", "Power Bank")
                                .add("quantity", "1")))

                .add("extras",U.objectBuilder()
                        .add("name","test")
                        .add("userid","30"));

        Request r = new Request();
        r.setSecretKey("skl_eb7e7ac5117dcd6c0b7539a635f61764aca615bd3b63051606b845c30db3bff8");
        String respons = new Intention(r).create(builder.toJson());
       System.out.println(respons);
       System.out.println(new Intention(r).retrieve());

    }
}
