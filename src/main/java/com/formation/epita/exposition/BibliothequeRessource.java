package com.formation.epita.exposition;

import com.formation.epita.exposition.mapper.BibliothequeDTOMapper;
import com.formation.epita.services.IServiceBibliotheque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("/monapi/bibliotheque")
@Validated
public class BibliothequeRessource {

    @Autowired
    IServiceBibliotheque serviceBibliotheque;

    @Autowired
    BibliothequeDTOMapper monDtoMapper;

    @GetMapping("/")
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("redirect:/swagger-ui.html",HttpStatus.OK);
    }

    @PostMapping("/create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> bibliotheques(@Valid @RequestBody BibliothequeDTO bibliothequeDTO){
        System.out.println("Je créé ma bibliotheque");
        serviceBibliotheque.enregistrer(monDtoMapper.mapToDomaine(bibliothequeDTO));
        return new ResponseEntity<>(null,HttpStatus.CREATED);
//        return "Bibliotheque créé";
    }

    @GetMapping("/list/{type}")
    @ResponseStatus(HttpStatus.OK)
    public List<BibliothequeDTO> listBibliotheque(@PathVariable("type") String typeBiliotheque){

        return monDtoMapper.mapToListDTO(serviceBibliotheque.listerBibliothequeParType(typeBiliotheque));
    }

    @DeleteMapping("/delete/{nom}")
    @ResponseStatus(HttpStatus.OK)
    public String suppression(@PathVariable("nom") String nomBibliotheque){
        serviceBibliotheque.supprimer(nomBibliotheque);
        return "Bibliotheque supprimé";
    }

    @GetMapping("/read/{nom}")
    public ResponseEntity<BibliothequeDTO> detailBibliotheque(@Valid @PathVariable("nom") String nomBibliotheque){
        BibliothequeDTO bibliothequeTrouve = monDtoMapper.mapToDTO(serviceBibliotheque.lireInfoBibliotheque(nomBibliotheque));
        return new ResponseEntity<>(bibliothequeTrouve,HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public String mettreAJour(@RequestBody BibliothequeDTO bibliotheque){
        serviceBibliotheque.modifierBibliotheque(monDtoMapper.mapToDomaine(bibliotheque));
        return "Bibliotheque modifié";

    }
}
