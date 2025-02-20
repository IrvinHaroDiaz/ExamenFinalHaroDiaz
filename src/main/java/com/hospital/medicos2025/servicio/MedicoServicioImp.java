package com.hospital.medicos2025.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.medicos2025.modelo.Medico;
import com.hospital.medicos2025.repositorio.MedicoRepository;

@Service
public class MedicoServicioImp implements MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository;

	@Override
	public void RegistrarMedico(Medico medico) {
		medicoRepository.save(medico);
	}

	@Override
	public void eliminarMedico(int id) {
		medicoRepository.deleteById(id);
	}

	@Override
	public List<Medico> listarMedicos() {
		return (List<Medico>) medicoRepository.findAll();
	}

	@Override
	public Medico obtenerMedicoPorId(int id) {
		return medicoRepository.findById(id).orElse(null);
	}
}
