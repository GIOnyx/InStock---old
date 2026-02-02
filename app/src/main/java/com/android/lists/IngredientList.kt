package com.android.lists

import com.android.data.IngredientCategory
import com.android.data.Ingredients
import com.android.readysetcook.R

object IngredientList {
    val listOfIngredientCategory = mutableListOf(

        IngredientCategory(1, "Dairy", listOf(
            Ingredients(R.drawable.butter, "Butter", allergens = listOf("Dairy"), variants = listOf("Unsalted Butter", "Salted Butter")),
            Ingredients(R.drawable.cheese, "Cheese", allergens = listOf("Dairy"), variants = listOf("Cheddar Cheese", "Mozzarella Cheese", "Parmesan Cheese","Feta Cheese","Ricotta Cheese", "Ricotta cheese")),
            Ingredients(R.drawable.cream, "Cream", allergens = listOf("Dairy"), variants = listOf("Heavy Cream", "Whipping Cream", "Sour Cream")),
            Ingredients(R.drawable.cream_cheese, "Cream Cheese", allergens = listOf("Dairy")),
            Ingredients(R.drawable.milk, "Milk", allergens = listOf("Dairy"), variants = listOf("Whole Milk", "Skim Milk", "Almond Milk")),
            Ingredients(R.drawable.sour_cream, "Sour Cream", allergens = listOf("Dairy")),
            Ingredients(R.drawable.yogurt, "Yogurt", allergens = listOf("Dairy"), variants = listOf("Plain Yogurt", "Greek Yogurt", "Flavored Yogurt")),
        )),

        IngredientCategory(2, "Eggs", listOf(
            Ingredients(R.drawable.chicken_egg, "Chicken Egg", allergens = listOf("Eggs"), variants = listOf("Eggs", "Whole Eggs","Egg Whites", "Egg Yolk","Egg Yolks")),
            Ingredients(R.drawable.duck_egg, "Duck Egg", allergens = listOf("Eggs"), variants = listOf("Eggs", "Whole Eggs", "Egg Whites", "Egg Yolk", "Egg Yolks"))
        )),

        IngredientCategory(3, "Fruits", listOf(
            Ingredients(R.drawable.apple, "Apple", variants = listOf("Sliced Apple", "Apple Cubes", "Apple Wedges")),
            Ingredients(R.drawable.avocado, "Avocado", variants = listOf("Sliced Avocado", "Mashed Avocado", "Guacamole")),
            Ingredients(R.drawable.banana, "Banana", variants = listOf("Bananas","Sliced Banana", "Mashed Banana", "Banana Chips")),
            Ingredients(R.drawable.blueberry, "Blueberry", variants = listOf("Fresh Blueberry", "Frozen Blueberry", "Blueberries")),
            Ingredients(R.drawable.grapes, "Grapes", variants = listOf("Red Grapes", "Green Grapes")),
            Ingredients(R.drawable.lemon, "Lemon", variants = listOf("Lemon Juice", "Lemon Slices", "Lemon Zest")),
            Ingredients(R.drawable.lime, "Lime", variants = listOf("Lime Juice", "Lime Slices", "Lime Zest")),
            Ingredients(R.drawable.orange, "Orange", variants = listOf("Orange Segments", "Orange Juice")),
            Ingredients(R.drawable.pineapple, "Pineapple", variants = listOf("Pineapple Chunks", "Grilled Pineapple")),
            Ingredients(R.drawable.strawberry, "Strawberry", variants = listOf("Sliced Strawberry", "Whole Strawberry", "Strawberries")),
            Ingredients(R.drawable.watermelon, "Watermelon", variants = listOf("Watermelon Cubes", "Watermelon Slices")),
            Ingredients(R.drawable.olives, "Olives", allergens = listOf(), variants = listOf("Kalamata Olives", "Green Olives", "Black Olives", "Stuffed Olives"))
        )),

        IngredientCategory(4, "Grains & Pasta", listOf(
            Ingredients(R.drawable.bread, "Bread", allergens = listOf("Gluten"), variants = listOf("Whole Wheat Bread", "White Bread", "Sourdough Bread")),
            Ingredients(R.drawable.flour, "Flour", allergens = listOf("Gluten"), variants = listOf("All-Purpose Flour", "Whole Wheat Flour", "Gluten-Free Flour")),
            Ingredients(R.drawable.oats, "Oats", allergens = listOf("Gluten"), variants = listOf("Rolled Oats", "Instant Oats")),
            Ingredients(R.drawable.pasta, "Pasta", allergens = listOf("Gluten"), variants = listOf("Spaghetti", "Penne", "Macaroni")),
            Ingredients(R.drawable.quinoa, "Quinoa"),
            Ingredients(R.drawable.rice, "Rice", variants = listOf("White Rice", "Brown Rice", "Jasmine Rice", "Arborio Rice")),
            Ingredients(R.drawable.tortilla, "Tortilla", variants = listOf("Tortillas", "Flour Tortilla", "Corn Tortilla")),
        )),

        IngredientCategory(5, "Herbs & Spices", listOf(
            Ingredients(R.drawable.allspice, "Allspice", variants = listOf("Whole Allspice", "Ground Allspice")),
            Ingredients(R.drawable.basil, "Basil", variants = listOf("Fresh Basil", "Dried Basil")),
            Ingredients(R.drawable.cardamom, "Cardamom", variants = listOf("Whole Cardamom", "Ground Cardamom")),
            Ingredients(R.drawable.cayenne_pepper, "Cayenne Pepper", variants = listOf("Ground Cayenne Pepper", "Cayenne Pepper Flakes")),
            Ingredients(R.drawable.chives, "Chives", variants = listOf("Fresh Chives", "Dried Chives")),
            Ingredients(R.drawable.cilantro, "Cilantro", variants = listOf("Fresh Cilantro", "Cilantro Leaves")),
            Ingredients(R.drawable.cinnamon, "Cinnamon", variants = listOf("Ground Cinnamon", "Cinnamon Stick")),
            Ingredients(R.drawable.cloves, "Cloves", variants = listOf("Whole Cloves", "Ground Cloves")),
            Ingredients(R.drawable.dill, "Dill", variants = listOf("Fresh Dill", "Dried Dill")),
            Ingredients(R.drawable.garlic, "Garlic", variants = listOf("Minced Garlic", "Garlic Paste", "Garlic Cloves","Garlic Powder")),
            Ingredients(R.drawable.ginger, "Ginger", variants = listOf("Grated Ginger", "Ground Ginger")),
            Ingredients(R.drawable.mint, "Mint", variants = listOf("Fresh Mint", "Dried Mint")),
            Ingredients(R.drawable.nutmeg, "Nutmeg", variants = listOf("Whole Nutmeg", "Ground Nutmeg")),
            Ingredients(R.drawable.onion, "Onion", variants = listOf("Onions", "Sliced Onion", "Chopped Onion", "Caramelized Onion", "White Onion", "Red Onion", "Yellow Onion", "Green Onion")),
            Ingredients(R.drawable.oregano, "Oregano", variants = listOf("Fresh Oregano", "Dried Oregano")),
            Ingredients(R.drawable.parsley, "Parsley", variants = listOf("Fresh Parsley", "Dried Parsley")),
            Ingredients(R.drawable.rosemary, "Rosemary", variants = listOf("Fresh Rosemary", "Dried Rosemary")),
            Ingredients(R.drawable.sage, "Sage", variants = listOf("Fresh Sage", "Dried Sage")),
            Ingredients(R.drawable.star_anise, "Star Anise", variants = listOf("Whole Star Anise", "Ground Star Anise")),
            Ingredients(R.drawable.thyme, "Thyme", variants = listOf("Fresh Thyme", "Dried Thyme")),
            Ingredients(R.drawable.turmeric, "Turmeric", variants = listOf("Fresh Turmeric", "Ground Turmeric","Turmeric Powder")),
            Ingredients(R.drawable.chilli_flakes, "Chilli Flakes", variants = listOf("Dried Chilli Flakes","Mild Chilli Flakes", "Hot Chilli Flakes")),
            Ingredients(R.drawable.garlic_powder, "Garlic Powder", allergens = listOf(), variants = listOf("Regular Garlic Powder")),
            Ingredients(R.drawable.onion_powder, "Onion Powder", allergens = listOf(), variants = listOf("Regular Onion Powder"))
        )),

        IngredientCategory(6, "Legumes & Nuts", listOf(
            Ingredients(R.drawable.almonds, "Almonds", allergens = listOf("Tree Nuts"), variants = listOf("Whole Almonds", "Sliced Almonds")),
            Ingredients(R.drawable.beans, "Beans", variants = listOf("Black Beans", "Kidney Beans", "Pinto Beans")),
            Ingredients(R.drawable.cashews, "Cashews", allergens = listOf("Tree Nuts"), variants = listOf("Raw Cashews", "Roasted Cashews")),
            Ingredients(R.drawable.chickpeas, "Chickpeas", variants = listOf("Canned Chickpeas", "Roasted Chickpeas")),
            Ingredients(R.drawable.lentils, "Lentils", variants = listOf("Red Lentils", "Green Lentils")),
            Ingredients(R.drawable.peas, "Peas", allergens = listOf(), variants = listOf("Fresh Peas", "Frozen Peas", "Green Peas")),
            Ingredients(R.drawable.peanuts, "Peanuts", allergens = listOf("Peanuts"), variants = listOf("Raw Peanuts", "Roasted Peanuts")),
            Ingredients(R.drawable.walnuts, "Walnuts", allergens = listOf("Tree Nuts")),
        )),

        IngredientCategory(7, "Meat & Poultry", listOf(
            Ingredients(R.drawable.bacon, "Bacon", variants = listOf("Crispy Bacon", "Bacon Bits")),
            Ingredients(R.drawable.beef, "Beef", variants = listOf("Ground Beef", "Beef Steaks", "Beef Ribs")),
            Ingredients(R.drawable.chicken, "Chicken", variants = listOf("Chicken Breast", "Chicken Thigh", "Chicken Wings", "Ground Chicken", "Grilled Chicken")),
            Ingredients(R.drawable.pancetta, "Pancetta", allergens = listOf(), variants = listOf("Cubed Pancetta", "Thinly Sliced Pancetta")),
            Ingredients(R.drawable.pork, "Pork", variants = listOf("Pork Chops", "Pulled Pork", "Pork Belly", "Ground Pork")),
            Ingredients(R.drawable.sausage, "Sausage", variants = listOf("Pork Sausage", "Chicken Sausage", "Turkey Sausage")),
            Ingredients(R.drawable.turkey, "Turkey", variants = listOf("Turkey Breast", "Ground Turkey", "Turkey Legs")),

        )),

        IngredientCategory(8, "Pantry Essentials", listOf(
            Ingredients(R.drawable.baking_powder, "Baking Powder"),
            Ingredients(R.drawable.baking_soda, "Baking Soda"),
            Ingredients(R.drawable.balsamic_glaze, "Balsamic Glaze", allergens = listOf(), variants = listOf("Classic Balsamic Glaze")),
            Ingredients(R.drawable.chocolate_chips, "Chocolate Chips", allergens = listOf("Dairy"), variants = listOf("Milk Chocolate Chips", "Dark Chocolate Chips", "Semi-Sweet Chocolate Chips")),
            Ingredients(R.drawable.coconut_milk, "Coconut Milk", allergens = listOf("Tree Nuts")),
            Ingredients(R.drawable.cornstarch, "Cornstarch"),
            Ingredients(R.drawable.fish_sauce, "Fish Sauce", allergens = listOf("Fish")),
            Ingredients(R.drawable.honey, "Honey", variants = listOf("Raw Honey", "Honeycomb")),
            Ingredients(R.drawable.hot_sauce, "Hot Sauce", variants = listOf("Sriracha", "Tabasco", "Chili Garlic Sauce")),
            Ingredients(R.drawable.ketchup, "Ketchup"),
            Ingredients(R.drawable.maple_syrup, "Maple Syrup"),
            Ingredients(R.drawable.mayonnaise, "Mayonnaise", allergens = listOf("Eggs", "Mustard"), variants = listOf("Regular Mayonnaise", "Light Mayonnaise", "Vegan Mayonnaise")),
            Ingredients(R.drawable.mustard, "Mustard", allergens = listOf("Mustard")),
            Ingredients(R.drawable.oil, "Oil", variants = listOf("Canola Oil", "Corn Oil", "Sunflower Oil", "Olive Oil")),
            Ingredients(R.drawable.oyster_sauce, "Oyster Sauce", allergens = listOf("Shellfish")),
            Ingredients(R.drawable.peanut_butter, "Peanut Butter", allergens = listOf("Peanuts"), variants = listOf("Creamy Peanut Butter", "Chunky Peanut Butter")),
            Ingredients(R.drawable.seasonings, "Seasonings", allergens = listOf(), variants = listOf("Taco Seasoning", "Fajita Seasoning")),
            Ingredients(R.drawable.soy_sauce, "Soy Sauce", allergens = listOf("Soy", "Gluten"), variants = listOf("Low-Sodium Soy Sauce", "Tamari Soy Sauce")),
            Ingredients(R.drawable.sugar, "Sugar", variants = listOf("Granulated Sugar", "Brown Sugar", "Powdered Sugar")),
            Ingredients(R.drawable.tofu, name = "Tofu", variants = listOf("Firm Tofu", "Soft Tofu", "Silken Tofu", "Smoked Tofu"), allergens = listOf("Soy")),
            Ingredients(R.drawable.tomato_paste, "Tomato Paste"),
            Ingredients(R.drawable.tomato_sauce, "Tomato Sauce", variants = listOf("Marinara Sauce", "Passata", "Pizza Sauce", "Salsa")),
            Ingredients(R.drawable.vinegar, "Vinegar", variants = listOf("White Vinegar", "Apple Cider Vinegar", "Balsamic Vinegar")),
            Ingredients(R.drawable.white_wine, "White Wine", allergens = listOf(), variants = listOf("Dry White Wine", "Sweet White Wine")),
            Ingredients(R.drawable.worcestershire_sauce, "Worcestershire Sauce", allergens = listOf("Fish", "Soy")),
            Ingredients(R.drawable.yeast, "Yeast", allergens = listOf(), variants = listOf("Active Dry Yeast", "Instant Yeast", "Fresh Yeast"))
        )),

        IngredientCategory(9, "Seafood", listOf(
            Ingredients(R.drawable.cod, "Cod", allergens = listOf("Fish")),
            Ingredients(R.drawable.crab, "Crab", allergens = listOf("Shellfish")),
            Ingredients(R.drawable.lobster, "Lobster", allergens = listOf("Shellfish")),
            Ingredients(R.drawable.salmon, "Salmon", allergens = listOf("Fish"), variants = listOf("Fresh Salmon", "Smoked Salmon")),
            Ingredients(R.drawable.shrimp, "Shrimp", allergens = listOf("Shellfish"), variants = listOf("Shrimps", "Fresh Shrimp", "Frozen Shrimp")),
            Ingredients(R.drawable.tuna, "Tuna", allergens = listOf("Fish"), variants = listOf("Fresh Tuna", "Canned Tuna")),
        )),


        IngredientCategory(10, "Vegetables", listOf(
            Ingredients(R.drawable.artichokes, "Artichoke", allergens = listOf(), variants = listOf("Artichoke Hearts","Canned Artichoke Hearts", "Fresh Artichoke Hearts")),
            Ingredients(R.drawable.asparagus, "Asparagus", variants = listOf("Steamed Asparagus", "Roasted Asparagus")),
            Ingredients(R.drawable.bell_pepper, "Bell Pepper", variants = listOf("Bell Peppers", "Sliced Bell Pepper", "Diced Bell Pepper", "Grilled Bell Pepper")),
            Ingredients(R.drawable.broccoli, "Broccoli", variants = listOf("Steamed Broccoli", "Roasted Broccoli")),
            Ingredients(R.drawable.brussels_sprouts, "Brussels Sprouts", allergens = listOf(), variants = listOf("Halved Brussels Sprouts", "Whole Brussels Sprouts")),
            Ingredients(R.drawable.butternut_squash, "Butternut Squash", allergens = listOf(), variants = listOf("Butternut squash", "Cubed Butternut Squash", "Roasted Butternut Squash")),
            Ingredients(R.drawable.cabbage, "Cabbage", variants = listOf("Shredded Cabbage", "Cabbage Wedges")),
            Ingredients(R.drawable.carrot, "Carrot", variants = listOf("Carrots","Shredded Carrot", "Carrot Sticks", "Carrot Chips")),
            Ingredients(R.drawable.cauliflower, "Cauliflower", variants = listOf("Cauliflower Florets", "Roasted Cauliflower")),
            Ingredients(R.drawable.celery, "Celery", variants = listOf("Sliced Celery", "Diced Celery")),
            Ingredients(R.drawable.corn, "Corn", variants = listOf("Fresh Corn", "Frozen Corn", "Grilled Corn")),
            Ingredients(R.drawable.cucumber, "Cucumber", variants = listOf("Sliced Cucumber", "Diced Cucumber")),
            Ingredients(R.drawable.eggplant, "Eggplant", variants = listOf("Eggplants", "Grilled Eggplant", "Baked Eggplant")),
            Ingredients(R.drawable.green_beans, "Green Beans", variants = listOf("Steamed Green Beans", "Sautéed Green Beans")),
            Ingredients(R.drawable.kale, "Kale", variants = listOf("Kale Chips", "Fresh Kale")),
            Ingredients(R.drawable.lettuce, "Lettuce", variants = listOf("Romaine Lettuce", "Iceberg Lettuce")),
            Ingredients(R.drawable.mushroom, "Mushroom", variants = listOf("Mushrooms", "Sliced Mushroom", "Chopped Mushroom", "Grilled Mushroom")),
            Ingredients(R.drawable.potato, "Potato", variants = listOf("Mashed Potato", "Diced Potato", "Baked Potato", "Roasted Potato", "Potatoes")),
            Ingredients(R.drawable.spinach, "Spinach", variants = listOf("Fresh Spinach", "Frozen Spinach")),
            Ingredients(R.drawable.sweet_potato, "Sweet Potato", variants = listOf("Mashed Sweet Potato", "Sweet Potato Fries", "Baked Sweet Potato")),
            Ingredients(R.drawable.tomato, "Tomato", variants = listOf("Tomatoes",  "Diced Tomatoes",  "Fresh Tomatoes",  "Cherry Tomato", "Diced Tomato", "Roma Tomato", "Tomato Puree")),
            Ingredients(R.drawable.zucchini, "Zucchini", variants = listOf("Zucchini Slices", "Zucchini Noodles", "Zucchini Ribbons"))

    ))
    )
}