package com.example.isaquecoelho.tourguideapp.repository;

import android.arch.lifecycle.MutableLiveData;

import com.example.isaquecoelho.tourguideapp.R;
import com.example.isaquecoelho.tourguideapp.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsRepository {

    private static NewsRepository instace;
    private ArrayList<News> newsDataSet = new ArrayList<>();

    public static NewsRepository getInstace(){
        if (instace == null){
            instace = new NewsRepository();
        }

        return instace;
    }

    public void clearNewsList(){
        newsDataSet.clear();
    }

    // Pretend to get data from a webservice or Firebase
    public MutableLiveData<List<News>> getNewsList(){

        buildNewsList();
        MutableLiveData<List<News>> newsData = new MutableLiveData<>();
        newsData.setValue(newsDataSet);

        return newsData;
    }

    private void buildNewsList(){

        newsDataSet.add(new News(
                "Notícias de Hortolândia",
                "Dell está com nova oportunidade de emprego em Hortolândia",
                R.drawable.ic_news_first,
                "http://noticiasdehortolandia.com.br/cidade/dell-esta-com-nova-oportunidade-de-emprego-em-hortolandia/"
        ));

        newsDataSet.add(new News(
                "Notícias de Hortolândia",
                "Aulas gratuitas de natação e hidroginástica: faça sua inscrição",
                R.drawable.ic_news_second,
                "http://noticiasdehortolandia.com.br/cidade/aulas-gratuitas-de-natacao-e-hidroginastica-faca-sua-inscricao/"
        ));

        newsDataSet.add(new News(
                "Notícias de Hortolândia",
                "Semana começa com chuva, ventos, raios e granizo em Hortolândia",
                R.drawable.ic_news_third,
                "http://noticiasdehortolandia.com.br/cidade/semana-comeca-com-chuva-raios-e-granizo-em-hortolandia/"
        ));

        newsDataSet.add(new News(
                "Notícias de Hortolândia",
                "Alunos da rede municipal receberão material escolar no início das aulas",
                R.drawable.ic_news_fourth,
                "http://noticiasdehortolandia.com.br/cidade/alunos-da-rede-municipal-receberao-material-escolar-no-inicio-das-aulas/"
        ));

    }

}
