package mx.com.realstate.administration.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import mx.com.realstate.administration.dto.ColoniaDto;
import mx.com.realstate.administration.dto.ColoniaResponseDto;
import mx.com.realstate.administration.exception.BusinessException;
import mx.com.realstate.administration.persistence.model.Colonia;
import mx.com.realstate.administration.service.ColoniaService;
import mx.com.realstate.administration.utils.RealStateUtils;

@CrossOrigin
@RestController
public class ColoniaController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ColoniaService coloniaService;

    @ApiOperation(value = "createColonia", tags = { "Colonia" })
    @PostMapping(path = "/realstate/colonia", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createColonia(@Valid @RequestBody final ColoniaDto coloniaDto, final BindingResult bindingResult) throws BusinessException {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(RealStateUtils.getMessages(bindingResult.getFieldErrors()), HttpStatus.BAD_REQUEST, coloniaDto.toString());
        }
        coloniaService.save(modelMapper.map(coloniaDto, Colonia.class));
    }

    @ApiOperation(value = "findByIdColonia", tags = { "Colonia" })
    @GetMapping(path = "/realstate/colonia/{idColonia}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ColoniaResponseDto findByColonianame(@PathVariable final Integer idColonia) throws BusinessException {
        Optional<Colonia> colonia = coloniaService.findById(idColonia);
        if (!colonia.isPresent()) {
            throw new BusinessException(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND, idColonia.toString());
        }
        return modelMapper.map(colonia.get(), ColoniaResponseDto.class);
    }

}
