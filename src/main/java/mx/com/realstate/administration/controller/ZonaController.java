package mx.com.realstate.administration.controller;

import java.util.Optional;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import mx.com.realstate.administration.dto.ColoniaResponseDto;
import mx.com.realstate.administration.dto.ZonaActualizacionDto;
import mx.com.realstate.administration.dto.ZonaColoniasDto;
import mx.com.realstate.administration.dto.ZonaDto;
import mx.com.realstate.administration.exception.BusinessException;
import mx.com.realstate.administration.persistence.model.Zona;
import mx.com.realstate.administration.service.ZonaService;
import mx.com.realstate.administration.utils.RealStateUtils;

@CrossOrigin
@RestController
public class ZonaController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ZonaService zonaService;

    @ApiOperation(value = "crearZona", tags = { "Zona" })
    @PostMapping(path = "/realstate/zona", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ZonaColoniasDto crearZona(@Valid @RequestBody final ZonaDto zonaDto, final BindingResult bindingResult) throws BusinessException {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(RealStateUtils.getMessages(bindingResult.getFieldErrors()), HttpStatus.BAD_REQUEST, zonaDto.toString());
        }
        Zona zona = zonaService.save(modelMapper.map(zonaDto, Zona.class));
        return modelMapper.map(zona, ZonaColoniasDto.class);
    }

    @ApiOperation(value = "actualizarZona", tags = { "Zona" })
    @PutMapping(path = "/realstate/zona", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarZona(@Valid @RequestBody final ZonaActualizacionDto zonaActualizacionDto, final BindingResult bindingResult) throws BusinessException {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(RealStateUtils.getMessages(bindingResult.getFieldErrors()), HttpStatus.BAD_REQUEST, zonaActualizacionDto.toString());
        }

        zonaService.save(modelMapper.map(zonaActualizacionDto, Zona.class));
    }

    @ApiOperation(value = "obtenerColonias", tags = { "Zona" })
    @GetMapping(path = "/realstate/{codigoZona}/colonias", produces = MediaType.APPLICATION_JSON_VALUE)
    public ZonaColoniasDto obtenerColonias(@PathVariable final String codigoZona) throws BusinessException {
        Optional<Zona> zona = zonaService.findByCodigoZona(codigoZona);
        if (!zona.isPresent()) {
            throw new BusinessException(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND, codigoZona);
        }
        ZonaColoniasDto zonaResponseDto = modelMapper.map(zona.get(), ZonaColoniasDto.class);
        zonaResponseDto.setColonias(zona.get().getColonias().stream().map(colonia -> modelMapper.map(colonia, ColoniaResponseDto.class)).collect(Collectors.toList()));
        return zonaResponseDto;

    }

}
