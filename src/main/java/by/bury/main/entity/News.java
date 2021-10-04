package by.bury.main.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "news")
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    @NotBlank(message = "The \"title\" field cannot be empty or consist only of spaces")
    private String title;
    @NotBlank(message = "The \"brief\" field cannot be empty or consist only of spaces")
    @Column(name = "brief")
    private String brief;
    @NotBlank(message = "The \"content\" field cannot be empty or consist only of spaces")
    @Size(min=10, message = "The \"content\" field must be at least 10 characters long")
    @Column(name = "content")
    private String content;

    @Column(name = "date_registration")
    private String dateRegistration;

    public News() {
    }

    public News(String title, String brief, String content, String dateRegistration) {
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.dateRegistration = dateRegistration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(String dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id && Objects.equals(title, news.title)
                && Objects.equals(brief, news.brief)
                && Objects.equals(content, news.content)
                && Objects.equals(dateRegistration, news.dateRegistration);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((brief == null) ? 0 : brief.hashCode());
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((dateRegistration == null) ? 0 : dateRegistration.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + '@'
                + "Id: " + id
                + ", title: " + title
                + ", brief: " + brief
                + ", dateRegistration: " + dateRegistration;
    }
}
