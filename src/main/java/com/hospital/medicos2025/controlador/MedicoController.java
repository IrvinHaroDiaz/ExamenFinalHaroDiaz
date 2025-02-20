package com.hospital.medicos2025.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.hospital.medicos2025.modelo.Medico;
import com.hospital.medicos2025.servicio.MedicoService;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public String listarMedicos(Model model) {
        model.addAttribute("medicos", medicoService.listarMedicos());
        return "medicos/medicos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("medico", new Medico());
        return "registro_medicos";
    }

    @PostMapping("/guardar")
    public String guardarMedico(@ModelAttribute Medico medico) {
        medicoService.registrarMedico(medico);
        return "redirect:/medicos";
    }

    @GetMapping("/editar/{id}")
    public String editarMedico(@PathVariable Integer id, Model model) {
        Medico medico = medicoService.obtenerMedicoPorId(id);
        if (medico != null) {
            model.addAttribute("medico", medico);
            return "editar_medico"; 
        }
        return "redirect:/medicos";
    }

    @PostMapping("/actualizar")
    public String actualizarMedico(@ModelAttribute Medico medico) {
        medicoService.actualizarMedico(medico);
        return "redirect:/medicos";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarMedico(@PathVariable Integer id) {
        medicoService.eliminarMedico(id);
        return "redirect:/medicos";
    }

}