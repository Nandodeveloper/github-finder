package br.com.github.java.main;

import br.com.github.java.http.CreateHttp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Write a user from github: ");
        String answer = s.nextLine();
        CreateHttp createHttp = new CreateHttp(answer);
        createHttp.create();
    }
}