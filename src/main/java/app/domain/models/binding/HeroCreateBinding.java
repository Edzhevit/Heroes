package app.domain.models.binding;

public class HeroCreateBinding {

    private String name;
    private String classOption;
    private Integer level;

    public HeroCreateBinding() {
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
