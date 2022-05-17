import com.github.underscore.lodash.U;
import com.google.gson.Gson;
import com.paymob.http.Request;
import com.paymob.resources.*;


public class TestExample {
    public static void main(String[] args){

                U.Builder sample_payload = U.objectBuilder()
                        .add("amount", "2000")
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
                                        .add("amount", "1000")
                                        .add("description", "football")
                                        .add("quantity", "1"))

                                .add(U.objectBuilder()
                                        .add("name", "ERT6565")
                                        .add("amount", "1000")
                                        .add("description", "toy2")
                                        .add("quantity", "1")))

                        .add("extras",U.objectBuilder()
                                .add("name","test")
                                .add("userid","30"));

                U.Builder moto_payload = U.objectBuilder()
                        .add("client_secret","ckl_f0390954c1cbed9ac8e7f86cd2902ea69")
                        .add("token","e29ac6d6676da32f28c7fe5a1a111694978f14ea686915f42fa53e93")
                        .add("customer_id","c26e2788-d367-4789-9b68-c431943b1d9a")
                        .add("method","card-moto")
                        .add("payment_method_id","1599970");

        // create a request
                 Request request = new Request();

        // set secretKey
                 request.setSecretKey("skl_1fb7a2f55a3cc0cff0c76d886e0c646e05900555c8de96b7d863f944cc9703d0");

        // create an intention
                 new Intention(request).create(sample_payload.toJson());

        // create a moto intention
                 // new PayToken(request).create(moto_payload.toJson());

        // list the customers
                 //new Customer(request).List();

        // retrieve the customer
                //new Customer(request).retrieve("73dcb83d-c93b-49e9-968e-1614dd93a839");

        // customize the intention by adding a different base url and different version
                //new Intention( request , new Model("https://next-stg.paymobsolutions.com/next/api",1)).create(builder.toJson());

        // create an retrieve
                //new Intention(request).retrieve("07dab2c8-7bbc-4cab-bcfa-3019e1c058d5");

        // create an List
                //new Intention(request).List();

        // creating a refund
                //new Refund(request).create(sample_payload.toJson());
                //new Refund(request, new Model("https://anotherBaseURL/",1)).create(sample_payload.toJson());

        // creating a capture
                //new Capture(request).create(sample_payload.toJson());
                //new Capture(request, new Model("https://anotherBaseURL/",1)).create(sample_payload.toJson());

        // creating a void
                //new Void(request).create(sample_payload.toJson());
                //new Void(request, new Model("https://anotherBaseURL/",1)).create(sample_payload.toJson());
    }

}
