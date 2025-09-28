package builder_pattern.yc;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

    private String method;
    private String url;
    private Map<String, String> headers;
    private Map<String, String> parameters;
    private String body;

    private HttpRequest(Builder builder) {
        this.method = builder.method;
        this.url = builder.url;
        this.headers = builder.headers;
        this.parameters = builder.parameters;
        this.body = builder.body;
    }

    public static class Builder {
        private String method;
        private String url;
        private Map<String, String> headers = new HashMap<>();
        private Map<String, String> parameters = new HashMap<>();
        private String body;

        public Builder(String url, String method) {
            this.url = url;
            this.method = method;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder addHeader(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public Builder addParameter(String key, String value) {
            this.parameters.put(key, value);
            return this;
        }

        public HttpRequest build(){
            return new HttpRequest(this);
        }

    }
}
