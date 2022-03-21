package LikeLion.example.LikeLion3.weeks1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("view")
public class SampleController {
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("/sample-jsp")  // jsp파일로 만듦
    public String sampleJsp(Model model) {
        logger.info("in sample jsp");
        List<SamplePayload> profiles = new ArrayList<>();
        profiles.add(new SamplePayload("Adam", 22, "Student"));
        profiles.add(new SamplePayload("Bradley", 29, "Accountant"));
        profiles.add(new SamplePayload("Charlie", 33, "Developer"));

        model.addAttribute("profiles", profiles);
        return "view-jsp";
    }

    @GetMapping("/sample-thyme")    // thyme(html)파일로 만듬
    public ModelAndView sampleThyme() {
        logger.info("in sample jsp");
        ModelAndView modelAndView = new ModelAndView();
        List<SamplePayload> profiles = new ArrayList<>();
        profiles.add(new SamplePayload("Adam", 22, "Student"));
        profiles.add(new SamplePayload("Bradley", 29, "Accountant"));
        profiles.add(new SamplePayload("Charlie", 33, "Developer"));

        modelAndView.addObject("profiles", profiles);
        modelAndView.setViewName("view-thyme");
        return modelAndView;
    }
}
