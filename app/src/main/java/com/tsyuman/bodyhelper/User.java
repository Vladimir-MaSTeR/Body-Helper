package com.tsyuman.bodyhelper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    /** Идентификатор пользователя */
    private Long id;
    /** Имя пользователя */
    private String name;
    /** Фамилия пользователя */
    private String surname;
    /** Текущий вес пользователя */
    private String currentWeigh;
    /** Желаемый вес пользователя */
    private String desiredWeight;
    /** Калории на день пользователя */
    private String caloriesPerDay;
    /** Кол. приемов пищи в день пользователя */
    private String numberOfMeals;

}
