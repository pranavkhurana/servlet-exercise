package bean;

public class Blog {
    int blogid;
    String content;

    public Blog(int blogid, String content) {
        this.blogid = blogid;
        this.content = content;
    }

    public int getBlogid() {
        return blogid;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
