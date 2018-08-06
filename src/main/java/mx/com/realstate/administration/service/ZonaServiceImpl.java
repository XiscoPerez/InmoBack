package mx.com.realstate.administration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.realstate.administration.persistence.model.Zona;
import mx.com.realstate.administration.persistence.repository.ZonaRepository;

@Service
public class ZonaServiceImpl implements ZonaService {

    @Autowired
    private ZonaRepository zonaRepository;

    @Override
    public Zona save(final Zona zona) {
        return zonaRepository.save(zona);
    }

    @Override
    public Optional<Zona> findByCodigoZona(final String codigoZona) {
        return zonaRepository.findByCodigoZona(codigoZona);
    }

}
