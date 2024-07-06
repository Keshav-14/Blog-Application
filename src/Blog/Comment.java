
package Blog;


public class Comment {
    private String userName;
    private String comment;
    
    public Comment(String uname, String comment){
        this.userName = uname;
        this.comment = comment;
    }
    
    @Override
    public String toString(){
        return "\nUser name : " + this.userName + "\nComment : " + this.comment + "\n";
    }
}
