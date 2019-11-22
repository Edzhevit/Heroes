package app.domain.models.service;

public class HeroServiceModel {

    private String id;
    private String name;
    private String classOption;
    private Integer level;

    public HeroServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassOption() {
        return classOption;
    }

    public void setClassOption(String classOption) {
        this.classOption = classOption;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
