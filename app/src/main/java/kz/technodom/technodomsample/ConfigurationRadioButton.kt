package kz.technodom.technodomsample

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RadioButton
import androidx.core.content.ContextCompat

class ConfigurationRadioButton(
    context: Context,
    attributeSet: AttributeSet?,
    defAttrs: Int
): RadioButton(context, attributeSet, defAttrs), View.OnClickListener {

    init {
        buttonDrawable = null
        val drawable = ContextCompat.getDrawable(context, R.drawable.radio_button_background_configuration_state)
        background = drawable
        setOnClickListener(this)
    }

    constructor(context: Context, attributeSet: AttributeSet) : this(context, attributeSet, 0)

    constructor(context: Context) : this(context, null, 0)

    override fun onClick(p0: View?) {
        toggle()
    }
}