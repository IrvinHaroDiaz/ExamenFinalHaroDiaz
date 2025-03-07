package com.hospital.medicos2025.servicio;

import java.util.List;

import com.hospital.medicos2025.modelo.Medico;

public interface MedicoService {
    void registrarMedico(Medico medico);
    void eliminarMedico(int id);
    List<Medico> listarMedicos();
    Medico obtenerMedicoPorId(int id);
    void actualizarMedico(Medico medico);
}