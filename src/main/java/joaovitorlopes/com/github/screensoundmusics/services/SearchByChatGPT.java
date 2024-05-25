package joaovitorlopes.com.github.screensoundmusics.services;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class SearchByChatGPT {
    public static String getInfo(String text) {
        OpenAiService service = new OpenAiService(System.getenv("OPENAI_APIKEY"));

        CompletionRequest request = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("me fale sobre o artista: " + text)
                .maxTokens(1000)
                .temperature(0.7)
                .build();


        var response = service.createCompletion(request);
        return response.getChoices().get(0).getText();
    }
}
