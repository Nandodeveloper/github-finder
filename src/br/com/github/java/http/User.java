package br.com.github.java.http;

public class User {
    private String name;
    private int id;
    private String username;
    private String location;
    private String email;
    private String biography;
    private int repositories;
    private int followers;
    private int following;

    public User(GitUser gitUser) {
        this.id = gitUser.id();
        this.username = gitUser.login();
        this.name = gitUser.name();
        this.location = gitUser.location();
        this.biography = gitUser.bio();
        this.email = gitUser.email();
        this.followers = gitUser.followers();
        this.following = gitUser.following();
        this.repositories = gitUser.public_repos();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getBiography() {
        return biography;
    }

    public int getRepositories() {
        return repositories;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    @Override
    public String toString() {
        return "\nId: " + id + "\nUsername: " + username
                + "\nName: " + name + "\nLocation: " + location + "\nBiography: " + biography
                + "\nEmail: " + email + "\nFollowers: " + followers + "\nFollowing: " + following
                + "\nRepositories: " + repositories;
    }
}
