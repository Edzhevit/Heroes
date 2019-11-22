package app.web.beans;

import app.domain.models.view.HeroViewModel;
import app.service.HeroService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class HeroesListBean {

    private List<HeroViewModel> heroes;
    private HeroService heroService;
    private ModelMapper modelMapper;

    public HeroesListBean() {
    }

    @Inject
    public HeroesListBean(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init(){
        this.setHeroes(this.heroService.getAllOrderedByLevelDesc()
                .stream()
                .map(hero -> this.modelMapper.map(hero, HeroViewModel.class)).collect(Collectors.toList()));
        this.getHeroes().forEach(h -> h.setClassOption(h.getClassOption().toLowerCase()));
    }


    public List<HeroViewModel> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<HeroViewModel> heroes) {
        this.heroes = heroes;
    }
}
