package br.com.tw.lunchandlearn.domain;

public class LunchAndLearn {

    public String date;
    public String name;
    public String title;

    public LunchAndLearn(String date, String name, String title) {
        this.date = date;
        this.name = name;
        this.title = title;
    }

    public LunchAndLearn() {
    }

    @Override
    public String toString() {
        return "{" +
                "date:'" + date + '\'' +
                ", name:'" + name + '\'' +
                ", title:'" + title + '\'' +
                '}';
    }

}
