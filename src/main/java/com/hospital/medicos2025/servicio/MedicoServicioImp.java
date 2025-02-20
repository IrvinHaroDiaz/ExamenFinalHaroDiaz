package com.hospital.medicos2025.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hospital.medicos2025.modelo.Medico;
import com.hospital.medicos2025.repositorio.MedicoRepository;

@Service
@Transactional
public class MedicoServicioImp implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public void registrarMedico(Medico medico) {
        medicoRepository.save(medico);
    }

    @Override
    public void eliminarMedico(int id) {
        if (!medicoRepository.existsById(id)) {
            throw new RuntimeException("Médico con ID " + id + " no encontrado.");
        }
        medicoRepository.deleteById(id);
    }

    @Override
    public List<Medico> listarMedicos() {
        return (List<Medico>) medicoRepository.findAll();
    }

    @Override
    public Medico obtenerMedicoPorId(int id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico con ID " + id + " no encontrado."));
    }

    @Override
    public void actualizarMedico(Medico medico) {
        if (!medicoRepository.existsById(medico.getIdMedicoT3())) {
            throw new RuntimeException("No se puede actualizar. Médico con ID " + medico.getIdMedicoT3() + " no existe.");
        }
        medicoRepository.save(medico);
    }
}