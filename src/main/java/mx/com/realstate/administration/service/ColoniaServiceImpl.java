package mx.com.realstate.administration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.realstate.administration.persistence.model.Colonia;
import mx.com.realstate.administration.persistence.model.Zona;
import mx.com.realstate.administration.persistence.repository.ColoniaRepository;
import mx.com.realstate.administration.persistence.repository.ZonaRepository;

@Service
public class ColoniaServiceImpl implements ColoniaService {

    @Autowired
    private ColoniaRepository coloniaRepository;

    @Autowired
    private ZonaRepository zonaRepository;

    @Override
    public void save(final Colonia colonia) {
        Optional<Zona> zona = zonaRepository.findByCodigoZona(colonia.getZona().getCodigoZona());
        if (zona.isPresent()) {
            colonia.setZona(zona.get());
            coloniaRepository.save(colonia);
        }
    }

    @Override
    public Optional<Colonia> findById(final int idColonia) {
        return coloniaRepository.findById(idColonia);
    }
}
