package com.shop.service;

import java.util.List;

import com.shop.entity.Color;

public interface ColorService {

    Color createColor(Color color);

    Color getByIdColor(Long colorId);

    List<Color> getAllColor();

    Color updateByColor(Long colorId, Color color);

    String deleteByColor(Long colorId);
}

