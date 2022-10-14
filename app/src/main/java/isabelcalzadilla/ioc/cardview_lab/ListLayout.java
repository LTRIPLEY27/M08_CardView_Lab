package isabelcalzadilla.ioc.cardview_lab;



// CLASE QUE CONTENDRÁ LOS ELEMENTOS DEFINIDOS EN LA LISTVIEW
public class ListLayout {

    private int img;
    private String name;
    private String resume;

    public ListLayout(int img, String name, String resume) {
        this.img = img;
        this.name = name;
        this.resume = resume;
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
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
