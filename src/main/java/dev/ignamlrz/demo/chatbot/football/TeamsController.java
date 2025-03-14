package dev.ignamlrz.demo.chatbot.football;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/teams")
public class TeamsController {

    ChatClient client;

    public TeamsController(ChatClient.Builder builder) {
        this.client = builder.build();
    }

    @GetMapping("/trophies")
    public List<TrophyDto> getTrophies(@RequestParam String team) {
        String prompt = String.format("How many trophies has %s. Expose and sorted by year", team);
        return this.client.prompt(prompt)
                .call()
                .entity(new ParameterizedTypeReference<>() {
                });
    }
}
