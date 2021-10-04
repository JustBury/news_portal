package by.bury.main.controller;

import by.bury.main.entity.News;
import by.bury.main.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping()
public class PortalController {

    private final static String NEWS = "news";
    private final static String NEWSES = "newses";
    private final static String NEWS_ID = "newsId";


    @Autowired
    private NewsService newsService;

    @RequestMapping("/")
    public String getAllNews(Model model) {
        List<News> newses = newsService.getNewses();
        model.addAttribute(NEWSES, newses);
        return "main-page";
    }

    @RequestMapping("/getNews")
    public String getNews(@RequestParam(NEWS_ID) int id, Model model) {
        News news = newsService.getNews(id);
        model.addAttribute(NEWS, news);
        return "news-content";
    }

    @RequestMapping("/addNewNews")
    public String addNewEmployee(Model model) {
        News news = new News();
        model.addAttribute(NEWS, news);
        return "news-info";
    }

    @PostMapping("/saveNews")
    public String saveNews(@Valid @ModelAttribute(NEWS) News news, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.hasErrors());
            return "news-info";
        } else {
            System.out.println(bindingResult.hasErrors());
            newsService.saveNews(news);
            return "redirect:/";
        }
    }

    @RequestMapping("/updateNews")
    public String updateEmployee(@RequestParam(NEWS_ID) int id, Model model) {
        News news = newsService.getNews(id);
        model.addAttribute(NEWS, news);
        return "news-info";
    }

    @RequestMapping("/deleteNews")
    public String deleteEmployee(@RequestParam(NEWS_ID) int id) {
        newsService.delete(id);
        return "redirect:/";
    }
}
