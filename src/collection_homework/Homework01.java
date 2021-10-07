package collection_homework;

import java.util.ArrayList;
import java.util.List;

public class Homework01 {
    public static void main(String[] args) {

        List list = new ArrayList<>();

        list.add(new News("title1", "content1"));
        list.add(new News("title2", "content2"));
        list.add(new News("title3", "content3"));
    }
}

class News {
    private String title;
    private String content;

    News(String title, String content) {
        this.title = title;
        this.content = content;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
