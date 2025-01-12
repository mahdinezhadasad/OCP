package IO.src.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.Arrays;

import java.io.Console;

public class Talker {
    public static void main(String[] args) {
        // Get the console instance
        Console console = System.console();
        
     
        
        // Prompt the user for username
        String username = console.readLine("Username: ");
        System.out.println("Hello " + username);
        
        // Prompt the user for password securely
        char[] passwordArray = console.readPassword("Password: ");
        
        if (passwordArray != null) {
            String password = new String(passwordArray);
            // TODO: Add logic to validate the password
            System.out.println("Password entered (for debugging purposes): " + password);
        }
    }
}