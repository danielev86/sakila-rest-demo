package com.firm.project.sakilarestdemo.utility;

import org.springframework.stereotype.Component;

import com.firm.project.sakilarestdemo.constants.ISakilaRestDemoConstants;

@Component
public class GenericUtility {
	
	public Integer getCategoryIdByCategoryName(String categoryName) {
		Integer categoryId = null;
		switch(categoryName.toLowerCase()) {
			case ISakilaRestDemoConstants.action_category_name :
				categoryId = 1;
				break;
			case ISakilaRestDemoConstants.animation_category_name :
				categoryId = 2;
				break;
			case ISakilaRestDemoConstants.children_category_name :
				categoryId = 3;
				break;
			case ISakilaRestDemoConstants.classics_category_name :
				categoryId = 4;
				break;
			case ISakilaRestDemoConstants.comedy_category_name :
				categoryId = 5;
				break;
			case ISakilaRestDemoConstants.documentary_category_name :
				categoryId = 6;
				break;
			case ISakilaRestDemoConstants.drama_category_name :
				categoryId = 7;
				break;
			case ISakilaRestDemoConstants.family_category_name :
				categoryId = 8;
				break;
			case ISakilaRestDemoConstants.foreign_category_name :
				categoryId = 9;
				break;
			case ISakilaRestDemoConstants.games_category_name :
				categoryId = 10;
				break;
			case ISakilaRestDemoConstants.horror_category_name :
				categoryId = 11;
				break;
			case ISakilaRestDemoConstants.music_category_name :
				categoryId = 12;
				break;
			case ISakilaRestDemoConstants.new_category_name :
				categoryId = 13;
				break;
			case ISakilaRestDemoConstants.sci_fi_category_name :
				categoryId = 14;
				break;
			case ISakilaRestDemoConstants.sports_category_name :
				categoryId = 15;
				break;
			case ISakilaRestDemoConstants.travel_category_name :
				categoryId = 16;
				break;
			default : break;
			
		}
		return categoryId;
	}

}
