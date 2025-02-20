package com.bd.medico2025.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bd.medico2025.modelo.Medico;
import com.bd.medico2025.servicio.MedicoServicio;

@Controller
@RequestMapping("/Vistas")
public class MedicoController {
    
    @Autowired
    private MedicoServicio medicoServicio;
    
    @GetMapping("/ListadoMedicos")
    public String listarMedicos(Model modelo) {
        List<Medico> listado = medicoServicio.listarMedicos();
        modelo.addAttribute("listado", listado);
        return "/Vistas/ListadoMedicos";
    }
    
    @GetMapping("/RegistrarMedico")
    public String registrarMedico(Model modelo) {
        Medico medico = new Medico();
        modelo.addAttribute("regmedico", medico);
        return "/Vistas/FrmRegMedico";
    }
    
    @PostMapping("/GuardarMedico")
    public String guardarMedico(@ModelAttribute Medico medico, RedirectAttributes redirectAttributes) {
        try {
            medicoServicio.registrarMedico(medico);
            redirectAttributes.addFlashAttribute("mensaje", "Médico registrado exitosamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al registrar el médico: " + e.getMessage());
            e.printStackTrace(); // Para depuración en la consola
        }
        return "redirect:/Vistas/ListadoMedicos";
    }

    
    @GetMapping("/EditarMedico/{id}")
    public String editarMedico(@PathVariable("id") Integer idMedico, Model modelo) {
        Medico medico = medicoServicio.obtenerMedicoPorId(idMedico);
        modelo.addAttribute("regmedico", medico);
        return "/Vistas/FrmRegMedico";
    }
    
    @GetMapping("/EliminarMedico/{id}")
    public String eliminarMedico(@PathVariable("id") Integer idMedico, RedirectAttributes redirectAttributes) {
        try {
            medicoServicio.eliminarMedico(idMedico);
            redirectAttributes.addFlashAttribute("mensaje", "Médico eliminado correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al eliminar el médico.");
        }
        return "redirect:/Vistas/ListadoMedicos";
    }
}
