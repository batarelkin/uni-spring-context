package com.example.spring.sample4.services;

import com.example.spring.sample4.model.User;

/**
 * Сервис по работе с пользователями
 */
public interface UserService {

    /**
     * Получение пользователя по идентификатору
     * @param id идентификатор пользователя
     * @return пользователь
     */
    public User getUser(long id);

    /**
     * Удаление пользователя по идентификатору
     * @param id идентификатор пользователя
     * @return true, если пользователь был удален, false в противном случае
     */
    public boolean deleteUser(long id);

    /**
     * Создание пользователя
     * @param user данные нового пользователя.
     * @return созданный пользователь
     */
    public User createUser(User user);
}
