package com.davos.core.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.davos.core.entity.*;

@Controller
@RequestMapping("/registro")
public class InicioControlador {

	/*
	 * @RequestMapping("/login") private String login(Usuario usuario) {
	 * 
	 * return "login";
	 * 
	 * }
	 * 
	 * @RequestMapping("/principal") private String irAPrincipal() {
	 * 
	 * return "principal";
	 * 
	 * }
	 * 
	 * @PostMapping("/principal") private String
	 * iniciarSesion(@ModelAttribute("usuario") Usuario intentoUsuario) {
	 * 
	 * List<Usuario> usuarios = usuarioDAO.getUsuarios();
	 * 
	 * String pagina = "redirect:/registro/login";
	 * 
	 * for (Usuario usuario : usuarios) {
	 * 
	 * if ((usuario.getNombre().equals(intentoUsuario.getNombre())) &&
	 * (usuario.getPassword().equals(intentoUsuario.getPassword()))) { pagina =
	 * "principal"; }
	 * 
	 * }
	 * 
	 * return pagina; }
	 * 
	 * @RequestMapping("/agregarCliente") private String agregarCliente(Cliente
	 * cliente) {
	 * 
	 * return "formulario-cliente";
	 * 
	 * }
	 * 
	 * @PostMapping("/insertaCliente") private String
	 * insertaCliente(@Valid @ModelAttribute("cliente") Cliente cliente,
	 * BindingResult resultadoValidacion) {
	 * 
	 * if (resultadoValidacion.hasErrors()) { return "formulario-cliente"; } else {
	 * clienteDAO.insertaCliente(cliente);
	 * 
	 * return "redirect:/registro/principal"; } }
	 * 
	 * @RequestMapping("/verClientes") private String verClientes(Model model) {
	 * List<Cliente> clientes = clienteDAO.getClientes();
	 * 
	 * model.addAttribute("clientes", clientes);
	 * 
	 * return "lista-clientes"; }
	 * 
	 * @RequestMapping("/agregarMercaderia") private String
	 * agregarMercaderia(Mercaderia mercaderia) {
	 * 
	 * return "formulario-mercaderia";
	 * 
	 * }
	 * 
	 * @PostMapping("/insertaMercaderia") private String
	 * insertaMercaderia(@Valid @ModelAttribute("mercaderia") Mercaderia mercaderia,
	 * BindingResult resultadoValidacion) {
	 * 
	 * if (resultadoValidacion.hasErrors()) { return "formulario-mercaderia"; } else
	 * { mercaderiaDAO.insertaMercaderia(mercaderia);
	 * 
	 * return "redirect:/registro/principal"; }
	 * 
	 * }
	 * 
	 * @RequestMapping("/agregarVentas") private String agregarVentas(Model model) {
	 * 
	 * VentaAIngresar venta = new VentaAIngresar(); List<Cliente> clientes =
	 * clienteDAO.getClientes(); List<Mercaderia> mercaderias =
	 * mercaderiaDAO.getMercaderias(); List<Vendedor> vendedores =
	 * vendedorDAO.getVendedores();
	 * 
	 * model.addAttribute("venta", venta); model.addAttribute("clientes", clientes);
	 * model.addAttribute("mercaderias", mercaderias);
	 * model.addAttribute("vendedores", vendedores); model.addAttribute("vendedor",
	 * new Vendedor());
	 * 
	 * return "formulario-venta";
	 * 
	 * }
	 * 
	 * @PostMapping("/insertaVenta") private String
	 * insertaVenta(@Valid @ModelAttribute("venta") VentaAIngresar venta,
	 * BindingResult resultadoValidacion) {
	 * 
	 * ventaDAO.insertarVenta(venta);
	 * 
	 * return "redirect:/registro/agregarVentas"; }
	 * 
	 * @RequestMapping("/verVentas") private String verVentas(Model model) {
	 * List<Cliente> clientes = clienteDAO.getClientes();
	 * 
	 * model.addAttribute("clientes", clientes); model.addAttribute("ventas", new
	 * ArrayList<Venta>());
	 * 
	 * return "lista-ventas"; }
	 * 
	 * @GetMapping("/buscarPorCliente") public String
	 * buscarPorCliente(@RequestParam("idCliente") int id, Model elModelo) {
	 * List<Cliente> clientes = clienteDAO.getClientes();
	 * 
	 * elModelo.addAttribute("ventas", clienteDAO.getVentas(id));
	 * elModelo.addAttribute("clientes", clientes);
	 * 
	 * // enviar al formulario
	 * 
	 * return "lista-ventas"; }
	 * 
	 * @GetMapping("/buscarPorFecha") public String
	 * buscarPorFecha(@RequestParam("fecha") String fechaString, Model elModelo) {
	 * List<Cliente> clientes = clienteDAO.getClientes();
	 * 
	 * elModelo.addAttribute("ventas", clienteDAO.getVentas(fechaString));
	 * elModelo.addAttribute("clientes", clientes);
	 * 
	 * // enviar al formulario
	 * 
	 * return "lista-ventas"; }
	 * 
	 * @Autowired private UsuarioDAO usuarioDAO;
	 * 
	 * @Autowired private ClienteDAO clienteDAO;
	 * 
	 * @Autowired private MercaderiaDAO mercaderiaDAO;
	 * 
	 * @Autowired private VendedorDAO vendedorDAO;
	 * 
	 * @Autowired private VentaDAO ventaDAO;
	 */
}
