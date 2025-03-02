package domain;

public class Member {
    private String name;
    private long id;  //고객의 정보를 저장하기 위한 id 저장

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
