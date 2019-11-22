package app.web.beans;

import app.domain.entities.Hero;
import app.domain.models.view.HeroViewModel;
import app.service.HeroService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class HeroDetailsBean {

    private HeroService heroService;
    private ModelMapper modelMapper;

    public HeroDetailsBean() {
    }

    @Inject
    public HeroDetailsBean(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    public HeroViewModel getJobById(String id){
        return this.modelMapper.map(this.heroService.getById(id), HeroViewModel.class);
    }
}
