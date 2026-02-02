package com.android.readysetcook

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.EditText
import android.text.TextWatcher
import android.text.Editable
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.android.data.FAQ

class HelpSupportActivity : Activity() {
    private val faqList = listOf(
        FAQ("How do I reset my password?",
            "1. Go to the login screen\n2. Tap 'Forgot Password'\n3. Enter your email address\n4. Follow the reset instructions sent to your email"),
            
        FAQ("Why can't I see certain recipes?",
            "Some recipes might be filtered out due to:\n• Your selected allergen preferences\n• Missing key ingredients\n• Regional availability"),

        FAQ("How do I update my allergy information?",
            "Go to the Ingredients screen, choose a category, then tap the filter icon to exclude ingredients you're allergic to. All recipe recommendations will automatically adjust based on your filtered preferences."),
            
        FAQ("Can I save recipes for offline viewing?",
            "Yes! Add recipes to your favorites by tapping the heart icon. These recipes will be available even without an internet connection."),
            
        FAQ("How does the ingredient checklist work?",
            "1. Go to 'My Ingredients'\n2. Browse categories or use the search bar\n3. Tap items you have\n4. The app will automatically show recipes you can make"),

        FAQ("Where can I find my cooking history?",
            "This feature is still in progress. Stay tuned for updates!"),
            
        FAQ("How accurate is the nutritional information?",
            "Our nutritional data is sourced from verified databases and is regularly updated. Values are approximate and based on standard serving sizes."),

        FAQ("Can I share recipes with friends?",
            "For now, you can recommend the app to your friends manually. The feature to share recipe links digitally is currently in development and will be available soon."),

        FAQ("Can I change my profile picture?",
            "Yes, you can! Go to the menu bar > Profile screen, tap on your current picture, then choose a new one from your device. Press the Save button to update your profile successfully."),
            
        FAQ("Why did my favorite recipe disappear?",
            "Recipes might be temporarily unavailable due to:\n• Content updates\n• Seasonal changes\n• Regional restrictions\nThey usually return within 24 hours."),

        FAQ("How do I report an issue with a recipe?",
            "You can report any issues by contacting us at support@readysetcook.com Please include specific details to help us improve."),
            
        FAQ("Can I suggest new features?",
            "We love hearing from our users! Send feature suggestions through Settings > Feedback or email us at support@readysetcook.com")
    )
    
    private val faqViews = mutableListOf<CardView>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_support)
        
        val backArrow = findViewById<ImageView>(R.id.back_arrow)
        val searchBar = findViewById<EditText>(R.id.search_bar)
        val faqContainer = findViewById<LinearLayout>(R.id.faq_container)
        
        backArrow.setOnClickListener {
            finish()
        }

        faqList.forEachIndexed { index, faq ->
            val cardView = createFAQCard(faq, index)
            faqViews.add(cardView)
            faqContainer.addView(cardView)
        }

        searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterFAQs(s.toString().lowercase())
            }
            
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun createFAQCard(faq: FAQ, index: Int): CardView {
        val card = layoutInflater.inflate(R.layout.faq_item, null) as CardView

        // Set margin manually
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(0, 10, 0, 10) // left, top, right, bottom
        card.layoutParams = layoutParams

        val questionText = card.findViewById<TextView>(R.id.question_text)
        val answerText = card.findViewById<TextView>(R.id.answer_text)
        val expandIcon = card.findViewById<ImageView>(R.id.expand_icon)
        val divider = card.findViewById<View>(R.id.divider)

        questionText.text = faq.question
        answerText.text = faq.answer
        answerText.visibility = if (faq.isExpanded) View.VISIBLE else View.GONE
        divider.visibility = if (faq.isExpanded) View.VISIBLE else View.GONE

        card.setOnClickListener {
            faq.isExpanded = !faq.isExpanded
            answerText.animate()
                .alpha(if (faq.isExpanded) 1f else 0f)
                .setDuration(200)
                .withStartAction {
                    if (faq.isExpanded) {
                        answerText.visibility = View.VISIBLE
                        divider.visibility = View.VISIBLE
                    }
                }
                .withEndAction {
                    if (!faq.isExpanded) {
                        answerText.visibility = View.GONE
                        divider.visibility = View.GONE
                    }
                }
            expandIcon.animate()
                .rotation(if (faq.isExpanded) 180f else 0f)
                .setDuration(200)
        }

        return card
    }


    private fun filterFAQs(query: String) {
        faqList.forEachIndexed { index, faq ->
            val matches = faq.question.lowercase().contains(query) || 
                         faq.answer.lowercase().contains(query)
            faqViews[index].visibility = if (matches || query.isEmpty()) View.VISIBLE else View.GONE
        }
    }
}