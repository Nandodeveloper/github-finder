import br.com.github.java.exceptions.GitHubQueryErrorException;
import br.com.github.java.http.GitUser;
import br.com.github.java.http.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite um usuário do github: ");
        String username = s.next();
        try {
            HttpClient client = HttpClient.newHttpClient();
            String address = ("https://api.github.com/users/" + username).replace(" ", "20%");
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address))
                    .header("Accept", "application/vnd.github.v3+json").build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 404) {
                throw new GitHubQueryErrorException("Error: User not found.");
            }
                var json = response.body();
                Gson gson = new GsonBuilder().create();
                GitUser gitUser = gson.fromJson(json, GitUser.class);
                User user = new User(gitUser);
                System.out.println(user);
        } catch (IOException | InterruptedException exception) {
            System.out.println("Erro: " + exception.getMessage());
        } catch (GitHubQueryErrorException e) {
            System.out.println(e.getMessage());
        }
    }
}