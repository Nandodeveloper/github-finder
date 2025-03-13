package br.com.github.java.exceptions;

public class GitHubQueryErrorException extends RuntimeException {
    private String message;

    public GitHubQueryErrorException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
