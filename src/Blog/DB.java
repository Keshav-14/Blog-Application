
package Blog;

import java.util.ArrayList;
import java.util.Scanner;
public class DB {
    
    private ArrayList<Post> posts;
    private ArrayList<User> users;
    
    public DB(){
        this.posts = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    
    public void addPost(User user){
        Post post = new Post();
        post.createPost(user);
        this.posts.add(post);
        System.out.println(this.posts.size());
    }
    
    public boolean deletePost(String name){
        // search for name and remove
        for(Post i : posts){
            if(i.getName().equals(name)){
                posts.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public Post getPost(String name){
        for(Post i : this.posts){
            if(i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }
    
    public void addUser(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Name : ");
        String name = in.next();
        System.out.print("Enter Username : ");
        String uname = in.next();
        System.out.print("Enter password : ");
        String pwd = in.next();
        this.users.add(new User(uname, pwd, name));
    }
    
    public User login(){
        String uname;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Username : ");
        uname = in.next();
        String pwd = null;
        int count = 0;
        for(User x : users){
            if(x.getUserName().equals(uname)){
                while(count < 3){
                    System.out.print("Enter Password : ");
                    pwd = in.next();
                    if(x.login(uname, pwd)){
                        return x;
                    } else {
                        System.out.println("Incorrect Password");
                    }
                    count++;
                }
            }
        }
        return null;
    }
    
    
}
