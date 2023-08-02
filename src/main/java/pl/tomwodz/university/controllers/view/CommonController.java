package pl.tomwodz.university.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.tomwodz.university.services.IMeetingViewModelService;

@Controller
public class CommonController {

    private final IMeetingViewModelService meetingViewModelService;

    public CommonController(IMeetingViewModelService meetingViewModelService) {
        this.meetingViewModelService = meetingViewModelService;
    }

   @GetMapping("/")
    public String main(Model model){
            model.addAttribute("meetings", this.meetingViewModelService.findAll());
        return "index";
    }

}
