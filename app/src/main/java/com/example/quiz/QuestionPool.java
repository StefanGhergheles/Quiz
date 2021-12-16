package com.example.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class QuestionPool {
    private String category;
    private List<QuizQuestion> questions = new ArrayList<>();
    private Map<String, List<QuizQuestion>> pools = new HashMap<>();

    public QuestionPool() {

        List<String> answersQ1R = new ArrayList<>();
        answersQ1R.add("Travis Scott");
        answersQ1R.add("Drake");
        answersQ1R.add("Dwayne The Rock Johnson");
        answersQ1R.add("Playboycarti");

        QuizQuestion quizQuestionR1 = new QuizQuestion("Who says \"its Lit\" and has the best apology video?",answersQ1R, 0);

        List<String> answersQ2R = new ArrayList<>();
        answersQ2R.add("Travis Scott");
        answersQ2R.add("Drake, Travis Scott");
        answersQ2R.add("Travis Scott, Baby Keem");
        answersQ2R.add("Frank Ocean, Travis Scott");

        QuizQuestion quizQuestionR2 = new QuizQuestion("Who is featured on Praise God (Donda)?",answersQ2R, 2);

        List<String> answersQ3R = new ArrayList<>();
        answersQ3R.add("Kanye");
        answersQ3R.add("Drake");
        answersQ3R.add("Polo G");
        answersQ3R.add("Pop Smoke");

        QuizQuestion quizQuestionR3 = new QuizQuestion("Who owns the Brand OVO (Octobers Very Own)?",answersQ3R, 1);

        List<String> answersQ4R = new ArrayList<>();
        answersQ4R.add("IDK");
        answersQ4R.add("Donda esta la biblioteca?");
        answersQ4R.add("Its a Kanye thing, dont question it.");
        answersQ4R.add("Its named after his Mother that passed away.");

        QuizQuestion quizQuestionR4 = new QuizQuestion("Why is Kanye's album named Donda?",answersQ4R, 3);

        List<String> answersQ5R = new ArrayList<>();
        answersQ5R.add("Welcome To The Party");
        answersQ5R.add("Hello");
        answersQ5R.add("Mood Swings");
        answersQ5R.add("Dior");

        QuizQuestion quizQuestionR5 = new QuizQuestion("Which one is Pop Smokes biggest Hit?",answersQ5R, 3);

        List<QuizQuestion> rapQuestions = new ArrayList<>();
        rapQuestions.add(quizQuestionR1);
        rapQuestions.add(quizQuestionR2);
        rapQuestions.add(quizQuestionR3);
        rapQuestions.add(quizQuestionR4);
        rapQuestions.add(quizQuestionR5);

        pools.put("Rap", rapQuestions);

        //2ND POOL

        List<String> answersQ1A = new ArrayList<>();
        answersQ1A.add("One Piece");
        answersQ1A.add("Naruto");
        answersQ1A.add("Hunter x Hunter");
        answersQ1A.add("Black Clover");

        QuizQuestion quizQuestionA1 = new QuizQuestion("What anime has the most episodes?",answersQ1A, 0);

        List<String> answersQ2A = new ArrayList<>();
        answersQ2A.add("Dumplings");
        answersQ2A.add("Sushi");
        answersQ2A.add("Noodle Soup");
        answersQ2A.add("Ramen");

        QuizQuestion quizQuestionA2 = new QuizQuestion("What is Naruto's favourite food?",answersQ2A, 3);

        List<String> answersQ3A = new ArrayList<>();
        answersQ3A.add("Colossus Titan");
        answersQ3A.add("Armored Titan");
        answersQ3A.add("Founding Titan");
        answersQ3A.add("Beast Titan");

        QuizQuestion quizQuestionA3 = new QuizQuestion("What Titan is Eren Jaeger?",answersQ3A, 2);

        List<String> answersQ4A = new ArrayList<>();
        answersQ4A.add("Black");
        answersQ4A.add("Green");
        answersQ4A.add("Blue");
        answersQ4A.add("Red");

        QuizQuestion quizQuestionA4 = new QuizQuestion("What color is Tanjiiro's Sword in Demon Slayer?",answersQ4A, 0);

        List<String> answersQ5A = new ArrayList<>();
        answersQ5A.add("he does not care");
        answersQ5A.add("tall with big ass");
        answersQ5A.add("big boobs, pretty face");
        answersQ5A.add("good personality");

        QuizQuestion quizQuestionA5 = new QuizQuestion("What kind of woman is Todo's type? (JJK)",answersQ5A, 1);

        List<QuizQuestion> animeQuestions = new ArrayList<>();
        animeQuestions.add(quizQuestionA1);
        animeQuestions.add(quizQuestionA2);
        animeQuestions.add(quizQuestionA3);
        animeQuestions.add(quizQuestionA4);
        animeQuestions.add(quizQuestionA5);

        pools.put("Anime", animeQuestions);

    }

    public List<QuizQuestion> getQuestionsByCategory(String category){
        return pools.get(category);
    }

    public String getRandomCategory(){
        List<String> categories = new ArrayList<>();
        categories.add("Rap");
        categories.add("Anime");
        Collections.shuffle(categories);
        System.out.println("im in getRandomCategory");
        return categories.get(1);
    }
}
