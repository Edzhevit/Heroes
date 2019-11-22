package app.web.beans;

import app.domain.models.binding.HeroCreateBinding;
import app.domain.models.service.HeroServiceModel;
import app.service.HeroService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class HeroCreateBean extends BaseBean {

    private HeroCreateBinding heroBinding;
    private HeroService heroService;
    private ModelMapper modelMapper;

    public HeroCreateBean() {
    }

    @Inject
    public HeroCreateBean(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init(){
        this.heroBinding = new HeroCreateBinding();
    }

    public void create(){
        HeroServiceModel hero = this.modelMapper.map(this.heroBinding, HeroServiceModel.class);
        this.heroService.save(hero);
        this.redirect("/home");
    }

    public HeroCreateBinding getHeroBinding() {
        return heroBinding;
    }

    public void setHeroBinding(HeroCreateBinding heroBinding) {
        this.heroBinding = heroBinding;
    }
}
