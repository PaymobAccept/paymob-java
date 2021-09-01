public class TestExample {
    public static void main(String[] args){
        String payload = "{\"amount\":1000,\"currency\":\"EGP\",\"payment_methods\":[\"card\",\"kiosk\"],\"billing_data\":{\"apartment\":\"803\",\"email\":\"claudette09@exa.com\",\"floor\":\"42\",\"first_name\":\"Clifford\",\"street\":\"Ethan Land\",\"building\":\"8028\",\"phone_number\":\"01010101010\",\"shipping_method\":\"PKG\",\"postal_code\":\"01898\",\"city\":\"Jaskolskiburgh\",\"country\":\"CR\",\"last_name\":\"Nicolas\",\"state\":\"Utah\"},\"customer\":{\"first_name\":\"test\",\"last_name\":\"test\",\"email\":\"claudette09@exa.com\"},\"items\":[{\"name\":\"ASC1515\",\"amount\":\"500\",\"description\":\"Smart Watch\",\"quantity\":\"1\"},{\"name\":\"ERT6565\",\"amount\":\"500\",\"description\":\"Power Bank\",\"quantity\":\"1\"}]}";
        Request r = new Request();
        r.setSecretKey("skt_a67ba5b0a9cfb19e37a685f9216ebf456ddc63aa9706d21c370571269689191b");
        System.out.println(new Intention(r).create(payload));
        System.out.println(new Customer(r).retrieve()); }}