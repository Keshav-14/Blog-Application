
package Blog;

import java.util.ArrayList;

public class Tag {
    
    String tagName;
    ArrayList<Post> posts;
    
    public Tag(String name){
        this.tagName = name;
        posts = new ArrayList<>();
    }
    
    public void addPost(Post post){
        this.posts.add(post);
    }
}
