package kz.technodom.technodomsample

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.util.AttributeSet
import android.view.View
import android.widget.RadioButton
import androidx.core.content.ContextCompat

class ConfigurationColorRadioButton(
    context: Context,
    attributeSet: AttributeSet?,
    defAttrs: Int
): RadioButton(context, attributeSet, defAttrs), View.OnClickListener {

    private val color: Int

    init {
        val a = context.obtainStyledAttributes(attributeSet, R.styleable.ConfigurationColorRadioButton, defAttrs, 0)
        color = a.getColor(R.styleable.ConfigurationColorRadioButton_color, Color.WHITE)
        a.recycle()
        buttonDrawable = null
        val drawable = ContextCompat.getDrawable(context, R.drawable.radio_button_background_configuration_color_state).apply {
            ((this as StateListDrawable).current as GradientDrawable).setColor(color)
        }
        background = drawable
        setOnClickListener(this)
    }

    constructor(context: Context, attributeSet: AttributeSet) : this(context, attributeSet, 0)

    constructor(context: Context) : this(context, null, 0)

    override fun onClick(p0: View?) {
        toggle()
    }

    override fun toggle() {
        super.toggle()
        val drawable = (background as? StateListDrawable)
        (drawable?.current as? GradientDrawable)?.setColor(color)
        drawable?.let { background = it }
    }
}