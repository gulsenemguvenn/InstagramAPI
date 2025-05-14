package org.gulsenemguven;

import java.io.IOException;
import java.util.Scanner;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;
import org.apache.http.client.ClientProtocolException;

public class Main
{
    public static void main( String[] args )
    {

        Scanner scanner = new Scanner(System.in);
        String username = null;
        String password = null;

        String menu = "1- Show Biography\n"
                + "2- Show Follower Count\n"
                + "3- Get Profile Picture URL\n"
                + "4- Get Follower List\n"
                + "5- Get Following List\n"
                + "6- Exit";

        System.out.println("WELCOME TO THE INSTAGRAM PROJECT!");
        System.out.print("Enter your username: ");
        username = scanner.nextLine();

        System.out.print("Enter your password: ");
        password = scanner.nextLine();

        if (username.equals("johnarrive1212") && password.equals("javatest")) {
            // login credentials correct
            Instagram4j instagram = Instagram4j.builder()
                    .username(username)
                    .password(password)
                    .build();
            instagram.setup();

            try {
                instagram.login();
                InstagramSearchUsernameResult userResult = instagram
                        .sendRequest(new InstagramSearchUsernameRequest(username));

                System.out.println(menu);
                String choice = scanner.nextLine();

                if (choice.equals("6")) {
                    System.out.println("Application has been terminated.");
                } else if (choice.equals("1")) {
                    System.out.println("Biography: " + userResult.getUser().biography);
                }

            } catch (ClientProtocolException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } else {
            System.out.println("Your username or password is incorrect!");
        }
    }


}

