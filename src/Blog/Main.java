
package Blog;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        DB db = new DB();
        db.addUser();
        while(true){
            User user = db.login();
            if(user != null){
                System.out.println("Login Successful");
                boolean logout = false;
                while(!logout){
                    System.out.println("Enter 1 to create post, 2 to delete "
                            + "post, 3 to view post, 4 to logout\n"
                            + " Enter Your Choice : ");
                    int choice = in.nextInt();
                    in.nextLine();
                    switch(choice){
                        case 1:
                        {
                            // create post
                            db.addPost(user);
                            break;
                        }
                        case 2:
                        {
                            // delete post
                            System.out.print("Enter post name : ");
                            String postName = in.nextLine();
                            if(db.deletePost(postName)){
                                System.out.println("Deleted Successfully");
                            } else {
                                System.out.println("Post Not Found");
                            }
                            break;
                        }
                        case 3:
                        {
                            // view post
                            System.out.print("Enter post name : ");
                            String postName = in.nextLine();
                            Post post = db.getPost(postName);
                            if(post != null){
                                System.out.print(post.toString());
                                System.out.print("Are you willing to comment in this post : (yes / no) : ");
                                String commentChoice = in.next();
                                    // comment on the viewed post
                                if(commentChoice.toLowerCase().equals("yes")){
                                    post.addComment(user.getUserName());
                                }
                            } else {
                                System.out.println("No post found");
                            }
                            
                            break;
                        }
                        case 4:
                        {
                            // logout
                            logout = true;
                            break;
                        }
                        default :{
                            System.out.println("Enter correct choice");
                        }
                    } // end of switch case
                } // end of while loop
                
            } else {
                    System.out.println("Login Failed");
            }
            System.out.print("Exit or Continue : ");
            String exit = in.next();
            if(exit.toLowerCase().equals("exit")){
                break;
            }
        }
        System.out.println("Program Exited");
    }
}
