package apim.github.tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {

	@Autowired
	private MessageSource messageSource;

	private RegistrationValidator validator;

	@Autowired
	public void setValidator(RegistrationValidator validator) {
		this.validator = validator;
	}

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	private String label(String key) {
		return messageSource.getMessage(key, null, null);
	}

	@ModelAttribute("classList")
	public List<String> populateClasses() {
		List<String> list = new ArrayList<>();
		list.add(label("reference.morning"));
		list.add(label("reference.afternoon"));
		list.add(label("reference.evening"));
		return list;
	}

	@ModelAttribute("campusList")
	public List<String> populateCampuses() {
		List<String> list = new ArrayList<>();
		list.add(label("reference.campus1"));
		list.add(label("reference.campus2"));
		list.add(label("reference.campus3"));
		list.add(label("reference.campus4"));
		return list;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String initialize(Map<String, Object> model) {
		RegistrationData regData = new RegistrationData();
		regData.setSex(label("sex.male.label"));
		regData.setCampus(label("reference.campus2"));
		model.put("regData", regData);
		return "register";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String registerStudent(Map<String, Object> model, @Valid @ModelAttribute("regData") RegistrationData regData,
			BindingResult result, RedirectAttributes ra) {
		if (result.hasErrors()) {
			return "register";
		}
		return "redirect:/result";
	}

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String view(Map<String, Object> model) {
		model.put("serverMsg", "Registration Successful");
		return "result";
	}

}
