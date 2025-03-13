package br.com.github.java.http;

public record GitUser(int id, String login, String name, String location,
                      String email, String bio, int public_repos, int followers, int following) {
}
