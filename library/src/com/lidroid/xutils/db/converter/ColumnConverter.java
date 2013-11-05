package com.lidroid.xutils.db.converter;

import android.database.Cursor;

/**
 * Author: wyouflf
 * Date: 13-11-4
 * Time: 下午8:57
 */
public interface ColumnConverter<T, E> {

    T getFiledValue(E entity, Cursor cursor, int index);

    Object fieldValue2ColumnValue(E entity, T fieldValue);

    String getColumnDbType();
}