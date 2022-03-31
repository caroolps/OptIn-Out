package fatec.sp.optinoptout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fatec.sp.optinoptout.entity.Termo;
import fatec.sp.optinoptout.service.TermoService;


@RestController
@CrossOrigin
@RequestMapping(value = "/termo")
public class TermoController {

    @Autowired
    private TermoService termoService;


    @GetMapping(value = "/all")
    public List<Termo> getAllTermos() {
        return termoService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Termo getTermo(@PathVariable("id") long id) {
        return termoService.getTermoById(id);
    }


    @PostMapping(value = "/new")
    public Termo postTermo(@RequestBody Termo termo) {
        return termoService.postTermo(termo);
    }

    @GetMapping
    public Termo getLatest() {
        return termoService.getLatestTermo();
    }

}



