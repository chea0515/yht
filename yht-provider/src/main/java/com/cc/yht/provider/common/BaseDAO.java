package com.cc.yht.provider.common;

import java.util.ArrayList;

public interface BaseDAO {
    /**
     * get bean .
     * @param <T> return params.
     * @param <V> input params.
     * @return T
     */
    <T, V> T select(V v);

    /**
     *
     * @param <T> return params.
     * @param <V> input params.
     * @return ArrayList<T>
     */
    <T, V> ArrayList<T> selectList(V v);

    /**
     * count bean total num.
     * @param <V> input params.
     * @return Integer.
     */
    <V> Integer count(V v);

    /**
     * save bean .
     * @param <V> input params.
     * @return Integer.
     */
    <V> Integer save(V v);

    /**
     * update bean.
     * @param <V> input params.
     * @return Integer.
     */
    <V> Integer update(V v);

    /**
     * delete bean .
     * @param <V>  input params.
     * @return Integer.
     */
    <V> Integer delete(V v);

    /**
     * sql 动态封装
     */
    /*
    class UserSQLProvider {

        public String getUserList(String name) {

            return new SQL() {
                {
                    SELECT("*");
                    FROM("t_user");
                    if (!StringUtils.isEmpty(name)) {
                        WHERE("name = #{name}");
                    }
                }
            }.toString();
        }
    }*/
}
