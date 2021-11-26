import com.github.underscore.lodash.U;
import com.paymob.http.Model;
import com.paymob.http.Request;
import com.paymob.resources.*;
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
                                        .add("first_name", "abdo")
                                        .add("last_name", "hassan")
                                        .add("email", "test_test@test.com"))

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

         request.setSecretKey("skl_51bf49f38681a7d859fbb7a48d43df747877e66e906a1851efad3c8f427c1082");

        // create an intention
        //  new Intention(request).create(builder.toJson());

        // list the customers
        new Customer(request).List();

        // retrieve the customer
        new Customer(request).retrieve("73dcb83d-c93b-49e9-968e-1614dd93a839");

        //        // customize the intention by adding a different base url and different version
        //        new Intention( request , new
        // Model("https://next-stg.paymobsolutions.com/next/api",1)).create(builder.toJson());
        //
        //        // create an retrieve
        //        new Intention(request).retrieve("07dab2c8-7bbc-4cab-bcfa-3019e1c058d5");
        //
        // create an List
        // new Intention(request).List();
        //
        //        // creating a refund
        //        new Refund(request).create(builder.toJson());
        //        new Refund(request, new Model("https://anotherBaseURL/",
        // 1)).create(builder.toJson());
        //
        //        // creating a capture
        //        new Capture(request).create(builder.toJson());
        //        new Capture(request, new Model("https://anotherBaseURL/",
        // 1)).create(builder.toJson());
        //
        //        // creating a void
        //        new Void(request).create(builder.toJson());
        //        new Void(request, new
        // Model("https://anotherBaseURL/",1)).create(builder.toJson());
    }
}
