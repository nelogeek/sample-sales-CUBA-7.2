package com.company.sales.service

import jdk.internal.org.jline.utils.Log


class Emailer {




    def template = "Уважаемый $firstName $lastName!\n" +
            "Поздравляем вас С Днём Рождения!\n" +
            "С уважением, ваш $autoservice";
    def binding = ["firstТame":"Sam", "lastТame":"Pullara", "autoservice":"топСТО"]


    def engine = SimpleTemplateEngine().engine.createTemplate(template).make(binding)





}
