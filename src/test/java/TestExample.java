import com.github.underscore.lodash.U;
import com.paymob.http.Model;
import com.paymob.http.Request;
import com.paymob.resources.Capture;
import com.paymob.resources.Intention;
import com.paymob.resources.Refund;
import com.paymob.resources.Void;


public class TestExample {
    public static void main(String[] args)  {

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
                                .add("phone_number", "+201010101019")
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

        // create a request
        Request request = new Request();

        // set secretKey
        request.setSecretKey("skl_726d35c37defcffd4edf9d3743228cd5535620be7111fc3387e317ef9c0dbcba");

        // create an intention
        new Intention(request).create(builder.toJson());

        // custmise the intention by adding a diffrent base url and diffrent version
        new Intention( request , new Model("https://next-stg.paymobsolutions.com/next/api",1)).create(builder.toJson());

        // create an retrieve
        new Intention(request).retrieve("0cc46c79-e377-4c43-91c4-95f7a2fca151");

        // create an List
        new Intention(request).List();

        // creating a refund
        new Refund(request).create(builder.toJson());
        new Refund(request, new Model("https://anotherBaseURL/", 1)).create(builder.toJson());

        // creating a capture
        new Capture(request).create(builder.toJson());
        new Capture(request, new Model("https://anotherBaseURL/", 1)).create(builder.toJson());

        // creating a void
        new Void(request).create(builder.toJson());
        new Void(request, new Model("https://anotherBaseURL/",1)).create(builder.toJson());
    }
}
