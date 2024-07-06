
package Blog;

import java.util.ArrayList;
import java.util.Scanner;

public class Post {
    
    private String name;
    private String content;
    private User author;
    private String[] tags;
    private String category;
    private ArrayList<Comment> comments;
    
    public Post(){
        this.tags = new String[5];
        this.comments = new ArrayList<>();
    }
    
    public boolean createPost(User user){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter post title : ");
        this.name = in.nextLine();
        this.author = user;
        System.out.print("Enter Contents : ");
        this.content = in.nextLine();
        System.out.print("Enter tags (5 Tags) : ");
        for(int i = 0 ; i < 5 ; i++){
            this.tags[i] = in.next();
        }
        System.out.print("Enter the category");
        this.category = in.next();
        
        // insert into db
        return true;
    }
    
    public String toString(){
        StringBuilder tagsStr = new StringBuilder();
        for(String str : tags){
            tagsStr.append(str).append("\n");
        }
        StringBuilder commentStr = new StringBuilder();
        for(Comment c : comments){
            commentStr.append(c.toString());
        }
        
        return "Title : " + this.name + "\n\n\t" + this.content + "\nAuthor : " 
                + this.author.getName() + "\nCategory : " + this.category + "\nTags : " 
                + tagsStr.toString() + "\nComments : " + commentStr.toString(); 
    }
    
    public String getName(){
        return this.name;
    }
    
    public void addComment(String userName){
        Scanner in = new Scanner(System.in);
        String comment = in.nextLine();
        this.comments.add(new Comment(userName, comment));
    }
}
