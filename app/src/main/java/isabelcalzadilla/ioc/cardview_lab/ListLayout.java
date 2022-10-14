package isabelcalzadilla.ioc.cardview_lab;

import android.graphics.drawable.Icon;

// CLASE QUE CONTENDRÁ LOS ELEMENTOS DEFINIDOS EN LA LISTVIEW
public class ListLayout {

    private String img;
    private String name;
    private String resume;

    public ListLayout(String img,String name, String resume) {
        this.img = img;
        this.name = name;
        this.resume = resume;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
