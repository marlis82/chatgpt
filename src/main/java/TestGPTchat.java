import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class TestGPTchat

{

    private static final String API_KEY = "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";
    private static final String ENDPOINT_URL = "https://api.openai.com/v1/engines/davinci/completions";

    private static String generateText(String prompt) throws IOException {
        MediaType mediaType = MediaType.get("application/json");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, "{\"prompt\":\"" + prompt + "\",\"max_tokens\":2024}");
        Request request = new Request.Builder()
                .url(ENDPOINT_URL)
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }



    public static void main(String[] args) throws IOException {
        String response = generateText("who is Putin?");
        System.out.println(response);
    }
}