package com.android.lists

import com.android.data.Recipes
import com.android.readysetcook.R

object RecipeList {
    val recipes = listOf(
        Recipes(
            id = "1",
            name = "Soy Stir Fry",
            description = "A quick vegetable stir fry with soy sauce.",
            ingredients = listOf("Soy Sauce", "Carrot", "Broccoli", "Garlic"),
            measurements = listOf("2 tbsp", "1 cup sliced", "1 cup florets", "2 cloves minced"),
            ingredientWeights = listOf(0.4, 0.25, 0.25, 0.1),
            instructions = listOf(
                "Heat 1 tbsp of oil in a large skillet or wok over medium-high heat.",
                "Add the sliced carrots and broccoli florets. Stir frequently for about 3 minutes.",
                "Add the minced garlic and continue stir-frying for another 2 minutes until fragrant.",
                "Pour in the soy sauce and cook for an additional 2 minutes, stirring to coat the vegetables evenly."
            ),
                    cookingTime = 10,
            allergenInfo = listOf("soy", "gluten"),
            photoRes = R.drawable.soy_stir_fry
        ),
        Recipes(
            id = "2",
            name = "Garlic Butter Shrimp",
            description = "Juicy shrimp sautéed with garlic butter.",
            ingredients = listOf("Shrimp", "Garlic", "Butter", "Parsley"),
            measurements = listOf("1 pound", "3 cloves minced", "2 tbsp", "1/4 cup chopped"),
            ingredientWeights = listOf(0.6, 0.15, 0.2, 0.05),
            instructions = listOf(
                "In a skillet, melt the butter over medium heat.",
                "Add the minced garlic and sauté for 1 minute until aromatic.",
                "Add the shrimp and cook for 2–3 minutes on each side or until they turn pink and opaque.",
                "Remove from heat and garnish with chopped parsley before serving."
            ),
            cookingTime = 8,
            allergenInfo = listOf("shellfish", "dairy"),
            photoRes = R.drawable.garlic_butter_shrimp
        ),
        Recipes(
            id = "3",
            name = "Tomato Basil Pasta",
            description = "Simple pasta tossed in tomato and basil sauce.",
            ingredients = listOf("Pasta", "Tomato", "Basil", "Garlic", "Olive Oil"),
            measurements = listOf(
                "8 oz",
                "2 cups diced",
                "1/4 cup chopped",
                "2 cloves minced",
                "2 tbsp"
            ),
            ingredientWeights = listOf(0.5, 0.25, 0.1, 0.1, 0.05),
            instructions = listOf(
                "Boil a pot of salted water and cook pasta until al dente according to package instructions. Drain and set aside.",
                "Heat olive oil in a pan over medium heat, then add minced garlic and sauté for 30 seconds.",
                "Add diced tomatoes and cook for 5–7 minutes until softened into a sauce.",
                "Add cooked pasta and chopped basil to the pan. Toss well to combine and heat through before serving."
            ),
            cookingTime = 20,
            allergenInfo = listOf("gluten"),
            photoRes = R.drawable.tomato_basil_pasta
        ),
        Recipes(
            id = "4",
            name = "Peanut Butter Smoothie",
            description = "A rich, protein-packed smoothie.",
            ingredients = listOf("Peanut Butter", "Banana", "Milk", "Honey"),
            measurements = listOf("2 tbsp", "1 banana", "1 cup", "1 tsp"),
            ingredientWeights = listOf(0.4, 0.3, 0.25, 0.05),
            instructions = listOf(
                "In a blender, combine 2 tbsp peanut butter, 1 sliced banana, 1 cup milk, and 1 tsp honey.",
                "Blend on high speed for 30–60 seconds or until the mixture is smooth and creamy.",
                "Pour into a glass and serve immediately, optionally with a sprinkle of cinnamon or extra banana slices."
            ),
            cookingTime = 5,
            allergenInfo = listOf("peanuts", "dairy"),
            photoRes = R.drawable.peanut_butter_smoothie
        ),
        Recipes(
            id = "5",
            name = "Egg Salad",
            description = "Classic creamy egg salad for sandwiches.",
            ingredients = listOf("Eggs", "Mayonnaise", "Mustard"),
            measurements = listOf("4 eggs", "2 tbsp", "1 tsp", "to taste", "to taste"),
            ingredientWeights = listOf(0.5, 0.3, 0.2),
            instructions = listOf(
                "Place eggs in a pot, cover with water, and bring to a boil. Once boiling, cook for 10 minutes.",
                "Transfer eggs to a bowl of cold water. Once cooled, peel and chop them.",
                "In a bowl, mix chopped eggs with mayonnaise, mustard, and season with salt and pepper to taste.",
                "Stir until well combined. Serve on bread, lettuce, or as desired."
            ),
            cookingTime = 15,
            allergenInfo = listOf("eggs"),
            photoRes = R.drawable.egg_salad
        ),
        Recipes(
            id = "6",
            name = "Veggie Omelette",
            description = "A fluffy omelette filled with fresh vegetables.",
            ingredients = listOf("Eggs", "Bell Pepper", "Onion", "Spinach", "Cheese"),
            measurements = listOf(
                "2 eggs",
                "1/2 cup sliced",
                "1/2 cup sliced",
                "1/4 cup chopped",
                "1/4 cup shredded"
            ),
            ingredientWeights = listOf(0.5, 0.15, 0.15, 0.1, 0.1),
            instructions = listOf(
                "Crack eggs into a bowl and whisk until smooth. Season with salt and pepper.",
                "Heat a non-stick pan over medium heat and lightly grease with oil or butter.",
                "Pour in the beaten eggs and cook undisturbed for 1–2 minutes.",
                "Sprinkle sliced bell pepper, onion, spinach, and shredded cheese evenly over the eggs.",
                "Cook until the omelette is set, then fold in half and serve warm."
            ),
            cookingTime = 10,
            allergenInfo = listOf("eggs", "dairy"),
            photoRes = R.drawable.veggie_omelette
        ),
        Recipes(
            id = "7",
            name = "Fruit Yogurt Parfait",
            description = "Layered yogurt with fresh fruit and granola.",
            ingredients = listOf("Yogurt", "Strawberries", "Blueberries", "Granola"),
            measurements = listOf("1 cup", "1/2 cup sliced", "1/2 cup", "2 tbsp"),
            ingredientWeights = listOf(0.5, 0.2, 0.2, 0.1),
            instructions = listOf(
                "In a glass or jar, spoon a layer of yogurt at the bottom.",
                "Add a layer of sliced strawberries, then a layer of blueberries.",
                "Sprinkle a spoonful of granola on top.",
                "Repeat layers as desired and serve immediately for best texture."
            ),
            cookingTime = 5,
            allergenInfo = listOf("dairy"),
            photoRes = R.drawable.fruit_yogurt_parfait
        ),
        Recipes(
            id = "8",
            name = "Grilled Cheese Sandwich",
            description = "Golden, melty grilled cheese sandwich.",
            ingredients = listOf("Bread", "Cheese", "Butter"),
            measurements = listOf("2 slices", "2 slices", "1 tsp"),
            ingredientWeights = listOf(0.45, 0.45, 0.1),
            instructions = listOf(
                "Spread butter evenly on one side of each bread slice.",
                "Place one slice of bread, buttered side down, in a skillet over medium heat.",
                "Add cheese slices on top and cover with the second bread slice, buttered side up.",
                "Grill until golden brown, about 2–3 minutes per side, and cheese is melted inside."
            ),
            cookingTime = 10,
            allergenInfo = listOf("gluten", "dairy"),
            photoRes = R.drawable.grilled_cheese
        ),
        Recipes(
            id = "9",
            name = "Chicken Stir Fry",
            description = "Quick chicken stir fry with vegetables.",
            ingredients = listOf("Chicken Breast", "Broccoli", "Carrot", "Soy Sauce", "Garlic"),
            measurements = listOf(
                "1 pound",
                "1 cup florets",
                "1 cup sliced",
                "2 tbsp",
                "2 cloves minced"
            ),
            ingredientWeights = listOf(0.5, 0.2, 0.15, 0.1, 0.05),
            instructions = listOf(
                "Cut chicken breast into bite-sized pieces.",
                "In a pan, heat oil over medium-high heat and cook chicken until browned and cooked through, about 5–7 minutes.",
                "Add broccoli, carrots, and minced garlic. Stir fry for another 3–4 minutes.",
                "Pour soy sauce over the mixture and cook for another 2 minutes, stirring to combine."
            ),
            cookingTime = 15,
            allergenInfo = listOf("soy"),
            photoRes = R.drawable.chicken_stir_fry
        ),
        Recipes(
            id = "10",
            name = "Beef Tacos",
            description = "Flavorful beef tacos with a crunchy finish.",
            ingredients = listOf(
                "Ground Beef",
                "Taco Seasoning",
                "Lettuce",
                "Tomato",
                "Cheddar Cheese",
                "Tortilla"
            ),
            measurements = listOf(
                "1 pound",
                "1 packet",
                "1 cup shredded",
                "1 cup diced",
                "1 cup shredded",
                "8 tortillas"
            ),
            ingredientWeights = listOf(0.4, 0.15, 0.1, 0.1, 0.15, 0.1),
            instructions = listOf(
                "In a skillet over medium heat, cook ground beef until browned. Drain excess fat.",
                "Stir in taco seasoning with a splash of water and cook for 2–3 more minutes.",
                "Warm tortillas in a separate pan or microwave.",
                "Fill tortillas with beef mixture, shredded lettuce, diced tomato, and shredded cheddar cheese.",
                "Serve immediately with salsa or your favorite toppings."
            ),
            cookingTime = 20,
            allergenInfo = listOf("dairy", "gluten"),
            photoRes = R.drawable.beef_tacos
        ),
        Recipes( id = "11",
            name = "Caesar Salad",
            description = "A classic Caesar salad with crispy croutons, shaved Parmesan, and homemade Caesar dressing.",
            ingredients = listOf("Romaine Lettuce", "Croutons", "Parmesan Cheese", "Grated Garlic", "Anchovy Fillets", "Egg Yolk", "Dijon Mustard", "Lemon Juice", "Olive Oil", "Grilled Chicken"),
            measurements = listOf("2 cups chopped", "1 cup", "1/2 cup shaved", "1 clove minced", "2 fillets", "1", "1 tsp", "1 tbsp", "1/4 cup", "1 cup diced"),
            ingredientWeights = listOf(0.35, 0.2, 0.15, 0.05, 0.05, 0.05, 0.05, 0.05, 0.1, 0.1),
            instructions = listOf("Wash and chop 2 cups of romaine lettuce into bite-size pieces.",
                "For the dressing, in a small bowl combine 1 clove minced garlic, 2 anchovy fillets (mashed), 1 egg yolk, 1 tsp Dijon mustard, and 1 tbsp lemon juice; then slowly whisk in 1/4 cup olive oil until emulsified, and season with salt and pepper.",
                "Toss the chopped lettuce with the freshly prepared dressing in a large bowl.",
                "Add 1 cup croutons and gently mix.", "Top with 1/2 cup shaved Parmesan cheese and, if desired, stir in 1 cup diced grilled chicken.",
                "Serve chilled." ),
            cookingTime = 10, allergenInfo = listOf("dairy", "gluten", "eggs", "fish"),
            photoRes = R.drawable.caesar_salad )
        ,
        Recipes(
            id = "12",
            name = "Margherita Pizza",
            description = "A simple and fresh pizza with tomato, mozzarella, and basil.",
            ingredients = listOf(
                "Pizza Dough",
                "Tomato Sauce",
                "Fresh Mozzarella",
                "Basil",
                "Olive Oil"
            ),
            measurements = listOf("1 dough", "1 cup", "8 oz", "1/4 cup chopped", "2 tbsp"),
            ingredientWeights = listOf(0.4, 0.2, 0.3, 0.05, 0.05),
            instructions = listOf(
                "Preheat oven to 475°F (245°C). Roll out the pizza dough on a baking tray or stone.",
                "Spread tomato sauce evenly over the surface of the dough.",
                "Arrange slices of fresh mozzarella evenly on top.",
                "Bake for 12–15 minutes or until the crust is golden and cheese is bubbling.",
                "Remove from oven, top with chopped basil and drizzle with olive oil before slicing and serving."
            ),
            cookingTime = 30,
            allergenInfo = listOf("gluten", "dairy"),
            photoRes = R.drawable.margherita_pizza
        ),
        Recipes(
            id = "13",
            name = "Mushroom Risotto",
            description = "Creamy risotto with earthy mushrooms and parmesan.",
            ingredients = listOf(
                "Arborio Rice",
                "Mushrooms",
                "Onion",
                "Garlic",
                "Parmesan Cheese",
                "White Wine"
            ),
            measurements = listOf(
                "1 cup",
                "1 cup sliced",
                "1/2 cup chopped",
                "2 cloves minced",
                "1/2 cup grated",
                "1/2 cup"
            ),
            ingredientWeights = listOf(0.4, 0.25, 0.1, 0.05, 0.15, 0.05),
            instructions = listOf(
                "Heat butter in a large pan over medium heat. Add finely chopped onion and minced garlic, and sauté until translucent.",
                "Stir in sliced mushrooms and cook until they release their moisture and turn golden brown.",
                "Add Arborio rice and toast for 2 minutes, stirring constantly to coat the grains with butter.",
                "Pour in white wine and stir until fully absorbed.",
                "Gradually add warm vegetable broth, one ladle at a time, stirring frequently. Let each addition absorb before adding the next.",
                "Continue until rice is creamy and al dente, about 18–20 minutes.",
                "Stir in grated parmesan cheese and a knob of butter for extra creaminess. Season with salt and pepper. Serve hot."
            ),
            cookingTime = 25,
            allergenInfo = listOf("dairy"),
            photoRes = R.drawable.mushroom_risotto
        ),
        Recipes(
            id = "14",
            name = "Pancakes",
            description = "Fluffy homemade pancakes perfect for breakfast.",
            ingredients = listOf("Flour", "Milk", "Eggs", "Baking Powder", "Sugar", "Butter"),
            measurements = listOf("1 cup", "1 cup", "2 eggs", "2 tsp", "2 tbsp", "2 tbsp"),
            ingredientWeights = listOf(0.35, 0.25, 0.2, 0.1, 0.05, 0.05),
            instructions = listOf(
                "In a bowl, whisk together flour, sugar, baking powder, and a pinch of salt.",
                "In a separate bowl, beat eggs and mix in milk and melted butter.",
                "Pour the wet ingredients into the dry ingredients and mix just until combined. Do not overmix; a few lumps are fine.",
                "Heat a lightly greased skillet over medium heat. Pour about 1/4 cup of batter onto the skillet.",
                "Cook until bubbles form on the surface and the edges look set, about 2–3 minutes.",
                "Flip and cook the other side for 1–2 minutes or until golden brown.",
                "Serve warm with butter, syrup, or toppings of your choice."
            ),
            cookingTime = 15,
            allergenInfo = listOf("gluten", "dairy", "eggs"),
            photoRes = R.drawable.pancakes
        ),
        Recipes(
            id = "15",
            name = "Tomato Basil Soup",
            description = "Smooth and comforting tomato basil soup.",
            ingredients = listOf(
                "Tomatoes",
                "Onion",
                "Garlic",
                "Vegetable Broth",
                "Basil",
                "Cream"
            ),
            measurements = listOf(
                "2 cups diced",
                "1/2 cup chopped",
                "2 cloves minced",
                "2 cups",
                "1/4 cup chopped",
                "1/2 cup"
            ),
            ingredientWeights = listOf(0.5, 0.15, 0.1, 0.15, 0.05, 0.05),
            instructions = listOf(
                "In a large pot, heat olive oil and sauté chopped onions until soft. Add minced garlic and cook for 1 minute.",
                "Add canned or fresh diced tomatoes, including juices. Stir in vegetable broth and bring to a boil.",
                "Reduce heat and let simmer for 15–20 minutes to develop flavor.",
                "Use an immersion blender to blend the soup until smooth (or transfer to a blender in batches).",
                "Stir in heavy cream and freshly chopped basil leaves. Simmer for another 5 minutes.",
                "Season with salt and pepper to taste. Serve warm, optionally with grilled cheese."
            ),
            cookingTime = 25,
            allergenInfo = listOf("dairy"),
            photoRes = R.drawable.tomato_basil_soup
        ),
        Recipes(
            id = "16",
            name = "Caprese Salad",
            description = "Refreshing salad with tomatoes, mozzarella, and basil.",
            ingredients = listOf(
                "Tomatoes",
                "Fresh Mozzarella",
                "Basil",
                "Olive Oil",
                "Balsamic Glaze"
            ),
            measurements = listOf(
                "2 cups sliced",
                "8 oz sliced",
                "1/4 cup chopped",
                "2 tbsp",
                "1 tbsp"
            ),
            ingredientWeights = listOf(0.4, 0.4, 0.1, 0.05, 0.05),
            instructions = listOf(
                "Slice fresh tomatoes and mozzarella cheese into 1/4-inch thick slices.",
                "Arrange tomato and mozzarella slices alternately in a circle on a serving plate.",
                "Tuck whole basil leaves between the slices.",
                "Drizzle with high-quality extra virgin olive oil and a balsamic glaze.",
                "Sprinkle with salt and freshly ground black pepper before serving."
            ),
            cookingTime = 5,
            allergenInfo = listOf("dairy"),
            photoRes = R.drawable.caprese_salad
        ),
        Recipes(
            id = "17",
            name = "Spaghetti Carbonara",
            description = "Rich and creamy pasta with pancetta and cheese.",
            ingredients = listOf(
                "Spaghetti",
                "Eggs",
                "Pancetta",
                "Parmesan Cheese",
            ),
            measurements = listOf("12 oz", "3 eggs", "6 slices", "1 cup grated", "to taste"),
            ingredientWeights = listOf(0.4, 0.2, 0.2, 0.2),
            instructions = listOf(
                "Bring a pot of salted water to a boil and cook spaghetti until al dente. Reserve 1/2 cup of pasta water before draining.",
                "In a skillet, cook pancetta or bacon until crispy. Remove from heat.",
                "In a bowl, whisk together eggs and grated Parmesan cheese.",
                "Immediately toss hot pasta with the egg mixture, pancetta, and reserved pasta water to create a creamy sauce (off the heat to avoid scrambling the eggs).",
                "Season generously with black pepper and serve hot."
            ),
            cookingTime = 20,
            allergenInfo = listOf("gluten", "eggs", "dairy"),
            photoRes = R.drawable.spaghetti_carbonara
        ),
        Recipes(
            id = "18",
            name = "Fried Rice",
            description = "Classic fried rice with vegetables and egg.",
            ingredients = listOf("Rice", "Eggs", "Carrots", "Peas", "Soy Sauce", "Green Onions"),
            measurements = listOf(
                "2 cups cooked",
                "2 eggs",
                "1 cup diced",
                "1 cup",
                "2 tbsp",
                "1/4 cup chopped"
            ),
            ingredientWeights = listOf(0.4, 0.15, 0.15, 0.1, 0.1, 0.1),
            instructions = listOf(
                "Heat oil in a large skillet or wok over medium-high heat.",
                "Add beaten eggs and scramble until just cooked. Transfer to a plate.",
                "Add more oil if needed, then sauté diced onions, garlic, and mixed vegetables until tender.",
                "Add cold, day-old rice and stir-fry to break up clumps and heat through.",
                "Return scrambled eggs to the pan and mix well.",
                "Season with soy sauce and sesame oil to taste. Garnish with chopped green onions before serving."
            ),
            cookingTime = 15,
            allergenInfo = listOf("eggs", "soy"),
            photoRes = R.drawable.fried_rice
        ),
        Recipes(
            id = "19",
            name = "Beef Stir Fry",
            description = "Tender beef stir-fried with colorful vegetables.",
            ingredients = listOf(
                "Beef",
                "Broccoli",
                "Bell Pepper",
                "Soy Sauce",
                "Garlic",
                "Ginger"
            ),
            measurements = listOf(
                "1 pound",
                "1 cup florets",
                "1 cup sliced",
                "2 tbsp",
                "2 cloves minced",
                "1 tsp grated"
            ),
            ingredientWeights = listOf(0.45, 0.2, 0.15, 0.1, 0.05, 0.05),
            instructions = listOf(
                "Thinly slice beef against the grain and marinate in soy sauce, garlic, ginger, and a little cornstarch for at least 20 minutes.",
                "Heat oil in a wok or large skillet over high heat. Stir-fry the beef in batches until just browned. Remove and set aside.",
                "Add more oil if needed, then stir-fry sliced vegetables (like bell peppers, broccoli, carrots) until crisp-tender.",
                "Return beef to the pan and pour in stir-fry sauce (soy sauce, oyster sauce, cornstarch slurry).",
                "Cook for another 1–2 minutes until everything is coated and heated through. Serve with steamed rice."
            ),
            cookingTime = 20,
            allergenInfo = listOf("soy"),
            photoRes = R.drawable.beef_stir_fry
        ),
        Recipes(
            id = "20",
            name = "Greek Salad",
            description = "Light and fresh salad with feta and olives.",
            ingredients = listOf(
                "Cucumber",
                "Tomatoes",
                "Red Onion",
                "Feta Cheese",
                "Olives",
                "Olive Oil"
            ),
            measurements = listOf(
                "1 cup sliced",
                "1 cup diced",
                "1/2 cup sliced",
                "1/2 cup crumbled",
                "1/4 cup pitted",
                "2 tbsp"
            ),
            ingredientWeights = listOf(0.25, 0.25, 0.15, 0.2, 0.1, 0.05),
            instructions = listOf(
                "Chop cucumbers, tomatoes, red onion, and green bell pepper into bite-sized pieces.",
                "Place vegetables in a large bowl and add Kalamata olives and crumbled or cubed feta cheese.",
                "Drizzle with extra virgin olive oil and a splash of red wine vinegar or lemon juice.",
                "Season with dried oregano, salt, and pepper.",
                "Toss gently and serve chilled or at room temperature."
            ),
            cookingTime = 10,
            allergenInfo = listOf("dairy"),
            photoRes = R.drawable.greek_salad
        ),
        Recipes(
            id = "21",
            name = "Baked Salmon",
            description = "Simple and healthy baked salmon fillet.",
            ingredients = listOf("Salmon", "Lemon", "Olive Oil", "Garlic", "Dill"),
            measurements = listOf(
                "4 fillets",
                "1 lemon sliced",
                "2 tbsp",
                "2 cloves minced",
                "1/4 cup chopped"
            ),
            ingredientWeights = listOf(0.6, 0.15, 0.1, 0.1, 0.05),
            instructions = listOf(
                "Preheat oven to 400°F (200°C). Line a baking sheet with parchment paper or foil.",
                "Place salmon fillets skin-side down and season with salt, pepper, minced garlic, lemon slices, and fresh dill.",
                "Drizzle with olive oil or melted butter for added flavor.",
                "Bake for 12–15 minutes, depending on thickness, until salmon flakes easily with a fork.",
                "Serve with a squeeze of fresh lemon and your choice of sides."
            ),
            cookingTime = 20,
            allergenInfo = listOf("fish"),
            photoRes = R.drawable.baked_salmon
        ),
        Recipes(
            id = "22",
            name = "Avocado Toast",
            description = "Trendy toast topped with creamy avocado.",
            ingredients = listOf("Bread", "Avocado", "Lemon Juice", "Chili Flakes"),
            measurements = listOf("2 slices", "1 avocado mashed", "1 tsp", "to taste", "to taste"),
            ingredientWeights = listOf(0.4, 0.4, 0.1, 0.1),
            instructions = listOf(
                "Toast slices of whole grain or sourdough bread until golden and crisp.",
                "In a bowl, mash ripe avocado with lemon juice, salt, and a dash of pepper (optional: chili flakes or garlic powder).",
                "Spread the mashed avocado evenly over the toasted bread.",
                "Top with optional ingredients like poached egg, sliced tomatoes, radishes, or feta cheese.",
                "Finish with a final sprinkle of salt, pepper, or drizzle of olive oil. Serve immediately."
            ),
            cookingTime = 5,
            allergenInfo = listOf("gluten"),
            photoRes = R.drawable.avocado_toast
        ),
        Recipes(
            id = "23",
            name = "Butternut Squash Soup",
            description = "Velvety soup made with roasted butternut squash.",
            ingredients = listOf("Butternut Squash", "Onion", "Garlic", "Vegetable Broth", "Cream"),
            measurements = listOf(
                "1 squash",
                "1/2 cup chopped",
                "2 cloves minced",
                "4 cups",
                "1 cup"
            ),
            ingredientWeights = listOf(0.5, 0.2, 0.1, 0.15, 0.05),
            instructions = listOf(
                "Preheat your oven to 400°F (200°C). Slice the butternut squash in half, remove the seeds, and drizzle with olive oil. Roast on a baking sheet for 25-30 minutes or until the squash is tender.",
                "In a large pot, heat some oil over medium heat. Add chopped onion and minced garlic. Sauté until the onion becomes translucent and the garlic fragrant, about 5 minutes.",
                "Scoop the flesh of the roasted squash into the pot with the onions and garlic. Add the vegetable broth, bring to a simmer, and cook for 10 minutes.",
                "Use an immersion blender or transfer the soup to a blender in batches. Blend until smooth and creamy.",
                "Stir in the cream, season with salt and pepper to taste, and serve warm."
            ),
            cookingTime = 35,
            allergenInfo = listOf("dairy"),
            photoRes = R.drawable.butternut_squash_soup
        ),
        Recipes(
            id = "24",
            name = "Buffalo Wings",
            description = "Spicy and tangy buffalo-style chicken wings.",
            ingredients = listOf("Chicken Wings", "Hot Sauce", "Butter", "Garlic Powder"),
            measurements = listOf("2 pounds", "1/2 cup", "1/4 cup", "1 tsp", "1 tsp"),
            ingredientWeights = listOf(0.6, 0.2, 0.15, 0.05),
            instructions = listOf(
                "Preheat your oven to 400°F (200°C) or heat oil in a deep fryer to 375°F (190°C). If baking, place the chicken wings on a baking sheet and bake for 25-30 minutes or until crispy and golden.",
                "While the wings are cooking, melt butter in a saucepan over medium heat. Add hot sauce and stir to combine. Let the sauce simmer for 5 minutes to thicken slightly.",
                "Once the wings are crispy, remove them from the oven or fryer and place them into a large bowl.",
                "Pour the hot sauce mixture over the wings and toss them to coat evenly. Add garlic powder and salt to taste.",
                "Serve immediately, garnished with extra sauce if desired, and enjoy!"
            )
            ,
            cookingTime = 30,
            allergenInfo = listOf("dairy"),
            photoRes = R.drawable.buffalo_wings
        ),
        Recipes(
            id = "25",
            name = "Teriyaki Chicken",
            description = "Savory and sweet chicken glazed with teriyaki sauce.",
            ingredients = listOf("Chicken Thighs", "Soy Sauce", "Sugar", "Ginger", "Garlic"),
            measurements = listOf(
                "4 thighs",
                "1/2 cup",
                "2 tbsp",
                "1 tsp grated",
                "2 cloves minced"
            ),
            ingredientWeights = listOf(0.5, 0.2, 0.15, 0.1, 0.05),
            instructions = listOf(
                "Heat a skillet over medium-high heat and add a little oil. Cook the chicken thighs until browned and cooked through, about 6-7 minutes per side.",
                "While the chicken is cooking, in a separate bowl, whisk together soy sauce, sugar, grated ginger, and minced garlic to make the teriyaki sauce.",
                "Once the chicken is cooked, pour the teriyaki sauce over the chicken and allow it to simmer for 3-4 minutes, stirring occasionally, until the sauce thickens slightly.",
                "Serve the teriyaki chicken with rice or vegetables, and drizzle the extra sauce over the top."
            ),
            cookingTime = 25,
            allergenInfo = listOf("soy"),
            photoRes = R.drawable.teriyaki_chicken
        ),
        Recipes(
            id = "26",
            name = "Banana Bread",
            description = "Moist and sweet banana bread loaf.",
            ingredients = listOf("Bananas", "Flour", "Sugar", "Eggs", "Butter", "Baking Soda"),
            measurements = listOf("3 bananas", "2 cups", "1 cup", "2 eggs", "1/2 cup", "1 tsp"),
            ingredientWeights = listOf(0.35, 0.3, 0.15, 0.1, 0.05, 0.05),
            instructions = listOf(
                "Preheat your oven to 350°F (175°C). Grease and flour a loaf pan or line it with parchment paper.",
                "In a large mixing bowl, mash the bananas with a fork until smooth. Add eggs, melted butter, and mix well.",
                "In another bowl, whisk together flour, sugar, and baking soda. Slowly add the dry ingredients into the banana mixture and stir until combined.",
                "Pour the batter into the prepared loaf pan and smooth the top with a spatula.",
                "Bake for 50-60 minutes, or until a toothpick inserted into the center comes out clean. Let the bread cool before slicing."
            ),
            cookingTime = 50,
            allergenInfo = listOf("gluten", "eggs", "dairy"),
            photoRes = R.drawable.banana_bread
        ),
        Recipes(
            id = "27",
            name = "Chicken Fajitas",
            description = "Sizzling fajitas with marinated chicken and bell peppers.",
            ingredients = listOf(
                "Chicken Breast",
                "Bell Peppers",
                "Onion",
                "Fajita Seasoning",
                "Tortillas"
            ),
            measurements = listOf(
                "1 pound",
                "2 peppers sliced",
                "1 onion sliced",
                "1 packet",
                "4 tortillas"
            ),
            ingredientWeights = listOf(0.4, 0.25, 0.2, 0.1, 0.05),
            instructions = listOf(
                "In a bowl, mix fajita seasoning with a bit of olive oil to create a marinade. Coat the chicken breasts with the marinade and let it sit for 15-20 minutes to absorb the flavors.",
                "In a large skillet, heat some oil over medium-high heat. Cook the marinated chicken for about 5-7 minutes per side or until cooked through and golden brown.",
                "While the chicken is cooking, slice the bell peppers and onion. Remove the chicken from the pan and set it aside.",
                "In the same skillet, sauté the sliced bell peppers and onion for 3-5 minutes until tender and slightly caramelized.",
                "Slice the cooked chicken into thin strips and return it to the pan with the vegetables. Toss everything together and cook for an additional 2 minutes.",
                "Serve the fajita mixture in tortillas, garnished with sour cream, salsa, or cheese if desired."
            ),
            cookingTime = 20,
            allergenInfo = listOf("gluten"),
            photoRes = R.drawable.chicken_fajitas
        ),
        Recipes(
            id = "28",
            name = "Quesadilla",
            description = "Crispy tortilla filled with melted cheese and chicken.",
            ingredients = listOf("Tortilla", "Chicken Breast", "Cheese", "Onion", "Bell Pepper"),
            measurements = listOf(
                "2 tortillas",
                "1 cup shredded",
                "2 cups shredded",
                "1/2 cup diced",
                "1/2 cup diced"
            ),
            ingredientWeights = listOf(0.3, 0.3, 0.25, 0.1, 0.05),
            instructions = listOf(
                "Shred cooked chicken and mix with shredded cheese in a bowl. You can also add diced onions and bell peppers for extra flavor.",
                "Place a tortilla in a heated skillet over medium heat. Spread the chicken and cheese mixture evenly over the tortilla.",
                "Top with another tortilla and cook for 2-3 minutes on each side, or until both tortillas are golden brown and the cheese is melted inside.",
                "Remove from the pan and slice into wedges. Serve with salsa, guacamole, or sour cream."
            ),
            cookingTime = 10,
            allergenInfo = listOf("gluten", "dairy"),
            photoRes = R.drawable.quesadilla
        ),
        Recipes(
            id = "29",
            name = "Grilled Steak",
            description = "Tender grilled steak with a flavorful crust.",
            ingredients = listOf("Steak", "Olive Oil", "Garlic"),
            measurements = listOf("1 steak", "2 tbsp", "2 cloves minced", "to taste", "to taste"),
            ingredientWeights = listOf(0.7, 0.15, 0.2),
            instructions = listOf(
                "Season both sides of the steak generously with salt, pepper, and minced garlic. You can also rub with olive oil for extra flavor.",
                "Preheat a grill or grill pan to medium-high heat. Place the steak on the grill and cook for 4-5 minutes per side for medium-rare, or longer if you prefer your steak cooked more.",
                "Once cooked to your desired doneness, remove the steak from the grill and let it rest for 5 minutes before slicing to retain the juices.",
                "Serve with your favorite sides and enjoy the tender, flavorful steak!"
            ),
            cookingTime = 15,
            allergenInfo = listOf(),
            photoRes = R.drawable.grilled_steak
        ),
        Recipes(
            id = "30",
            name = "Roasted Vegetables",
            description = "Colorful roasted vegetables with a caramelized finish.",
            ingredients = listOf("Broccoli", "Carrots", "Brussels Sprouts", "Olive Oil"),
            measurements = listOf(
                "1 cup florets",
                "1 cup sliced",
                "1 cup halved",
                "2 tbsp",
                "to taste"
            ),
            ingredientWeights = listOf(0.3, 0.25, 0.2, 0.15),
            instructions = listOf(
                "Preheat your oven to 400°F (200°C). Cut the broccoli into florets, slice the carrots, and halve the Brussels sprouts.",
                "In a large bowl, toss the vegetables with olive oil and salt until evenly coated.",
                "Spread the vegetables in a single layer on a baking sheet. Roast for 20-25 minutes, tossing once halfway through, until the vegetables are tender and caramelized.",
                "Serve warm as a side dish or top with grated parmesan cheese for added flavor."
            ),
            cookingTime = 25,
            allergenInfo = listOf(),
            photoRes = R.drawable.roasted_vegetables
        ),
        Recipes(
            id = "31",
            name = "Lentil Soup",
            description = "Hearty and comforting lentil soup.",
            ingredients = listOf("Lentils", "Vegetable Broth", "Onion", "Carrot", "Celery"),
            measurements = listOf(
                "1 cup",
                "4 cups",
                "1 onion chopped",
                "2 carrots chopped",
                "2 stalks chopped"
            ),
            ingredientWeights = listOf(0.4, 0.3, 0.15, 0.1, 0.05),
            instructions = listOf(
                "Heat some oil in a large pot over medium heat. Add chopped onion, carrot, and celery. Sauté for 5-7 minutes until the vegetables are softened.",
                "Add the lentils to the pot, followed by the vegetable broth. Bring to a boil, then reduce the heat and simmer for about 30 minutes until the lentils are tender.",
                "Season with salt and pepper to taste, and serve hot with a slice of crusty bread."
            ),
            cookingTime = 40,
            allergenInfo = listOf(),
            photoRes = R.drawable.lentil_soup
        ),
        Recipes( id = "32",
            name = "Chicken Tikka Masala",
            description = "Rich and creamy Indian-inspired chicken dish with homemade tikka masala sauce.",
            ingredients = listOf("Chicken Breast", "Yogurt", "Garlic", "Ginger", "Onion", "Tomato Puree", "Heavy Cream", "Garam Masala", "Turmeric", "Ground Cumin", "Paprika", "Chili Powder", "Salt", "Oil"),
            measurements = listOf("1 pound", "1 cup", "2 cloves minced", "1 tsp grated", "1 medium finely chopped", "1 cup", "1/2 cup", "1 tsp", "1/2 tsp", "1/2 tsp", "1/2 tsp", "1/4 tsp", "to taste", "2 tbsp"),
            ingredientWeights = listOf(0.3, 0.1, 0.05, 0.05, 0.1, 0.1, 0.1, 0.05, 0.03, 0.03, 0.03, 0.03, 0.0, 0.03),
            instructions = listOf("Marinate 1 pound chicken breast (cut into pieces) in 1 cup yogurt, 2 minced garlic cloves, and 1 tsp grated ginger for at least 30 minutes.",
                "Heat 2 tbsp oil in a heavy pan and sauté 1 medium finely chopped onion until soft.",
                "Add 1 cup tomato puree and cook for 2 minutes.",
                "Stir in 1 tsp garam masala, 1/2 tsp turmeric, 1/2 tsp ground cumin, 1/2 tsp paprika, and 1/4 tsp chili powder; cook for another minute.",
                "Pour in 1/2 cup heavy cream, season with salt to taste, and simmer the sauce until slightly thickened.",
                "Add the marinated chicken to the sauce and cook over medium heat for 10-15 minutes until the chicken is cooked through.",
                "Serve over basmati rice and garnish with fresh cilantro."),
            cookingTime = 30, allergenInfo = listOf("dairy"),
            photoRes = R.drawable.chicken_tikka_masala )
        ,
        Recipes(
            id = "33",
            name = "Beef and Broccoli Stir-Fry",
            description = "Quick and easy stir-fry with beef and broccoli.",
            ingredients = listOf("Beef", "Broccoli", "Soy Sauce", "Garlic", "Ginger"),
            measurements = listOf(
                "1 pound",
                "1 cup florets",
                "2 tbsp",
                "2 cloves minced",
                "1 tsp grated"
            ),
            ingredientWeights = listOf(0.5, 0.25, 0.15, 0.05, 0.05),
            instructions = listOf(
                "Heat some oil in a large skillet or wok over medium-high heat. Sauté the thinly sliced beef for 3-4 minutes until browned and cooked through.",
                "Add the minced garlic and grated ginger, and cook for an additional 1-2 minutes until fragrant.",
                "Add the broccoli florets and soy sauce to the skillet, and stir-fry for 5-7 minutes until the broccoli is tender yet crisp.",
                "Serve the stir-fry over steamed rice and enjoy a quick and healthy meal."
            ),
            cookingTime = 15,
            allergenInfo = listOf("soy"),
            photoRes = R.drawable.beef_and_broccoli_stir_fry
        ),
        Recipes(
            id = "34",
            name = "Shrimp Scampi",
            description = "Light and flavorful shrimp scampi with garlic and lemon.",
            ingredients = listOf("Shrimp", "Garlic", "Lemon Juice", "Butter", "Parsley"),
            measurements = listOf(
                "1 pound",
                "3 cloves minced",
                "2 tbsp",
                "2 tbsp",
                "1/4 cup chopped"
            ),
            ingredientWeights = listOf(0.6, 0.15, 0.1, 0.1, 0.05),
            instructions = listOf(
                "Melt butter in a large skillet over medium heat. Once the butter is melted, add the minced garlic and sauté for 1-2 minutes until fragrant. Be careful not to burn the garlic.",
                "Add the shrimp to the pan and cook for 2-3 minutes on each side, or until they turn pink and opaque. Stir occasionally to ensure even cooking.",
                "Pour in the lemon juice and stir to coat the shrimp. Let the mixture simmer for another minute, allowing the flavors to combine.",
                "Garnish the dish with chopped parsley, give it a quick stir, and serve immediately over pasta or your favorite side dish."
            ),
            cookingTime = 10,
            allergenInfo = listOf("shellfish", "dairy"),
            photoRes = R.drawable.shrimp_scampi
        ),
        Recipes(
            id = "35",
            name = "Vegetable Skewers",
            description = "Colorful vegetable skewers with a Mediterranean twist.",
            ingredients = listOf("Bell Peppers", "Onion", "Mushrooms", "Zucchini", "Olive Oil"),
            measurements = listOf(
                "2 peppers sliced",
                "1 onion sliced",
                "1 cup sliced",
                "1 zucchini sliced",
                "2 tbsp"
            ),
            ingredientWeights = listOf(0.25, 0.2, 0.2, 0.2, 0.15),
            instructions = listOf(
                "Start by washing and slicing the bell peppers, onion, zucchini, and mushrooms. Make sure all vegetables are cut into similar-sized pieces to ensure even cooking.",
                "Thread the vegetables onto skewers, alternating the types of vegetables for a colorful mix. Don't over-pack them, as this can cause uneven cooking.",
                "Preheat the grill or oven to medium-high heat. Brush each skewer generously with olive oil to prevent sticking and enhance flavor.",
                "Place the skewers on the grill or in the oven. Grill or bake for 12-15 minutes, turning occasionally, until the vegetables are tender and slightly charred."
            ),
            cookingTime = 15,
            allergenInfo = listOf(),
            photoRes = R.drawable.vegetable_skewers
        ),
        Recipes( id = "36",
            name = "Chicken Caesar Wrap",
            description = "Crisp wrap filled with grilled chicken, romaine lettuce, shaved parmesan, and homemade Caesar dressing.",
            ingredients = listOf("Chicken Breast", "Romaine Lettuce", "Parmesan Cheese", "Tortilla", "Garlic", "Anchovy Fillets", "Egg Yolk", "Dijon Mustard", "Lemon Juice", "Olive Oil"),
            measurements = listOf("1 cup cooked", "2 cups chopped", "1/2 cup shaved", "1 tortilla", "1 clove minced", "2 fillets", "1", "1 tsp", "1 tbsp", "1/4 cup"),
            ingredientWeights = listOf(0.4, 0.25, 0.15, 0.1, 0.05, 0.05, 0.05, 0.1, 0.05, 0.5),
            instructions = listOf(
                "Grill the chicken breast until fully cooked (about 6-7 minutes per side) and slice into thin strips.",
                "In a small bowl for the dressing, combine 1 clove minced garlic, 2 anchovy fillets (mashed), 1 egg yolk, 1 tsp Dijon mustard, and 1 tbsp lemon juice; then slowly whisk in 1/4 cup olive oil until well emulsified; season with salt and freshly ground black pepper.",
                "Toss 2 cups chopped romaine lettuce thoroughly with the homemade Caesar dressing.",
                "Lay 1 tortilla flat, arrange the grilled chicken strips in the center, add the dressed lettuce, and top with 1/2 cup shaved Parmesan cheese.", "Fold in the sides and roll tightly to form the wrap." ),
            cookingTime = 15,
            allergenInfo = listOf("gluten", "wheat", "dairy", "eggs", "fish"), photoRes = R.drawable.chicken_caesar_wrap )
        ,
        Recipes(
            id = "37",
            name = "Mac and Cheese",
            description = "Creamy macaroni and cheese with a crispy top.",
            ingredients = listOf("Macaroni", "Cheese", "Milk", "Butter", "Breadcrumbs"),
            measurements = listOf("1 cup", "2 cups shredded", "2 cups", "2 tbsp", "1/2 cup"),
            ingredientWeights = listOf(0.4, 0.3, 0.2, 0.05, 0.05),
            instructions = listOf(
                "Boil a pot of salted water and cook the macaroni until al dente, about 8-10 minutes. Drain the macaroni and set aside.",
                "In a separate saucepan, melt butter over medium heat. Stir in the milk and bring it to a simmer. Slowly whisk in the shredded cheese until melted and the sauce is smooth.",
                "Combine the cooked macaroni with the cheese sauce, stirring until fully coated. If the sauce is too thick, add a little extra milk to reach your desired consistency.",
                "Transfer the mac and cheese to a baking dish, sprinkle breadcrumbs on top, and bake in a preheated oven at 375°F (190°C) for 15-20 minutes until the top is golden brown."
            ),
            cookingTime = 30,
            allergenInfo = listOf("gluten", "dairy"),
            photoRes = R.drawable.mac_and_cheese
        ),
        Recipes( id = "38",
            name = "Meatball Subs",
            description = "Hearty meatball subs with homemade meatballs, marinara sauce, and melted mozzarella cheese.",
            ingredients = listOf("Ground Beef", "Egg", "Breadcrumbs", "Parmesan Cheese", "Garlic", "Parsley", "Marinara Sauce", "Mozzarella Cheese", "Bread"),
            measurements = listOf("1 pound", "1 egg", "1/2 cup", "1/4 cup grated", "2 cloves minced", "2 tbsp chopped", "1 cup", "1 cup shredded", "1 loaf"),
            ingredientWeights = listOf(0.3, 0.1, 0.1, 0.1, 0.05, 0.05, 0.2, 0.1, 0.1),
            instructions = listOf("In a bowl, combine 1 pound ground beef, 1 egg, 1/2 cup breadcrumbs, 1/4 cup grated Parmesan cheese, 2 minced garlic cloves, and 2 tbsp chopped parsley; season with salt and pepper.", "Shape the mixture into 4-5 meatballs.", "Heat a skillet over medium heat and cook the meatballs until browned on all sides and cooked through (about 8–10 minutes); then set them aside.", "In the same skillet, heat 1 cup marinara sauce over medium heat, add the meatballs back, and let them simmer for about 5 minutes.", "While simmering, slice 4 sub rolls in half and lightly toast them.", "Fill each toasted roll with meatballs and sauce, then top each sub with 1 cup shredded mozzarella cheese.", "Place the assembled subs under a broiler or in an oven preheated to 375°F (190°C) for 5–7 minutes until the cheese melts and turns bubbly.", "Serve warm." ),
            cookingTime = 20, allergenInfo = listOf("gluten", "dairy"),
            photoRes = R.drawable.meatball_subs
        ),
        Recipes(
            id = "39",
            name = "Chicken and Rice Bowl",
            description = "Simple and satisfying chicken and rice bowl.",
            ingredients = listOf("Chicken Breast", "Rice", "Vegetable Broth", "Soy Sauce"),
            measurements = listOf("1 pound", "1 cup cooked", "2 cups", "1 tbsp"),
            ingredientWeights = listOf(0.5, 0.3, 0.15, 0.05),
            instructions = listOf(
                "In a large skillet, cook the chicken breast until browned and fully cooked, about 6-7 minutes per side. Once done, dice the chicken into small pieces.",
                "In a separate pot, cook the rice according to the package instructions. Once cooked, fluff with a fork and set aside.",
                "In a saucepan, heat the vegetable broth and soy sauce over medium heat. Stir in the cooked chicken and rice, mixing everything together until evenly combined.",
                "Allow the mixture to simmer for 2-3 minutes to let the flavors meld, then serve the chicken and rice bowl hot."
            ),
            cookingTime = 20,
            allergenInfo = listOf("soy"),
                photoRes = R.drawable.chicken_and_rice_bowl
        ),
        Recipes(
            id = "40",
            name = "Spinach and Artichoke Dip",
            description = "Creamy spinach and artichoke dip with a crispy top.",
            ingredients = listOf(
                "Spinach",
                "Artichoke Hearts",
                "Cream Cheese",
                "Mayonnaise",
                "Parmesan Cheese"
            ),
            measurements = listOf(
                "1 cup frozen",
                "1 cup canned",
                "1 cup",
                "1/2 cup",
                "1/2 cup grated"
            ),
            ingredientWeights = listOf(0.3, 0.25, 0.2, 0.15, 0.1),
            instructions = listOf(
                "Preheat the oven to 375°F (190°C). In a large bowl, combine the spinach, artichoke hearts, cream cheese, and mayonnaise. Mix until smooth and evenly combined.",
                "Transfer the mixture into a baking dish, then sprinkle grated parmesan cheese evenly over the top.",
                "Bake in the preheated oven for 20-25 minutes, or until the top is golden brown and the dip is hot and bubbly.",
                "Remove from the oven and allow it to cool slightly before serving with crackers or fresh bread for dipping."
            ),
            cookingTime = 25,
            allergenInfo = listOf("dairy"),
            photoRes = R.drawable.spinach_and_artichoke_dip
        ),
        Recipes(
            id = "41",
            name = "Garlic Knots",
            description = "Homemade garlic knots made from scratch pizza dough and topped with garlic butter and parmesan cheese.",
            ingredients = listOf("Flour", "Yeast", "Sugar", "Water", "Olive Oil", "Garlic", "Butter", "Parmesan Cheese"),
            measurements = listOf("300 grams", "2 tsp", "1 tsp", "200 ml", "1 tbsp", "3 cloves minced", "2 tbsp", "1/4 cup grated"),
            ingredientWeights = listOf(0.35, 0.15, 0.05, 0.2, 0.05, 0.1, 0.15, 0.1),
            instructions = listOf(
                "In a large bowl, combine 300 grams of flour, 1 tsp salt, 1 tsp sugar, and 2 tsp yeast.",
                "Gradually add 200 ml of warm water and 1 tbsp olive oil; mix until a soft dough forms.",
                "Turn the dough onto a floured surface and knead for 8–10 minutes until smooth and elastic.",
                "Place the kneaded dough in a lightly oiled bowl, cover, and let it rise for 1 hour until doubled in size.",
                "Preheat the oven to 375°F (190°C).",
                "Punch down the risen dough and roll it out into a rectangle about 1/2 inch thick.",
                "Cut the dough into 1-inch-wide strips and tie each strip into a knot.",
                "Arrange the knots on a greased baking sheet.",
                "In a small saucepan, melt 2 tbsp butter over medium heat; add 3 cloves minced garlic and sauté for 1–2 minutes until fragrant.",
                "Brush the garlic butter over the dough knots and sprinkle with 1/4 cup grated parmesan cheese.",
                "Bake for 12–15 minutes until the knots are golden brown.",
                "Serve warm."
            ),
            cookingTime = 15,
            allergenInfo = listOf("gluten", "dairy"),
            photoRes = R.drawable.garlic_knots
        ),
        Recipes(
            id = "42",
            name = "Chicken Quesadilla Casserole",
            description = "Layered casserole with chicken, tortillas, and cheese.",
            ingredients = listOf("Chicken Breast", "Tortillas", "Cheese", "Salsa"),
            measurements = listOf("1 pound", "6 tortillas", "2 cups shredded", "1 cup"),
            ingredientWeights = listOf(0.4, 0.3, 0.2, 0.1),
            instructions = listOf(
                "Shred the cooked chicken breast and mix it with salsa in a bowl. Ensure the chicken is evenly coated with the salsa for added flavor.",
                "In a baking dish, layer the tortillas, then top with a generous layer of the shredded chicken mixture. Add a layer of cheese over the chicken, and repeat the layers until all ingredients are used up.",
                "Bake the casserole at 375°F (190°C) for 20-25 minutes or until the cheese is melted and bubbly. Let it cool slightly before serving."
            ),
            cookingTime = 30,
            allergenInfo = listOf("gluten", "wheat", "dairy"),
            photoRes = R.drawable.chicken_quesadilla_casserole
        ),
        Recipes(
            id = "43",
            name = "Breakfast Burrito",
            description = "Hearty breakfast burrito with scrambled eggs and sausage.",
            ingredients = listOf("Scrambled Eggs", "Sausage", "Tortilla", "Cheese"),
            measurements = listOf("2 eggs", "2 sausages", "1 tortilla", "1/4 cup shredded"),
            ingredientWeights = listOf(0.4, 0.3, 0.2, 0.1),
            instructions = listOf(
                "In a pan, scramble the eggs over medium heat, stirring occasionally until cooked through but still soft.",
                "Cook the sausage in the same pan or another, breaking it apart into small pieces as it cooks. Drain any excess fat.",
                "Warm the tortilla slightly by placing it in a dry skillet for 1-2 minutes or heating it in the microwave for 15 seconds.",
                "Assemble the burrito by placing scrambled eggs, sausage, and shredded cheese in the center of the tortilla. Roll it up, folding in the sides as you go."
            ),
            cookingTime = 10,
            allergenInfo = listOf("eggs", "gluten", "dairy"),
            photoRes = R.drawable.breakfast_burrito
        ),
        Recipes(
            id = "44",
            name = "Cinnamon Rolls",
            description = "Sweet and gooey cinnamon rolls with a soft and fluffy interior.",
            ingredients = listOf("Flour", "Sugar", "Yeast", "Cinnamon", "Butter"),
            measurements = listOf("2 cups", "1/2 cup", "1 tsp", "1 tsp", "1/4 cup"),
            ingredientWeights = listOf(0.4, 0.25, 0.1, 0.1, 0.15),
            instructions = listOf(
                "In a bowl, mix the flour, sugar, yeast, and cinnamon to create the dry ingredients for the dough.",
                "Add in the wet ingredients, including butter, to form a dough. Knead the dough until smooth, then cover and let it rise in a warm spot for about 1 hour or until doubled in size.",
                "Roll the dough out into a rectangle, spread softened butter over it, then sprinkle the cinnamon and sugar mixture evenly on top. Roll the dough up tightly and slice it into 12 equal pieces.",
                "Place the rolls in a greased baking dish and bake at 375°F (190°C) for 15-20 minutes or until golden brown. Let them cool slightly before serving."
            ),
            cookingTime = 25,
            allergenInfo = listOf("gluten", "dairy"),
            photoRes = R.drawable.cinnamon_rolls
        ),
        Recipes(
            id = "45",
            name = "Chicken and Vegetable Kabobs",
            description = "Colorful kabobs with marinated chicken and vegetables.",
            ingredients = listOf(
                "Chicken Breast",
                "Bell Peppers",
                "Onion",
                "Mushrooms",
                "Olive Oil"
            ),
            measurements = listOf(
                "1 pound",
                "2 peppers sliced",
                "1 onion sliced",
                "1 cup sliced",
                "2 tbsp"
            ),
            ingredientWeights = listOf(0.4, 0.2, 0.15, 0.15, 0.1),
            instructions = listOf(
                "Marinate the chicken breast pieces in olive oil, salt, pepper, and any preferred herbs for at least 30 minutes.",
                "While the chicken marinates, prepare the vegetables by washing and slicing the bell peppers, onion, and mushrooms.",
                "Thread the marinated chicken and vegetables onto skewers, alternating the ingredients for an even mix of flavors.",
                "Grill or bake the kabobs at 400°F (200°C) for 15-20 minutes, turning occasionally, until the chicken is fully cooked and the vegetables are tender."
            ),
            cookingTime = 20,
            allergenInfo = listOf(),
            photoRes = R.drawable.chicken_and_vegetable_kabobs
        ),
        Recipes(
            id = "46",
            name = "Beef Tacos (new recipe)",
            description = "Tasty beef tacos with a crunchy shell.",
            ingredients = listOf("Ground Beef", "Taco Seasoning", "Tortillas", "Cheese", "Lettuce"),
            measurements = listOf(
                "1 pound",
                "1 packet",
                "8 tortillas",
                "1 cup shredded",
                "1 cup shredded"
            ),
            ingredientWeights = listOf(0.4, 0.15, 0.2, 0.15, 0.1),
            instructions = listOf(
                "In a skillet, cook the ground beef over medium heat, breaking it apart with a spatula as it cooks. Once browned, add the taco seasoning and a splash of water, stirring to combine.",
                "Warm the tortillas in a dry skillet or microwave for 10-15 seconds until pliable.",
                "Assemble the tacos by spooning the seasoned beef into the center of each tortilla. Top with shredded cheese and lettuce.",
                "Serve the tacos immediately, optionally adding salsa or other toppings like sour cream or guacamole."
            ),
            cookingTime = 20,
            allergenInfo = listOf("gluten", "dairy"),
            photoRes = R.drawable.beef_tacos_new
        ),
        Recipes(
            id = "47",
            name = "Chicken Salad",
            description = "Refreshing chicken salad with grapes and almonds.",
            ingredients = listOf("Chicken Breast", "Grapes", "Almonds", "Mayonnaise"),
            measurements = listOf("1 pound", "1 cup", "1/2 cup sliced", "1/4 cup"),
            ingredientWeights = listOf(0.5, 0.1, 0.15, 0.25),
            instructions = listOf(
                "Shred or chop the cooked chicken breast into bite-sized pieces.",
                "Wash the grapes and cut them in half. Slice the almonds into smaller pieces if needed.",
                "In a large mixing bowl, combine the shredded chicken, halved grapes, and sliced almonds. Add mayonnaise and stir everything together until well coated.",
                "Chill in the refrigerator for 15 minutes before serving, or enjoy immediately."
            ),
            cookingTime = 10,
            allergenInfo = listOf(),
            photoRes = R.drawable.chicken_salad
        ),
        Recipes(
            id = "48",
            name = "Baked Chicken Thighs",
            description = "Tender baked chicken thighs with a crispy skin.",
            ingredients = listOf("Chicken Thighs", "Olive Oil"),
            measurements = listOf("4 thighs", "2 tbsp", "to taste", "to taste"),
            ingredientWeights = listOf(0.7, 0.3),
            instructions = listOf(
                "Preheat your oven to 400°F (200°C). While it heats, season the chicken thighs with salt and pepper on both sides.",
                "Place the chicken thighs on a baking sheet lined with parchment paper or aluminum foil. Drizzle with olive oil to ensure crispy skin.",
                "Bake for 20-25 minutes or until the chicken reaches an internal temperature of 165°F (75°C) and the skin is golden and crispy.",
                "Let the chicken rest for 5 minutes before serving."
            ),
            cookingTime = 25,
            allergenInfo = listOf(),
            photoRes = R.drawable.baked_chicken_thighs
        ),
        Recipes(
            id = "49",
            name = "Roasted Sweet Potatoes",
            description = "Sweet and nutty roasted sweet potatoes.",
            ingredients = listOf("Sweet Potatoes", "Olive Oil"),
            measurements = listOf("2 sweet potatoes", "2 tbsp", "to taste", "to taste"),
            ingredientWeights = listOf(0.8, 0.2),
            instructions = listOf(
                "Preheat the oven to 425°F (220°C). Wash and peel the sweet potatoes, then cut them into 1-inch cubes.",
                "Toss the sweet potato cubes with olive oil, salt, and pepper until evenly coated.",
                "Spread the seasoned sweet potatoes in a single layer on a baking sheet. Roast for 25-30 minutes, flipping halfway through, until the potatoes are tender and slightly caramelized."
            ),
            cookingTime = 30,
            allergenInfo = listOf(),
            photoRes = R.drawable.roasted_sweet_potatoes
        ),
        Recipes(
            id = "50",
            name = "Chocolate Chip Cookies",
            description = "Soft-baked cookies filled with chocolate chips.",
            ingredients = listOf("Butter", "Sugar", "Eggs", "Flour", "Chocolate Chips"),
            measurements = listOf("1 cup", "3/4 cup", "2 eggs", "2 1/4 cups", "2 cups"),
            ingredientWeights = listOf(0.2, 0.25, 0.1, 0.3, 0.15),
            instructions = listOf(
                "Preheat the oven to 375°F (190°C). In a large mixing bowl, cream together the softened butter and sugar until smooth.",
                "Add the eggs one at a time, mixing well after each addition. Stir in the vanilla extract.",
                "In a separate bowl, combine the flour, baking soda, and salt. Gradually add the dry ingredients to the wet mixture, mixing until just combined.",
                "Fold in the chocolate chips, then drop spoonfuls of dough onto a baking sheet, spacing them about 2 inches apart.",
                "Bake for 10-12 minutes or until the edges are golden brown. Let the cookies cool on the baking sheet for 5 minutes before transferring to a wire rack."
            ),
            cookingTime = 12,
            allergenInfo = listOf("gluten", "dairy", "eggs"),
            photoRes = R.drawable.chocolate_chip_cookies
        )
    )
}

