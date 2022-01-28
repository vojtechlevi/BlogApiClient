package com.example.blogapiclient;

import java.util.Scanner;

public class BlogProgram {
    private BlogClient myApiClient;

    // Vår konstruktor som skapar ett nytt ApiClient-objekt
    public BlogProgram() {
        myApiClient = new BlogClient("http://127.0.0.1:8080/api/v1/blog");
    }

    // Där vårt program startar
    public void start() {
        boolean programRunning = true;

        while (programRunning) {
            System.out.println();
            System.out.println("=========================================");
            System.out.println("Hello, What would you like to do?");
            System.out.println("1. Add a new post");
            System.out.println("2. List all posts");
            System.out.println("3. Search post by ID");
            System.out.println("4. Update a post");
            System.out.println("5. Delete a post");
            System.out.println("6. Clear all posts");
            System.out.println("7. Exit program");
            System.out.println("=========================================");
            System.out.println();

            int userChoice = getUserInt();
            System.out.println("User picked: " + userChoice);

            switch (userChoice) {
                case 1:
                    addPost();
                    break;
                case 2:
                    printListOfPosts();
                    break;
                case 3:
                    getPostByID();
                    break;
                case 4:
                    updatePostByID();
                    break;
                case 5:
                    deletePostByID();
                    break;
                case 6:
                    clearListOfPosts();
                    break;
                case 7:
                    System.out.println("Goodbye.");
                    programRunning = false;
            }
        }
    }

    // Metod för att skapa ett nytt inlägg
    public void addPost() {
        System.out.println("Whats the title of your post?");
        String title = getUserString();

        System.out.println("What would you like to post?");
        String body = getUserString();

        BlogPost newPost = new BlogPost(title, body);

        boolean success = myApiClient.addPost(newPost);

        if (success) {
            System.out.println("Post Added!");
        } else {
            System.out.println("Issue adding post. :( ");
        }

    }

    // Metod för att lista alla blogginlägg
    public void printListOfPosts() {
        BlogPost[] posts = myApiClient.printListOfPosts();

        System.out.println("Posts");
        System.out.println("-----------------------------------------");

        if (posts.length > 0) {
            for (int i = 0; i < posts.length; i++) {
                String title = posts[i].title;
                String body = posts[i].body;
                int id = posts[i].id;

                System.out.printf("-> ID: %d Title: %s ( %s )\n", id, title, body);
            }
        } else {
            System.out.println("No posts in the list. :(");
        }
    }

    // Metod för att lista blogginlägg med specifikt ID
    public void getPostByID() {
        System.out.println("What ID are your looking for?");
        int postId = getUserInt();
        BlogPost post = myApiClient.getPostByID(postId);

        if (post != null) {
            String title = post.title;
            String body = post.body;
            int id = post.id;
            System.out.printf("-> ID: %d Title: %s ( %s )\n", id, title, body);
        } else {
            System.out.println("ID:" + postId + " Not found :( ");
        }
    }

    public void updatePostByID() {
        System.out.println("Which post would you like to update?");
        System.out.print("ID: ");
        int postId = getUserInt();

        System.out.print("New Title: ");
        String titleUpdate = getUserString();

        System.out.print("New Body: ");
        String bodyUpdate = getUserString();

        BlogPost updatePost = new BlogPost(titleUpdate, bodyUpdate);

        boolean success = myApiClient.updatePostById(postId, updatePost);

        if (success) {
            System.out.println("Post Updated!");
        } else {
            System.out.println("Issue updating post. :( ");
        }

    }

    public void deletePostByID() {
        System.out.println("Which post would you like to delete?");
        System.out.print("ID: ");
        int postId = getUserInt();

        if (myApiClient.deletePostByID(postId)) {
            System.out.println("ID:" + postId + " Deleted.");
        } else {
            System.out.println("Issue deleting ID:" + postId);
        }


    }

    // Metod för att rensa listan med blogginlägg
    public void clearListOfPosts() {

        if (myApiClient.clearPosts()) {
            System.out.println("List of posts cleared!");
        } else {
            System.out.println("Issue clearing list of posts. :(");
        }
    }


    public String getUserString() {
        Scanner myScanner = new Scanner(System.in);

        String myString;

        while (true) {
            try {
                System.out.print("> ");
                myString = myScanner.nextLine();
                break;
            } catch (Exception e) {
                //System.out.println("Exception: " + e);
                System.out.println("Felaktig indata");
            }
        }

        return myString;
    }

    public int getUserInt() {
        Scanner myScanner = new Scanner(System.in);

        int myInteger;

        while (true) {
            try {
                System.out.print("> ");
                myInteger = Integer.parseInt(myScanner.nextLine());
                break;
            } catch (Exception e) {
                //System.out.println("Exception: " + e);
                System.out.println("Felaktig indata");
            }
        }

        return myInteger;
    }
}

