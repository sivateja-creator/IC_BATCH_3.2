public class WebsiteValidator {
    String url = "https://www.google.com";

    void validateWebsite() {
        if (url.startsWith("https://")) {
            System.out.println("Secure Website URL");
        } else {
            System.out.println("Invalid Website Protocol");
        }
    }

    public static void main(String[] args) {
        WebsiteValidator w = new WebsiteValidator();

        w.validateWebsite();

        w.url = "http://www.google.com";
        w.validateWebsite();
    }
}