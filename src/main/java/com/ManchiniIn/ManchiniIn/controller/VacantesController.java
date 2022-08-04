package com.ManchiniIn.ManchiniIn.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ManchiniIn.ManchiniIn.model.Categoria;
import com.ManchiniIn.ManchiniIn.model.Vacante;
import com.ManchiniIn.ManchiniIn.service.ICategoriaService;
import com.ManchiniIn.ManchiniIn.service.IVacanteService;
import com.ManchiniIn.ManchiniIn.util.Utileria;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Value("${JuanchiniIn.ruta.imagenes}")
	private String ruta;

	@Autowired
	private IVacanteService serviceVacantes;

	@Autowired
	@Qualifier("categoriasServiceJpa")
	private ICategoriaService serviceCategorias;

	@GetMapping("/create")
	public String crear(Vacante vacante, Model model) {

		return "vacantes/formVacante";
	}

//	@PostMapping("/save")
//	public String guardar(@RequestParam("nombre") String nombre,
//			@RequestParam("descripcion") String descripcion, 
//			@RequestParam("estatus") String estatus, 
//			@RequestParam("fecha") String fecha, 
//			@RequestParam("destacado") Integer destacado, 
//			@RequestParam("salario") Double salario, 
//			@RequestParam("detalles") String detalles) {
//		
//		System.out.println(nombre);
//		System.out.println(descripcion);
//		System.out.println(estatus);
//		System.out.println(fecha);
//		System.out.println(destacado);
//		System.out.println(salario);
//		System.out.println(detalles);
//
//		return "vacantes/listVacantes";
//	}

	@GetMapping("/index")
	public String mostarIndex(Model model) {
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);

		return "vacantes/listVacantes";
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Vacante> lista = serviceVacantes.buscarTodas(page);
		model.addAttribute("vacantes", lista);
		return "vacantes/listVacantes";
	}

	@PostMapping("/save")
	public String guardar(Vacante vacante, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "vacantes/formVacante";
		}

		if (!multiPart.isEmpty()) {
			// String ruta = "/empleos/img-vacantes/"; // Linux/MAC
			// String ruta = "c:/empleos/img-vacantes/"; // Windows
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null) { // La imagen si se subio
				// Procesamos la variable nombreImagen
				vacante.setImagen(nombreImagen);
			}
		}

		serviceVacantes.guardar(vacante);
		attributes.addFlashAttribute("msg", "Vacante guardada");
		System.out.println(vacante.toString());
		return "redirect:/vacantes/index";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idVacante, RedirectAttributes attributes) {
		serviceVacantes.eliminar(idVacante);
		attributes.addFlashAttribute("msg", "La vacante fue eliminada correctamente");
		return "redirect:/vacantes/index";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idVacante, Model model) {
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);
		model.addAttribute("vacante", vacante);
		return "vacantes/formVacante";
	}

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") Integer idVacante, Model model) {
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);

		System.out.println("Vacante: " + vacante);
		model.addAttribute("vacante", vacante);
		// buscar los detalles de la vacante en la BD
		return "detalle";
	}

	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("categorias", serviceCategorias.buscarTodas());
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
