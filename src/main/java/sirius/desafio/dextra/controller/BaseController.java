package sirius.desafio.dextra.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sirius.desafio.dextra.model.Ingrediente;
import sirius.desafio.dextra.model.Lanche;
import sirius.desafio.dextra.model.ModelManager;


@Controller
public class BaseController {

	private static int counter = 0;
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);
	private static ModelManager db = new ModelManager();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(HttpServletRequest request, ModelMap model) {
		logger.debug(request.getLocalAddr() + " - " + request.getRequestURI());

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";

	}

	
	/**
	 * Requests Lanches */

	@RequestMapping(value="/lanches/new", method = RequestMethod.GET)
	public String getAddLanchePage(HttpServletRequest request, ModelMap model) {
		logger.debug(request.getLocalAddr() + " - " + request.getRequestURI());
		model.addAttribute("listIngredientes",  new ArrayList<Ingrediente>(db.getMapIngredientes().values()));
		return "add_lanche";
	}
	
	@RequestMapping(value="/lanches/add", method = RequestMethod.POST)
	public ModelAndView addLanche(HttpServletRequest request, ModelMap model) {
		logger.debug(request.getLocalAddr() + " - " + request.getRequestURI());
		try {
			String nome = request.getParameter("nome");
			Lanche l = new Lanche(nome);
			for (String key : db.getMapIngredientes().keySet()) {
				for (int i = 0; i < Integer.parseInt(request.getParameter("qtd_" + key)); i++)
					l.addIngrediente(db.getMapIngredientes().get(key)); 
			}
			db.getMapLanches().put(nome, l);
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
        return new ModelAndView("redirect:list");
	}

	@RequestMapping(value="/lanches/update/{nome}", method = RequestMethod.GET)
	public String getUpdateLanchesPage(HttpServletRequest request, @PathVariable String nome, ModelMap model) {
		logger.debug(request.getLocalAddr() + " - " + request.getRequestURI());
		try {
			Lanche l = db.getMapLanches().get(nome);
			if (l != null) { 
				model.addAttribute("lanche",  l);
				model.addAttribute("listIngredientes",  new ArrayList<Ingrediente>(db.getMapIngredientes().values()));
				return "update_lanche";
			}
			else {
				return "add_lanche";
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@RequestMapping(value="/lanches/update", method = RequestMethod.POST)
	public ModelAndView updateLanches(HttpServletRequest request, ModelMap model) {
		logger.debug(request.getLocalAddr() + " - " + request.getRequestURI());
		try {
			String nomeOriginal =  request.getParameter("nomeOriginal");
			Lanche l = db.getMapLanches().get(nomeOriginal);
			l.getListIngredientes().clear();
			for (String key : db.getMapIngredientes().keySet()) {
				for (int i = 0; i < Integer.parseInt(request.getParameter("qtd_" + key)); i++)
					l.addIngrediente(db.getMapIngredientes().get(key)); 
			}
			
			String nome = request.getParameter("nome");
			l.setNome(nome);
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
        return new ModelAndView("redirect:list");
	}
	
	@RequestMapping(value="/lanches/delete/{name}", method = RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest request, @PathVariable String name, ModelMap model) {
		logger.debug(request.getLocalAddr() + " - " + request.getRequestURI());
		db.getMapLanches().remove(name);
        return new ModelAndView("redirect:../list");
	}


	@RequestMapping(value="/lanches/list", method = RequestMethod.GET)
	public String listCustomer(HttpServletRequest request, ModelMap model) {
		logger.debug(request.getLocalAddr() + " - " + request.getRequestURI());
	    model.addAttribute("listLanches",  new ArrayList<Lanche>(db.getMapLanches().values()));
		return "list_lanches";
	}
	
	
	/**
	 * ############################################################################################################################################################
	 * Requests ingredientes.
	 * ############################################################################################################################################################
	 * */

	@RequestMapping(value="/ingredientes/new", method = RequestMethod.GET)
	public String getAddIngredientePage(HttpServletRequest request, ModelMap model) {
		logger.debug(request.getLocalAddr() + " - " + request.getRequestURI());
		return "add_ingrediente";
	}
	
	@RequestMapping(value="/ingredientes/add", method = RequestMethod.POST)
	public ModelAndView addIngrediente(HttpServletRequest request, ModelMap model) {
		logger.debug(request.getLocalAddr() + " - " + request.getRequestURI());

	    try {
	    	String nome = request.getParameter("nome");
			String valor = request.getParameter("valor");
	    	db.getMapIngredientes().put(nome, new Ingrediente(nome, Double.parseDouble(valor)));
	    }
	    catch (Exception e) {
	    	System.err.println(e.getMessage());
	    }
        return new ModelAndView("redirect:list");
	}

	@RequestMapping(value="/ingredientes/update/{nome}", method = RequestMethod.GET)
	public String getUpdateIngredientePage(HttpServletRequest request, @PathVariable String nome, ModelMap model) {
		logger.debug(request.getLocalAddr() + " - " + request.getRequestURI());
		try {
			Ingrediente i = db.getMapIngredientes().get(nome);
			if (i != null) { 
				model.addAttribute("ingrediente",  i);
				return "update_ingrediente";
			}
			else {
				return "add_ingrediente";
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@RequestMapping(value="/ingredientes/update", method = RequestMethod.POST)
	public ModelAndView updateIngrediente(HttpServletRequest request, ModelMap model) {
		logger.debug(request.getLocalAddr() + " - " + request.getRequestURI());
		try {
			String nome = request.getParameter("nome");
			String valor = request.getParameter("valor");
			String nomeOriginal =  request.getParameter("nomeOriginal");
			Ingrediente i = db.getMapIngredientes().get(nomeOriginal);
			i.setNome(nome);
			i.setValor(Double.parseDouble(valor));
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
        return new ModelAndView("redirect:list");
	}
	
	@RequestMapping(value="/ingredientes/delete/{name}", method = RequestMethod.GET)
	public ModelAndView deleteIngrediente(HttpServletRequest request, @PathVariable String name, ModelMap model) {
		logger.debug(request.getLocalAddr() + " - " + request.getRequestURI());
		db.getMapIngredientes().remove(name);
        return new ModelAndView("redirect:../list");
	}


	@RequestMapping(value="/ingredientes/list", method = RequestMethod.GET)
	public String listIngrediente(HttpServletRequest request, ModelMap model) {
		logger.debug(request.getLocalAddr() + " - " + request.getRequestURI());
	    model.addAttribute("listIngredientes",  new ArrayList<Ingrediente>(db.getMapIngredientes().values()));
		return "list_ingredientes";
	}

	
	

}