package com.example.geoquiz

import android.util.Log

class QuestionHelper {
    private val qList = ArrayList<Ques>()

    public fun uploadQuestion(){
        val rawQuestions: ArrayList<String> = arrayListOf(
            "The Earth is flat.", "false",
            "The Great Wall of China is visible from space.", "false",
            "The human brain stops growing after a certain age.", "false",
            "Goldfish have a three-second memory span.", "false",
            "Penguins can fly.", "false",
            "The Sun is a planet.", "false",
            "Mount Everest is the tallest mountain in the world.", "true",
            "The Eiffel Tower was originally intended to be a temporary structure.", "true",
            "Bananas are berries.", "true",
            "The moon emits its own light.", "false",
            "The speed of light is faster than the speed of sound.", "true",
            "Water boils at 100 degrees Celsius at sea level.", "true",
            "A group of crows is called a murder.", "true",
            "Octopuses have three hearts.", "true",
            "The Sahara Desert is the largest desert in the world.", "false",
            "The Atlantic Ocean is the largest ocean on Earth.", "false",
            "Lightning never strikes the same place twice.", "false",
            "Humans use only 10% of their brains.", "false",
            "Venus is the hottest planet in our solar system.", "true",
            "The Statue of Liberty was a gift from France.", "true",
            "The Mona Lisa has no eyebrows.", "true",
            "DNA stands for Deoxyribonucleic Acid.", "true",
            "The Pacific Ring of Fire is known for its frequent volcanic activity.", "true",
            "Honey never spoils.", "true",
            "Leonardo da Vinci painted the Sistine Chapel ceiling.", "false",
            "A day on Mars is shorter than a day on Earth.", "true",
            "Bees can recognize human faces.", "true",
            "The currency of Japan is the yuan.", "false",
            "Neil Armstrong was the first person to step on the moon.", "true",
            "All the planets in our solar system rotate counterclockwise.", "false",
            "Jupiter is primarily composed of gas.", "true",
            "The Amazon River is the longest river in the world.", "false",
            "The Wright brothers invented the first successful airplane.", "true",
            "The Great Barrier Reef is the largest coral reef system.", "true",
            "Spiders are insects.", "false",
            "Cheetahs are the fastest land animals.", "true",
            "The Sahara Desert was once a lush, green landscape.", "true",
            "Thomas Edison invented the light bulb.", "true",
            "Albert Einstein failed mathematics in school.", "false",
            "Ostriches bury their heads in the sand when scared.", "false",
            "Watermelons are berries.", "true",
            "The human body has 206 bones.", "false",
            "New York City is the capital of the United States.", "false",
            "Beethoven was deaf when he composed his Ninth Symphony.", "true",
            "The moon has a dark side that never receives sunlight.", "false",
            "An ostrich's eye is bigger than its brain.", "true",
            "The leaning Tower of Pisa is leaning because of an intentional design.", "false",
            "George Washington had wooden teeth.", "false",
            "The coldest temperature ever recorded on Earth was in Antarctica.", "true",
            "The Red Sea is blue.", "true",
            "The piano was invented by Wolfgang Amadeus Mozart.", "false",
            "Snakes can blink.", "false",
            "Pluto is considered a planet.", "false",
            "The Great Pyramid of Giza was built by slaves.", "false",
            "A centipede has 100 legs.", "false",
            "Pineapples grow on trees.", "false",
            "The Earth's core is made of iron and nickel.", "true",
            "Water is a good conductor of electricity.", "false",
            "The color of a polar bear's skin is black.", "true",
            "The speed of sound is faster in water than in air.", "true",
            "Honeybees can recognize human faces.", "true",
            "The longest river in South America is the Amazon River.", "true",
            "Napoleon Bonaparte was extremely tall.", "false",
            "Dolphins are fish.", "false",
            "The longest bone in the human body is the femur.", "true",
            "Thomas Jefferson was the first President of the United States.", "false",
            "The Great Wall of China was built to keep invaders out.", "true",
            "Diamonds are made from compressed coal.", "false",
            "The Venus Flytrap only eats flies.", "false",
            "A group of flamingos is called a flamboyance.", "true",
            "The Eiffel Tower is made of iron.", "true",
            "The longest river in the world is the Nile River.", "false"

        )
        for(i in rawQuestions.indices step 2){
            var temp_ans:Boolean
            if(rawQuestions[i+1].equals("false")){
                temp_ans=false;
            } else{
                temp_ans=true;
            }
            val q:Ques=Ques(rawQuestions[i],temp_ans)
            //Log.d("bugger",q.getQ())
            addQuestion(q)
        }

    }
    public fun addQuestion(q:Ques){
        qList.add(q)
    }
    public fun getRandomQuestion():Ques{
        var temp=qList.random()
        qList.remove(temp)
        return temp
    }

}

