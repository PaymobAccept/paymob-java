import com.github.underscore.lodash.U;
import com.paymob.resources.Capture;
import com.paymob.resources.Intention;
import com.paymob.http.Request;
import com.paymob.resources.Refund;
import com.paymob.resources.Void;

import java.io.IOException;

public class TestExample {
    public static void main(String[] args) throws IOException {

        U.formatJson("{\"a\":{\"b\":\"data\"}}");

        U.Builder builder = U.objectBuilder()
                .add("amount", "3000")
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
                                .add("amount", "1500")
                                .add("description", "foot")
                                .add("quantity", "1"))

                        .add(U.objectBuilder()
                                .add("name", "ERT6565")
                                .add("amount", "1500")
                                .add("description", "ball")
                                .add("quantity", "1")))

                .add("extras",U.objectBuilder()
                        .add("name","test")
                        .add("userid","30"));

        Request r = new Request();
        r.setSecretKey("skl_221fb053736eb27f0a28d51511bed6b3d4eda6ab41413a1e168d1e06d4ebaf8a");
         System.out.println(new Intention(r).create(builder.toJson()));
        // System.out.println(new Intention(r).retrieve(builder.toJson()));
        // System.out.println(new Intention(r).List());
        System.out.println(new Capture(r).create(""));
        System.out.println(new Refund(r).create(""));
        System.out.println(new Void(r).create(""));
    }
}
