package by.bury.main.service;

import by.bury.main.dao.NewsDAO;
import by.bury.main.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    private NewsDAO newsDAO;

    @Override
    @Transactional
    public void saveNews(News news) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        news.setDateRegistration(sdf.format(date));
        newsDAO.saveNews(news);
    }

    @Override
    @Transactional
    public News getNews(int id) {
        return newsDAO.getNews(id);
    }

    @Override
    @Transactional
    public List<News> getNewses() {
        return newsDAO.getNewses();
    }

    @Override
    @Transactional
    public void delete(int id) {
        newsDAO.delete(id);
    }
}
