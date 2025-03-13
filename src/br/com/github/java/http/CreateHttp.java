package br.com.github.java.http;

import br.com.github.java.exceptions.GitHubQueryErrorException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CreateHttp {
    private String username;

    public CreateHttp(String username) {
        this.username = username;
    }

    public void create() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String address = ("https://api.github.com/users/" + username).replace(" ", "");
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 404) {
                throw new GitHubQueryErrorException("Error: User not found.");
            }
            var json = response.body();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            GitUser gitUser = gson.fromJson(json, GitUser.class);
            User user = new User(gitUser);
            System.out.println(user);
            FileWriter writer = new FileWriter("githubUser.json");
            writer.write(gson.toJson(user));
            writer.close();
        } catch (IOException | InterruptedException exception) {
            System.out.println("Error: " + exception.getMessage());
        } catch (GitHubQueryErrorException e) {
            System.out.println(e.getMessage());
        }
    }

}
