package entities.models;

public class Power {
    private String name;
    private Integer id;
    private String hability;

    public Power(String name, Integer id, String hability) {
        this.name = name;
        this.id = id;
        this.hability = hability;
    }

    public Power() {

    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHability() {
        return hability;
    }

    public void setHability(String hability) {
        this.hability = hability;
    }
}
