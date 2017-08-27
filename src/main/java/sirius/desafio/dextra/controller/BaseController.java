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
import sirius.desafio.dextra.model.ModelManager;


@Controller
public class BaseController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);
	private static ModelManager db = new ModelManager();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", ++counter);
		logger.debug("[welcomeName] counter : {}", counter);
		return VIEW_INDEX;

	}
	
	
	
	
	
	

	@RequestMapping(value="/ingredientes/new", method = RequestMethod.GET)
	public String getAddCustomerPage(ModelMap model) {
		return "add_ingrediente";
	}
	
	@RequestMapping(value="/ingredientes/add", method = RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request, ModelMap model) {

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
	public String getUpdateCustomerPage(@PathVariable String nome, ModelMap model) {
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
	public ModelAndView update(HttpServletRequest request, ModelMap model) {
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
	public ModelAndView delete(@PathVariable String name, ModelMap model) {
		db.getMapIngredientes().remove(name);
        return new ModelAndView("redirect:../list");
	}


	@RequestMapping(value="/ingredientes/list", method = RequestMethod.GET)
	public String listCustomer(ModelMap model) {
	    model.addAttribute("listIngredientes",  new ArrayList<Ingrediente>(db.getMapIngredientes().values()));
		return "list_ingredientes";
	}

	
	

}