
package Blog;

import java.util.ArrayList;

public class Category {
    private String categoryName;
    private ArrayList<Post> posts;
    
    public Category(String name){
        this.categoryName = name;
        this.posts = new ArrayList<>();
    }
    
    public void addPost(Post post){
        this.posts.add(post);
    }
}
