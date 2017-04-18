package org.complaint.web.controller.complaint;

import javax.validation.Valid;

import org.complaint.persistence.common.entity.Employee;
import org.complaint.persistence.common.service.DepartmentService;
import org.complaint.persistence.complaint.entity.Complaint;
import org.complaint.persistence.complaint.entity.ComplaintStatus;
import org.complaint.persistence.complaint.service.ComplaintService;
import org.complaint.persistence.complaint.service.ComplaintStatusService;
import org.complaint.persistence.complaint.service.ComplaintTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/complaint")
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;

	@Autowired
	private ComplaintTypeService complaintTypeService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private ComplaintStatusService complaintStatusService;

	private void prepareNewForm(Model model) {
		model.addAttribute("complaintTypes", complaintTypeService.getAll());
		model.addAttribute("complaintStatus", complaintStatusService.getAll());
		model.addAttribute("department", departmentService.getAll());

	}

	@RequestMapping("/_create")
	public ModelAndView showForm(Model model) {
		prepareNewForm(model);
		model.addAttribute("complaint", new Complaint());
		return new ModelAndView("complaint-registration-form", "command", new Complaint());
	}

	@RequestMapping("/_editSearch")
	public ModelAndView showEditSearchForm(Model model) {
		model.addAttribute("action", "_update");
		model.addAttribute("complaints", complaintService.getAll());
		return new ModelAndView("complaint-registration-edit-search", "command", model);
	}

	@RequestMapping("/_viewSearch")
	public ModelAndView showViewSearchForm(Model model) {
		model.addAttribute("action", "_view");
		model.addAttribute("complaints", complaintService.getAll());
		return new ModelAndView("complaint-registration-view-search", "command", model);
	}

	
	@PostMapping("/_update/{id}")
	public ModelAndView showEditForm(Model model, @PathVariable(name = "id") Long id) {
		prepareNewForm(model);
		return new ModelAndView("complaint-registration-edit-form", "command", complaintService.getById(id));
	}
	
	@PostMapping("/_view/{id}")
	public ModelAndView showViewForm(Model model, @PathVariable(name = "id") Long id) {
		model.addAttribute("complaint", complaintService.getById(id).get());
		return new ModelAndView("complaint-registration-view", "command", model);
	}

	
	@PostMapping("create")
	public ModelAndView create(@Valid @ModelAttribute final Complaint complaint, final BindingResult errors,
			final Model model, final RedirectAttributes redirectAttrs) {

		if (errors.hasErrors()) {
			prepareNewForm(model);
			return new ModelAndView("complaint-registration-success", "command", model);
		}

		ComplaintStatus status = new ComplaintStatus();
		status.setName("PROCESSING");
		complaint.setStatus(status);

		Employee assignee = new Employee();
		assignee.setId(1l);
		complaint.setAssignee(assignee);

		complaintService.createComplaint(complaint);

		model.addAttribute("successMessage", "Complaint created successfully with complaint number "
				+ complaint.getCrn() + "  and it is under processing......");

		return new ModelAndView("complaint-registration-success", "command", model);
	}

	@PostMapping("update")
	public ModelAndView update(@Valid @ModelAttribute Complaint complaint, final BindingResult errors,
			final Model model, final RedirectAttributes redirectAttrs) {

		if (errors.hasErrors()) {
			prepareNewForm(model);
			return new ModelAndView("complaint-registration-success", "command", model);
		}

		complaint = complaintService.updateComplaint(complaint);

		model.addAttribute("successMessage", "Complaint updated successfully with complaint number "
				+ complaint.getCrn() + "  and Status " + complaint.getStatus().getName() + "......");

		return new ModelAndView("complaint-registration-success", "command", model);
	}

	/*
	 * @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET) public
	 * String edit(@PathVariable("id") final Integer id, Model model) {
	 * Complaint complaint = complaintService.getById(id.longValue()).get();
	 * prepareNewForm(model); model.addAttribute("complaint", complaint); return
	 * "complaint-edit"; }
	 * 
	 * @RequestMapping(value = "/update", method = RequestMethod.POST) public
	 * String update(@Valid @ModelAttribute final Complaint complaint, final
	 * BindingResult errors, final Model model, final RedirectAttributes
	 * redirectAttrs) { if (errors.hasErrors()) { prepareNewForm(model); return
	 * "complaint-edit"; } complaintService.updateComplaint(complaint);
	 * redirectAttrs.addFlashAttribute("message",
	 * "Complaint registred successfully"); return "redirect:/complaint/result/"
	 * + complaint.getId(); }
	 * 
	 * @RequestMapping(value = "/view/{id}", method = RequestMethod.GET) public
	 * String view(@PathVariable("id") final Integer id, Model model) {
	 * Complaint complaint = complaintService.getById(id.longValue()).get();
	 * prepareNewForm(model); model.addAttribute("complaint", complaint); return
	 * "complaint-view"; }
	 * 
	 * @RequestMapping(value = "/result/{id}", method = RequestMethod.GET)
	 * public String result(@PathVariable("id") final Integer id, Model model) {
	 * Complaint complaint = complaintService.getById(id.longValue()).get();
	 * model.addAttribute("complaint", complaint); return "complaint-result"; }
	 * 
	 * @RequestMapping(value = "/search/{mode}", method = RequestMethod.GET)
	 * public String search(@PathVariable("mode") final String mode, Model
	 * model) { Complaint complaint = new Complaint(); prepareNewForm(model);
	 * model.addAttribute("complaint", complaint); return "complaint-search";
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/ajaxsearch/{mode}", method =
	 * RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	 * public @ResponseBody String ajaxsearch(@PathVariable("mode") final String
	 * mode, Model model,
	 * 
	 * @ModelAttribute final Complaint complaint) { List<Complaint>
	 * searchResultList = complaintService.search(complaint); String result =
	 * new StringBuilder("{ \"data\":"
	 * ).append(toSearchResultJson(searchResultList)).append("}") .toString();
	 * return result; }
	 * 
	 * public Object toSearchResultJson(final Object object) { final GsonBuilder
	 * gsonBuilder = new GsonBuilder(); final Gson gson =
	 * gsonBuilder.registerTypeAdapter(Complaint.class, new
	 * ComplaintJsonAdaptor()).create(); final String json =
	 * gson.toJson(object); return json; }
	 * 
	 * 
	 * @PostMapping("create")
	 * 
	 * @ResponseBody public String create(@ModelAttribute Complaint complaint,
	 * BindingResult bindingResult) {
	 * 
	 * ResponseEntity<?> errorResponseEntity =
	 * validateComplaintRequest(complaint, bindingResult); if
	 * (errorResponseEntity != null) return "";
	 * 
	 * return "";//
	 * getSuccessResponseForCreate(complaintService.createComplaint(complaint));
	 * }
	 * 
	 * @PostMapping("/{id}/_update")
	 * 
	 * @ResponseBody public ResponseEntity<?> update(@RequestBody Complaint
	 * complaint, BindingResult bindingResult,
	 * 
	 * @PathVariable(name = "id") Long id) {
	 * 
	 * ResponseEntity<?> errorResponseEntity =
	 * validateComplaintRequest(complaint, bindingResult); if
	 * (errorResponseEntity != null) return errorResponseEntity;
	 * complaint.setId(id); return
	 * getSuccessResponseForCreate(complaintService.updateComplaint(complaint));
	 * }
	 * 
	 * @GetMapping("_search")
	 * 
	 * @ResponseBody public ResponseEntity<?> search() { return
	 * getSuccessResponseForSearch(complaintService.getAll()); } private
	 * ResponseEntity<?> validateComplaintRequest(Complaint complaint,
	 * BindingResult bindingResult) { // validate input params that can be
	 * handled by annotations if (bindingResult.hasErrors()) { return
	 * errorHandler.getErrorResponseEntityForBindingErrors(bindingResult); }
	 * return null; }
	 * 
	 * public ResponseEntity<?> getSuccessResponseForSearch(List<Complaint>
	 * complaintStatuss) { return new
	 * ResponseEntity<List<Complaint>>(complaintStatuss, HttpStatus.OK); }
	 * 
	 * public ResponseEntity<?> getSuccessResponseForCreate(Complaint complaint)
	 * { return new ResponseEntity<Complaint>(complaint, HttpStatus.OK); }
	 */
}