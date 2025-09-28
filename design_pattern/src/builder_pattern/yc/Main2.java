package builder_pattern.yc;

public class Main2 {
    public static void main(String[] args) {
        HttpRequest getRequest = new HttpRequest.Builder(
                "GET", "https://design_pattern.example.com")
                .addHeader("Authorization", "Barer token")
                .addParameter("query", "builder-pattern")
                .build();

        HttpRequest postRequest = new HttpRequest.Builder(
                "POST", "https://example.com")
                .addHeader("Authorization", "Barer token")
                .setBody("{\"name\" : \"John\", \"age\" : 30 }")
                .build();

        System.out.println("getRequest = " + getRequest);
        System.out.println("postRequest = " + postRequest);
    }
}
