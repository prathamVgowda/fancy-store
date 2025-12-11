package com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Color;
import com.shop.repository.ColorRepository;
import com.shop.service.ColorService;

@Service
public class ColorServiceImple implements ColorService
{

	@Autowired
	private ColorRepository colorRepository;
	
	
	@Override
	public Color createColor(Color color) {
		
		Color color2 = colorRepository.save(color);
		return color2;
	}

	@Override
	public Color getByIdColor(Long colorId) 
	{
		Color color = colorRepository.findById(colorId).orElseThrow(() -> new RuntimeException("Color not found"));
		return color;
	}

	@Override
	public List<Color> getAllColor() 
	{
		List<Color> colors = colorRepository.findAll();
		return colors;
	}

	@Override
	public Color updateByColor(Long colorId, Color color) 
	{
		Color color2 = colorRepository.findById(colorId).orElseThrow(() -> new RuntimeException("Color not found"));
		color2.setColorName(color.getColorName());
		return colorRepository.save(color2);
	}

	@Override
	public String deleteByColor(Long colorId) {
		
		colorRepository.deleteById(colorId);
		return "Deleted Successfully";
	}

}
